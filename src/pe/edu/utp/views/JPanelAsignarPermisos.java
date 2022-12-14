package pe.edu.utp.views;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.controllers.PermisoJpaController;
import pe.edu.utp.controllers.RolJpaController;
import pe.edu.utp.controllers.exceptions.NonexistentEntityException;
import pe.edu.utp.entity.Rol;
import pe.edu.utp.entity.Permiso;

public class JPanelAsignarPermisos extends javax.swing.JPanel {

    private final RolJpaController rolJpaController = new RolJpaController();
    private final PermisoJpaController permisoJpaController = new PermisoJpaController();
    private DefaultTableModel model;
    List<Permiso> listaPermisosAll;
    List<Permiso> listaPermisosEnabled;
    List<Rol> listaRolesAll;

    public JPanelAsignarPermisos() {
        initComponents();
        getPermisosAll();
        getRolesAll();
        getPermisosEnabled();
    }

    private void getPermisosAll() {
        model = (DefaultTableModel) tblListado.getModel();
        if (model.getRowCount() > 0) {
            model.setNumRows(0);
        }
        Object[] obj = new Object[3];
        try {
            listaPermisosAll = permisoJpaController.findPermisoEntities();
            for (Permiso p : listaPermisosAll) {
                obj[0] = false;
                obj[1] = p.getName();
                obj[2] = p.getId();
                model.addRow(obj);
            }
            tblListado.setModel(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void getPermisosEnabled() {
        if (!listaPermisosAll.isEmpty() && !listaRolesAll.isEmpty()) {
            model = (DefaultTableModel) tblListado.getModel();
            if (model.getRowCount() > 0) {
                model.setNumRows(0);
            }
            Object[] obj = new Object[3];
            try {
                listaPermisosEnabled = listaRolesAll.get(cboRoles.getSelectedIndex()).getPermisoList();
                for (Permiso p : listaPermisosAll) {
                    obj[0] = false;
                    for (Permiso p1 : listaPermisosEnabled) {
                        if (p1.getId().equals(p.getId())) {
                            obj[0] = true;
                        }
                    }
                    obj[1] = p.getName();
                    obj[2] = p.getId();
                    model.addRow(obj);
                }
                tblListado.setModel(model);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            model = (DefaultTableModel) tblListado.getModel();
            if (model.getRowCount() > 0) {
                model.setNumRows(0);
            }
        }
    }

    private void getRolesAll() {
        try {
            listaRolesAll = rolJpaController.findRolByStatus("1");

            for (Rol r : listaRolesAll) {
                cboRoles.addItem(r.getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboRoles = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Seleccionar rol :");

        cboRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRolesActionPerformed(evt);
            }
        });

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Activo", "Permiso", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
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
            tblListado.getColumnModel().getColumn(0).setPreferredWidth(25);
            tblListado.getColumnModel().getColumn(2).setResizable(false);
            tblListado.getColumnModel().getColumn(2).setPreferredWidth(0);
        }

        jLabel2.setText("Listado de permisos :");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cboRoles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRolesActionPerformed
        getPermisosEnabled();
    }//GEN-LAST:event_cboRolesActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        List<Permiso> newPermisos = new ArrayList<>();
        for (int i = 0; i < tblListado.getRowCount(); i++) {
            if (Boolean.parseBoolean(tblListado.getValueAt(i, 0).toString())) {
                newPermisos.add(new Permiso(tblListado.getValueAt(i, 2).toString(), tblListado.getValueAt(i, 1).toString()));
            }
        }
        listaRolesAll.get(cboRoles.getSelectedIndex()).setPermisoList(newPermisos);
        listaRolesAll.get(cboRoles.getSelectedIndex()).setEmployeList(listaRolesAll.get(cboRoles.getSelectedIndex()).getEmployeList());
        try {
            rolJpaController.edit(listaRolesAll.get(cboRoles.getSelectedIndex()));
            getPermisosEnabled();
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (NonexistentEntityException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboRoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListado;
    // End of variables declaration//GEN-END:variables
}
