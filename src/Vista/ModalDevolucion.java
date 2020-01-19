package Vista;

import Animacion.Animacion;
import Control.ControlCaja;
import Control.ControlDevolucion;
import Dato.Devolucion;
import Util.Constant;
import Util.HMySQL;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Salatiel
 */
public class ModalDevolucion extends javax.swing.JPanel {

    private JTable Tabla1, Tabla5;
    private JPanel PanelTabla, PanelSearch;
    private JButton Menu, Agregar, Editar, Eliminar, Consultar;
    private int Op;
    private Devolucion devolucion;
    private ControlCaja CtrlCaja = new ControlCaja();
    private ControlDevolucion CtrlDev = new ControlDevolucion();

    public ModalDevolucion(JTable Tabla, JTable Tabla5, JPanel Panel, JPanel pSearch, JButton Menu, JButton Agregar, JButton Editar, JButton Eliminar, JButton Consultar) {
        initComponents();
        prueba.setVisible(false);
        this.Tabla1 = Tabla;
        this.Tabla5 = Tabla5;
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
        devolucion = new Devolucion();
        this.Op = Inicio.Operacion;
        CtrlDev.rellenaCombo(cmbTipo, casillaMntInicial);
        //idTipos=Inicio.v.ItemCombo(cmbTipo, "tipo_c","Gasto Normal",casillaMntInicial,"Elige un tipo de Gasto");
        if (Op != 1) {
            devolucion = (Devolucion) Inicio.hmysql.consultaObjeto(Devolucion.class, Inicio.Id);
            Recupera();
        }
        String titulo = "";
        switch (Op) {
            case 1:
                titulo = "Agregar";
                this.Fecha.setDatoFecha(Inicio.v.fechaActual());
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
        this.Titulo.setText(titulo + " Devolución");
        this.casillaId.setEditable(false);
        this.casillaMntInicial.setEditable(false);
        this.cmbTipo.requestFocus();
    }

    private void Recupera() {
        this.casillaId.setText("" + devolucion.getId());
        this.cmbTipo.setSelectedIndex((devolucion.isTipo())? 1: 0);
        this.Fecha.setDatoFecha(devolucion.getFecha());              
        this.casillaCantidadDevuelto.setText("" + devolucion.getCantidad());
    }

    private void Habilita(boolean bnd) {
        this.cmbTipo.setEnabled(bnd);
        this.Fecha.setEnabled(bnd);
        this.casillaCantidadDevuelto.setEditable(bnd);
    }

    private boolean Valida() {
        if (Fecha.getDatoFecha() == null) {
            System.out.println(Fecha.getDatoFecha());
            Inicio.v.Msj("Porfavor escoje la fecha de entrega", Constant.TITULO_ERROR_VALID, 2);
            Fecha.requestFocus();
        } else if ("".equals(casillaCantidadDevuelto.getText())) {
            Inicio.v.Msj("Porfavor Ingrese la cantidad a devolver.", Constant.TITULO_ERROR_VALID, 2);
            casillaCantidadDevuelto.requestFocus();
        } else {
            return true;
        }
        return false;
    }

    private void Asigna() {
        if (Op != 1) {
            devolucion.setId(Integer.parseInt(casillaId.getText()));
        }
        devolucion.setCaja(CtrlCaja.getCajaOpen());
        devolucion.setCantidad(Integer.parseInt(casillaCantidadDevuelto.getText().trim()));
        devolucion.setFecha(Fecha.getDatoFecha());
        devolucion.setTipo((cmbTipo.getSelectedIndex() == 0) ? false: true);
        devolucion.setStatus(true);
        if(Op == HMySQL.ELIMINAR)
            devolucion.setStatus(false);
    }

    private void enableMenu() {
        this.Menu.setVisible(true);
        this.Agregar.setVisible(true);
        this.Editar.setVisible(true);
        this.Eliminar.setVisible(true);
        this.Consultar.setVisible(true);
    }

    private void movePanel() {
        if (Inicio.indexModal == 1) {
            PanelSearch.setVisible(true);
        }
        Animacion.subir(500, 120, 1, 5, PanelTabla);
        Animacion.bajar(120, 500, 1, 5, this);
    }

    private void procesa() {
        if (Valida()) {
            Asigna();
            if (Inicio.hmysql.ejecutaTransaccion(devolucion, Devolucion.class, Op)){
                Inicio.Id = 0;
                Inicio.v.Msj(Constant.SATISFACTORIO, Constant.TITULO_EXITO, 1);
                Inicio.search.mostrarDatos(Tabla1, "vistadevoluciones1");
                panelDevolucion.TotalMontoFinal1.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + CtrlCaja.getTotalDevoluciones1())));
                panelDevolucion.TotalMontoFinal1.setPlaceholder("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + CtrlCaja.getTotalDevoluciones1())));

                Inicio.search.mostrarDatos(Tabla5, "vistadevoluciones5");
                panelDevolucion.TotalMontoFinal5.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + CtrlCaja.getTotalDevoluciones5())));
                panelDevolucion.TotalMontoFinal5.setPlaceholder("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + CtrlCaja.getTotalDevoluciones5())));

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
        LabelMonto = new javax.swing.JLabel();
        casillaMntInicial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        casillaId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Cancelar = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        Fecha = new rojeru_san.componentes.RSDateChooser();
        casillaCantidadDevuelto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setName("ModalDevolucion"); // NOI18N
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(950, 380));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Decker", 0, 25)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 153, 153));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Agregar devolución");
        add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 820, -1));

        prueba.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prueba.setText("|");
        prueba.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 820, -1));

        LabelMonto.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        LabelMonto.setForeground(new java.awt.Color(255, 255, 255));
        LabelMonto.setText("Monto incial :");
        add(LabelMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 200, -1));

        casillaMntInicial.setBackground(new java.awt.Color(50, 50, 50));
        casillaMntInicial.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        casillaMntInicial.setForeground(new java.awt.Color(170, 170, 170));
        casillaMntInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                casillaMntInicialKeyTyped(evt);
            }
        });
        add(casillaMntInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 380, 35));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de entrega :");
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
        jLabel5.setText("Id :");
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
        jLabel6.setText("Tipo de devolución :");
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

        casillaCantidadDevuelto.setBackground(new java.awt.Color(50, 50, 50));
        casillaCantidadDevuelto.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        casillaCantidadDevuelto.setForeground(new java.awt.Color(170, 170, 170));
        casillaCantidadDevuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaCantidadDevueltoActionPerformed(evt);
            }
        });
        casillaCantidadDevuelto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                casillaCantidadDevueltoKeyTyped(evt);
            }
        });
        add(casillaCantidadDevuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 380, 35));

        jLabel7.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cantidad devuelto : ");
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

    private void casillaMntInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casillaMntInicialKeyTyped
        //Inicio.v.limCaracter(evt, casillaMntInicial, "^[\\s\\S]", 100);
    }//GEN-LAST:event_casillaMntInicialKeyTyped

    private void casillaCantidadDevueltoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casillaCantidadDevueltoKeyTyped
        Inicio.v.limCaracter(evt, casillaCantidadDevuelto, "[0-9]", 10);
    }//GEN-LAST:event_casillaCantidadDevueltoKeyTyped

    private void casillaCantidadDevueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaCantidadDevueltoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaCantidadDevueltoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Cancelar;
    private rojeru_san.componentes.RSDateChooser Fecha;
    private javax.swing.JLabel LabelMonto;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField casillaCantidadDevuelto;
    private javax.swing.JTextField casillaId;
    private javax.swing.JTextField casillaMntInicial;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel prueba;
    // End of variables declaration//GEN-END:variables
}
