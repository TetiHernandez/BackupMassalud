/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massalud.vista;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import massalud.controlador.AfiliadoData;
import massalud.controlador.Conexion;
import massalud.controlador.EspecialidadData;
import massalud.controlador.HorarioData;
import massalud.controlador.OrdenData;
import massalud.controlador.PrestadorData;
import massalud.modelo.Afiliado;
import massalud.modelo.Especialidad;
import massalud.modelo.Horario;
import massalud.modelo.Orden;
import massalud.modelo.Prestador;

/**
 *
 * @author tetid
 */
public class VistaGenerarOrden extends javax.swing.JInternalFrame {

    private Conexion conexion;
    private AfiliadoData ad;
    private PrestadorData pd;
    private OrdenData od;
    private EspecialidadData ed;
    private HorarioData hd;
    
    private DefaultTableModel modelo;
    
    private List<Afiliado> listaAfiliadosActivos;
    private List<Especialidad> listaEspecialidades;
    private List<Horario> horariosDelPrestador;
    private List<Prestador> listaPrestadoresEspecialidad;
    
    /**
     * Creates new form VistaGenerarOrden
     */
    public VistaGenerarOrden() {
        initComponents();
        
        try {
            conexion = new Conexion();
            ad = new AfiliadoData(conexion);
            pd = new PrestadorData(conexion);
            od = new OrdenData(conexion);
            ed = new EspecialidadData(conexion);
            hd = new HorarioData(conexion);
            
            modelo = new DefaultTableModel(); 
            
            listaAfiliadosActivos = ad.listarAfiliadosActivos();
            listaEspecialidades = ed.listarEspecialidades();
            
            dcFecha.getDateEditor().setEnabled(false);
            
            armarCabeceraTabla();
            cargarCbEspecialidades();
            
            formaPago();
            importes();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al generar clases data.");
            Logger.getLogger(VistaGenerarOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tIdOrden = new javax.swing.JTextField();
        tDniAfiliado = new javax.swing.JTextField();
        tNombreAfiliado = new javax.swing.JTextField();
        tApellidoAfiliado = new javax.swing.JTextField();
        btBuscarId = new javax.swing.JButton();
        btBuscarDni = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tHorarios = new javax.swing.JTable();
        btCrear = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        cbEspecialidades = new javax.swing.JComboBox<>();
        cbPrestadores = new javax.swing.JComboBox<>();
        btHorario = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tIdAfiliado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbImporte = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbFormaPago = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Generar Orden");

        jLabel2.setText("Datos Especialista");

        jLabel3.setText("id:");

        jLabel4.setText("Dni:");

        jLabel5.setText("Nombre:");

        jLabel6.setText("Apellido:");

        tIdOrden.setEditable(false);
        tIdOrden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tIdOrdenKeyTyped(evt);
            }
        });

