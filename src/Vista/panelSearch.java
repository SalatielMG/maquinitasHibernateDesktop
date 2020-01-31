package Vista;


import Control.ControlSearch;
import Util.Constant;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JTable;
import rojerusan.RSAnimation;

/**
 *
 * @author Salatiel
 */
public class panelSearch extends javax.swing.JPanel {

    private String cadena = "";
    private JTable Tabla;
    private ControlSearch search = new ControlSearch();
    public panelSearch(JTable Tabla) {
        initComponents();
        this.Tabla = Tabla;
        this.cmbType.setVisible(false);
        Fecha.setVisible(false);
        Fecha.setDatoFecha(Inicio.v.fechaActual());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<>();
        IconSearch = new javax.swing.JLabel();
        casillaSearch = new javax.swing.JTextField();
        Fecha = new rojeru_san.componentes.RSDateChooser();
        BtnBusqueda = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setName("panelSearch"); // NOI18N
        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbType.setBackground(new java.awt.Color(50, 50, 50));
        cmbType.setFont(new java.awt.Font("Decker", 0, 19)); // NOI18N
        cmbType.setForeground(new java.awt.Color(170, 170, 170));
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 180, 35));

        IconSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Search_40px.png"))); // NOI18N
        IconSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IconSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IconSearchMouseClicked(evt);
            }
        });
        add(IconSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 50));

        casillaSearch.setBackground(new java.awt.Color(50, 50, 50));
        casillaSearch.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        casillaSearch.setForeground(new java.awt.Color(170, 170, 170));
        casillaSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaSearchActionPerformed(evt);
            }
        });
        casillaSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                casillaSearchKeyTyped(evt);
            }
        });
        add(casillaSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 10, 190, 35));

        Fecha.setFont(new java.awt.Font("Decker", 1, 20)); // NOI18N
        Fecha.setFuente(new java.awt.Font("Decker", 1, 20)); // NOI18N
        add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 10, 190, 35));

        BtnBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Consultar_40px.png"))); // NOI18N
        BtnBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBusquedaMouseClicked(evt);
            }
        });
        add(BtnBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 5, 40, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void IconSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconSearchMouseClicked
        movePanelSearch();
    }//GEN-LAST:event_IconSearchMouseClicked

    private void casillaSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaSearchActionPerformed
        //Realizamos la busqueda de acuerdo a la cadena.
        /*cadena=casillaSearch.getText();
        System.out.println("valor de cadena en el actionPerformed: = "+cadena);
        int index=cmbType.getSelectedIndex();
        switch(Inicio.indexModal){
            case 1:
                if(index==0){
                    if(Inicio.v.validaNumero(cadena,casillaSearch))
                    search.mostrarDatos(Tabla, "vistalocales", Constant.columnTableCajas[cmbType.getSelectedIndex()], "=", cadena);
                }else
                    search.mostrarDatos(Tabla, "vistalocales", Constant.columnTableCajas[cmbType.getSelectedIndex()], "like", "'%"+cadena+"%'");
                break;
            case 2: 
                switch(index){
                    case 0:
                        if(Inicio.v.validaNumero(cadena,casillaSearch))
                            search.mostrarDatos(Tabla, "vistaentradas", Constant.columnTableVistaDevoluciones[cmbType.getSelectedIndex()], "=", cadena);
                        break;
                    case 4:
                        if(Inicio.v.validaDouble(cadena))
                            search.mostrarDatos(Tabla, "vistaentradas", Constant.columnTableVistaDevoluciones[cmbType.getSelectedIndex()], "=", cadena);
                        break;
                    default:
                        search.mostrarDatos(Tabla, "vistaentradas", Constant.columnTableVistaDevoluciones[cmbType.getSelectedIndex()], "like", "'%"+cadena+"%'");
                        break;
                }
                break;
            case 3: 
                switch(index){
                    case 0:
                        if(Inicio.v.validaNumero(cadena,casillaSearch))
                            search.mostrarDatos(Tabla, "vistasalidas", Constant.columnTableVistaGastos[cmbType.getSelectedIndex()], "=", cadena);
                        break;
                    case 4:
                        if(Inicio.v.validaDouble(cadena))
                            search.mostrarDatos(Tabla, "vistasalidas", Constant.columnTableVistaGastos[cmbType.getSelectedIndex()], "=", cadena);
                        break;
                    default:
                        search.mostrarDatos(Tabla, "vistasalidas", Constant.columnTableVistaGastos[cmbType.getSelectedIndex()], "like", "'%"+cadena+"%'");
                        break;
                }
                break;
        }*/
    }//GEN-LAST:event_casillaSearchActionPerformed

    private void casillaSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casillaSearchKeyTyped
        Inicio.v.validarCasilla(evt, casillaSearch.getText(), "^[0-9]{1,10}$");
        /*switch(Inicio.indexSearch){
            case 1: //Numero
                Inicio.v.validarCasilla(evt, casillaSearch.getText(), "^[0-9]{1,10}$");
                break;
            case 3: //Decimal
                Inicio.v.dosDecimales(evt, casillaSearch);
                break;
        }*/
    }//GEN-LAST:event_casillaSearchKeyTyped

    private void BtnBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBusquedaMouseClicked
        cadena = casillaSearch.getText().trim();

        switch (Inicio.indexSearch) {
            case 1:
                if (Inicio.v.validaNumero(cadena, casillaSearch)) {
                    search.mostrarDatos(Tabla, "vistacajaclose", Constant.columnTableCajas[cmbType.getSelectedIndex()], "=", cadena);
                }
                break;
            case 2:
                if (Fecha.getDatoFecha() != null) {
                    search.mostrarDatos(Tabla, "vistacajaclose", Constant.columnTableCajas[cmbType.getSelectedIndex()], "like", "'%" + Inicio.v.getFecha(Fecha.getDatoFecha()) + "%'");
                } else {
                    Inicio.v.Msj("Porfavor escoje una Fecha", Constant.TITULO_ERROR_VALID, 2);
                    Fecha.requestFocus();
                }
                break;
        }
    }//GEN-LAST:event_BtnBusquedaMouseClicked
    private void movePanelSearch() {
        this.casillaSearch.requestFocus();
        if (this.getX() == 790) {
            //System.out.println("JpMenuSearch.getX():=" + this.getX());
            //this.cmbType.setVisible(true);
            RSAnimation.setMoverIzquierda(790, 360, 1, 5, this);
            this.cmbType.setVisible(true);
        } else {
            //System.out.println("JpMenuSearch.getX():=" + this.getX());
            //this.cmbType.setVisible(false);
            RSAnimation.setMoverDerecha(360, 790, 1, 5, this);
            
             this.cmbType.setVisible(false);
        }
    }

    private void movePanelSearch1() {
        this.casillaSearch.requestFocus();
        if (this.getX() == 790) {
            //System.out.println("JpMenuSearch.getX():=" + this.getX());
            //this.cmbType.setVisible(true);
            RSAnimation.setMoverIzquierda(790, 790, 1, 5, this);
        } else {
            //System.out.println("JpMenuSearch.getX():=" + this.getX());
            //this.cmbType.setVisible(false);
            RSAnimation.setMoverDerecha(360, 360, 1, 5, this);
        }
    }

    public void changeValueCmb() {
        this.cadena = "";
        this.casillaSearch.setText("");
        switch (Inicio.indexModal) {
            case 1:
                rellenarCombo(Constant.headerTableCajas);
                break;
            case 2:
                rellenarCombo(Constant.headerTableVistaDevoluciones);
                break;
            case 3:
                rellenarCombo(Constant.headerTableVistaGastos);
                break;
        }
    }

    private void rellenarCombo(String[] nameItems) {
        this.cmbType.removeAllItems();
        for (int i = 0; i < nameItems.length; i++) {
            cmbType.addItem(nameItems[i]);
        }
        this.cmbType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cadena = "";
                casillaSearch.setText("");
                casillaSearch.requestFocus();
                final String caso = e.getItem().toString();

                switch (Inicio.indexModal) {
                    case 1:
                        if (caso.equals(Constant.headerTableCajas[0]) || caso.equals(Constant.headerTableCajas[2])) {
                            Inicio.indexSearch = 1;
                            casillaSearch.setVisible(true);
                            Fecha.setVisible(false);
                        } else if (caso.equals(Constant.headerTableCajas[3])) {
                            Inicio.indexSearch = 1;
                            casillaSearch.setVisible(true);
                            Fecha.setVisible(false);
                        } else {
                            Inicio.indexSearch = 2;
                            casillaSearch.setVisible(false);
                            Fecha.setVisible(true);

                        }
                        break;
                    case 2:
                        /*if(e.getItem().toString().equals(Constant.columnTableVistaDevoluciones[0]))
                            Inicio.indexSearch=1;
                        else if(e.getItem().toString().equals(Constant.columnTableVistaDevoluciones[4]))
                            Inicio.indexSearch=3;
                        else
                            Inicio.indexSearch=2; */
                        break;
                    case 3:
                        /*if (e.getItem().toString().equals(Constant.columnTableVistaGastos[0])) {
                            Inicio.indexSearch = 1;
                        } else if (e.getItem().toString().equals(Constant.columnTableVistaGastos[4])) {
                            Inicio.indexSearch = 3;
                        } else {
                            Inicio.indexSearch = 2;
                        }*/
                        break;
                }
                movePanelSearch1();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnBusqueda;
    public static rojeru_san.componentes.RSDateChooser Fecha;
    private javax.swing.JLabel IconSearch;
    public static javax.swing.JTextField casillaSearch;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
