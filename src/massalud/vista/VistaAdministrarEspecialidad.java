/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massalud.vista;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import massalud.controlador.Conexion;
import massalud.controlador.EspecialidadData;
import massalud.modelo.Especialidad;

/**
 *
 * @author tetid
 */
public class VistaAdministrarEspecialidad extends javax.swing.JInternalFrame {

    private EspecialidadData ed;
    private Conexion conexion;
    
    private List<Especialidad> listaEspecialidades;
    
    /**
     * Creates new form VistaAdministrarEspecialidad
     */
    public VistaAdministrarEspecialidad() {
        initComponents();
        
        try {
            conexion = new Conexion();
            ed = new EspecialidadData(conexion);
            
            listaEspecialidades= ed.listarEspecialidades();            
            
        } catch (ClassNotFoundException ex) {
            System.out.println("No se pudo crear la EspecialidadData");
            Logger.getLogger(VistaAdministrarEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tIdEspecialidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tNombreEspecialidad = new javax.swing.JTextField();
        btCrear = new javax.swing.JButton();
        btActualizar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Administrar Especialidad");

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Id Especialidad:");

        tIdEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdEspecialidadActionPerformed(evt);
            }
        });
        tIdEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tIdEspecialidadKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        tNombreEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNombreEspecialidadActionPerformed(evt);
            }
        });
        tNombreEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tNombreEspecialidadKeyTyped(evt);
            }
        });

        btCrear.setText("Crear");
        btCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearActionPerformed(evt);
            }
        });

        btActualizar.setText("Actualizar");
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btCrear)
                                .addGap(20, 20, 20)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tNombreEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btActualizar)
                                    .addGap(84, 84, 84)
                                    .addComponent(btLimpiar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tIdEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(btBuscar))))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tIdEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNombreEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCrear)
                    .addComponent(btActualizar)
                    .addComponent(btLimpiar))
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        int idEspecialidad;
        String nombre;
        
        int maximo = listaEspecialidades.size();

        Especialidad e;
        
        
        
        if((tIdEspecialidad.getText() != null && !tIdEspecialidad.getText().isEmpty())){
            idEspecialidad = Integer.parseInt(tIdEspecialidad.getText());
            if(idEspecialidad <= maximo){
                e = ed.buscarEspecialidad(idEspecialidad);

                nombre = e.getEspecialidad();
        

                tNombreEspecialidad.setText(nombre);
            }else{
                JOptionPane.showMessageDialog(this, "No se encuentra en la base de datos");
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Por favor ingrese un id de especialidad");
        }
        
        
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tIdEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdEspecialidadActionPerformed

    private void tNombreEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNombreEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNombreEspecialidadActionPerformed

    private void btCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearActionPerformed

        String nombreEspecialidad;
        
        Especialidad e;

        nombreEspecialidad = tNombreEspecialidad.getText();     

        e = new Especialidad(nombreEspecialidad);
        ed.agregarEspecialidad(e);
        tIdEspecialidad.setText(e.getIdEspecialidad() + "");
    }//GEN-LAST:event_btCrearActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        int idEspecialidad;
        String nombreEspecialidad;

        Especialidad e;

        if(tIdEspecialidad.getText() != null ){
            idEspecialidad = Integer.parseInt(tIdEspecialidad.getText());
            nombreEspecialidad = tNombreEspecialidad.getText();            

            e = new Especialidad(nombreEspecialidad);
            e.setIdEspecialidad(idEspecialidad);

            ed.actualizarEspecialidad(e);
        }

    }//GEN-LAST:event_btActualizarActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        tIdEspecialidad.setText("");
        tNombreEspecialidad.setText("");
        
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void tIdEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tIdEspecialidadKeyTyped
        char myChar = evt.getKeyChar();
        
        if(!Character.isDigit(myChar)){
            evt.consume();
        }
    }//GEN-LAST:event_tIdEspecialidadKeyTyped

    private void tNombreEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNombreEspecialidadKeyTyped
       char myChar = evt.getKeyChar();
        
        if(Character.isDigit(myChar)){
            evt.consume();
        }
    }//GEN-LAST:event_tNombreEspecialidadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCrear;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tIdEspecialidad;
    private javax.swing.JTextField tNombreEspecialidad;
    // End of variables declaration//GEN-END:variables
}
