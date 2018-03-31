/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Vistas;

import javax.swing.JOptionPane;
import uhv1.Negocio.Casa;
import uhv1.Negocio.ControlModificaHabitante;
import uhv1.Negocio.Responsable;
/**
 *
 * @author adrianags
 */


public class VentanaModificaHabitante extends javax.swing.JFrame {

    /**
     * Creates new form VentanaModificaHabitante
     */
    ControlModificaHabitante control;
    Responsable responsable;
    Casa casa; 
    
    /*
    Constructor de la ventana modifica habitante
    */
    public VentanaModificaHabitante(ControlModificaHabitante control, Responsable res, Casa casa) {
        initComponents();
        this.control = control;
        this.responsable=res;
        this.casa=casa;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelModiH = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApat = new javax.swing.JLabel();
        jLabelAmat = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelCasa = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApat = new javax.swing.JTextField();
        jTextFieldAmat = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldCasa = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelModiH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelModiH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModiH.setText("Modifica Habitante");

        jLabelNombre.setText("Nombre:");

        jLabelApat.setText("Apellido paterno:");

        jLabelAmat.setText("Apellido materno:");

        jLabelTelefono.setText("Teléfono");

        jLabelCasa.setText("Casa");

        jButtonAceptar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
         jButtonCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
         jButtonDatos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonDatos.setText("Datos");
        jButtonDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabelModiH))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelApat)
                            .addComponent(jLabelAmat)
                            .addComponent(jLabelTelefono)
                            .addComponent(jLabelCasa))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(jTextFieldApat)
                            .addComponent(jTextFieldAmat)
                            .addComponent(jTextFieldTelefono)
                            .addComponent(jTextFieldCasa))))
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jButtonAceptar)
                        .addGap(77, 77, 77)
                        .addComponent(jButtonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jButtonDatos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabelModiH)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApat)
                    .addComponent(jTextFieldApat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAmat)
                    .addComponent(jTextFieldAmat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCasa)
                    .addComponent(jTextFieldCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonDatos)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    El boton aceptar manda un aviso si hay un jTextField vacio
    o puedes ingresar los datos que quieres modificar y si aceptas muestra mensaje que 
    las modificaciones se hicieron con exito y muestra la ventana principal
    */
    
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        if(jTextFieldNombre.getText().isEmpty() || jTextFieldApat.getText().isEmpty() || jTextFieldAmat.getText().isEmpty()
                                                || jTextFieldTelefono.getText().isEmpty() || jTextFieldCasa.getText().isEmpty()){
                     
            JOptionPane.showMessageDialog (null, "Debes llenar todos los campos");   
            
        }else{ 
         
            String nombre = jTextFieldNombre.getText(); // getText regresa el texto del campo
            String apat = jTextFieldApat.getText(); //
            String amat = jTextFieldAmat.getText();
            int telefono = Integer.parseInt(jTextFieldTelefono.getText());
            int casa1= Integer.parseInt(jTextFieldCasa.getText());
            
            System.out.println("en la ventana: " + nombre+  apat+ amat+ "TE" + telefono+"cas"+ casa1);
            control.controlModifica(nombre, apat, amat, telefono, casa1);//se le mandan al control los datos ingresados en los jTextField
            JOptionPane.showMessageDialog (null, "Las modificaciones se hicieron con exito");
            setVisible(false); //cierra la ventana
            control.controlPrincipal();//muestra la ventana principal
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    /*
    Si das click en boton cancelar
    se cierra la ventana y muestra la ventana principal
    */
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);//cierra la ventana
        control.controlPrincipal();
        
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /*
    El boton datos lo que hace es que si los jTextField estàn vacios
    Ponen los datos del responsable en cada JtextField correspondiente
    */
    private void jButtonDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDatosActionPerformed
        // TODO add your handling code here:
       
        if(jTextFieldNombre.getText().isEmpty() || jTextFieldApat.getText().isEmpty() || jTextFieldAmat.getText().isEmpty()
                                                || jTextFieldTelefono.getText().isEmpty() || jTextFieldCasa.getText().isEmpty()){
                      
                      jTextFieldNombre.setText(responsable.getNombre());//pone nombre del responsable en  jTextFieldNombre
                      jTextFieldApat.setText(responsable.getaPat());//pone el apellido paterno del responsable en  jTextFieldApat
                      jTextFieldAmat.setText(responsable.getaMat());//pone el apellido materno del responsable en  jTextFieldAmat
                      
                      float telefono = responsable.getTelefono(); //el telefono del reponsable lo asigna a un int telefono
                      String tel = Integer.toString((int) telefono);//el valor de telefono se convierte a string
                      jTextFieldTelefono.setText(tel);//pone el telefono del responsable en  jTextFieldTelefono
                      
                      casa= responsable.getCasa();//el valor de la casa del responsable se asigna a casa
                      String house = casa.toString();////el valor de la casa se convierte a string
                      jTextFieldCasa.setText(house);//pone la casa del responsable asignada en jTextFieldCasa
                      
                      
        }
                     
    }//GEN-LAST:event_jButtonDatosActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonDatos;
    private javax.swing.JLabel jLabelAmat;
    private javax.swing.JLabel jLabelApat;
    private javax.swing.JLabel jLabelCasa;
    private javax.swing.JLabel jLabelModiH;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JTextField jTextFieldAmat;
    private javax.swing.JTextField jTextFieldApat;
    private javax.swing.JTextField jTextFieldCasa;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
