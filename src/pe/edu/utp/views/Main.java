package pe.edu.utp.views;
/**
 *
 * @author zhaulvaldera
 */
public class Main {

    public static void main(String[] args) {
        FrmSplash frmSplash = new FrmSplash();
        FrmLogin frmLogin = new FrmLogin();
        FrmDashboard frmDashboard = new FrmDashboard();
        frmSplash.setVisible(true);
        boolean isLogin = false;

        try {
            for (int row = 0; row <= 100; row++) {
                Thread.sleep(25);
                frmSplash.pgbCargando.setValue(row);
                frmSplash.lblPorcentaje.setText("Cargando " + row + " %");
            }
            frmSplash.dispose();
            frmLogin.setModal(true);
            frmLogin.setVisible(true);
            isLogin = frmLogin.isLogin;
            if (isLogin) {
                frmDashboard.employe = frmLogin.employe;
                frmDashboard.setVisible(true);
                frmLogin.dispose();
            } else {
                frmLogin.dispose();
                System.exit(0);
            }
            
        } catch (Exception e) {
        }
    }
}
