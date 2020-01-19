package Vista;

import Util.Seleccion;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Salatiel
 */
public class panelAcerca extends javax.swing.JPanel {

    //private MySQL mysql;
    String pass = "";
    String path = "";
    String backup = "mysqldump --user=root --password= -v machine > " + path;
    private String extension = ".sql";
    Runtime rt = Runtime.getRuntime();

    public panelAcerca() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        BtnRepaldo = new javax.swing.JButton();
        BtnRestaurar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setName("panelAcerca"); // NOI18N
        setOpaque(false);
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -7, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(33, 33, 33));
        jSeparator2.setForeground(new java.awt.Color(33, 33, 33));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 20, 130));

        BtnRepaldo.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        BtnRepaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/icons8-copias-de-seguridad-filled-50.png"))); // NOI18N
        BtnRepaldo.setText("Respaldar BD");
        BtnRepaldo.setOpaque(false);
        BtnRepaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRepaldoActionPerformed(evt);
            }
        });
        add(BtnRepaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, 60));

        BtnRestaurar.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        BtnRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/icons8-importar-base-de-datos-filled-50.png"))); // NOI18N
        BtnRestaurar.setText("Restaurar BD");
        BtnRestaurar.setOpaque(false);
        BtnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRestaurarActionPerformed(evt);
            }
        });
        add(BtnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, -1, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Fondo.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 949, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRepaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRepaldoActionPerformed

        try {
            File file;
            file = new File("D:\\Sistema Machines\\Resources\\Respaldo Bd\\Copia de Seguridad ");
            path = file.getAbsolutePath() + Inicio.v.getFechaHoraSistema() + extension;
            System.out.println("" + path);
            int c = JOptionPane.showConfirmDialog(null, "Desea Crear una Copia de Seguridad en esta ruta: \n" + path, "Mensaje de Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/respaldar.png")));
            if (c == JOptionPane.YES_OPTION) {
                backup = "cmd /c mysqldump -u root --password= --databases machine --opt --routines --add-drop-database --add-drop-table --complete-insert --create-options > \"" + path + "\"";
                rt.exec(backup);
                //System.out.println("mysql:= " + backup);
                JOptionPane.showMessageDialog(null, "BackUp Creado Correctamente en:\n" + file.getPath());

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_BtnRepaldoActionPerformed

    private void BtnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRestaurarActionPerformed
        Seleccion o = new Seleccion();
        File file = o.Abrir(this);
        if (file != null) {
            String cad = file.getAbsolutePath();
            System.out.println(cad);
            if (cad.length() > 0) {
                try {
                    File Ofile = new File(cad);
                    path = Ofile.getAbsolutePath();
                    int c = JOptionPane.showConfirmDialog(null, "Desea Restaurar esta Base de datos:\n" + cad, "mensaje de confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/AceptarBD.png")));
                    if (c == JOptionPane.YES_OPTION) {
                        backup = "cmd /c mysql --user=root --password= -e \"source " + path + "\"";
                        //System.out.println("Mysql:= "+backup);
                        Process child = Runtime.getRuntime().exec(backup);
                        JOptionPane.showMessageDialog(null, "La Base de Datos ha sido Restaurada Correctamente");

                    }

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_BtnRestaurarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRepaldo;
    private javax.swing.JButton BtnRestaurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
