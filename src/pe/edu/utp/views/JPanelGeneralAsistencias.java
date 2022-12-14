package pe.edu.utp.views;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.controllers.EmployeJpaController;
import pe.edu.utp.controllers.JustificationJpaController;
import pe.edu.utp.controllers.ScheduleJpaController;
import pe.edu.utp.entity.Schedule;
import pe.edu.utp.entity.Employe;
import pe.edu.utp.entity.Justification;

public class JPanelGeneralAsistencias extends javax.swing.JPanel {

    ScheduleJpaController scheduleJpaC = new ScheduleJpaController();
    EmployeJpaController employeJpaC = new EmployeJpaController();
    JustificationJpaController justiJpaController = new JustificationJpaController();
    Employe employe;

    List<Schedule> scheduleList;
    List<Justification> justiList;

    public JPanelGeneralAsistencias() {
        initComponents();
        cabecera();
    }

    private void listar() {
        String codigo = txtCodigo.getText();
        String[] cabecera = {"Fecha", "Hora", "A", "T", "F", "J"};
        DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
        Object[] obj = new Object[6];
        try {
            scheduleList = employeJpaC.findByCodeEmployee(codigo).getScheduleList();
            
            for (Schedule s : scheduleList) {
                int d = s.getDateStart().getDate();
                int me = s.getDateStart().getMonth() + 1;
                int a = s.getDateStart().getYear() + 1900;
                String h = String.valueOf(s.getHourEntry().getHours());
                String mi = String.valueOf(s.getHourEntry().getMinutes());
                boolean ingreso = false;
                txtNombre.setText(employeJpaC.findByCodeEmployee(codigo).getNames());
                txtApellido.setText(employeJpaC.findByCodeEmployee(codigo).getLastNames());
                
                if (dateInicio.getDate() != null && dateFin.getDate() == null) {
                    s.getDateStart().setDate(s.getDateStart().getDate()+1);
                    if (s.getDateStart().after(dateInicio.getDate()) && s.getDateStart() != null) {
                        obj[0] = d + "/" + me + "/" + a;
                        obj[1] = h + ":" + mi;
                        ingreso=true;
                        System.out.println("1");
                            
                    }
                    s.getDateStart().setDate(s.getDateStart().getDate()-1);
                }else if(dateFin.getDate() != null && dateInicio.getDate() == null){
                    s.getDateStart().setDate(s.getDateStart().getDate() -1);
                    if (s.getDateStart().before(dateFin.getDate()) && s.getDateStart() != null) {
                        obj[0] = d + "/" + me + "/" + a;
                        obj[1] = h + ":" + mi;
                        ingreso = true;
                        System.out.println("2");
                    }
                    s.getDateStart().setDate(s.getDateStart().getDate() + 1);
                }else if(dateInicio.getDate() != null && dateFin.getDate() != null){
                    s.getDateStart().setDate(s.getDateStart().getDate()+1);
                    if (s.getDateStart().after(dateInicio.getDate())&& s.getDateStart() != null) {
                        s.getDateStart().setDate(s.getDateStart().getDate()-2);
                        if ((s.getDateStart().before(dateFin.getDate())) && s.getDateStart() != null) {
                            obj[0] = d + "/" + me + "/" + a;
                            obj[1] = h + ":" + mi;
                            ingreso = true;
                            System.out.println("1 y 2");
                        }
                        s.getDateStart().setDate(s.getDateStart().getDate() + 1);
                    }else{
                        s.getDateStart().setDate(s.getDateStart().getDate() - 1);
                    }                
                    
                } else {
                    try {
                        ingreso=true;
                        obj[0] = d + "/" + me + "/" + a;
                        obj[1] = h + ":" + mi;

                    } catch (Exception e) {
                    }
                }               
                                
                if (ingreso) {
                    if(s.getHourEntry().getTime()<=s.getHourStart().getTime()){
                        obj[2]="X";
                    }else if (s.getHourEntry().getTime()-s.getHourStart().getTime()>=6400000){
                        obj[4]="X";
                    }else{
                        obj[3]="X";
                    }
                    
                    justiList = justiJpaController.findJustificationEntities();
                    
                    for(Justification j : justiList){
                        
                        try {
                            int jd = j.getDate().getDate();
                            int jm = j.getDate().getMonth()+1;
                            int ja = j.getDate().getYear()+1900;

                            if (jd==d && jm==me && ja == a){
                                obj[5]="X";
                            } 
                        } catch (Exception e) {
                            System.out.println("ERROR: "+e);
                        }
  
                        
                    }               
                    modelo.addRow(obj);
                    obj[2]="";
                    obj[3]="";
                    obj[4]="";
                    obj[5]="";
                }
            }
            tblAsistencias.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ponga un codigo valido.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void cabecera() {
        String codigo = txtCodigo.getText();
        String[] cabecera = {"Fecha", "Hora", "A", "T", "F", "J"};
        DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
        Object[] obj = new Object[6];
        tblAsistencias.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        dateInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateFin = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtApellido = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAsistencias = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Codigo del trabajador:");

        txtCodigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Fecha de inicio:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Fecha de fin:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Nombres:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Apellidos:");

        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombre.setText("Name");

        txtApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtApellido.setText("LastName");

        tblAsistencias = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int column){
                for(int i = 0; i < tblAsistencias.getRowCount(); i ++){
                    if(row < 0){
                        return true;
                    }
                }
                return false;
            }
        };
        tblAsistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAsistencias.setFocusable(false);
        tblAsistencias.getTableHeader().setResizingAllowed(false);
        tblAsistencias.getTableHeader().setReorderingAllowed(false);
        tblAsistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAsistenciasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblAsistencias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellido))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblAsistenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAsistenciasMouseClicked

    }//GEN-LAST:event_tblAsistenciasMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        listar();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private com.toedter.calendar.JDateChooser dateFin;
    private com.toedter.calendar.JDateChooser dateInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblAsistencias;
    private javax.swing.JLabel txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JLabel txtNombre;
    // End of variables declaration//GEN-END:variables
}
