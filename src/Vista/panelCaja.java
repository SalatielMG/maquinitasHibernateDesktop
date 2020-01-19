package Vista;

import Animacion.Animacion;
import Control.ControlCaja;
import Dato.Caja;
import Dato.CajaOC;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Salatiel
 */
public class panelCaja extends javax.swing.JPanel {

    private JPanel PanelTabla, PanelSearch;
    private JButton Menu, Consultar;
    private CajaOC caja;
    private ControlCaja CtrlCaja = new ControlCaja();
    private double mntFn1,mntFn5;
    
    public panelCaja(JPanel panel, JPanel search, JButton Menu, JButton Consultar) {

        initComponents();
        this.PanelTabla = panel;
        this.PanelSearch = search;
        this.Menu = Menu;
        this.Consultar = Consultar;
    }
    public void Consulta(int idCaja) {
        caja = CtrlCaja.getCaja(idCaja);
        
        labelTitulo.setText("Consulta a caja " + idCaja + " con Corte el : " + Inicio.v.presentacionFecha(caja.getFechaCorte()));
        mntFn1 = caja.getMonto1() - (caja.getTotalgastos()+ caja.getTotaldevolucion1());
        mntFn5 = caja.getMonto5() - caja.getTotaldevolucion5();
        this.Fecha.setDatoFecha(caja.getFechaAbierto());
        
        this.Monto5.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getMonto5())));
        this.Monto5.setPlaceholder("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getMonto5())));
        this.totalDev5.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getTotaldevolucion5())));
        this.totalDev5.setPlaceholder("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getTotaldevolucion5())));
        this.Monto1.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getMonto1())));
        this.Monto1.setPlaceholder("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getMonto1())));
        this.totalDev1.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getTotaldevolucion1())));
        this.totalDev1.setPlaceholder("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getTotaldevolucion1())));
        this.totalGastos.setText("$" + Inicio.v.presentardecimalFormat(caja.getTotalgastos()));
        this.totalGastos.setPlaceholder("$" + Inicio.v.presentardecimalFormat(caja.getTotalgastos()));
        this.TotalMontoFinal1.setText("$" + Inicio.v.presentardecimalFormat(mntFn1));
        this.TotalMontoFinal1.setPlaceholder("$" + Inicio.v.presentardecimalFormat(mntFn1));
        this.TotalMontoFinal5.setText("$" + Inicio.v.presentardecimalFormat(mntFn5));
        this.TotalMontoFinal5.setPlaceholder("$" + Inicio.v.presentardecimalFormat(mntFn5));
    }

    public void Recupera() {
        Inicio.isReportActual = false;
        caja = CtrlCaja.getCajaOpen();
        //System.out.println("caja,sise " + cja.size());
        //caja = (Caja) Inicio.hmysql.consultaSQLObjeto("select * from vistacajaopen");
        mntFn1 = caja.getMonto1() - (CtrlCaja.getTotalGastos() + CtrlCaja.getTotalDevoluciones1());
        mntFn5 = caja.getMonto5() - CtrlCaja.getTotalDevoluciones5();
        this.labelTitulo.setText("Caja núm : " + caja.getId());
        
        this.Fecha.setDatoFecha(caja.getFechaAbierto());
        this.Monto5.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getMonto5())));
        this.Monto5.setPlaceholder("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getMonto5())));
        this.totalDev5.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + CtrlCaja.getTotalDevoluciones5())));
        this.totalDev5.setPlaceholder("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + CtrlCaja.getTotalDevoluciones5())));
        this.Monto1.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getMonto1())));
        this.Monto1.setPlaceholder("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getMonto1())));
        this.totalDev1.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + CtrlCaja.getTotalDevoluciones1())));
        this.totalDev1.setPlaceholder("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + CtrlCaja.getTotalDevoluciones1())));
        this.totalGastos.setText("$" + Inicio.v.presentardecimalFormat(CtrlCaja.getTotalGastos()));
        this.totalGastos.setPlaceholder("$" + Inicio.v.presentardecimalFormat(CtrlCaja.getTotalGastos()));
        this.TotalMontoFinal1.setText("$" + Inicio.v.presentardecimalFormat(mntFn1));
        this.TotalMontoFinal1.setPlaceholder("$" + Inicio.v.presentardecimalFormat(mntFn1));
        this.TotalMontoFinal5.setText("$" + Inicio.v.presentardecimalFormat(mntFn5));
        this.TotalMontoFinal5.setPlaceholder("$" + Inicio.v.presentardecimalFormat(mntFn5));
    }

    private void enableMenu() {
        this.Menu.setVisible(true);
        this.Consultar.setVisible(true);
    }

    private void movePanel() {
        PanelSearch.setVisible(true);
        Animacion.subir(500, 120, 1, 5, PanelTabla);
        Animacion.bajar(120, 500, 1, 5, this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Fecha = new rojeru_san.componentes.RSDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        totalDev1 = new rojeru_san.RSMTextFull();
        TotalMontoFinal1 = new rojeru_san.RSMTextFull();
        totalDev5 = new rojeru_san.RSMTextFull();
        Monto5 = new rojeru_san.RSMTextFull();
        Monto1 = new rojeru_san.RSMTextFull();
        jLabel11 = new javax.swing.JLabel();
        totalGastos = new rojeru_san.RSMTextFull();
        BtnCorte = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        TotalMontoFinal5 = new rojeru_san.RSMTextFull();

        setName("panelCaja"); // NOI18N
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(950, 380));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Decker", 0, 25)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 102, 0));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Consulta Caja");
        add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 820, -1));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de recibido :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 200, -1));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Monto de $1.°° :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(33, 33, 33));
        jSeparator1.setForeground(new java.awt.Color(33, 33, 33));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, 162));

        Fecha.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        Fecha.setFormatoFecha("yyyy-MM-dd");
        Fecha.setFuente(new java.awt.Font("Decker", 0, 20)); // NOI18N
        add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 150, 35));

        jLabel7.setFont(new java.awt.Font("Decker", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Monto de $1.°° :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total de devoluciones :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Monto  de $5.°° :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total de devoluciones :");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        totalDev1.setEditable(false);
        totalDev1.setBackground(new java.awt.Color(50, 50, 50));
        totalDev1.setForeground(new java.awt.Color(255, 0, 0));
        totalDev1.setText("$0.00");
        totalDev1.setColorTransparente(true);
        totalDev1.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        totalDev1.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        totalDev1.setModoMaterial(true);
        totalDev1.setOpaque(false);
        totalDev1.setPlaceholder("$0.00");
        totalDev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalDev1ActionPerformed(evt);
            }
        });
        add(totalDev1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 150, 40));

        TotalMontoFinal1.setEditable(false);
        TotalMontoFinal1.setBackground(new java.awt.Color(50, 50, 50));
        TotalMontoFinal1.setForeground(new java.awt.Color(0, 153, 204));
        TotalMontoFinal1.setText("$0.00");
        TotalMontoFinal1.setColorTransparente(true);
        TotalMontoFinal1.setDisabledTextColor(new java.awt.Color(0, 153, 204));
        TotalMontoFinal1.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        TotalMontoFinal1.setModoMaterial(true);
        TotalMontoFinal1.setOpaque(false);
        TotalMontoFinal1.setPlaceholder("$5,000.00");
        TotalMontoFinal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalMontoFinal1ActionPerformed(evt);
            }
        });
        add(TotalMontoFinal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 150, 40));

        totalDev5.setEditable(false);
        totalDev5.setBackground(new java.awt.Color(50, 50, 50));
        totalDev5.setForeground(new java.awt.Color(255, 0, 0));
        totalDev5.setText("$0.00");
        totalDev5.setColorTransparente(true);
        totalDev5.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        totalDev5.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        totalDev5.setModoMaterial(true);
        totalDev5.setOpaque(false);
        totalDev5.setPlaceholder("$0.00");
        totalDev5.setxDarkIcon(true);
        totalDev5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalDev5ActionPerformed(evt);
            }
        });
        add(totalDev5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 150, 40));

        Monto5.setEditable(false);
        Monto5.setBackground(new java.awt.Color(0, 128, 0));
        Monto5.setForeground(new java.awt.Color(0, 128, 0));
        Monto5.setText("$0.00");
        Monto5.setCaretColor(new java.awt.Color(0, 128, 0));
        Monto5.setColorTransparente(true);
        Monto5.setDisabledTextColor(new java.awt.Color(0, 128, 0));
        Monto5.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        Monto5.setModoMaterial(true);
        Monto5.setPlaceholder("$0.00");
        Monto5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Monto5ActionPerformed(evt);
            }
        });
        add(Monto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 150, 40));

        Monto1.setEditable(false);
        Monto1.setBackground(new java.awt.Color(0, 128, 0));
        Monto1.setForeground(new java.awt.Color(0, 128, 0));
        Monto1.setText("$0.00");
        Monto1.setCaretColor(new java.awt.Color(0, 128, 0));
        Monto1.setColorTransparente(true);
        Monto1.setDisabledTextColor(new java.awt.Color(0, 128, 0));
        Monto1.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        Monto1.setModoMaterial(true);
        Monto1.setPlaceholder("$0.00");
        Monto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Monto1ActionPerformed(evt);
            }
        });
        add(Monto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 150, 40));

        jLabel11.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total de gastos :");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, -1));

        totalGastos.setEditable(false);
        totalGastos.setBackground(new java.awt.Color(50, 50, 50));
        totalGastos.setForeground(new java.awt.Color(255, 0, 0));
        totalGastos.setText("$0.00");
        totalGastos.setColorTransparente(true);
        totalGastos.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        totalGastos.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        totalGastos.setModoMaterial(true);
        totalGastos.setOpaque(false);
        totalGastos.setPlaceholder("$0.00");
        totalGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalGastosActionPerformed(evt);
            }
        });
        add(totalGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, 150, 40));

        BtnCorte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Ok_45px.png"))); // NOI18N
        BtnCorte.setToolTipText("Corte de caja");
        BtnCorte.setBorder(null);
        BtnCorte.setBorderPainted(false);
        BtnCorte.setContentAreaFilled(false);
        BtnCorte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCorte.setFocusPainted(false);
        BtnCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCorteActionPerformed(evt);
            }
        });
        add(BtnCorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 310, 70, 50));

        jLabel12.setFont(new java.awt.Font("Decker", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total Monto de $5.°° :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        TotalMontoFinal5.setEditable(false);
        TotalMontoFinal5.setBackground(new java.awt.Color(50, 50, 50));
        TotalMontoFinal5.setForeground(new java.awt.Color(0, 153, 204));
        TotalMontoFinal5.setText("$0.00");
        TotalMontoFinal5.setColorTransparente(true);
        TotalMontoFinal5.setDisabledTextColor(new java.awt.Color(0, 153, 204));
        TotalMontoFinal5.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        TotalMontoFinal5.setModoMaterial(true);
        TotalMontoFinal5.setOpaque(false);
        TotalMontoFinal5.setPlaceholder("$5,000.00");
        TotalMontoFinal5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalMontoFinal5ActionPerformed(evt);
            }
        });
        add(TotalMontoFinal5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 150, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void totalDev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalDev1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalDev1ActionPerformed

    private void TotalMontoFinal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalMontoFinal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalMontoFinal1ActionPerformed

    private void Monto5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Monto5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Monto5ActionPerformed

    private void totalDev5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalDev5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalDev5ActionPerformed

    private void Monto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Monto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Monto1ActionPerformed

    private void totalGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalGastosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalGastosActionPerformed

    private void BtnCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCorteActionPerformed
        if (Inicio.isCajaOpen) {            
            //Hay que comparar si la caja esta cerrada, o sea en ceros.-
            String msj = "";
            
            if(mntFn5 != 0){//Caja de 5 en ceros.
                msj += "La caja de $5 no se ha cerrado\nAún queda $" + mntFn5 + " en la caja de $5\n";
                //Inicio.v.Msj("¡¡¡ La caja de $5 no se ha cerrado\nAún queda dinero en la caja de $5 !!!", ".:: CAJA DE $5  .::", 2);
                //return;
            }
            if(mntFn1 != 0){//Caja de 5 en ceros.
                msj += "La caja de $1 no se ha cerrado\nAún queda $" + mntFn1 + " en la caja de $1";
                //Inicio.v.Msj("¡¡¡ La caja de $1 no se ha cerrado\nAún queda dinero en la caja de $1 !!!", ".:: CAJA DE $1  .::", 2);
                //return;
            }
            
            if (this.mntFn1 != 0 && this.mntFn5 != 0) {
                
                msj += "\n\n¿ Desea cerrar la caja de todas formas ?";
                int op = JOptionPane.showConfirmDialog(null, msj, ".:: CAJA ABIERTA  .::", 2);
                if (op == JOptionPane.YES_OPTION) {
                    new CorteCaja(null, true, caja.getId());
                }
            }
                 
        } else {
            //Consulta a Caja
            enableMenu();
            movePanel();
            System.out.println("Acabas de mover el panelTabla hacia arrriba");
        }
    }//GEN-LAST:event_BtnCorteActionPerformed

    private void TotalMontoFinal5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalMontoFinal5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalMontoFinal5ActionPerformed
    public Caja AsignaCorte() {
        caja.setTotaldevolucion1(CtrlCaja.getTotalDevoluciones1());
        caja.setTotaldevolucion5(CtrlCaja.getTotalDevoluciones5());
        caja.setTotalgastos(CtrlCaja.getTotalGastos());
        //caja.setFechaCorte(Inicio.v.fechaActual());
        caja.setCorte(true);
        caja.setStatus(true);
        //corte.setFecha(Inicio.v.getFecha(Inicio.v.fechaActual()));
        
        return caja;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BtnCorte;
    private rojeru_san.componentes.RSDateChooser Fecha;
    private rojeru_san.RSMTextFull Monto1;
    private rojeru_san.RSMTextFull Monto5;
    private rojeru_san.RSMTextFull TotalMontoFinal1;
    private rojeru_san.RSMTextFull TotalMontoFinal5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelTitulo;
    private rojeru_san.RSMTextFull totalDev1;
    private rojeru_san.RSMTextFull totalDev5;
    private rojeru_san.RSMTextFull totalGastos;
    // End of variables declaration//GEN-END:variables
}
