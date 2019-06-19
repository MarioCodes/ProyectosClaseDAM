/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Alojamiento;
import DTO.Habitacion;
import XML.XML;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 * @version 1.0
 * @author Mario Codes Sánchez
 * @since 28/10/16
 */
public class ModifAlojamiento extends javax.swing.JFrame {
    private final Alojamiento ALOJA;
    private final XML CONEXION;
    
    /**
     * Creates new form VentanaAltaAlojamiento
     */
    public ModifAlojamiento(XML conexion, Alojamiento aloja) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        this.ALOJA = aloja;
        this.CONEXION = conexion;
        
        rellenoCampos(aloja);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputTelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputDireccionSocial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputRazonSocial = new javax.swing.JTextField();
        LabelFechaApertura = new javax.swing.JLabel();
        sliderValoracion = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        inputBoxProvincia = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        botonModificar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        inputDescripcion = new javax.swing.JTextField();
        inputFecha = new javax.swing.JTextField();
        inputNumHabitaciones = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificacion de un Alojamiento");
        setMinimumSize(new java.awt.Dimension(22, 0));
        setResizable(false);

        jLabel1.setText("Nombre*");

        inputNombre.setToolTipText("Nombre del alojamiento");
        inputNombre.setEnabled(false);

        jLabel2.setText("Telefono*");

        inputTelefono.setToolTipText("Telefono de contacto");
        inputTelefono.setMinimumSize(new java.awt.Dimension(113, 28));

        jLabel3.setText("Dir. Social*");

        inputDireccionSocial.setToolTipText("Direccion Social del alojamiento");

        jLabel4.setText("Razón Social*");

        inputRazonSocial.setToolTipText("Razon social del alojamiento");
        inputRazonSocial.setEnabled(false);

        LabelFechaApertura.setText("Fecha Apertura*");

        sliderValoracion.setMajorTickSpacing(1);
        sliderValoracion.setMaximum(5);
        sliderValoracion.setMinimum(1);
        sliderValoracion.setPaintLabels(true);
        sliderValoracion.setSnapToTicks(true);
        sliderValoracion.setToolTipText("Valoracion media de los clientes");
        sliderValoracion.setValue(3);

        jLabel6.setText("Provincia*");

        inputBoxProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Huesca", "Zaragoza", "Teruel" }));
        inputBoxProvincia.setToolTipText("Provincia donde esta ubicada el alojamiento");
        inputBoxProvincia.setPreferredSize(new java.awt.Dimension(87, 26));

        jLabel7.setText("Valoración*");

        botonModificar.setText("Modificar");
        botonModificar.setToolTipText("Modificar la entrada a la BDD");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.setToolTipText("Volver atrás");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jLabel8.setText("Descripción");

