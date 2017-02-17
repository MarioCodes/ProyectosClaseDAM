/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Clase estatica para recopilar las comprobaciones de la mano que tiene cada jugador.
 * Se va recorriendo desde la mas alta, y en cuanto detecta una se devuelve esa.
 * @author Mario Codes Sánchez
 * @since 17/02/2017
 */
public class Jugadas {
    public static int valor; //fixme: cambiar a private.
    public static String jugada;
    
    /**
     * Obtener el valor numerico de una carta. A = 14, K = 13...
     * @param carta Carta de la cual obtenemos el valor.
     * @return Valor numerico de la Carta.
     */
    private static int getValor(Carta carta) {
        int valor = -1;
        String v = carta.toString().substring(0, 1);
        if(v.matches("1")) v = "10";
        try {
            valor = Integer.parseInt(v);
        }catch(ClassCastException|NumberFormatException ex) {
            switch(v) {
                case "A":
                    valor = 14;
                    break;
                case "K":
                    valor = 13;
                    break;
                case "Q":
                    valor = 12;
                    break;
                case "J":
                    valor = 11;
                    break;
                default:
                    valor = -1;
                    System.out.println("Valor por defecto en getValor().");
                    break;
            }
        }
        
        return valor;
    }
    
    /**
     * Obtencion del palo de la carta para comprobar escaleras, fulls y demas.
     * @param carta Carta a obtener el palo.
     * @return Palo de la carta introducida.
     */
    private static String getPalo(Carta carta) {
        return carta.toString().substring(carta.toString().indexOf(',')+1);
    }
    
