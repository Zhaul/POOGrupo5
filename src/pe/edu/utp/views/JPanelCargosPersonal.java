package pe.edu.utp.views;

import java.awt.Color;
import java.awt.HeadlessException;
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

public class JPanelCargosPersonal extends javax.swing.JPanel {

    private final CargoPersonalJpaController cpJpaController = new CargoPersonalJpaController();
    private final AreaJpaController areaJpaController = new AreaJpaController();
    List<CargoPersonal> lista;
    List<Area> listaAreas;

    public JPanelCargosPersonal() {
        initComponents();
        listar();
        listarCbxAreas();
        desabilitarFormulario();
    }

    private void desabilitarFormulario() {
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        txtCargo.setEnabled(false);
        txtDescripcion.setEnabled(false);
        cbxArea.setEnabled(false);
        chkEstado.setEnabled(false);
    }

    private void habilitarFormulario() {
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        txtCargo.setEnabled(true);
        txtDescripcion.setEnabled(true);
        cbxArea.setEnabled(true);
        chkEstado.setEnabled(true);
    }

    private void listar() {
        tblCP.removeAll();
        String[] cabecera = {"ID", "Area", "Nombre", "Descripcion", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
        Object[] obj = new Object[5];
        try {
            lista = cpJpaController.findCargoPersonalEntities();
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
        hr.setBackground(new Color(65, 65, 65));
        hr.setForeground(Color.white);
        hr.setHorizontalAlignment(JLabel.CENTER);
        tblCP.getTableHeader().setDefaultRenderer(hr);
        tblCP.setBackground(new Color(230, 230, 230));
        tblCP.setShowGrid(true);
        tblCP.setGridColor(new Color(0, 0, 0));
        tblCP.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(30);
        tblCP.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(110);
        tblCP.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(110);
        tblCP.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(304);
        tblCP.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(70);

    }

    private void listarCbxAreas() {
        String[] areas = {""};
        cbxArea.removeAllItems();
        try {
            listaAreas = areaJpaController.findAreaEntities();
            for (Area a : listaAreas) {
                areas[0] = a.getName();
                cbxArea.addItem(areas[0]);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
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
        btnRefrescar = new javax.swing.JButton();
        pnlFormulario = new javax.swing.JPanel();
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
        btnAgregar = new javax.swing.JButton();

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

        btnRefrescar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(102, 102, 102));
        btnRefrescar.setText("Refrescar");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        pnlFormulario.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ID :");

        jLabel2.setText("Nombre del Cargo:");

        jLabel3.setText("Descripción :");

        jLabel4.setText("Estado :");

        txtId.setEditable(false);
        txtId.setEnabled(false);

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

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkEstado)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnlFormularioLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFormularioLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(41, 41, 41)
                            .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pnlFormularioLayout.setVerticalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCargo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnGuardar))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkEstado)))))
        );

        btnAgregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(102, 102, 102));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCPPrincipalLayout = new javax.swing.GroupLayout(pnlCPPrincipal);
        pnlCPPrincipal.setLayout(pnlCPPrincipalLayout);
        pnlCPPrincipalLayout.setHorizontalGroup(
            pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCPPrincipalLayout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlCPPrincipalLayout.setVerticalGroup(
            pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCPPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCPMouseClicked

    }//GEN-LAST:event_tblCPMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int row = tblCP.getSelectedRow();
        int id = -1;
        String nombre = "";
        String[] botones = {"Si", "No"};
        int result = -1;
        try {
            id = Integer.parseInt(String.valueOf(tblCP.getValueAt(row, 0)));
            nombre = String.valueOf(tblCP.getValueAt(row, 2));
            result = JOptionPane.showOptionDialog(null, "Seguro que quieres eliminar:\n" + nombre, "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

        if (result == 0 && id != -1) {
            try {
                cpJpaController.destroy(id);
            } catch (IllegalOrphanException | NonexistentEntityException ex) {
                System.out.println(ex.getMessage());
            }
        }
        listar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int row = tblCP.getSelectedRow();
        try {
            String id = String.valueOf(tblCP.getValueAt(row, 0));
            String areaName = String.valueOf(tblCP.getValueAt(row, 1));
            String nombre = String.valueOf(tblCP.getValueAt(row, 2));
            String desc = String.valueOf(tblCP.getValueAt(row, 3));
            String estado = String.valueOf(tblCP.getValueAt(row, 4));

            if ("Activo".equals(estado)) {
                chkEstado.setSelected(true);
            } else {
                chkEstado.setSelected(false);
            }
            txtId.setText(id);
            txtCargo.setText(nombre);
            txtDescripcion.setText(desc);
            cbxArea.setSelectedItem(areaName);
            habilitarFormulario();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        listar();
        listarCbxAreas();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (!"".equals(txtCargo.getText()) && !"".equals(txtDescripcion.getText())) {

            if ("".equals(txtId.getText())) {
                CargoPersonal cp = new CargoPersonal();
                cp.setIdArea(listaAreas.get(cbxArea.getSelectedIndex()));
                cp.setName(txtCargo.getText());
                cp.setDescription(txtDescripcion.getText());
                if (chkEstado.isSelected()) {
                    cp.setStatus("1".charAt(0));
                } else {
                    cp.setStatus("0".charAt(0));
                }
                cpJpaController.create(cp);
            } else {
                try {
                    CargoPersonal cp = new CargoPersonal();
                    cp.setId(Integer.parseInt(txtId.getText()));
                    cp.setIdArea(listaAreas.get(cbxArea.getSelectedIndex()));
                    cp.setName(txtCargo.getText());
                    cp.setDescription(txtDescripcion.getText());
                    cp.setEmployeList(cpJpaController.findCargoPersonal(cp.getId()).getEmployeList());
                    if (chkEstado.isSelected()) {
                        cp.setStatus("1".charAt(0));
                    } else {
                        cp.setStatus("0".charAt(0));
                    }
                    cpJpaController.edit(cp);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(JPanelCargosPersonal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(JPanelCargosPersonal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            vaciar();
            listar();
            desabilitarFormulario();
            tblCP.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(null, "Rellene los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void vaciar() {
        txtCargo.setText("");
        txtId.setText("");
        txtDescripcion.setText("");
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        vaciar();
        desabilitarFormulario();
        tblCP.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        habilitarFormulario();
        tblCP.setEnabled(false);
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JComboBox<String> cbxArea;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlCPPrincipal;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JTable tblCP;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