        tDniAfiliado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tDniAfiliadoKeyTyped(evt);
            }
        });

        tNombreAfiliado.setEditable(false);

        tApellidoAfiliado.setEditable(false);

        btBuscarId.setText("Buscar id");
        btBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarIdActionPerformed(evt);
            }
        });

        btBuscarDni.setText("Buscar DNI");
        btBuscarDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarDniActionPerformed(evt);
            }
        });

        jLabel7.setText("Datos Afiliado");

        jLabel8.setText("Especialidad:");

        jLabel9.setText("Prestadores:");

        tHorarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tHorarios);

        btCrear.setText("Crear");
        btCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearActionPerformed(evt);
            }
        });

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        jLabel11.setText("Fecha:");

        cbEspecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecialidadesActionPerformed(evt);
            }
        });

        cbPrestadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPrestadoresActionPerformed(evt);
            }
        });

        btHorario.setText("Mostrar Horarios");
        btHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHorarioActionPerformed(evt);
            }
        });

        jLabel12.setText("Orden Nro:");

        tIdAfiliado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tIdAfiliadoKeyTyped(evt);
            }
        });

        jLabel10.setText("Forma de Pago:");

        jLabel13.setText("Pago/Importe");

        jLabel14.setText("Importe:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(tIdOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(btCrear))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(btLimpiar)
                                .addGap(117, 117, 117)
                                .addComponent(btSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(tIdAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btBuscarId))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cbEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tDniAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btBuscarDni)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tNombreAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tApellidoAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPrestadores, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(btHorario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(tIdOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(tNombreAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarId)
                    .addComponent(tIdAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(tDniAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tApellidoAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarDni))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(cbEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPrestadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btHorario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCrear)
                    .addComponent(btLimpiar)
                    .addComponent(btSalir))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    private void btBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarIdActionPerformed
        int idAfiliado;
        String nombre;
        String apellido;
        int dni;
        

        Afiliado a;
        
        if(tIdAfiliado.getText() != null){
            idAfiliado = Integer.parseInt(tIdAfiliado.getText());
            a = ad.buscarAfiliadoActivo(idAfiliado);
            

            nombre = a.getNombre();
            apellido = a.getApellido();
            dni = a.getDni();


            tNombreAfiliado.setText(nombre);
            tApellidoAfiliado.setText(apellido);
            tDniAfiliado.setText(dni + "");
        }else{
            JOptionPane.showMessageDialog(this, "Por favor ingrese un id");
        }
        
        

    }//GEN-LAST:event_btBuscarIdActionPerformed

    private void tIdOrdenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tIdOrdenKeyTyped
        char myChar = evt.getKeyChar();

        if(!Character.isDigit(myChar)){
            evt.consume();
        }
    }//GEN-LAST:event_tIdOrdenKeyTyped

    private void tDniAfiliadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tDniAfiliadoKeyTyped
        char myChar = evt.getKeyChar();

        if(!Character.isDigit(myChar)){
            evt.consume();
        }
    }//GEN-LAST:event_tDniAfiliadoKeyTyped

    private void btBuscarDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarDniActionPerformed
        int idAfiliado;
        String nombre;
        String apellido;
        int dni;
        

        Afiliado a;
        if(tDniAfiliado.getText() != null){
            dni = Integer.parseInt(tDniAfiliado.getText());
            a = ad.buscarAfiliadoPorDniActivo(dni);


            idAfiliado = a.getIdAfiliado();
            nombre = a.getNombre();
            apellido = a.getApellido();
            dni = a.getDni();

            tIdAfiliado.setText(idAfiliado + "");
            tNombreAfiliado.setText(nombre);
            tApellidoAfiliado.setText(apellido);
            tDniAfiliado.setText(dni + "");
        }
    }//GEN-LAST:event_btBuscarDniActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        tIdOrden.setText("");
        tIdAfiliado.setText("");
        tNombreAfiliado.setText("");
        tApellidoAfiliado.setText("");
        tDniAfiliado.setText("");
        borrarFilasTabla();
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void cbEspecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecialidadesActionPerformed
        cbPrestadores.removeAllItems();
        borrarFilasTabla();
        
        Especialidad eSeleccionada = (Especialidad)cbEspecialidades.getSelectedItem();
        
        listaPrestadoresEspecialidad = pd.obtenerPrestadoresPorEspecialidad(eSeleccionada.getIdEspecialidad());
        
        for(Prestador p : listaPrestadoresEspecialidad){
            cbPrestadores.addItem(p);
        }
    }//GEN-LAST:event_cbEspecialidadesActionPerformed

    private void cbPrestadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPrestadoresActionPerformed
               
        
    }//GEN-LAST:event_cbPrestadoresActionPerformed

    private void btHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHorarioActionPerformed
        //Borramos las filas
        borrarFilasTabla();
        
        Prestador pS = (Prestador)cbPrestadores.getSelectedItem();
        
        //Lista de horarios del prestador
        horariosDelPrestador = hd.obtenerHorarioPorPrestador(pS);
        
        for(Horario h : horariosDelPrestador){
            modelo.addRow(new Object[]{h.getIdHorario(), h.getDia(), h.getHorarioAtencion()});

        }
        
    }//GEN-LAST:event_btHorarioActionPerformed

    private void btCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearActionPerformed
        LocalDate fecha = null;
        int idA = -1;
        int idH = -1;
        String formaPago;
        float importe;
        
        int filaSeleccionada;
        

        if(dcFecha.getDateEditor().getDate() == null){
            JOptionPane.showMessageDialog(this, "Por favor ingrese una fecha");            
        }else{
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            String fechaIngresada = formato.format(dcFecha.getDate());
        
            fecha = LocalDate.parse(fechaIngresada, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        
        if(tNombreAfiliado.getText()== null){
            JOptionPane.showMessageDialog(this, "Por ingrese los id o documento correcto.");     
        }else{
            idA = Integer.parseInt(tIdAfiliado.getText());
        }
        
        if(tHorarios.getSelectedRow() != -1){
            filaSeleccionada = tHorarios.getSelectedRow();
            idH = (int)modelo.getValueAt(filaSeleccionada, 0);
            
        }
        
        formaPago = (String)cbFormaPago.getSelectedItem();
        importe = Float.parseFloat((String)cbImporte.getSelectedItem());
        
        Afiliado a = ad.buscarAfiliadoActivo(idA);
        Horario h = hd.buscarHorario(idH);
        
        Orden o = new Orden(fecha, formaPago, importe, a, h, true);
        
        od.generarOrden(o);
        
        tIdOrden.setText(o.getIdOrden() + "");
    }//GEN-LAST:event_btCrearActionPerformed

    private void tIdAfiliadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tIdAfiliadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdAfiliadoKeyTyped

    public void cargarCbEspecialidades(){
        for(Especialidad e : listaEspecialidades){
            cbEspecialidades.addItem(e);
        }
    }
    
    public void armarCabeceraTabla(){
        List<Object> columnas = new ArrayList<Object>();
        
        columnas.add("Id Horario");
        columnas.add("Dia");
        columnas.add("Horario de atención");
        
        
        for(Object columna : columnas){
            modelo.addColumn(columna);
        }
        
        tHorarios.setModel(modelo);
    }
    
    public void borrarFilasTabla(){
        int nFilas = modelo.getRowCount() - 1;
        
        for(int i = nFilas; i >= 0; i--){
            modelo.removeRow(i);
        }
        
    }    
    
    
    //Formas de pago
    
    public void formaPago(){
        List<String> fPago = new ArrayList<>();
        fPago.add("efectivo");
        fPago.add("tarjeta");
        
        for(String s : fPago){
            cbFormaPago.addItem(s);
        }
    }
    
    public void importes(){
        List<String> importes = new ArrayList<>();
        importes.add("100");
        importes.add("300");
        importes.add("500");
        
        for(String f : importes){
            cbImporte.addItem(f);
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarDni;
    private javax.swing.JButton btBuscarId;
    private javax.swing.JButton btCrear;
    private javax.swing.JButton btHorario;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JButton btSalir;
    private javax.swing.JComboBox<Especialidad> cbEspecialidades;
    private javax.swing.JComboBox<String> cbFormaPago;
    private javax.swing.JComboBox<String> cbImporte;
    private javax.swing.JComboBox<Prestador> cbPrestadores;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tApellidoAfiliado;
    private javax.swing.JTextField tDniAfiliado;
    private javax.swing.JTable tHorarios;
    private javax.swing.JTextField tIdAfiliado;
    private javax.swing.JTextField tIdOrden;
    private javax.swing.JTextField tNombreAfiliado;
    // End of variables declaration//GEN-END:variables
}