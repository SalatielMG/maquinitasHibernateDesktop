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

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setName("panelAcerca"); // NOI18N
        setOpaque(false);
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Decker", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Salatiel Montero González");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 950, -1));

        jLabel7.setFont(new java.awt.Font("Decker", 1, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Desarrollado por ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 950, -1));

        jLabel5.setFont(new java.awt.Font("Decker", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("v 2.0");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, -1, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/java3.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Decker", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sistema Control E & G Maquinitas");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 950, -1));

        jSeparator1.setBackground(new java.awt.Color(111, 174, 2));
        jSeparator1.setForeground(new java.awt.Color(111, 174, 2));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 790, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/FondoDesenfoque.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 949, 380));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
