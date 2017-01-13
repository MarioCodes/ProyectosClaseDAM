/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.juego;

import aplicacion.controlador.tablero.Casilla;
import aplicacion.controlador.tablero.Tablero;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTable;

/**
 * Resolucion del Sudoku mediante utilizacion de algoritmos de solucion 'Humanos'.
 *  Utilizado del metodo 'Single Candidate'. (Ver Link Anexo).
 * @author Mario Codes Sánchez
 * @since 13/01/2016
 * @see http://www.sudokuoftheday.com/techniques/single-candidate/
 */
public class ResolucionHumana {
    private int indiceFila, indiceColumna;
    private final JTable TABLA;
    private final Tablero TABLERO;
    private final ArrayList<Integer>[][] NUMEROS_POSIBLES_CASILLA = new ArrayList[9][9]; //[EjeX][EjeY].add(numerosPosibles)
    
    /**
     * Constructor por defecto, le pasamos los datos de una JTable y la convertimos a un Tablero con el cual operar.
     * @param tabla Tabla desde la cual sacamos los datos.
     */
    public ResolucionHumana(JTable tabla) {
        this.TABLA = tabla;
        this.TABLERO = Tablero.generacionTablero(tabla);
    }
    
    /**
     * Metodos para (re)inicializar las listas cada iteracion.
     */
    private void gestionListasNumeros() {
        iniListaCasillasPosibles(); //Me interesa que se reseteen a 0 cada vez que llamamos al metodo de ejecucion para que esten vacias.
        almacenarNumerosPosibles();
    }
    
    /**
     * Inicializacion de las ArrayList.
     */
    private void iniListaCasillasPosibles() {
        for (int i = 0; i < NUMEROS_POSIBLES_CASILLA.length; i++) {
            for (int j = 0; j < NUMEROS_POSIBLES_CASILLA[i].length; j++) {
                NUMEROS_POSIBLES_CASILLA[i][j] = new ArrayList<>();
            }
        }
    }
    
    /**
     * Check para comprobar si el numero que queremos meter en la casilla es valido.
     * @param casilla Casilla que queremos comprobar.
     * @param numeroAProbar Numero que queremos meter.
     * @return True si el numero es valido contra las 3 listas de numeros (Cuadrado, Fila y Columna).
     */
    private boolean checkNumeroCasillaValido(Casilla casilla, int numeroAProbar) {
        ArrayList<Integer> numerosDisponiblesCuadrado = TABLERO.getCUADRADOS()[casilla.getNUMERO_CUADRADO()].getNumerosDisponiblesCuadrado();
        ArrayList<Integer> numerosDisponiblesFila = TABLERO.getFILAS()[casilla.getNUMERO_FILA()].getNumerosDisponiblesFila();
        ArrayList<Integer> numerosDisponiblesColumna = TABLERO.getCOLUMNAS()[casilla.getNUMERO_COLUMNA()].getNumerosDisponiblesColumna();
        
        return numerosDisponiblesCuadrado.contains((Object) numeroAProbar) && numerosDisponiblesFila.contains((Object) numeroAProbar) && numerosDisponiblesColumna.contains((Object) numeroAProbar);
    }
    
    /**
     * Metemos los numeros posibles de cada Casilla en la ArrayList[EjeX][EjeY].
     */
    private void almacenarNumerosPosibles() {
        for (int indiceFila = 0; indiceFila < TABLERO.getCOLUMNAS().length; indiceFila++) {
            for (int indiceColumna = 0; indiceColumna < TABLERO.getCOLUMNAS()[indiceFila].getCASILLAS().length; indiceColumna++) {
                for (int numAComprobar = 1; numAComprobar < 10; numAComprobar++) {
                    Casilla casilla = TABLERO.getCasillasPorEjes(indiceFila, indiceColumna);
                    boolean numeroPuestoGraficamente = (TABLA.getValueAt(indiceFila, indiceColumna) != null);
                    if(checkNumeroCasillaValido(casilla, numAComprobar) && !numeroPuestoGraficamente) NUMEROS_POSIBLES_CASILLA[indiceFila][indiceColumna].add(numAComprobar);
                }
            }
        }
    }
    
    /**
     * Comprobacion de si el Tablero tiene algun numero que no este relleno.
     * @param tablero tablero sobre el cual operamos.
     * @return True si el tablero ya esta lleno.
     */
    private boolean checkTableroLleno() {
        for (int indiceFila = 0; indiceFila < 9; indiceFila++) {
            for (int indiceColumna = 0; indiceColumna < 9; indiceColumna++) {
                if(TABLERO.getCasillasPorEjes(indiceFila, indiceColumna).getNumeroPropio() == 0) return false;
            }
        }
        
        return true;
    }
    
    /**
     * Busca una Casilla que tenga un unico numero posible. Devuelve null si no hay (punto muerto).
     * @return Casilla con numero unico. Null si no hay (punto muerto).
     */
    private Casilla getCasillaUnicaPosibilidad() {
        for (int indiceFila = 0; indiceFila < 9; indiceFila++) {
            for (int indiceColumna = 0; indiceColumna < 9; indiceColumna++) {
                if(NUMEROS_POSIBLES_CASILLA[indiceFila][indiceColumna].size() == 1) {
                    this.indiceFila = indiceFila;
                    this.indiceColumna = indiceColumna;
                    return TABLERO.getCasillasPorEjes(indiceFila, indiceColumna);
                }
            }
        }
        
        return null;
    }
    
    /**
     * Mecanismos de resolucion en si misma.
     */
    private void resolucion() {
        try {
            while(!checkTableroLleno()) {
                gestionListasNumeros();

                Casilla casilla = getCasillaUnicaPosibilidad();
                int numero = NUMEROS_POSIBLES_CASILLA[indiceFila][indiceColumna].get(0);
                casilla.setNumeroPropio(numero);
                TABLA.setValueAt(numero, indiceFila, indiceColumna);
            }
        }catch(NullPointerException ex) {
            System.out.println("shit."); //fixme: punto muerto, hacer cambios acordes.
        }
    }
    
    /**
     * Metodo de llamado para ejecutar la resolucion.
     */
    public void resolucionTecnicaHumana() {
        resolucion();
    }
}
