package Vista;

import Control.ControlCaja;
import Util.Tabla.EstiloTablaHeader;
import Util.Tabla.EstiloTablaRenderer;
import Util.Tabla.MyScrollbarUI;
import static Vista.Inicio.search;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Salatiel
 */
public class panelDevolucion extends javax.swing.JPanel {
    
    private ControlCaja CtrlCaja = new ControlCaja();
    
    public panelDevolucion() {
        initComponents();
        this.Tabla1.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.Tabla1.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.Tabla1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());

        this.Tabla5.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.Tabla5.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.Tabla5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane2.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        search.mostrarDatos(Tabla1, "vistadevoluciones1");
        search.mostrarDatos(Tabla5, "vistadevoluciones5");

        ListSelectionModel rowSM = Tabla1.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm
                        = (ListSelectionModel) e.getSource();

                if (!lsm.isSelectionEmpty()) {
                    search.mostrarDatos(Tabla5, "vistadevoluciones5");
                } 
            }
        });
        ListSelectionModel rowSMM = Tabla5.getSelectionModel();
        rowSMM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm
                        = (ListSelectionModel) e.getSource();

                if (!lsm.isSelectionEmpty()) {
                    search.mostrarDatos(Tabla1, "vistadevoluciones1");
                } 
            }
        });;
        this.TotalMontoFinal5.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + CtrlCaja.getTotalDevoluciones5())));
        this.TotalMontoFinal5.setPlaceholder("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + CtrlCaja.getTotalDevoluciones5())));
        this.TotalMontoFinal1.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + CtrlCaja.getTotalDevoluciones1())));
        this.TotalMontoFinal1.setPlaceholder("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + CtrlCaja.getTotalDevoluciones1())));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla5 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TotalMontoFinal5 = new rojeru_san.RSMTextFull();
        TotalMontoFinal1 = new rojeru_san.RSMTextFull();
        jLabel8 = new javax.swing.JLabel();

        setName("panelDevolucion"); // NOI18N
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(950, 380));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setOpaque(false);

        Tabla1.setBackground(new java.awt.Color(111, 174, 2));
        Tabla1.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        Tabla1.setForeground(new java.awt.Color(255, 255, 255));
        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla1.setFocusable(false);
        Tabla1.setOpaque(false);
        Tabla1.setRowHeight(20);
        jScrollPane1.setViewportView(Tabla1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 820, 130));

        jLabel1.setFont(new java.awt.Font("Decker", 0, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("(Monto $1.°°)");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jScrollPane2.setOpaque(false);

        Tabla5.setBackground(new java.awt.Color(111, 174, 2));
        Tabla5.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        Tabla5.setForeground(new java.awt.Color(255, 255, 255));
        Tabla5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla5.setFocusable(false);
        Tabla5.setOpaque(false);
        Tabla5.setRowHeight(20);
        jScrollPane2.setViewportView(Tabla5);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 820, 80));

        jLabel2.setFont(new java.awt.Font("Decker", 0, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("(Monto $5.°°)");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel7.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total devolución :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        TotalMontoFinal5.setEditable(false);
        TotalMontoFinal5.setBackground(new java.awt.Color(50, 50, 50));
        TotalMontoFinal5.setForeground(new java.awt.Color(255, 0, 0));
        TotalMontoFinal5.setText("$0.00");
        TotalMontoFinal5.setColorTransparente(true);
        TotalMontoFinal5.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        TotalMontoFinal5.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        TotalMontoFinal5.setModoMaterial(true);
        TotalMontoFinal5.setOpaque(false);
        TotalMontoFinal5.setPlaceholder("$5,000.00");
        TotalMontoFinal5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalMontoFinal5ActionPerformed(evt);
            }
        });
        add(TotalMontoFinal5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 200, 40));

        TotalMontoFinal1.setEditable(false);
        TotalMontoFinal1.setBackground(new java.awt.Color(50, 50, 50));
        TotalMontoFinal1.setForeground(new java.awt.Color(255, 0, 0));
        TotalMontoFinal1.setText("$0.00");
        TotalMontoFinal1.setColorTransparente(true);
        TotalMontoFinal1.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        TotalMontoFinal1.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        TotalMontoFinal1.setModoMaterial(true);
        TotalMontoFinal1.setOpaque(false);
        TotalMontoFinal1.setPlaceholder("$5,000.00");
        TotalMontoFinal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalMontoFinal1ActionPerformed(evt);
            }
        });
        add(TotalMontoFinal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 200, 40));

        jLabel8.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total devolución :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void TotalMontoFinal5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalMontoFinal5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalMontoFinal5ActionPerformed

    private void TotalMontoFinal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalMontoFinal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalMontoFinal1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Tabla1;
    public javax.swing.JTable Tabla5;
    public static rojeru_san.RSMTextFull TotalMontoFinal1;
    public static rojeru_san.RSMTextFull TotalMontoFinal5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
