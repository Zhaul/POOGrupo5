package pe.edu.utp.views;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.controllers.CargoPersonalJpaController;
import pe.edu.utp.controllers.EmployeJpaController;
import pe.edu.utp.controllers.RolJpaController;
import pe.edu.utp.controllers.exceptions.IllegalOrphanException;
import pe.edu.utp.controllers.exceptions.NonexistentEntityException;
import pe.edu.utp.entity.CargoPersonal;
import pe.edu.utp.entity.Employe;
import pe.edu.utp.entity.Rol;

public class JPanelEmpleados extends javax.swing.JPanel {

    private final EmployeJpaController employeJpaController = new EmployeJpaController();
    private final RolJpaController rolJpaController = new RolJpaController();
    private final CargoPersonalJpaController cpJpaController = new CargoPersonalJpaController();
    private DefaultTableModel model;
    List<Employe> listaEmpleados;
    List<CargoPersonal> listaCargos;
    List<Rol> listaRolesAll;
    private String accion = "";

    public JPanelEmpleados() {
        initComponents();
        disabledForm();
        getRolesAll();
        getCargosAll();
        listar();
    }

    private void getRolesAll() {
        try {
            listaRolesAll = rolJpaController.findRolByStatus("1");
            for (Rol r : listaRolesAll) {
                cboRol.addItem(r.getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void getCargosAll() {
        try {
            listaCargos = cpJpaController.findByStatus("1");
            for (CargoPersonal c : listaCargos) {
                cboCargo.addItem(c.getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listar() {
        model = (DefaultTableModel) tblListado.getModel();
        if (model.getRowCount() > 0) {
            model.setNumRows(0);
        }
        Object[] obj = new Object[6];
        try {
            listaEmpleados = employeJpaController.findEmployeEntities();
            for (Employe empleado : listaEmpleados) {
                obj[0] = empleado.getId();
                obj[1] = empleado.getNames() + " " + empleado.getLastNames();
                cboDocumento.setSelectedIndex(Integer.parseInt(empleado.getTypeDocument()));
                obj[2] = cboDocumento.getSelectedItem() + " " + empleado.getNumberDocument();
                obj[3] = empleado.getIdCargo().getIdArea().getName();
                obj[4] = empleado.getIdCargo().getName();
                obj[5] = empleado.getStatus().toString().equalsIgnoreCase("1") ? "Activo" : "Inactivo";
                model.addRow(obj);
            }
            tblListado.setModel(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void disabledForm() {
        chkEstado.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        tblListado.setEnabled(true);
        txtId.setText("");
        chkEstado.setSelected(true);
        txtNombres.setText("");
        txtApellidos.setText("");
        chkEstado.setSelected(true);
        txtNumDocumento.setText("");
        txtEmail.setText("");
        txtDireccion.setText("");
        txtCelular.setText("");
        txtCodigoTrabajador.setText("");
        chkEstado.setText("Activo");
        chkFlagAccess.setText("NO");
        txtUsuario.setVisible(false);
        txtContrasenia.setVisible(false);
        lblContrasenia.setVisible(false);
        lblUsuario.setVisible(false);
        chkFlagAccess.setSelected(false);
        rdbMasculino.setSelected(true);
    }

    private void enabledForm() {
        chkEstado.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        tblListado.setEnabled(false);
        //txtnombreRol.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboDocumento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNumDocumento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboCargo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cboRol = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        chkEstado = new javax.swing.JCheckBox();
        rdbFemenino = new javax.swing.JRadioButton();
        rdbMasculino = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        chkFlagAccess = new javax.swing.JCheckBox();
        lblUsuario = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCodigoTrabajador = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        lblContrasenia = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        dtpCumpleanios = new com.toedter.calendar.JDateChooser();
        dtpInicioContrato = new com.toedter.calendar.JDateChooser();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("ID :");

        txtId.setEditable(false);

        jLabel2.setText("Nombres :");

        jLabel3.setText("Apellidos :");

        jLabel4.setText("Documento : ");

        cboDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "PASAPORTE", "CARNET DE EXTRANJERIA" }));

        jLabel5.setText("Número de documento :");

        jLabel6.setText("Cargo : ");

        jLabel7.setText("Rol :");

        jLabel8.setText("Email :");

        jLabel9.setText("Estado :");

        chkEstado.setSelected(true);
        chkEstado.setText("Activo");
        chkEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEstadoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbFemenino);
        rdbFemenino.setText("Masculino");

        buttonGroup1.add(rdbMasculino);
        rdbMasculino.setText("Femenino");

        jLabel10.setText("Sexo :");

        jLabel11.setText("Dirección :");

        jLabel12.setText("Célular :");

        jLabel13.setText("Cumpleaños : ");

        jLabel14.setText("Inicio de contrato :");

        jLabel15.setText("¿Puede acceder al sistema?");

        chkFlagAccess.setSelected(true);
        chkFlagAccess.setText("SI");
        chkFlagAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFlagAccessActionPerformed(evt);
            }
        });

        lblUsuario.setText("Usuario : ");

        jLabel17.setText("Código de trabajador :");

        lblContrasenia.setText("Contraseña : ");

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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtpCumpleanios, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dtpInicioContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(553, 553, 553)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel17)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkFlagAccess)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkEstado)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbFemenino))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(lblContrasenia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar))
                            .addComponent(txtCodigoTrabajador)
                            .addComponent(txtCelular))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addComponent(dtpCumpleanios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dtpInicioContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodigoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(chkFlagAccess)
                            .addComponent(jLabel9)
                            .addComponent(chkEstado)
                            .addComponent(jLabel10)
                            .addComponent(rdbMasculino)
                            .addComponent(rdbFemenino))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContrasenia)
                            .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnGuardar))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

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

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Empleado", "Doc Iden", "Area", "Cargo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListado.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblListado);
        if (tblListado.getColumnModel().getColumnCount() > 0) {
            tblListado.getColumnModel().getColumn(0).setResizable(false);
            tblListado.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblListado.getColumnModel().getColumn(1).setResizable(false);
            tblListado.getColumnModel().getColumn(2).setResizable(false);
            tblListado.getColumnModel().getColumn(3).setResizable(false);
            tblListado.getColumnModel().getColumn(4).setResizable(false);
            tblListado.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblListado.getSelectedRowCount() == 1) {
            this.accion = "edit";
            enabledForm();
            int row = tblListado.getSelectedRow();
            txtId.setText(tblListado.getValueAt(row, 0).toString());
            Employe empl = new Employe();
            empl = employeJpaController.findEmploye(Integer.parseInt(txtId.getText()));
            txtNombres.setText(empl.getNames());
            txtApellidos.setText(empl.getLastNames());
            chkEstado.setSelected(empl.getStatus().toString().equals("1"));
            cboCargo.setSelectedItem(empl.getIdCargo().getName());
            cboDocumento.setSelectedIndex(Integer.parseInt(empl.getTypeDocument()));
            txtNumDocumento.setText(empl.getNumberDocument());
            cboRol.setSelectedItem(empl.getIdRol().getName());
            txtEmail.setText(empl.getEmail());
            txtDireccion.setText(empl.getAddress());
            txtCelular.setText(empl.getPhone());
            dtpCumpleanios.setDate(empl.getDateBirth());
            dtpInicioContrato.setDate(empl.getDateStart());
            txtCodigoTrabajador.setText(empl.getCodeEmployee());
            chkFlagAccess.setSelected(empl.getFlagAccess().toString().equals("1"));
            rdbMasculino.setSelected(empl.getSex().toString().equalsIgnoreCase("M"));
            rdbFemenino.setSelected(empl.getSex().toString().equalsIgnoreCase("F"));
            if (chkEstado.isSelected()) {
                chkEstado.setText("Activo");
            } else {
                chkEstado.setText("Inactivo");
            }
            if (chkFlagAccess.isSelected()) {
                chkFlagAccess.setText("SI");
                txtUsuario.setText(empl.getUser());
                txtContrasenia.setText(empl.getPassword());
                txtUsuario.setVisible(true);
                txtContrasenia.setVisible(true);
                lblContrasenia.setVisible(true);
                lblUsuario.setVisible(true);
            } else {
                chkFlagAccess.setText("NO");
                txtUsuario.setVisible(false);
                txtContrasenia.setVisible(false);
                lblContrasenia.setVisible(false);
                lblUsuario.setVisible(false);
            }

            txtNombres.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Tiene que seleccionar un registro de la lista", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            Employe employe = new Employe();
            employe.setNames(txtNombres.getText());
            employe.setLastNames(txtApellidos.getText());
            employe.setIdCargo(listaCargos.get(cboCargo.getSelectedIndex()));
            employe.setTypeDocument(String.valueOf(cboDocumento.getSelectedIndex()));
            employe.setNumberDocument(txtNumDocumento.getText());
            employe.setIdRol(listaRolesAll.get(cboRol.getSelectedIndex()));
            employe.setEmail(txtEmail.getText());
            employe.setAddress(txtDireccion.getText());
            employe.setPhone(txtCelular.getText());
            employe.setDateBirth(dtpCumpleanios.getDate());
            employe.setDateStart(dtpInicioContrato.getDate());
            employe.setCodeEmployee(txtCodigoTrabajador.getText());
            employe.setStatus(chkEstado.isSelected() ? '1' : '0');
            employe.setFlagAccess(chkFlagAccess.isSelected() ? '1' : '0');
            employe.setSex(rdbMasculino.isSelected() ? 'M' : 'F');
            if (chkFlagAccess.isSelected()) {
                employe.setUser(txtUsuario.getText());
                employe.setPassword(txtContrasenia.getText());
            } else {
                employe.setUser("");
                employe.setPassword("");
            }
            int rpta = 0;

            switch (accion) {
                case "add" -> {
                    employeJpaController.create(employe);
                    rpta = 1;
                }
                case "edit" -> {
                    employe.setId(Integer.parseInt(txtId.getText()));
                    employe.setScheduleList(employeJpaController.findEmploye(Integer.parseInt(txtId.getText())).getScheduleList());
                    employeJpaController.edit(employe);
                    rpta = 1;
                }
                default ->
                    JOptionPane.showMessageDialog(null, "No se encontró la acción a realizar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

            if (rpta == 1) {
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                listar();
                disabledForm();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar la operación, consulte los logs del sistema", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tblListado.getSelectedRowCount() == 1) {
            int row = tblListado.getSelectedRow();
            int id = Integer.parseInt(tblListado.getValueAt(row, 0).toString());
            String nombreEmpleado = tblListado.getValueAt(row, 1).toString();
            if (JOptionPane.showConfirmDialog(null, "¿Seguro de eliminar al empleado " + nombreEmpleado + "?") == JOptionPane.YES_OPTION) {
                try {
                    employeJpaController.destroy(id);
                    JOptionPane.showMessageDialog(null, "Operación realizada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    listar();
                } catch (IllegalOrphanException | NonexistentEntityException ex) {
                    Logger.getLogger(JPanelEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tiene que seleccionar un registro de la lista", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void chkFlagAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFlagAccessActionPerformed
        if (chkFlagAccess.isSelected()) {
            chkFlagAccess.setText("SI");
            txtUsuario.setVisible(true);
            txtContrasenia.setVisible(true);
            lblContrasenia.setVisible(true);
            lblUsuario.setVisible(true);
        } else {
            chkFlagAccess.setText("NO");
            txtUsuario.setVisible(false);
            txtContrasenia.setVisible(false);
            lblContrasenia.setVisible(false);
            lblUsuario.setVisible(false);
        }
    }//GEN-LAST:event_chkFlagAccessActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btagregar;
    private javax.swing.JButton btagregar1;
    private javax.swing.JButton btagregar2;
    private javax.swing.JButton btagregar3;
    private javax.swing.JButton btagregar4;
    private javax.swing.JButton btagregar5;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JComboBox<String> cboDocumento;
    private javax.swing.JComboBox<String> cboRol;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JCheckBox chkFlagAccess;
    private com.toedter.calendar.JDateChooser dtpCumpleanios;
    private com.toedter.calendar.JDateChooser dtpInicioContrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JRadioButton rdbFemenino;
    private javax.swing.JRadioButton rdbMasculino;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodigoTrabajador;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNumDocumento;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
