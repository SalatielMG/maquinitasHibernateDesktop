package Vista;

import Control.ControlCaja;
import Dato.Caja;
import Dato.CajaOC;
import Util.Constant;
import rojerusan.RSAnimation;

/**
 *
 * @author Salatiel
 */
public class MontoInicial extends javax.swing.JDialog {

    private ControlCaja CtrlCaja = new ControlCaja();
    private Caja caja = new Caja();
    //private HMySQL hmysql = new HMySQL();
    
    public MontoInicial(Inicio parent, boolean modal, int op) {
        super(parent, modal);
        initComponents();
        this.Fecha.setDatoFecha(Inicio.v.fechaActual());
        if(op != 1)
            Recupera();
        Anim();
        this.setLocationRelativeTo(parent);
        this.setVisible(true);

    }
    private void Anim(){
        RSAnimation.setBajar(-500, 155, 1, 5, this);
    }
    private void Recupera() {        
        caja = CtrlCaja.getCaja();
        //System.out.println(this.caja.contentCaja());
        System.out.println(caja.toString());
        this.Titulo.setText("Editar Caja Núm: "+caja.getId());
        //this.Titulo.setName(""+caja.getId());
        this.Fecha.setDatoFecha(caja.getFechaAbierto());
        this.Monto$1.setText(""+caja.getMonto1());
        this.Monto$5.setText(""+caja.getMonto5());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelImage1 = new rojerusan.RSPanelImage();
        jSeparator1 = new javax.swing.JSeparator();
        Monto$5 = new rojeru_san.RSMTextFull();
        Titulo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Fecha = new rojeru_san.componentes.RSDateChooser();
        jLabel3 = new javax.swing.JLabel();
        BtnOk = new rojerusan.RSMaterialButtonCircle();
        Monto$1 = new rojeru_san.RSMTextFull();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/Fondos Dialog/sofa-black-texture-pattern-34-iphone-7-plus-wallpaper (1).jpg"))); // NOI18N
        rSPanelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(111, 174, 2));
        jSeparator1.setForeground(new java.awt.Color(111, 174, 2));
        rSPanelImage1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 260, 10));

        Monto$5.setBackground(new java.awt.Color(0, 128, 0));
        Monto$5.setForeground(new java.awt.Color(0, 128, 0));
        Monto$5.setCaretColor(new java.awt.Color(0, 128, 0));
        Monto$5.setColorTransparente(true);
        Monto$5.setDisabledTextColor(new java.awt.Color(0, 128, 0));
        Monto$5.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        Monto$5.setModoMaterial(true);
        Monto$5.setPlaceholder("Monto Inicial");
        Monto$5.setSoloNumeros(true);
        Monto$5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Monto$5ActionPerformed(evt);
            }
        });
        rSPanelImage1.add(Monto$5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 150, 40));

        Titulo.setFont(new java.awt.Font("Decker", 1, 22)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Nueva Caja");
        rSPanelImage1.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 280, -1));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Monto de $5.°° :");
        rSPanelImage1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 280, -1));

        Fecha.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        Fecha.setFormatoFecha("yyyy-MM-dd");
        Fecha.setFuente(new java.awt.Font("Decker", 0, 20)); // NOI18N
        rSPanelImage1.add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 220, 35));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fecha de recibido :");
        rSPanelImage1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 280, -1));

        BtnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnOk.setText("OK");
        BtnOk.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        BtnOk.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnOk.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnOk.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnOk.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOkActionPerformed(evt);
            }
        });
        rSPanelImage1.add(BtnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 80, 80));

        Monto$1.setBackground(new java.awt.Color(0, 128, 0));
        Monto$1.setForeground(new java.awt.Color(0, 128, 0));
        Monto$1.setCaretColor(new java.awt.Color(0, 128, 0));
        Monto$1.setColorTransparente(true);
        Monto$1.setDisabledTextColor(new java.awt.Color(0, 128, 0));
        Monto$1.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        Monto$1.setModoMaterial(true);
        Monto$1.setPlaceholder("Monto Inicial");
        Monto$1.setSoloNumeros(true);
        Monto$1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Monto$1ActionPerformed(evt);
            }
        });
        rSPanelImage1.add(Monto$1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 150, 40));

        jLabel5.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Monto de $1.°° :");
        rSPanelImage1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 280, -1));

        getContentPane().add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Monto$5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Monto$5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Monto$5ActionPerformed

    private void Monto$1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Monto$1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Monto$1ActionPerformed

    private void BtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOkActionPerformed
        if (valida()) {
            Asigna();
            if (Inicio.hmysql.ejecutaTransaccion(caja, Caja.class, Inicio.Operacion)) {            
                try {
                    animacion();
                    Thread.sleep(1000);
                    this.dispose();
                    Inicio.pC.Recupera();
                } catch (Exception e) {
                }
                Inicio.v.Msj(Constant.SATISFACTORIO, Constant.TITULO_EXITO, 1);
            } else {
                Inicio.v.Msj(Constant.INSATISFACTORIO, Constant.TITULO_ERROR, 0);
            }
        }
    }//GEN-LAST:event_BtnOkActionPerformed
    private void Asigna() {
        /*if(Inicio.Operacion!=1){
            caja.setId(Integer.parseInt(Titulo.getName()));
        }*/
        caja.setCorte(false);
        caja.setFechaAbierto(Fecha.getDatoFecha());
        caja.setMonto1(Integer.parseInt(Monto$1.getText().trim()));
        caja.setMonto5(Integer.parseInt(Monto$5.getText().trim()));
        caja.setStatus(true);
    }
    private boolean valida() {
        if (Fecha.getDatoFecha() == null) {
            Inicio.v.Msj("¡ Porfavor elige la fecha de recibido !", Constant.TITULO_ERROR_VALID, 2);
            Fecha.requestFocus();
        } else if (Monto$1.getText().equals("")) {
            Inicio.v.Msj("¡ Porfavor ingrese un monto inicial de monedas de $1.°° !", Constant.TITULO_ERROR_VALID, 2);
            Monto$1.requestFocus();
        } else if (Monto$5.getText().equals("")) {
            Inicio.v.Msj("¡ Porfavor ingrese un monto inicial de monedas de $5.°° !", Constant.TITULO_ERROR_VALID, 2);
            Monto$5.requestFocus();
        } else {
            return true;
        }
        return false;
    }

    private void animacion() {
        RSAnimation.setSubir(155, -500, 1, 5, this);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle BtnOk;
    private rojeru_san.componentes.RSDateChooser Fecha;
    private rojeru_san.RSMTextFull Monto$1;
    private rojeru_san.RSMTextFull Monto$5;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private rojerusan.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables
}
