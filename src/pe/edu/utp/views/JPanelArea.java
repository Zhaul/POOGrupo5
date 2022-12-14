package pe.edu.utp.views;

import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.entity.CargoPersonal;
import pe.edu.utp.controllers.AreaJpaController;
import pe.edu.utp.controllers.CargoPersonalJpaController;
import pe.edu.utp.controllers.exceptions.IllegalOrphanException;
import pe.edu.utp.controllers.exceptions.NonexistentEntityException;
import pe.edu.utp.entity.Area;

public class JPanelArea extends javax.swing.JPanel {

    private AreaJpaController areaJpaController = new AreaJpaController();
    private CargoPersonalJpaController CPJpaController = new CargoPersonalJpaController();
    List<Area> lista;

    public JPanelArea() {
        initComponents();
        listar();
        desabilitarFormulario();
    }

    private void desabilitarFormulario() {
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        txtArea.setEnabled(false);
        txtDescripcion.setEnabled(false);
        chkEstado.setEnabled(false);
    }

    private void habilitarFormulario() {
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        txtArea.setEnabled(true);
        txtDescripcion.setEnabled(true);
        chkEstado.setEnabled(true);
    }

    private void listar() {
        String[] cabecera = {"ID", "Area", "Descripcion", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
        Object[] obj = new Object[4];
        try {
            lista = areaJpaController.findAreaEntities();
            for (Area a : lista) {
                obj[0] = a.getId();
                obj[1] = a.getName();
                obj[2] = a.getDescription();
                obj[3] = a.getStatus().toString().equalsIgnoreCase("1") ? "Activo" : "Inactivo";
                modelo.addRow(obj);
            }
            tblArea.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        DefaultTableCellRenderer hr = new DefaultTableCellRenderer();
        hr.setBackground(new Color(65, 65, 65));
        hr.setForeground(Color.white);
        hr.setHorizontalAlignment(JLabel.CENTER);
        tblArea.getTableHeader().setDefaultRenderer(hr);
        tblArea.setBackground(new Color(230, 230, 230));
        tblArea.setShowGrid(true);
        tblArea.setGridColor(new Color(0, 0, 0));
        tblArea.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
        tblArea.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(150);
        tblArea.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(354);
        tblArea.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(70);

    }

    private void vaciar() {
        txtArea.setText("");
        txtDescripcion.setText("");
        txtId.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCPPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArea = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        bntRefrescar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        chkEstado = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        bntAgregar = new javax.swing.JButton();

        pnlCPPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlCPPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        tblArea = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int column){
                for(int i = 0; i < tblArea.getRowCount(); i ++){
                    if(row < 0){
                        return true;
                    }
                }
                return false;
            }
        };
        tblArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblArea.setFocusable(false);
        tblArea.setOpaque(false);
        tblArea.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblArea.setShowGrid(false);
        tblArea.getTableHeader().setResizingAllowed(false);
        tblArea.getTableHeader().setReorderingAllowed(false);
        tblArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArea);

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

        bntRefrescar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bntRefrescar.setForeground(new java.awt.Color(102, 102, 102));
        bntRefrescar.setText("Refrescar");
        bntRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRefrescarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ID :");

        jLabel2.setText("Nombre del Area:");

        jLabel3.setText("Descripción :");

        jLabel4.setText("Estado :");

        txtId.setEditable(false);
        txtId.setEnabled(false);

        txtArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setMaximumSize(new java.awt.Dimension(13, 21));
        jScrollPane2.setViewportView(txtDescripcion);

        chkEstado.setText("Activo");

        btnGuardar.setBackground(new java.awt.Color(51, 204, 0));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(chkEstado)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)
                                .addGap(23, 23, 23))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        bntAgregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bntAgregar.setForeground(new java.awt.Color(102, 102, 102));
        bntAgregar.setText("Agregar");
        bntAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCPPrincipalLayout = new javax.swing.GroupLayout(pnlCPPrincipal);
        pnlCPPrincipal.setLayout(pnlCPPrincipalLayout);
        pnlCPPrincipalLayout.setHorizontalGroup(
            pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCPPrincipalLayout.createSequentialGroup()
                        .addGap(0, 60, Short.MAX_VALUE)
                        .addComponent(bntAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCPPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        pnlCPPrincipalLayout.setVerticalGroup(
            pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tblAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAreaMouseClicked

    }//GEN-LAST:event_tblAreaMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int row = tblArea.getSelectedRow();
        int id = -1;
        String nombre = "";
        String[] botones = {"Si", "No"};
        int result = -1;

        if (tblArea.getSelectedRow() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        id = Integer.parseInt(String.valueOf(tblArea.getValueAt(row, 0)));
        nombre = String.valueOf(tblArea.getValueAt(row, 1));
        result = JOptionPane.showOptionDialog(null, "Seguro que quieres eliminar:\n" + nombre, "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);

        if (result == 0 && id != -1) {
            try {
                areaJpaController.destroy(id);
            } catch (IllegalOrphanException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "No puede eliminar esta Area\nporque esta siendo usada.", "Aviso", JOptionPane.ERROR_MESSAGE);
            } catch (NonexistentEntityException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "No puede eliminar esta Area\nporque esta siendo usada.", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        listar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int row = tblArea.getSelectedRow();
        try {
            String id = String.valueOf(tblArea.getValueAt(row, 0));
            String nombre = String.valueOf(tblArea.getValueAt(row, 1));
            String desc = String.valueOf(tblArea.getValueAt(row, 2));
            String estado = String.valueOf(tblArea.getValueAt(row, 3));
            if ("Activo".equals(estado)) {
                chkEstado.setSelected(true);
            } else {
                chkEstado.setSelected(false);
            }
            txtId.setText(id);
            txtArea.setText(nombre);
            txtDescripcion.setText(desc);
            habilitarFormulario();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void bntRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRefrescarActionPerformed
        listar();
    }//GEN-LAST:event_bntRefrescarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (!"".equals(txtArea.getText()) && !"".equals(txtDescripcion.getText())) {
            try {
                if ("".equals(txtId.getText())) {
                    Area area = new Area();
                    area.setName(txtArea.getText());
                    area.setDescription(txtDescripcion.getText());
                    if (chkEstado.isSelected()) {
                        area.setStatus("1".charAt(0));
                    } else {
                        area.setStatus("0".charAt(0));
                    }
                    areaJpaController.create(area);
                } else {
                    Area area = new Area();
                    area.setId(Integer.parseInt(txtId.getText()));
                    area.setName(txtArea.getText());
                    area.setDescription(txtDescripcion.getText());
                    if (chkEstado.isSelected()) {
                        area.setStatus("1".charAt(0));
                    } else {
                        area.setStatus("0".charAt(0));
                    }
                    area.setCargoPersonalList(areaJpaController.findArea(area.getId()).getCargoPersonalList());
                    areaJpaController.edit(area);
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e);
            }

            vaciar();
            listar();
            desabilitarFormulario();
            tblArea.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(null, "Rellene los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        vaciar();
        desabilitarFormulario();
        tblArea.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void bntAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAgregarActionPerformed
        habilitarFormulario();
        tblArea.setEnabled(false);
    }//GEN-LAST:event_bntAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAgregar;
    private javax.swing.JButton bntRefrescar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlCPPrincipal;
    private javax.swing.JTable tblArea;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}