    private static boolean checkFull(ArrayList<Carta> propias, ArrayList<Carta> comunes) {
        ArrayList<Integer> valores = getValores(propias, comunes);
        boolean parejaEncontrada = false;
        boolean trioEncontrado = false;
        int valorTrio = 0;
        
        for (int i = 0; i < valores.size() && !parejaEncontrada; i++) { //Buscado de trio.
            int valor1 = valores.get(i);
//            System.out.println("\tValor1: " +valor1 +", Indice: " +i);
            for (int j = 0; j < valores.size() && !parejaEncontrada; j++) {
                int valor2 = valores.get(j);
//                System.out.println("\tValor2: " +valor2 +", Indice: " +j);
                if(j != i) {
                    for (int q = 0; q < valores.size() && !parejaEncontrada; q++) {
                        int valor3 = valores.get(q);
//                        System.out.println("\tValor3 " +valor3 +", Indice: " +q);
                        if(q != j && q != i) {
                            if(valor3 == valor2 && valor3 == valor1) {
                                Jugadas.valor = valor3+valor2+valor1;
                                trioEncontrado = true;
                                valorTrio = valor1;
                            }
                        }
                    }
                }
            }
        }
        
        if(trioEncontrado) {
            for (int i = 0; i < valores.size(); i++) { //Buscado de pareja.
                int valor = valores.get(i);
                for (int j = 0; j < valores.size(); j++) {
                    int valor2 = valores.get(j);
                    if(j != i) {
                        if(valor == valor2 && valor != valorTrio) {
                            Jugadas.valor += valor+valor2;
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Check de si existe color.
     * @param propias Cartas propias del jugador.
     * @param comunes Cartas comunes a todos.
     * @return True si existe color.
     */
    private static boolean checkColor(ArrayList<Carta> propias, ArrayList<Carta> comunes) {
        ArrayList<Carta> cartas = new ArrayList<>();
        cartas.addAll(propias);
        cartas.addAll(comunes);
        
        ArrayList<String> palos = getPalos(propias, comunes);
        boolean existe = false;
        String paloColor = "";
        int iguales = 1;
        
        for (int i = 0; i < palos.size(); i++) {
            String palo = palos.get(i);
//            System.out.println("Palo a comprobar: " +palo);
            for (int j = 0; j < palos.size(); j++) {
                if(j != i) {
                    if(palos.get(j).matches(palo)) iguales++;
                    if(iguales == 5) {
                        existe = true;
                        paloColor = palo;
                    }
                }
            }
            iguales = 1;
        }
        
        if(existe) {
            int valor = 0;
            for (int i = 0; i < cartas.size(); i++) {
                if(getPalo(cartas.get(i)).matches(paloColor) && getValor(cartas.get(i)) > valor) valor = getValor(cartas.get(i));
            }
            Jugadas.valor = valor;
        }
        
        return existe;
    }
    
    /**
     * Check de si existe escalera Normal. (5 cartas consecutivas de distinto palo).
     * @param propias Cartas exclusivas del jugador.
     * @param comunes Cartas comunes a todos los jugadores.
     * @return True si existe escalera.
     */
    private static boolean checkEscalera(ArrayList<Carta> propias, ArrayList<Carta> comunes) {
        ArrayList<Integer> valores = getValores(propias, comunes);
        
        for (int i = 0; i < valores.size(); i++) {
            int valor = valores.get(i);
//            System.out.println("Valor: " +valor);
            if(valores.contains((Integer) valor+1)) {
                if(valores.contains((Integer) valor+2)) {
                    if(valores.contains((Integer) valor+3)) {
                        if(valores.contains((Integer) valor+4)) { //A partir de aqui ya hay escalera existente. El resto es por si existe escalera de +5 cartas, que pille los valores mas altos.
                            Jugadas.valor = valor+(valor+1)+(valor+2)+(valor+3)+(valor+4);
                            if(valores.contains((Integer) valor+5)) {
                                Jugadas.valor -= valor;
                                Jugadas.valor += (valor+5);
                                if(valores.contains((Integer) valor+6)) { //Mas de 7 Cartas nunca habra en Juego.
                                    Jugadas.valor -= valor+1;
                                    Jugadas.valor += (valor+6);
                                }
                            }
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Comprobacion de si hay trio. Tres cartas iguales.
     * @param propias Cartas propias del Jugador.
     * @param comunes Cartas comunes a todos.
     * @return True si hay trio.
     */
    private static boolean checkTrio(ArrayList<Carta> propias, ArrayList<Carta> comunes) {
        ArrayList<Integer> valores = getValores(propias, comunes);
        boolean parejaEncontrada = false;
        
        for (int i = 0; i < valores.size() && !parejaEncontrada; i++) { //Buscado de una primera pareja.
            int valor1 = valores.get(i);
//            System.out.println("\tValor1: " +valor1 +", Indice: " +i);
            for (int j = 0; j < valores.size() && !parejaEncontrada; j++) {
                int valor2 = valores.get(j);
//                System.out.println("\tValor2: " +valor2 +", Indice: " +j);
                if(j != i) {
                    for (int q = 0; q < valores.size() && !parejaEncontrada; q++) {
                        int valor3 = valores.get(q);
//                        System.out.println("\tValor3 " +valor3 +", Indice: " +q);
                        if(q != j && q != i) {
                            if(valor3 == valor2 && valor3 == valor1) {
                                Jugadas.valor = valor3+valor2+valor1;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Check para comprobar si tiene dos parejas independientes.
     * @param propias Cartas propias del jugador.
     * @param comunes Cartas comunes a todos.
     * @return True si dispone de doble pareja.
     */
    private static boolean checkDoblePareja(ArrayList<Carta> propias, ArrayList<Carta> comunes) {
        ArrayList<Integer> valores = getValores(propias, comunes);
        boolean parejaEncontrada = false;
        int parejaUno = 0;
        
        for (int i = 0; i < valores.size() && !parejaEncontrada; i++) { //Buscado de una primera pareja.
            int valor = valores.get(i);
            for (int j = 0; j < valores.size() && !parejaEncontrada; j++) {
                int valor2 = valores.get(j);
                if(j != i) {
                    if(valor == valor2) {
                        parejaUno += valor+valor2;
                        parejaEncontrada = true;
                    }
                }
            }
        }
        
        if(parejaUno == 0) return false; //No hace falta que siga buscando.

        for (int i = 0; i < valores.size(); i++) { //Segunda pareja, que no sea la primera.
            int valor = valores.get(i);
            for (int j = 0; j < valores.size(); j++) {
                int valor2 = valores.get(j);
                if(j != i) {
                    if(valor == valor2 && ((valor+valor2) != parejaUno)) {
                        Jugadas.valor += (valor+valor2+parejaUno);
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Comprobacion de si el jugador dispone de una pareja simple. (2 cartas iguales).
     * @param propias Cartas propias del jugador.
     * @param comunes Cartas comunes a todos.
     * @return True si dispone de pareja.
     */
    public static boolean checkPareja(ArrayList<Carta> propias, ArrayList<Carta> comunes) {
        ArrayList<Integer> valores = getValores(propias, comunes);
        
        for (int i = 0; i < valores.size(); i++) {
            int valor = valores.get(i);
            for (int j = 0; j < valores.size(); j++) {
                int valor2 = valores.get(j);
                if(j != i) {
                    if(valor == valor2) {
                        Jugadas.valor = valor+valor2;
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Comprobacion de cual es la carta mas alta.
     * @param propias Cartas propias del jugador.
     * @param comunes Cartas comunes a todos.
     * @return True siempre ya que es la minima combinacion posible.
     */
    private static boolean checkCartaAlta(ArrayList<Carta> propias, ArrayList<Carta> comunes) {
        int maxValor = getValor(propias.get(0));
        if(getValor(propias.get(1)) > maxValor) maxValor = getValor(propias.get(1));
        else {
            for(Carta c: comunes) {
                if(getValor(c) > maxValor) maxValor = getValor(c);
            }
        }
        
        Jugadas.valor = maxValor;
        return true;
    }
    
    /**
     * Mezcla de todas las cartas para chequear palos en una unica ArrayList.
     * @param propias Cartas propias del Jugador.
     * @param comunes Cartas comunes a todos los jugadores.
     * @return ArrayList conjunta de todos los palos existentes.
     */
    private static ArrayList<String> getPalos(ArrayList<Carta> propias, ArrayList<Carta> comunes) {
        ArrayList<String> palos = new ArrayList<>();
        for(Carta c: propias) palos.add(getPalo(c));
        for(Carta c: comunes) palos.add(getPalo(c));
        palos.sort(Comparator.naturalOrder());
        return palos;
    }
    
    /**
     * Mezcla de todas las cartas para chequear combinaciones posibles en una unica ArrayList.
     * @param propias Cartas propias del Jugador.
     * @param comunes Cartas comunes a todos.
     * @return ArrayList conjunta a todas las cartas.
     */
    private static ArrayList<Integer> getValores(ArrayList<Carta> propias, ArrayList<Carta> comunes) {
        ArrayList<Integer> valores = new ArrayList<>();
        for(Carta c: propias) valores.add(getValor(c));
        for(Carta c: comunes) valores.add(getValor(c));
        valores.sort(Comparator.naturalOrder());
        return valores;
    }
    
    /**
     * Comprobacion de la jugada posible que tiene un jugador, dado el conjunto de cartas.
     * Modifica la String para saber la jugada, y el valor por si hay empate de jugadas.
     * @param propias Cartas propias. Siempre son 2.
     * @param comunes Cartas comunes a todos, pueden ser 3, 4 o 5.
     */
    public static void checkJugada(ArrayList<Carta> propias, ArrayList<Carta> comunes) {
        if(checkFull(propias, comunes)) Jugadas.jugada = "Full";
        else {
            if(checkColor(propias, comunes)) Jugadas.jugada = "Color";
            else {
                if(checkEscalera(propias, comunes)) Jugadas.jugada = "Escalera";
                else {
                    if(checkTrio(propias, comunes)) Jugadas.jugada = "Trio";
                    else {
                        if(checkDoblePareja(propias, comunes)) Jugadas.jugada = "Doble Pareja";
                        else {
                            if(checkPareja(propias, comunes)) Jugadas.jugada = "Pareja";
                            else {
                                if(checkCartaAlta(propias, comunes)) Jugadas.jugada = "Carta Alta";
                            }
                        }
                    }
                }
            }
        }
    }
}
