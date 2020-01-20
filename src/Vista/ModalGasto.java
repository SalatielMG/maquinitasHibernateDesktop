package Vista;

import Animacion.Animacion;
import Control.ControlCaja;
import Control.ControlGasto;
import Dato.Gasto;
import Dato.Tipogasto;
import Util.Constant;
import Util.HMySQL;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Salatiel
 */
public class ModalGasto extends javax.swing.JPanel {

    private JTable Tabla;
    private JPanel PanelTabla, PanelSearch;
    private JButton Menu, Agregar, Editar, Eliminar, Consultar;
    private int Op;
    private Gasto gasto;
    private ControlGasto CtrlGasto = new ControlGasto();
    private ControlCaja CtrlCaja = new ControlCaja();
    protected static int[] idTipos;

    public ModalGasto(JTable Tabla, JPanel Panel, JPanel pSearch, JButton Menu, JButton Agregar, JButton Editar, JButton Eliminar, JButton Consultar) {
        initComponents();
        prueba.setVisible(false);
        this.Tabla = Tabla;
        this.PanelTabla = Panel;
        this.PanelSearch = pSearch;
        this.Menu = Menu;
        this.Agregar = Agregar;
        this.Editar = Editar;
        this.Eliminar = Eliminar;
        this.Consultar = Consultar;
        //inicio();
    }

    public void inicio() {
        this.gasto = new Gasto();
        this.Op = Inicio.Operacion;
        idTipos = Inicio.v.ItemCombo(cmbTipo, "tipogasto", "Gasto Normal", casillaConcepto, "Elige un tipo de Gasto");
        if (Op != 1) {
        gasto = (Gasto) Inicio.hmysql.consultaObjeto(Gasto.class, Inicio.Id);
        Recupera();
        }
        String titulo = "";
        switch (Op) {
            case 1:
                titulo = "Agregar";

                this.Fecha.setDatoFecha(Inicio.v.fechaActual());//Año, mes, dia             
                //System.out.println("Esta es el Placeholder en el Inicio: "+Fecha.getPlaceholder());
                //System.out.println("Esta es la fecha  en el Inicio: "+Fecha.getDatoFecha());
                this.casillaId.setText("");
                Habilita(true);
                break;
            case 2:
                titulo = "Editar";
                Habilita(true);
                break;
            case 3:
                titulo = "Eliminar";
                Habilita(false);
                break;
            case 4:
                titulo = "Consultar";
                Habilita(false);
                break;
        }
        this.Titulo.setText(titulo + " Gasto");
        this.casillaId.setEditable(false);
        this.cmbTipo.requestFocus();
    }

    private void Recupera() {
        this.casillaId.setText("" + gasto.getId());
       
            this.cmbTipo.setSelectedIndex(Inicio.v.obtIndex(idTipos, gasto.getTipogasto().getId()));
            this.Fecha.setDatoFecha(gasto.getFecha());
            this.prueba.setText("" + gasto.getFecha().toString());
        
        this.casillaConcepto.setText(gasto.getDescripcion());
        this.casillaGasto.setText("" + Inicio.v.decimalFormat(gasto.getGasto()));
    }

    private void Habilita(boolean bnd) {
        this.cmbTipo.setEnabled(bnd);
        this.casillaConcepto.setEditable(bnd);
        this.Fecha.setEnabled(bnd);
        this.casillaGasto.setEditable(bnd);
    }

    private boolean Valida() {
        if ("".equals(casillaConcepto.getText())) {
            Inicio.v.Msj("Porfavor describa el Gasto", Constant.TITULO_ERROR_VALID, 2);
            casillaConcepto.requestFocus();
        } else if (Fecha.getDatoFecha() == null) {
            System.out.println(Fecha.getDatoFecha());
            Inicio.v.Msj("Porfavor escoje la fecha de Gasto", Constant.TITULO_ERROR_VALID, 2);
            Fecha.requestFocus();
        } else if ("".equals(casillaGasto.getText()) || !Inicio.v.validaDouble(casillaGasto.getText().trim())) {
            Inicio.v.Msj("Porfavor verifique el dato ingresado como gasto.", Constant.TITULO_ERROR_VALID, 2);
            casillaGasto.requestFocus();
        } else {
            return true;
        }
        return false;
    }

    private void Asigna() {
        if (Op != 1) {
            gasto.setId(Integer.parseInt(casillaId.getText()));
        }
        gasto.setTipogasto((Tipogasto)cmbTipo.getSelectedItem());
        gasto.setDescripcion(casillaConcepto.getText().trim());
        gasto.setFecha(Fecha.getDatoFecha());
        gasto.setGasto(Double.parseDouble(casillaGasto.getText().trim()));
        gasto.setCaja(CtrlCaja.getCaja());
        gasto.setStatus(true);
        if(Op == HMySQL.ELIMINAR)
            gasto.setStatus(false);
    }

