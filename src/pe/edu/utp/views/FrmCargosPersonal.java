
package pe.edu.utp.views;

import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.controllers.CargoPersonalJpaController;
import pe.edu.utp.controllers.exceptions.IllegalOrphanException;
import pe.edu.utp.controllers.exceptions.NonexistentEntityException;
import pe.edu.utp.entity.CargoPersonal;
import pe.edu.utp.controllers.AreaJpaController;
import pe.edu.utp.entity.Area;
import pe.edu.utp.entity.Employe;
import pe.edu.utp.controllers.EmployeJpaController;


public class FrmCargosPersonal extends javax.swing.JFrame {

    private CargoPersonalJpaController CPJpaController = new CargoPersonalJpaController();
    private AreaJpaController areaJpaController = new AreaJpaController(); 
    private EmployeJpaController emJpaController = new EmployeJpaController();
    private DefaultTableModel model;
    List<CargoPersonal> lista;
    List<Area> area;
    public FrmCargosPersonal() {
        initComponents();
        this.setLocationRelativeTo(null);
        listar();
        listarCbxAreas();
      
    }

    private void listar() {
        tblCP.removeAll();
        String[] cabecera = {"ID", "Area", "Nombre", "Descripcion", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
        Object[] obj = new Object[5];
        try {
            lista = CPJpaController.findCargoPersonalEntities();
            for (CargoPersonal cp : lista) {
                obj[0] = cp.getId();
                obj[1] = cp.getIdArea().getName();
                obj[2] = cp.getName();
                obj[3] = cp.getDescription();
                obj[4] = cp.getStatus().toString().equalsIgnoreCase("1") ? "Activo" : "Inactivo";
                modelo.addRow(obj);               
            }
            tblCP.setModel(modelo);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        DefaultTableCellRenderer hr = new DefaultTableCellRenderer();      
        hr.setBackground(new Color(65,65,65));
        hr.setForeground(Color.white);
        hr.setHorizontalAlignment(JLabel.CENTER);       
        tblCP.getTableHeader().setDefaultRenderer(hr);
        tblCP.setBackground(new Color(230,230,230));
        tblCP.setShowGrid(true);
        tblCP.setGridColor(new Color(0,0,0));
        tblCP.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(30);
        tblCP.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(110);
        tblCP.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(110);
        tblCP.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(304);
        tblCP.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(70);
            
    }
    
    private void listarCbxAreas(){
        String[] areas = {""};
        cbxArea.removeAllItems();
        try {
            area = areaJpaController.findAreaEntities();
            for (Area a : area){
                areas[0] = a.getName();
                cbxArea.addItem(areas[0]);
            }
        } catch (Exception e) {
            System.out.println("ERROR: "+e);
        } 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCPPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCP = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        chkEstado = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbxArea = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlCPPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlCPPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        tblCP = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int column){
                for(int i = 0; i < tblCP.getRowCount(); i ++){
                    if(row < 0){
                        return true;
                    }
                }
                return false;
            }
        };
        tblCP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCP.setFocusable(false);
        tblCP.getTableHeader().setResizingAllowed(false);
        tblCP.getTableHeader().setReorderingAllowed(false);
        tblCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCP);

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(102, 102, 102));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(102, 102, 102));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(102, 102, 102));
        jButton7.setText("Refrescar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setText("ID :");

        jLabel2.setText("Nombre del Cargo:");

        jLabel3.setText("Descripción :");

        jLabel4.setText("Estado :");

        txtId.setEditable(false);
        txtId.setEnabled(false);

        txtCargo.setBackground(new java.awt.Color(204, 204, 204));
        txtCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCargo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        chkEstado.setText("Activo");

        btnGuardar.setBackground(new java.awt.Color(102, 204, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("ID del Área:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkEstado)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxArea, 0, 113, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkEstado)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnGuardar))))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout pnlCPPrincipalLayout = new javax.swing.GroupLayout(pnlCPPrincipal);
        pnlCPPrincipal.setLayout(pnlCPPrincipalLayout);
        pnlCPPrincipalLayout.setHorizontalGroup(
            pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlCPPrincipalLayout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        pnlCPPrincipalLayout.setVerticalGroup(
            pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCPPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCPMouseClicked
         
    }//GEN-LAST:event_tblCPMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int row = tblCP.getSelectedRow();       
        int id=-1;
        String nombre="";
        String [] botones = { "Si", "No"};  
        int result = -1;
        try {
            id = Integer.parseInt(String.valueOf(tblCP.getValueAt(row, 0)));
            nombre = String.valueOf(tblCP.getValueAt(row, 2));
            result = JOptionPane.showOptionDialog(null, "Seguro que quieres eliminar:\n"+nombre, "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Aviso", JOptionPane.WARNING_MESSAGE);
        }   
        
        if (result==0 && id!=-1){
            try {
                CPJpaController.destroy(id);
            } catch (IllegalOrphanException ex) {
                Logger.getLogger(FrmCargosPersonal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(FrmCargosPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        listar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int row = tblCP.getSelectedRow();       
        try {
            String id = String.valueOf(tblCP.getValueAt(row, 0));
            String idArea = String.valueOf(tblCP.getValueAt(row, 1));
            String nombre = String.valueOf(tblCP.getValueAt(row, 2));
            String desc = String.valueOf(tblCP.getValueAt(row, 3));
            String estado = String.valueOf(tblCP.getValueAt(row, 4));
            
            if (estado=="Activo") {
                chkEstado.setSelected(true);
            }else{
                chkEstado.setSelected(false);
            }      
            txtId.setText(id);           
            txtCargo.setText(nombre);
            txtDescripcion.setText(desc);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Aviso", JOptionPane.WARNING_MESSAGE);
        }          
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
                 
        String[] areas = {""};
        
        if (!"".equals(txtCargo.getText()) && !"".equals(txtDescripcion.getText())){
            try {
                area = areaJpaController.findAreaEntities();
                for (Area a : area){
                    areas[0] = a.getName();                
                    if (a.getName()==cbxArea.getSelectedItem()) {
                        if("".equals(txtId.getText())){
                            CargoPersonal cp = new CargoPersonal();
                            cp.setIdArea(a);
                            cp.setName(txtCargo.getText());
                            cp.setDescription(txtDescripcion.getText());
                            if (chkEstado.isSelected()){
                                cp.setStatus("1".charAt(0));
                            }else{
                                cp.setStatus("0".charAt(0));
                            }                       
                            CPJpaController.create(cp);
                        }else{
                            CargoPersonal cp = new CargoPersonal();                           
                            cp.setId(Integer.parseInt(txtId.getText()));
                            cp.setIdArea(a);
                            cp.setName(txtCargo.getText());
                            cp.setDescription(txtDescripcion.getText());
                            List<Employe> el = emJpaController.findEmployeEntities();
                            cp.setEmployeList(el);
                            if (chkEstado.isSelected()){
                                cp.setStatus("1".charAt(0));
                            }else{
                                cp.setStatus("0".charAt(0));
                            } 
                            CPJpaController.edit(cp);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("ERROR: "+e);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Rellene los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
  
        listar();
            
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        listar();
        listarCbxAreas();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtCargo.setText("");
        txtId.setText("");
        txtDescripcion.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCargosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCargosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCargosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCargosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCargosPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxArea;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlCPPrincipal;
    private javax.swing.JTable tblCP;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
