package Vista;

/**
 *
 * @author Salatiel
 */
public class panelHome extends javax.swing.JPanel {

    /**
     * Creates new form panelHome
     */
    public panelHome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        setName("panelHome"); // NOI18N
        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/java3.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/FondoHome.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 949, -1));

        jSeparator1.setBackground(new java.awt.Color(111, 174, 2));
        jSeparator1.setForeground(new java.awt.Color(111, 174, 2));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 790, 10));

        jLabel3.setFont(new java.awt.Font("Decker", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sistema Control E & G Maquinitas");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 950, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
