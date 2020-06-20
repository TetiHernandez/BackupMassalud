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
import massalud.controlador.OrdenData;
import massalud.controlador.PrestadorData;
import massalud.modelo.Orden;
import massalud.modelo.Prestador;

/**
 *
 * @author tetid
 */
public class VistaListarOrdenes extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private OrdenData od;
    private List<Orden> listaOrdenes;
    private Conexion conexion;
    
    /**
     * Creates new form VistaListarOrdenes
     */
    public VistaListarOrdenes() {
        initComponents();
        
        try {
            conexion = new Conexion();
//            connection = conexion.getConexion();


            modelo = new DefaultTableModel();        
            
            od = new OrdenData(conexion);            
           
            listaOrdenes = od.listarOrdenes();
            
            
            armarCabeceraTabla();
            cargarDatos();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaListarOrdenes.class.getName()).log(Level.SEVERE, null, ex);
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
        tOrdenes = new javax.swing.JTable();

        jLabel1.setText("Listado de Ordenes");

        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        tOrdenes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tOrdenes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSalir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    
    public void armarCabeceraTabla(){
        List<Object> columnas = new ArrayList<Object>();
        
        columnas.add("Id Orden");
        columnas.add("Fecha");
        columnas.add("Forma de Pago");
        columnas.add("Importe");
        columnas.add("Nombre Prestador");
        columnas.add("Apellido Prestador");
        columnas.add("Dni Afiliado");
        columnas.add("Dia del Turno");
        columnas.add("Hora");
        columnas.add("Activo");

        
        for(Object columna : columnas){
            modelo.addColumn(columna);
        }
        
        tOrdenes.setModel(modelo);
    }
    
    public void borrarFilasTabla(){
        int nFilas = modelo.getRowCount() - 1;
        
        for(int i = nFilas; i >= 0; i--){
            modelo.removeRow(i);
        }
        
    }
    
    public void cargarDatos(){
        borrarFilasTabla();
        
        
        for(Orden o : listaOrdenes){
            
                modelo.addRow(new Object[]{o.getIdOrden(), o.getFecha(),
                    o.getFormaPago(), o.getImporte(),o.getIdHorario().getIdPrestador().getNombre(),
                    o.getIdHorario().getIdPrestador().getApellido(), o.getIdAfiliado().getDni(),
                    o.getIdHorario().getDia(), o.getIdHorario().getHorarioAtencion(), o.isActivo()});
           
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tOrdenes;
    // End of variables declaration//GEN-END:variables
}
