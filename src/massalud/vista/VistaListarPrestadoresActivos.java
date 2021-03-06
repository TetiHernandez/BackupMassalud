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
import javax.swing.table.DefaultTableModel;
import massalud.controlador.Conexion;
import massalud.controlador.PrestadorData;
import massalud.modelo.Prestador;

/**
 *
 * @author tetid
 */
public class VistaListarPrestadoresActivos extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private PrestadorData pd;
    private List<Prestador> listaPrestadoresActivos;
    private Conexion conexion;
    
    /**
     * Creates new form VistaListarPrestadoresActivos
     */
    public VistaListarPrestadoresActivos() {
        initComponents();
        
        try {
            conexion = new Conexion();
//            connection = conexion.getConexion();


            modelo = new DefaultTableModel();        
            
            pd = new PrestadorData(conexion);            
           
            listaPrestadoresActivos = pd.obtenerPrestadoresActivos();
            
            
            armarCabeceraTabla();
            cargarDatos();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaListarAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPrestadoresA = new javax.swing.JTable();

        jLabel1.setText("Lista de Prestadores Activos");

        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        tPrestadoresA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tPrestadoresA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel1)
                .addContainerGap(241, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addGap(68, 68, 68)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addGap(80, 80, 80)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    
    public void armarCabeceraTabla(){
        List<Object> columnas = new ArrayList<Object>();
        
        columnas.add("Id");
        columnas.add("Nombre");
        columnas.add("Apellido");
        columnas.add("Dni");
        columnas.add("Especialidad");
        
        for(Object columna : columnas){
            modelo.addColumn(columna);
        }
        
        tPrestadoresA.setModel(modelo);
    }
    
    public void borrarFilasTabla(){
        int nFilas = modelo.getRowCount() - 1;
        
        for(int i = nFilas; i >= 0; i--){
            modelo.removeRow(i);
        }
        
    }
    
    public void cargarDatos(){
        borrarFilasTabla();
        
        
        for(Prestador p : listaPrestadoresActivos){
            
                modelo.addRow(new Object[]{p.getIdPrestador(), p.getNombre(),
                    p.getApellido(), p.getDni(), p.getEspecialidad().getEspecialidad()});
           
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tPrestadoresA;
    // End of variables declaration//GEN-END:variables
}
