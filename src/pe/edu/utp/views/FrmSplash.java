
package pe.edu.utp.views;

/**
 *
 * @author zhaulvaldera
 */
public class FrmSplash extends javax.swing.JFrame {

    public FrmSplash() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pgbCargando = new javax.swing.JProgressBar();
        lblPorcentaje = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Mali", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 114, 87));
        jLabel1.setText("Sistema de Asistencia Nemcor SAC");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        pgbCargando.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        pgbCargando.setForeground(new java.awt.Color(25, 114, 87));
        pgbCargando.setValue(1);
        jPanel1.add(pgbCargando, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 357, 430, 10));

        lblPorcentaje.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblPorcentaje.setForeground(new java.awt.Color(25, 114, 87));
        lblPorcentaje.setText("Cargando 100 %");
        jPanel1.add(lblPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 120, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/resources/nemcor-logo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, 160));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/resources/bg-splash.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSplash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblPorcentaje;
    public javax.swing.JProgressBar pgbCargando;
    // End of variables declaration//GEN-END:variables
}