    private void enableMenu() {
        this.Menu.setVisible(true);
        this.Agregar.setVisible(true);
        this.Editar.setVisible(true);
        this.Eliminar.setVisible(true);
        this.Consultar.setVisible(true);
    }

    private void movePanel() {
        if(Inicio.indexModal==1)
        PanelSearch.setVisible(true);
        Animacion.subir(500, 120, 1, 5, PanelTabla);
        Animacion.bajar(120, 500, 1, 5, this);
    }

    private void procesa() {
        if (Valida()) {
            Asigna();
            if (Inicio.hmysql.ejecutaTransaccion(gasto, Gasto.class, Op)){
                Inicio.Id = 0;
                Inicio.v.Msj(Constant.SATISFACTORIO, Constant.TITULO_EXITO, 1);
                Inicio.search.mostrarDatos(Tabla, "vistagastos");
                Inicio.casillaTotal.setText("$" + Inicio.v.presentardecimalFormat(CtrlCaja.getTotalGastos()));
                Inicio.casillaTotal.setPlaceholder("$" + Inicio.v.presentardecimalFormat(CtrlCaja.getTotalGastos()));

                enableMenu();
                movePanel();
            } else {
                Inicio.v.Msj(Constant.INSATISFACTORIO, Constant.TITULO_ERROR, 0);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        prueba = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        casillaConcepto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        casillaId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Cancelar = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        Fecha = new rojeru_san.componentes.RSDateChooser();
        casillaGasto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setName("ModalSalida"); // NOI18N
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(950, 380));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Decker", 0, 25)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 153, 153));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Agregar salida");
        add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 820, -1));

        prueba.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prueba.setText("|");
        prueba.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 820, -1));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripción:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        casillaConcepto.setBackground(new java.awt.Color(50, 50, 50));
        casillaConcepto.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        casillaConcepto.setForeground(new java.awt.Color(170, 170, 170));
        casillaConcepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                casillaConceptoKeyTyped(evt);
            }
        });
        add(casillaConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 380, 35));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        casillaId.setBackground(new java.awt.Color(50, 50, 50));
        casillaId.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        casillaId.setForeground(new java.awt.Color(170, 170, 170));
        casillaId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaIdActionPerformed(evt);
            }
        });
        add(casillaId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 35));

        jLabel5.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Id:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(33, 33, 33));
        jSeparator1.setForeground(new java.awt.Color(33, 33, 33));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, 162));

        Cancelar.setBackground(new java.awt.Color(204, 0, 0));
        Cancelar.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.setFocusPainted(false);
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        add(Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, -1, 45));

        Aceptar.setBackground(new java.awt.Color(0, 153, 0));
        Aceptar.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        Aceptar.setText("Aceptar");
        Aceptar.setFocusPainted(false);
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, 45));

        jLabel6.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de gasto:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        cmbTipo.setBackground(new java.awt.Color(50, 50, 50));
        cmbTipo.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        cmbTipo.setForeground(new java.awt.Color(170, 170, 170));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 220, 35));

        Fecha.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        Fecha.setFormatoFecha("yyyy-MM-dd");
        Fecha.setFuente(new java.awt.Font("Decker", 0, 20)); // NOI18N
        add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 380, 35));

        casillaGasto.setBackground(new java.awt.Color(50, 50, 50));
        casillaGasto.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        casillaGasto.setForeground(new java.awt.Color(170, 170, 170));
        casillaGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                casillaGastoKeyTyped(evt);
            }
        });
        add(casillaGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 380, 35));

        jLabel7.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gasto:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void casillaIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaIdActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        procesa();
    }//GEN-LAST:event_AceptarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        Inicio.Id = 0;
        enableMenu();
        movePanel();
    }//GEN-LAST:event_CancelarActionPerformed

    private void casillaConceptoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casillaConceptoKeyTyped
        Inicio.v.limCaracter(evt, casillaConcepto, "^[\\s\\S]", 100);
    }//GEN-LAST:event_casillaConceptoKeyTyped

    private void casillaGastoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casillaGastoKeyTyped
        Inicio.v.dosDecimales(evt, casillaGasto);
    }//GEN-LAST:event_casillaGastoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Cancelar;
    private rojeru_san.componentes.RSDateChooser Fecha;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField casillaConcepto;
    private javax.swing.JTextField casillaGasto;
    private javax.swing.JTextField casillaId;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel prueba;
    // End of variables declaration//GEN-END:variables
}
