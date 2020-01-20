package Vista;

import Control.ControlCaja;
import Dato.Caja;
import Reportes.ControladorReporte;
import Util.Constant;
import Util.HMySQL;
import rojerusan.RSAnimation;

/**
 *
 * @author Salatiel
 */
public class CorteCaja extends javax.swing.JDialog {

    private ControlCaja CtrlCaja = new ControlCaja();
    private int inicio = -500, fin = 190;

    public CorteCaja(Inicio parent, boolean modal, int caja) {
        super(parent, modal);
        initComponents();
        this.Fecha.setDatoFecha(Inicio.v.fechaActual());
        Anim(inicio, fin);
        this.Titulo.setText("Corte a Caja Núm: " + caja);
        this.setLocationRelativeTo(parent);
        this.setVisible(true);

    }

    private void Anim(int i, int f) {
        RSAnimation.setBajar(i, f, 1, 5, this);
    }

    private void animacion(int i, int f) {
        RSAnimation.setSubir(i, f, 1, 5, this);
    }

    private void subir() {
        try {
            animacion(fin, inicio);
            Thread.sleep(1000);
            this.dispose();
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelImage1 = new rojerusan.RSPanelImage();
        jSeparator1 = new javax.swing.JSeparator();
        Titulo = new javax.swing.JLabel();
        Fecha = new rojeru_san.componentes.RSDateChooser();
        jLabel3 = new javax.swing.JLabel();
        BtnSi = new rojerusan.RSMaterialButtonCircle();
        BtnNo = new rojerusan.RSMaterialButtonCircle();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notaCorte = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/Fondos Dialog/Cerrar.jpg"))); // NOI18N
        rSPanelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(111, 174, 2));
        jSeparator1.setForeground(new java.awt.Color(111, 174, 2));
        rSPanelImage1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 260, 10));

        Titulo.setFont(new java.awt.Font("Decker", 1, 22)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Corte a Caja Núm: ");
        rSPanelImage1.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 280, -1));

        Fecha.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        Fecha.setFormatoFecha("yyyy-MM-dd");
        Fecha.setFuente(new java.awt.Font("Decker", 0, 20)); // NOI18N
        rSPanelImage1.add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 220, 35));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nota :");
        rSPanelImage1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 280, -1));

        BtnSi.setBackground(new java.awt.Color(51, 153, 0));
        BtnSi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnSi.setText("SÍ");
        BtnSi.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        BtnSi.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnSi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnSi.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnSi.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSiActionPerformed(evt);
            }
        });
        rSPanelImage1.add(BtnSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 80, 80));

        BtnNo.setBackground(new java.awt.Color(204, 0, 0));
        BtnNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnNo.setText("n0");
        BtnNo.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        BtnNo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnNo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnNo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnNo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_32px.png"))); // NOI18N
        BtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNoActionPerformed(evt);
            }
        });
        rSPanelImage1.add(BtnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 80, 80));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Fecha de corte :");
        rSPanelImage1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, -1));

        jScrollPane1.setBorder(null);

        notaCorte.setBackground(new java.awt.Color(51, 51, 51));
        notaCorte.setColumns(20);
        notaCorte.setFont(new java.awt.Font("Decker", 0, 16)); // NOI18N
        notaCorte.setForeground(new java.awt.Color(204, 204, 204));
        notaCorte.setLineWrap(true);
        notaCorte.setRows(5);
        notaCorte.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        notaCorte.setCaretColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(notaCorte);

        rSPanelImage1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 260, 60));

        getContentPane().add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSiActionPerformed
        Caja cja = CtrlCaja.getCaja();
        cja.setCorte(true);
        cja.setStatus(true);
        cja.setNota(notaCorte.getText());
        cja.setFechaCorte(Fecha.getDatoFecha());
        if (Inicio.hmysql.ejecutaTransaccion(cja, Caja.class, HMySQL.ACTUALIZAR)) {
            subir();
            Inicio.isReportActual = true;
            new ControladorReporte(cja.getId(), 1);
            Inicio.Operacion = HMySQL.AGREGAR;
            new MontoInicial(null, true, Inicio.Operacion);
            
        } else {
            Inicio.v.Msj("¡¡¡ No se pudo cerrar la caja !!!", Constant.TITULO_ERROR, 2);
        }
    }//GEN-LAST:event_BtnSiActionPerformed

    private void BtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNoActionPerformed
        subir();
    }//GEN-LAST:event_BtnNoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle BtnNo;
    private rojerusan.RSMaterialButtonCircle BtnSi;
    private rojeru_san.componentes.RSDateChooser Fecha;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea notaCorte;
    private rojerusan.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables
}