        inputDescripcion.setToolTipText("Descripcion breve de las caracteristicas del alojamiento.");
        inputDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputDescripcionFocusGained(evt);
            }
        });

        inputFecha.setText("dd/mm/yyyy");
        inputFecha.setToolTipText("Formato: dd/mm/yyyy");
        inputFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputFechaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputFechaFocusLost(evt);
            }
        });

        jLabel10.setText("Num_Habitaciones*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addComponent(sliderValoracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(inputDescripcion))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputDireccionSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputBoxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelFechaApertura)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputNumHabitaciones)
                            .addComponent(inputRazonSocial)
                            .addComponent(inputNombre)
                            .addComponent(inputFecha))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputDireccionSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(inputRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNumHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelFechaApertura, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(inputBoxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(inputDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Recoleccion de los campos de la ventana e instanciacion de un alojamiento con esos datos. Aqui ya esta
     *  realizada la comprobacion de que los datos sean correctos.
     */
    private void inputDatosVentana() {
        //Recoleccion y almacenado de los valores actuales en la ventana.
        String nombre = "", telefono = "", dirSocial = "", razonSocial = "", provincia = "", descrip = "", fecha = "";
        int valoracion = 0, id = 0, num_habitaciones = 0;

        try {
            //Recoleccion de datos de la ventana.
            nombre = this.inputNombre.getText();
            telefono = this.inputTelefono.getText();
            dirSocial = this.inputDireccionSocial.getText();
            razonSocial = this.inputRazonSocial.getText();
            provincia = (String) this.inputBoxProvincia.getSelectedItem(); //Hay que hacer un parse de getSelectedItem ya que devuelve 'Object'.
            descrip = this.inputDescripcion.getText();
            valoracion = this.sliderValoracion.getValue();
            num_habitaciones = Integer.parseInt(this.inputNumHabitaciones.getText());
            fecha = this.inputFecha.getText();
            ArrayList<Habitacion> arrayListHabitacionesVacia = new ArrayList<>(); 
            
            Alojamiento alojamientoDatosNuevos = new Alojamiento(arrayListHabitacionesVacia, nombre, telefono, dirSocial, razonSocial, descrip, valoracion, fecha, num_habitaciones, provincia);
            CONEXION.modificarAlojamiento(alojamientoDatosNuevos);
            JOptionPane.showMessageDialog(this, "¡Alojamiento Modificado con Exito!");
            reseteoCamposVentana();
        } catch(NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "ERROR. NullPointerException: \n" +ex.getLocalizedMessage());
        } catch(IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "ERROR. Problema con la conversion de la fecha: \n" +ex.getLocalizedMessage());
        } catch(ClassCastException ex) {
            JOptionPane.showMessageDialog(this, "ERROR. Problema generico: \n" +ex.getLocalizedMessage());
        }
    }
    
    /**
     * Se encarga de vaciar los campos de input, una vez se haya instanciado con exito el alojamiento.
     */
    private void reseteoCamposVentana() {
        //Set de los campos en blanco
        this.inputNombre.setText(null);
        this.inputTelefono.setText(null);
        this.inputDireccionSocial.setText(null);
        this.inputRazonSocial.setText(null);
        this.inputFecha.setText("dd/mm/yyyy");
        this.inputDescripcion.setText(null);
        this.sliderValoracion.setValue(3);
        this.inputNumHabitaciones.setText(null);
        this.inputBoxProvincia.setSelectedIndex(0);
    }
    
    /*
        Boton de Aceptar al hacer click. Habra que hacer comprobaciones de los datos antes de trabajar con ellos.
    */
    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        if(checkInputsLlenos()) { //Chequeo de que todos los campos estan llenos
            if(checkInputTlfNumerico()) { //Chequeo de que el telefono solo contenga numeros
                if(checkNumHabitacionesNumerico()) { //Chequeo de que el numero de habitaciones sea un Int.
                    inputDatosVentana(); //Llamada al metodo que comienza a trabajar los datos.
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "ERROR. El numero de habitaciones Introducido, NO es valido.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "ERROR. El numero de telefono Introducido, NO es valido.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "ERROR. Hay algun campo obligatorio vacío.");
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    /**
     * Chequeo de que el input del numero de habitaciones sea numero INT.
     * @return True si correcto.
     */
    private boolean checkNumHabitacionesNumerico() {
        try {
            return Integer.parseInt(this.inputNumHabitaciones.getText()) > 0;
        } catch(NumberFormatException ex) {
            return false;
        }
    }
    
    /*
        Boton de Cancelar al hacer click.
    */
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    /**
     * Chequea que el input realizado sobre el telefono sean solo numeros.
     * @return True si el campo contiene solo numeros (int).
     */
    private boolean checkInputTlfNumerico() {
        try {
            Integer.parseInt(this.inputTelefono.getText());
            return this.inputTelefono.getText().length() >= 9 && this.inputTelefono.getText().length() <= 15 && Integer.parseInt(this.inputTelefono.getText()) > 0;
        } catch(NumberFormatException ex) {
            return false;
        }
    }
    
    /**
     * Hace check de que los campos de input no estan vacios.
     * @return True si todos estan rellenados.
     */
    private boolean checkInputsLlenos() {
        return (!this.inputNumHabitaciones.getText().isEmpty() && !this.inputNombre.getText().isEmpty() && !this.inputTelefono.getText().isEmpty() && !this.inputDireccionSocial.getText().isEmpty() && !this.inputRazonSocial.getText().isEmpty() && !this.inputFecha.getText().isEmpty());
    }
    
    /*
        Si los campos estan llenos, convierte en enabled el boton para enviar.
    */
    private void inputDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputDescripcionFocusGained
    }//GEN-LAST:event_inputDescripcionFocusGained

    /*
        Problemas para mostrar como introducir el formato de la fecha, al hacer focus quita el formato requerido.
    */
    private void inputFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputFechaFocusGained
        String input;
        
        try {
            input = this.inputFecha.getText();
            
            if(input.matches("dd/mm/yyyy")) this.inputFecha.setText(null);
        } catch(NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "ERROR. NullPointerException: \n" +ex.getLocalizedMessage());
        } catch(IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "ERROR. Problema con la conversion de la fecha: \n" +ex.getLocalizedMessage());
        } catch(ClassCastException ex) {
            JOptionPane.showMessageDialog(this, "ERROR. Problema generico: \n" +ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_inputFechaFocusGained

    /*
        Y al perder el focus, si no se ha introducido nada, o un espacio en blanco, lo vuelve a poner.
    */
    private void inputFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputFechaFocusLost
        String input;
        
        try {
            input = this.inputFecha.getText();
            
            if(input.matches("") || input.matches(" ")) this.inputFecha.setText("dd/mm/yyyy");
        } catch(NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "ERROR. NullPointerException: \n" +ex.getLocalizedMessage());
        } catch(IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "ERROR. Problema con la conversion de la fecha: \n" +ex.getLocalizedMessage());
        } catch(ClassCastException ex) {
            JOptionPane.showMessageDialog(this, "ERROR. Problema generico: \n" +ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_inputFechaFocusLost

   
    /*
        Hace un match del valor actual contenido en el rs e iguala al valor de la box que coincida.
    */
    private void rellenoAutoProvincia(String provinciaActual) {
        switch(provinciaActual) {
            case "Huesca":
                this.inputBoxProvincia.setSelectedIndex(0);
                break;
            case "Zaragoza":
                this.inputBoxProvincia.setSelectedIndex(1);
                break;
            case "Teruel":
                this.inputBoxProvincia.setSelectedIndex(2);
                break;
            default:
                this.inputBoxProvincia.setSelectedIndex(0);
                JOptionPane.showMessageDialog(this, "ERROR. Problema con valor provincia.");
                break;
        }
    }
    
    /**
     * Relleno automatico de los campos, pasandole como parametro un Alojamiento desde donde obtenerlos.
     * @param tmp Alojamiento desde el cual se obtienen los datos.
     */
    private void rellenoCampos(Alojamiento tmp) {
        this.inputNombre.setText(tmp.getNombre());
        this.inputTelefono.setText(tmp.getTelefono());
        this.inputDireccionSocial.setText(tmp.getDireccionSocial());
        this.inputRazonSocial.setText(tmp.getRazonSocial());
        this.inputTelefono.setText(tmp.getTelefono());
        this.inputDescripcion.setText(tmp.getDescripcion());
        this.sliderValoracion.setValue(tmp.getValoracion());
        this.inputFecha.setText(tmp.getFechaApertura());
        this.inputNumHabitaciones.setText(Integer.toString(tmp.getNum_habitaciones()));
        rellenoAutoProvincia(tmp.getProvincia());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelFechaApertura;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JComboBox inputBoxProvincia;
    private javax.swing.JTextField inputDescripcion;
    private javax.swing.JTextField inputDireccionSocial;
    private javax.swing.JTextField inputFecha;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputNumHabitaciones;
    private javax.swing.JTextField inputRazonSocial;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSlider sliderValoracion;
    // End of variables declaration//GEN-END:variables
}