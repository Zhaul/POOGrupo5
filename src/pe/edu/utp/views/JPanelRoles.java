package pe.edu.utp.views;

import java.awt.HeadlessException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.controllers.RolJpaController;
import pe.edu.utp.controllers.exceptions.IllegalOrphanException;
import pe.edu.utp.controllers.exceptions.NonexistentEntityException;
import pe.edu.utp.entity.Rol;

public class JPanelRoles extends javax.swing.JPanel {

    private final RolJpaController rolJpaController = new RolJpaController();
    private DefaultTableModel model;
    List<Rol> lista;
    private String accion = "";

    public JPanelRoles() {
        initComponents();
        listar();
        disabledForm();
    }

    private void listar() {
        model = (DefaultTableModel) tblListado.getModel();
        if (model.getRowCount() > 0) {
            model.setNumRows(0);
        }
        Object[] obj = new Object[3];
        try {
            lista = rolJpaController.findRolEntities();
            for (Rol r : lista) {
                obj[0] = r.getId();
                obj[1] = r.getName();
                obj[2] = r.getStatus().toString().equalsIgnoreCase("1") ? "Activo" : "Inactivo";
                model.addRow(obj);
            }
            tblListado.setModel(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void disabledForm() {
        txtnombreRol.setEnabled(false);
        chkEstado.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        tblListado.setEnabled(true);
        txtId.setText("");
        txtnombreRol.setText("");
        chkEstado.setSelected(true);
    }

    private void enabledForm() {
        txtnombreRol.setEnabled(true);
        chkEstado.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        tblListado.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnombreRol = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chkEstado = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("ID :");

        txtId.setEditable(false);

        jLabel3.setText("Nombre del rol :");

        jLabel4.setText("Esatdo :");

        chkEstado.setSelected(true);
        chkEstado.setText("Activo");
        chkEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEstadoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chkEstado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(226, 226, 226)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkEstado))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre del rol", "Esatdo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListado);
        if (tblListado.getColumnModel().getColumnCount() > 0) {
            tblListado.getColumnModel().getColumn(0).setMaxWidth(80);
            tblListado.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnEditar)
                        .addGap(8, 8, 8)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEstadoActionPerformed
        if (chkEstado.isSelected()) {
            chkEstado.setText("Activo");
        } else {
            chkEstado.setText("Inactivo");
        }
    }//GEN-LAST:event_chkEstadoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        disabledForm();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.accion = "add";
        this.enabledForm();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if (this.accion.equalsIgnoreCase("edit")) {
                if (txtId.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Tiene que seleccionar un registro de la lista", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            if (txtnombreRol.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Tiene que ingresar el nombre del rol", "Advertencia", JOptionPane.WARNING_MESSAGE);
                txtnombreRol.requestFocus();
                return;
            }

            Rol rol = new Rol();
            rol.setName(txtnombreRol.getText());
            rol.setStatus(chkEstado.isSelected() ? '1' : '0');
            int rpta = 0;

            switch (accion) {
                case "add" -> {
                    rolJpaController.create(rol);
                    rpta = 1;
                }
                case "edit" -> {
                    rol.setId(Integer.parseInt(txtId.getText()));
                    rol.setPermisoList(rolJpaController.findRol(Integer.parseInt(txtId.getText())).getPermisoList());
                    rol.setEmployeList(rolJpaController.findRol(Integer.parseInt(txtId.getText())).getEmployeList());
                    rolJpaController.edit(rol);
                    rpta = 1;
                }
                default -> JOptionPane.showMessageDialog(null, "No se encontró la acción a realizar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

            if (rpta == 1) {
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                listar();
                disabledForm();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar la operación, consulte los logs del sistema", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPanelRoles.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JPanelRoles.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblListado.getSelectedRowCount() == 1) {
            this.accion = "edit";
            enabledForm();
            int row = tblListado.getSelectedRow();
            txtId.setText(tblListado.getValueAt(row, 0).toString());
            txtnombreRol.setText(tblListado.getValueAt(row, 1).toString());
            chkEstado.setSelected(tblListado.getValueAt(row, 2).toString().equalsIgnoreCase("Activo"));
            if (chkEstado.isSelected()) {
                chkEstado.setText("Activo");
            } else {
                chkEstado.setText("Inactivo");
            }
            txtnombreRol.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Tiene que seleccionar un registro de la lista", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (tblListado.getSelectedRowCount() == 1) {
                int row = tblListado.getSelectedRow();
                int id = Integer.parseInt(tblListado.getValueAt(row, 0).toString());
                String nombreRol = tblListado.getValueAt(row, 1).toString();
                if (JOptionPane.showConfirmDialog(null, "¿Seguro de eliminar el rol " + nombreRol + "?") == JOptionPane.YES_OPTION) {
                    rolJpaController.destroy(id);
                    JOptionPane.showMessageDialog(null, "Operación realizada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    listar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tiene que seleccionar un registro de la lista", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (HeadlessException | NumberFormatException | IllegalOrphanException | NonexistentEntityException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar la operación, consulte los logs del sistema", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtnombreRol;
    // End of variables declaration//GEN-END:variables
}
