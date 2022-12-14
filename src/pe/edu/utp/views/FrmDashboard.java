package pe.edu.utp.views;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import pe.edu.utp.entity.Employe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FrmDashboard extends javax.swing.JFrame {

    public Employe employe = null;
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            lblFecha.setText(dtf.format(LocalDateTime.now()));
        }
    });

    public FrmDashboard() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        timer.start();
        this.panelMantenimiento.setVisible(false);
        this.panelOperaciones.setVisible(false);
        this.panelReportes.setVisible(false);
        this.panelSeguridad.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSeguridad = new javax.swing.JPanel();
        btnSeguridad1 = new javax.swing.JLabel();
        panelSeguridad = new javax.swing.JPanel();
        subRoles = new javax.swing.JButton();
        subPermisos = new javax.swing.JButton();
        btnMantenimiento = new javax.swing.JPanel();
        btnMantenimiento1 = new javax.swing.JLabel();
        panelMantenimiento = new javax.swing.JPanel();
        subMenuAreas = new javax.swing.JButton();
        subCargosPersonal = new javax.swing.JButton();
        subEmpleados = new javax.swing.JButton();
        btnOperaciones = new javax.swing.JPanel();
        btnOperaciones1 = new javax.swing.JLabel();
        panelOperaciones = new javax.swing.JPanel();
        subHorarios = new javax.swing.JButton();
        subAsistencia = new javax.swing.JButton();
        subJustificaciones = new javax.swing.JButton();
        btnReportes = new javax.swing.JPanel();
        btnReportes1 = new javax.swing.JLabel();
        panelReportes = new javax.swing.JPanel();
        subReportAsisstencia = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblNames = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Asistencia de Nemcor SAC");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(25, 114, 87));
        jPanel1.setMaximumSize(new java.awt.Dimension(150, 32767));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 790));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel8.setBackground(new java.awt.Color(25, 114, 87));
        jPanel8.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel8.setPreferredSize(new java.awt.Dimension(120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/resources/mas.png"))); // NOI18N
        jLabel1.setText(" ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel8);

        btnSeguridad.setBackground(new java.awt.Color(25, 114, 87));
        btnSeguridad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeguridad.setMaximumSize(new java.awt.Dimension(32767, 50));
        btnSeguridad.setPreferredSize(new java.awt.Dimension(120, 50));
        btnSeguridad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeguridadMouseClicked(evt);
            }
        });

        btnSeguridad1.setForeground(new java.awt.Color(255, 255, 255));
        btnSeguridad1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSeguridad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/resources/proteger_1.png"))); // NOI18N
        btnSeguridad1.setText("Seguridad");
        btnSeguridad1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeguridad1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeguridad1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnSeguridadLayout = new javax.swing.GroupLayout(btnSeguridad);
        btnSeguridad.setLayout(btnSeguridadLayout);
        btnSeguridadLayout.setHorizontalGroup(
            btnSeguridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSeguridadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSeguridad1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        );
        btnSeguridadLayout.setVerticalGroup(
            btnSeguridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSeguridadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSeguridad1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(btnSeguridad);

        panelSeguridad.setBackground(new java.awt.Color(25, 114, 87));
        panelSeguridad.setMaximumSize(new java.awt.Dimension(32767, 50));
        panelSeguridad.setMinimumSize(new java.awt.Dimension(120, 50));
        panelSeguridad.setPreferredSize(new java.awt.Dimension(120, 50));
        panelSeguridad.setLayout(new java.awt.GridLayout(2, 0));

        subRoles.setBackground(new java.awt.Color(25, 114, 87));
        subRoles.setForeground(new java.awt.Color(255, 255, 255));
        subRoles.setText("     Roles del sistema");
        subRoles.setBorder(null);
        subRoles.setBorderPainted(false);
        subRoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subRoles.setFocusPainted(false);
        subRoles.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subRoles.setMaximumSize(new java.awt.Dimension(120, 25));
        subRoles.setMinimumSize(new java.awt.Dimension(120, 25));
        subRoles.setPreferredSize(new java.awt.Dimension(120, 25));
        subRoles.setRequestFocusEnabled(false);
        subRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subRolesActionPerformed(evt);
            }
        });
        panelSeguridad.add(subRoles);

        subPermisos.setBackground(new java.awt.Color(25, 114, 87));
        subPermisos.setForeground(new java.awt.Color(255, 255, 255));
        subPermisos.setText("     Asignar permisos");
        subPermisos.setBorder(null);
        subPermisos.setBorderPainted(false);
        subPermisos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subPermisos.setFocusPainted(false);
        subPermisos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subPermisos.setMaximumSize(new java.awt.Dimension(120, 25));
        subPermisos.setMinimumSize(new java.awt.Dimension(120, 25));
        subPermisos.setPreferredSize(new java.awt.Dimension(120, 25));
        subPermisos.setRequestFocusEnabled(false);
        subPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subPermisosActionPerformed(evt);
            }
        });
        panelSeguridad.add(subPermisos);

        jPanel1.add(panelSeguridad);

        btnMantenimiento.setBackground(new java.awt.Color(25, 114, 87));
        btnMantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenimiento.setMaximumSize(new java.awt.Dimension(32767, 50));
        btnMantenimiento.setPreferredSize(new java.awt.Dimension(120, 50));
        btnMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMantenimientoMouseClicked(evt);
            }
        });

        btnMantenimiento1.setForeground(new java.awt.Color(255, 255, 255));
        btnMantenimiento1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMantenimiento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/resources/db.png"))); // NOI18N
        btnMantenimiento1.setText("Mantenimiento");
        btnMantenimiento1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenimiento1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMantenimiento1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnMantenimientoLayout = new javax.swing.GroupLayout(btnMantenimiento);
        btnMantenimiento.setLayout(btnMantenimientoLayout);
        btnMantenimientoLayout.setHorizontalGroup(
            btnMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnMantenimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMantenimiento1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        );
        btnMantenimientoLayout.setVerticalGroup(
            btnMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMantenimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMantenimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(btnMantenimiento);

        panelMantenimiento.setBackground(new java.awt.Color(25, 114, 87));
        panelMantenimiento.setMaximumSize(new java.awt.Dimension(32767, 75));
        panelMantenimiento.setMinimumSize(new java.awt.Dimension(120, 75));
        panelMantenimiento.setPreferredSize(new java.awt.Dimension(120, 75));
        panelMantenimiento.setLayout(new java.awt.GridLayout(3, 0));

        subMenuAreas.setBackground(new java.awt.Color(25, 114, 87));
        subMenuAreas.setForeground(new java.awt.Color(255, 255, 255));
        subMenuAreas.setText("     Áreas administrativas");
        subMenuAreas.setBorder(null);
        subMenuAreas.setBorderPainted(false);
        subMenuAreas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subMenuAreas.setFocusPainted(false);
        subMenuAreas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subMenuAreas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        subMenuAreas.setMargin(new java.awt.Insets(2, 50, 2, 14));
        subMenuAreas.setMaximumSize(new java.awt.Dimension(120, 25));
        subMenuAreas.setMinimumSize(new java.awt.Dimension(120, 25));
        subMenuAreas.setPreferredSize(new java.awt.Dimension(120, 25));
        subMenuAreas.setRequestFocusEnabled(false);
        subMenuAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuAreasActionPerformed(evt);
            }
        });
        panelMantenimiento.add(subMenuAreas);

        subCargosPersonal.setBackground(new java.awt.Color(25, 114, 87));
        subCargosPersonal.setForeground(new java.awt.Color(255, 255, 255));
        subCargosPersonal.setText("     Cargos del personal");
        subCargosPersonal.setBorder(null);
        subCargosPersonal.setBorderPainted(false);
        subCargosPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subCargosPersonal.setFocusPainted(false);
        subCargosPersonal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subCargosPersonal.setMaximumSize(new java.awt.Dimension(120, 25));
        subCargosPersonal.setMinimumSize(new java.awt.Dimension(120, 25));
        subCargosPersonal.setPreferredSize(new java.awt.Dimension(120, 25));
        subCargosPersonal.setRequestFocusEnabled(false);
        subCargosPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subCargosPersonalActionPerformed(evt);
            }
        });
        panelMantenimiento.add(subCargosPersonal);

        subEmpleados.setBackground(new java.awt.Color(25, 114, 87));
        subEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        subEmpleados.setText("     Empleados");
        subEmpleados.setBorder(null);
        subEmpleados.setBorderPainted(false);
        subEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subEmpleados.setFocusPainted(false);
        subEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subEmpleados.setMaximumSize(new java.awt.Dimension(120, 25));
        subEmpleados.setMinimumSize(new java.awt.Dimension(120, 25));
        subEmpleados.setPreferredSize(new java.awt.Dimension(120, 25));
        subEmpleados.setRequestFocusEnabled(false);
        subEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subEmpleadosActionPerformed(evt);
            }
        });
        panelMantenimiento.add(subEmpleados);

        jPanel1.add(panelMantenimiento);

        btnOperaciones.setBackground(new java.awt.Color(25, 114, 87));
        btnOperaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOperaciones.setMaximumSize(new java.awt.Dimension(32767, 50));
        btnOperaciones.setPreferredSize(new java.awt.Dimension(120, 50));
        btnOperaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOperacionesMouseClicked(evt);
            }
        });

        btnOperaciones1.setForeground(new java.awt.Color(255, 255, 255));
        btnOperaciones1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOperaciones1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/resources/calendario.png"))); // NOI18N
        btnOperaciones1.setText("Operaciones");
        btnOperaciones1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOperaciones1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOperaciones1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnOperacionesLayout = new javax.swing.GroupLayout(btnOperaciones);
        btnOperaciones.setLayout(btnOperacionesLayout);
        btnOperacionesLayout.setHorizontalGroup(
            btnOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnOperacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOperaciones1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        );
        btnOperacionesLayout.setVerticalGroup(
            btnOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnOperacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOperaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(btnOperaciones);

        panelOperaciones.setBackground(new java.awt.Color(25, 114, 87));
        panelOperaciones.setMaximumSize(new java.awt.Dimension(32767, 75));
        panelOperaciones.setLayout(new java.awt.GridLayout(3, 0));

        subHorarios.setBackground(new java.awt.Color(25, 114, 87));
        subHorarios.setForeground(new java.awt.Color(255, 255, 255));
        subHorarios.setText("     Registrar horarios");
        subHorarios.setBorder(null);
        subHorarios.setBorderPainted(false);
        subHorarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subHorarios.setFocusPainted(false);
        subHorarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subHorarios.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        subHorarios.setMargin(new java.awt.Insets(2, 50, 2, 14));
        subHorarios.setMaximumSize(new java.awt.Dimension(120, 25));
        subHorarios.setMinimumSize(new java.awt.Dimension(120, 25));
        subHorarios.setPreferredSize(new java.awt.Dimension(120, 25));
        subHorarios.setRequestFocusEnabled(false);
        subHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subHorariosActionPerformed(evt);
            }
        });
        panelOperaciones.add(subHorarios);

        subAsistencia.setBackground(new java.awt.Color(25, 114, 87));
        subAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        subAsistencia.setText("     Registrar asistencia");
        subAsistencia.setBorder(null);
        subAsistencia.setBorderPainted(false);
        subAsistencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subAsistencia.setFocusPainted(false);
        subAsistencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subAsistencia.setMaximumSize(new java.awt.Dimension(120, 25));
        subAsistencia.setMinimumSize(new java.awt.Dimension(120, 25));
        subAsistencia.setPreferredSize(new java.awt.Dimension(120, 25));
        subAsistencia.setRequestFocusEnabled(false);
        panelOperaciones.add(subAsistencia);

        subJustificaciones.setBackground(new java.awt.Color(25, 114, 87));
        subJustificaciones.setForeground(new java.awt.Color(255, 255, 255));
        subJustificaciones.setText("     Registrar justificación");
        subJustificaciones.setBorder(null);
        subJustificaciones.setBorderPainted(false);
        subJustificaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subJustificaciones.setFocusPainted(false);
        subJustificaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subJustificaciones.setMaximumSize(new java.awt.Dimension(120, 25));
        subJustificaciones.setMinimumSize(new java.awt.Dimension(120, 25));
        subJustificaciones.setPreferredSize(new java.awt.Dimension(120, 25));
        subJustificaciones.setRequestFocusEnabled(false);
        subJustificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subJustificacionesActionPerformed(evt);
            }
        });
        panelOperaciones.add(subJustificaciones);

        jPanel1.add(panelOperaciones);

        btnReportes.setBackground(new java.awt.Color(25, 114, 87));
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setMaximumSize(new java.awt.Dimension(32767, 50));
        btnReportes.setPreferredSize(new java.awt.Dimension(120, 50));
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
        });

        btnReportes1.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/resources/estadisticas.png"))); // NOI18N
        btnReportes1.setText("Reportes");
        btnReportes1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportes1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnReportesLayout = new javax.swing.GroupLayout(btnReportes);
        btnReportes.setLayout(btnReportesLayout);
        btnReportesLayout.setHorizontalGroup(
            btnReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReportes1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        );
        btnReportesLayout.setVerticalGroup(
            btnReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReportes1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(btnReportes);

        panelReportes.setBackground(new java.awt.Color(25, 114, 87));
        panelReportes.setMaximumSize(new java.awt.Dimension(32767, 75));
        panelReportes.setLayout(new java.awt.GridLayout(3, 0));

        subReportAsisstencia.setBackground(new java.awt.Color(25, 114, 87));
        subReportAsisstencia.setForeground(new java.awt.Color(255, 255, 255));
        subReportAsisstencia.setText("     Asistencias");
        subReportAsisstencia.setBorder(null);
        subReportAsisstencia.setBorderPainted(false);
        subReportAsisstencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subReportAsisstencia.setFocusPainted(false);
        subReportAsisstencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subReportAsisstencia.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        subReportAsisstencia.setMargin(new java.awt.Insets(2, 50, 2, 14));
        subReportAsisstencia.setMaximumSize(new java.awt.Dimension(120, 25));
        subReportAsisstencia.setMinimumSize(new java.awt.Dimension(120, 25));
        subReportAsisstencia.setPreferredSize(new java.awt.Dimension(120, 25));
        subReportAsisstencia.setRequestFocusEnabled(false);
        subReportAsisstencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subReportAsisstenciaActionPerformed(evt);
            }
        });
        panelReportes.add(subReportAsisstencia);

        jButton10.setBackground(new java.awt.Color(25, 114, 87));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("     Justificaciones");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setFocusPainted(false);
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.setMaximumSize(new java.awt.Dimension(120, 25));
        jButton10.setMinimumSize(new java.awt.Dimension(120, 25));
        jButton10.setPreferredSize(new java.awt.Dimension(120, 25));
        jButton10.setRequestFocusEnabled(false);
        panelReportes.add(jButton10);

        jButton11.setBackground(new java.awt.Color(25, 114, 87));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("     Empleados");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setFocusPainted(false);
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton11.setMaximumSize(new java.awt.Dimension(120, 25));
        jButton11.setMinimumSize(new java.awt.Dimension(120, 25));
        jButton11.setPreferredSize(new java.awt.Dimension(120, 25));
        jButton11.setRequestFocusEnabled(false);
        panelReportes.add(jButton11);

        jPanel1.add(panelReportes);

        getContentPane().add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(809, 511));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(603, 40));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel5.setPreferredSize(new java.awt.Dimension(710, 40));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitle.setText("Inicio > Dashboard");

        lblNames.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNames.setText("jLabel2");

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("29/02/2000 12:30:30");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(lblNames, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(lblNames))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblFecha)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/resources/nemcor-logo.png"))); // NOI18N

        jLabel3.setText("SISTEMA DE ASISTENCIA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4);

        jPanel2.add(jPanel3);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        if (employe != null) {
            lblNames.setText(employe.getNames());
        }
    }//GEN-LAST:event_formComponentShown

    private void subRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subRolesActionPerformed
        JPanelRoles panel = new JPanelRoles();
        showPanel(panel);
        this.lblTitle.setText("Inicio > Seguridad > Roles");
    }//GEN-LAST:event_subRolesActionPerformed

    private void subMenuAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAreasActionPerformed
        JPanelArea panel = new JPanelArea();
        panel.setSize(694, 485);
        panel.setLocation(0, 0);
        this.jPanel4.removeAll();
        this.jPanel4.add(panel, BorderLayout.CENTER);
        this.jPanel4.revalidate();
        this.jPanel4.repaint();
        this.lblTitle.setText("Inicio > Mantenimiento > Áreas");
    }//GEN-LAST:event_subMenuAreasActionPerformed

    private void showPanel(JPanel panel){
        panel.setSize(jPanel4.getSize());
        panel.setLocation(0, 0);
        this.jPanel4.removeAll();
        this.jPanel4.add(panel, BorderLayout.CENTER);
        this.jPanel4.revalidate();
        this.jPanel4.repaint();
    }
    
    private void btnSeguridad1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeguridad1MouseClicked
        this.panelMantenimiento.setVisible(false);
        this.panelOperaciones.setVisible(false);
        this.panelReportes.setVisible(false);
        this.panelSeguridad.setVisible(!this.panelSeguridad.isVisible());
    }//GEN-LAST:event_btnSeguridad1MouseClicked

    private void btnSeguridadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeguridadMouseClicked
        this.panelMantenimiento.setVisible(false);
        this.panelOperaciones.setVisible(false);
        this.panelReportes.setVisible(false);
        this.panelSeguridad.setVisible(!this.panelSeguridad.isVisible());
    }//GEN-LAST:event_btnSeguridadMouseClicked

    private void btnMantenimiento1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenimiento1MouseClicked
        this.panelSeguridad.setVisible(false);
        this.panelOperaciones.setVisible(false);
        this.panelReportes.setVisible(false);
        this.panelMantenimiento.setVisible(!this.panelMantenimiento.isVisible());
    }//GEN-LAST:event_btnMantenimiento1MouseClicked

    private void btnMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenimientoMouseClicked
        this.panelSeguridad.setVisible(false);
        this.panelOperaciones.setVisible(false);
        this.panelReportes.setVisible(false);
        this.panelMantenimiento.setVisible(!this.panelMantenimiento.isVisible());
    }//GEN-LAST:event_btnMantenimientoMouseClicked

    private void btnOperaciones1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOperaciones1MouseClicked
        this.panelSeguridad.setVisible(false);
        this.panelMantenimiento.setVisible(false);
        this.panelReportes.setVisible(false);
        this.panelOperaciones.setVisible(!this.panelOperaciones.isVisible());
    }//GEN-LAST:event_btnOperaciones1MouseClicked

    private void btnOperacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOperacionesMouseClicked
        this.panelSeguridad.setVisible(false);
        this.panelMantenimiento.setVisible(false);
        this.panelReportes.setVisible(false);
        this.panelOperaciones.setVisible(!this.panelOperaciones.isVisible());
    }//GEN-LAST:event_btnOperacionesMouseClicked

    private void btnReportes1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportes1MouseClicked
        this.panelSeguridad.setVisible(false);
        this.panelMantenimiento.setVisible(false);
        this.panelOperaciones.setVisible(false);
        this.panelReportes.setVisible(!this.panelReportes.isVisible());
    }//GEN-LAST:event_btnReportes1MouseClicked

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        this.panelSeguridad.setVisible(false);
        this.panelMantenimiento.setVisible(false);
        this.panelOperaciones.setVisible(false);
        this.panelReportes.setVisible(!this.panelReportes.isVisible());
    }//GEN-LAST:event_btnReportesMouseClicked

    private void subPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subPermisosActionPerformed
        JPanelAsignarPermisos panel = new JPanelAsignarPermisos();
        showPanel(panel);
        this.lblTitle.setText("Inicio > Seguridad > Asignar permisos");
    }//GEN-LAST:event_subPermisosActionPerformed

    private void subCargosPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subCargosPersonalActionPerformed
        JPanelCargosPersonal panel = new JPanelCargosPersonal();
        panel.setSize(619, 485);
        panel.setLocation(0, 0);
        this.jPanel4.removeAll();
        this.jPanel4.add(panel, BorderLayout.CENTER);
        this.jPanel4.revalidate();
        this.jPanel4.repaint();
        this.lblTitle.setText("Inicio > Mantenimiento > Cargos del personal");
    }//GEN-LAST:event_subCargosPersonalActionPerformed

    private void subEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subEmpleadosActionPerformed
        JPanelEmpleados panel = new JPanelEmpleados();
        panel.setSize(900, 722);
        panel.setLocation(0, 0);
        this.jPanel4.removeAll();
        this.jPanel4.add(panel, BorderLayout.CENTER);
        this.jPanel4.revalidate();
        this.jPanel4.repaint();
        this.lblTitle.setText("Inicio > Mantenimiento > Empleados");
    }//GEN-LAST:event_subEmpleadosActionPerformed

    private void subHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subHorariosActionPerformed
        JPanelHorarios panel = new JPanelHorarios();
        panel.setSize(900, 722);
        panel.setLocation(0, 0);
        this.jPanel4.removeAll();
        this.jPanel4.add(panel, BorderLayout.CENTER);
        this.jPanel4.revalidate();
        this.jPanel4.repaint();
        this.lblTitle.setText("Inicio > Operaciones > Horarios");
    }//GEN-LAST:event_subHorariosActionPerformed

    private void subReportAsisstenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subReportAsisstenciaActionPerformed
        JPanelGeneralAsistencias panel = new JPanelGeneralAsistencias();
        panel.setSize(900, 722);
        panel.setLocation(0, 0);
        this.jPanel4.removeAll();
        this.jPanel4.add(panel, BorderLayout.CENTER);
        this.jPanel4.revalidate();
        this.jPanel4.repaint();
        this.lblTitle.setText("Inicio > Reportes > Asistencias");
    }//GEN-LAST:event_subReportAsisstenciaActionPerformed

    private void subJustificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subJustificacionesActionPerformed
        JPanelObservaciones panel = new JPanelObservaciones();
        panel.setSize(900, 722);
        panel.setLocation(0, 0);
        this.jPanel4.removeAll();
        this.jPanel4.add(panel, BorderLayout.CENTER);
        this.jPanel4.revalidate();
        this.jPanel4.repaint();
        this.lblTitle.setText("Inicio > Operaciones > Justificaciones");
    }//GEN-LAST:event_subJustificacionesActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnMantenimiento;
    private javax.swing.JLabel btnMantenimiento1;
    private javax.swing.JPanel btnOperaciones;
    private javax.swing.JLabel btnOperaciones1;
    private javax.swing.JPanel btnReportes;
    private javax.swing.JLabel btnReportes1;
    private javax.swing.JPanel btnSeguridad;
    private javax.swing.JLabel btnSeguridad1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNames;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelMantenimiento;
    private javax.swing.JPanel panelOperaciones;
    private javax.swing.JPanel panelReportes;
    private javax.swing.JPanel panelSeguridad;
    private javax.swing.JButton subAsistencia;
    private javax.swing.JButton subCargosPersonal;
    private javax.swing.JButton subEmpleados;
    private javax.swing.JButton subHorarios;
    private javax.swing.JButton subJustificaciones;
    private javax.swing.JButton subMenuAreas;
    private javax.swing.JButton subPermisos;
    private javax.swing.JButton subReportAsisstencia;
    private javax.swing.JButton subRoles;
    // End of variables declaration//GEN-END:variables
}
