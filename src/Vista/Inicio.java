package Vista;

import Animacion.*;
import Control.ControlCaja;
import Control.ControlGasto;
import Control.ControlSearch;
import Reportes.ControladorReporte;
import Util.Constant;
import Util.HMySQL;

import Util.Tabla.EstiloTablaHeader;
import Util.Tabla.EstiloTablaRenderer;
import Util.Tabla.MyScrollbarUI;
import Util.Validacion;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Salatiel
 */
public class Inicio extends javax.swing.JFrame {
    
    public static HMySQL hmysql = new HMySQL();
    public static int indexSearch = 1;
    public static Validacion v = new Validacion();
    public static int Operacion = 0, Id = 0, indexModal = 0, IDReportCaja = 0;
    private panelHome pH;
    public static panelCaja pC;
    private panelSearch pS;
    private panelDevolucion pD;
    private panelAcerca pA;
    private ModalDevolucion MD;
    private ModalGasto MG;
    
    
    public static ControlSearch search = new ControlSearch();
    private ControlGasto CtrlSalida = new ControlGasto();    
    private ControlCaja CtrlCaja = new ControlCaja();
    /*
    
    
    
    
    */
    private Component[] cmp;
    private String[] nameCmp = {"panelCaja", "ModalDevolucion", "ModalSalida", "panelSearch", "panelHome", "panelReporte", "panelAcerca","panelDevolucion"};
    private boolean isModal = false;
    public static boolean isCajaOpen = false, isReportActual = false;
    private ListSelectionModel rowSM;

    public Inicio() {
        initComponents();
        this.LineHome.setVisible(true);
        this.LineCaja.setVisible(false);
        this.LineDevoluciones.setVisible(false);
        this.LineSalida.setVisible(false);
        this.LineCajaCerrada.setVisible(false);
        this.LineAcerca.setVisible(false);
        this.JpTabla.setVisible(false);
        this.BtnReporte1.setVisible(false);
        this.BtnReporte5.setVisible(false);
        habilitarMenuOption(false);
        //MoveO2();
        //Midificar propiedades de la Tabla.
        this.Tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.Tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.Tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());

        cmp = this.getContentPane().getComponents();
        pH = new panelHome();
        pH.setVisible(true);
        this.getContentPane().add(pH, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 950, 380));
        String[] excp = {nameCmp[4]};
        reorderCmp(nameCmp[4]);
        remAnim(excp, true);
        if(!v.hayCajaAbierta()){
            Operacion = 1;
            new MontoInicial(this, true, Operacion);
        }
        this.setTitle("Sistema Control E & G Maquinitas v2.0");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void remAnim(String[] excp, boolean isBD) {
        removeCmp(excp);
        try {
            moverControlPanel2();
            if (isBD) {
                MoveO2();
                if (this.Agregar.getX() == 930) {
                    MoveO();
                }

            }
        } catch (Exception e) {
            v.Msj("Error en la ejecucuion de la animacion", "Error enla animacion", 0);
        }

    }

    private void reorderCmp(String nameCmp) {
        cmp = this.getContentPane().getComponents();
        int pos = isCmp(nameCmp);
        this.getContentPane().setComponentZOrder(cmp[pos], pos - 1);
        cmp = this.getContentPane().getComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbMinimiza = new javax.swing.JButton();
        JbCerrar = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        JpControlPanel = new javax.swing.JPanel();
        LineCajaCerrada = new javax.swing.JLabel();
        LineHome = new javax.swing.JLabel();
        LineAcerca = new javax.swing.JLabel();
        LineDevoluciones = new javax.swing.JLabel();
        LineCaja = new javax.swing.JLabel();
        LineSalida = new javax.swing.JLabel();
        Menu = new javax.swing.JLabel();
        SelectedHome = new javax.swing.JButton();
        SelectedDevoluciones = new javax.swing.JButton();
        SelectedSalidas = new javax.swing.JButton();
        SelectedCajaCerrada = new javax.swing.JButton();
        SelectedAcerca = new javax.swing.JButton();
        SelectedCaja = new javax.swing.JButton();
        JlbHome = new javax.swing.JLabel();
        JlbCaja = new javax.swing.JLabel();
        JlbDevoluciones = new javax.swing.JLabel();
        JlbSalida = new javax.swing.JLabel();
        JlbCajaCerrada = new javax.swing.JLabel();
        JlbEmpleado = new javax.swing.JLabel();
        TituloHome = new javax.swing.JLabel();
        TituloCaja = new javax.swing.JLabel();
        TituloDevoluciones = new javax.swing.JLabel();
        TituloSalida = new javax.swing.JLabel();
        TituloCajaCerrada = new javax.swing.JLabel();
        TituloEmpleado = new javax.swing.JLabel();
        JbtnLogout = new javax.swing.JButton();
        JlPanel = new javax.swing.JLabel();
        JpMenuOption = new javax.swing.JPanel();
        MenuOption = new javax.swing.JButton();
        BtnReporte5 = new javax.swing.JButton();
        BtnReporte1 = new javax.swing.JButton();
        Fnd = new javax.swing.JLabel();
        TitulpPestaña = new javax.swing.JLabel();
        JpTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Monto1 = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        casillaTotal = new rojeru_san.RSMTextFull();
        JpBackground = new javax.swing.JPanel();
        JlBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Control E & G Machines");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/1.png")).getImage());
        setUndecorated(true);
        setSize(new java.awt.Dimension(1000, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeiconified(java.awt.event.WindowEvent evt) {
                formWindowDeiconified(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JbMinimiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Compress_32px.png"))); // NOI18N
        JbMinimiza.setBorderPainted(false);
        JbMinimiza.setContentAreaFilled(false);
        JbMinimiza.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JbMinimiza.setFocusPainted(false);
        JbMinimiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbMinimizaActionPerformed(evt);
            }
        });
        getContentPane().add(JbMinimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 40, 40));

        JbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Delete_32px.png"))); // NOI18N
        JbCerrar.setBorderPainted(false);
        JbCerrar.setContentAreaFilled(false);
        JbCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JbCerrar.setFocusPainted(false);
        JbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(JbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 10, 40, 40));

        Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Add_40px.png"))); // NOI18N
        Agregar.setToolTipText("Agregar");
        Agregar.setBorderPainted(false);
        Agregar.setContentAreaFilled(false);
        Agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Agregar.setFocusable(false);
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        getContentPane().add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 145, 70, 50));

        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Edit_40px.png"))); // NOI18N
        Editar.setToolTipText("Editar");
        Editar.setBorderPainted(false);
        Editar.setContentAreaFilled(false);
        Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Editar.setFocusable(false);
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        getContentPane().add(Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 215, 70, 50));

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Trash Can_40px.png"))); // NOI18N
        Eliminar.setToolTipText("Eliminar");
        Eliminar.setBorderPainted(false);
        Eliminar.setContentAreaFilled(false);
        Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Eliminar.setFocusable(false);
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 285, 70, 50));

        Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Select_40px.png"))); // NOI18N
        Consultar.setToolTipText("Consultar");
        Consultar.setBorderPainted(false);
        Consultar.setContentAreaFilled(false);
        Consultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultar.setFocusable(false);
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 355, 70, 50));

        JpControlPanel.setName("Control Panel"); // NOI18N
        JpControlPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LineCajaCerrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LineCajaCerrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/line2.png"))); // NOI18N
        LineCajaCerrada.setFocusable(false);
        JpControlPanel.add(LineCajaCerrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 325, 105, 10));

        LineHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LineHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/line2.png"))); // NOI18N

        LineHome.setDisabledIcon(null);

        LineHome.setFocusable(false);
        JpControlPanel.add(LineHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 98, 105, 10));

        LineAcerca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LineAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/line2.png"))); // NOI18N
        LineAcerca.setFocusable(false);
        JpControlPanel.add(LineAcerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 383, 105, 10));

        LineDevoluciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LineDevoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/line2.png"))); // NOI18N
        LineDevoluciones.setFocusable(false);
        JpControlPanel.add(LineDevoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 215, 105, 10));

        LineCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LineCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/line2.png"))); // NOI18N
        LineCaja.setFocusable(false);
        JpControlPanel.add(LineCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 155, 105, 10));

        LineSalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LineSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/line2.png"))); // NOI18N
        LineSalida.setFocusable(false);
        JpControlPanel.add(LineSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 105, 10));

        Menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Menu_32px.png"))); // NOI18N
        Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMouseClicked(evt);
            }
        });
        JpControlPanel.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 50, 50));

        SelectedHome.setBorderPainted(false);
        SelectedHome.setContentAreaFilled(false);
        SelectedHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelectedHome.setFocusPainted(false);
        SelectedHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectedHomeActionPerformed(evt);
            }
        });
        JpControlPanel.add(SelectedHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 50));

        SelectedDevoluciones.setBorderPainted(false);
        SelectedDevoluciones.setContentAreaFilled(false);
        SelectedDevoluciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelectedDevoluciones.setFocusPainted(false);
        SelectedDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectedDevolucionesActionPerformed(evt);
            }
        });
        JpControlPanel.add(SelectedDevoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 50));

        SelectedSalidas.setBorderPainted(false);
        SelectedSalidas.setContentAreaFilled(false);
        SelectedSalidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelectedSalidas.setFocusPainted(false);
        SelectedSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectedSalidasActionPerformed(evt);
            }
        });
        JpControlPanel.add(SelectedSalidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, 50));

        SelectedCajaCerrada.setBorderPainted(false);
        SelectedCajaCerrada.setContentAreaFilled(false);
        SelectedCajaCerrada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelectedCajaCerrada.setFocusPainted(false);
        SelectedCajaCerrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectedCajaCerradaActionPerformed(evt);
            }
        });
        JpControlPanel.add(SelectedCajaCerrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 230, 50));

        SelectedAcerca.setBorderPainted(false);
        SelectedAcerca.setContentAreaFilled(false);
        SelectedAcerca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelectedAcerca.setFocusPainted(false);
        SelectedAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectedAcercaActionPerformed(evt);
            }
        });
        JpControlPanel.add(SelectedAcerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 50));

        SelectedCaja.setBorderPainted(false);
        SelectedCaja.setContentAreaFilled(false);
        SelectedCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelectedCaja.setFocusPainted(false);
        SelectedCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectedCajaActionPerformed(evt);
            }
        });
        JpControlPanel.add(SelectedCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 230, 50));

        JlbHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home Button_32px.png"))); // NOI18N
        JpControlPanel.add(JlbHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 55, 50, 55));

        JlbCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Coins_40px.png"))); // NOI18N
        JpControlPanel.add(JlbCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 50, 55));

        JlbDevoluciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbDevoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Cash in Hand_40px.png"))); // NOI18N
        JpControlPanel.add(JlbDevoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 50, 55));

        JlbSalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Low Price_40px.png"))); // NOI18N
        JpControlPanel.add(JlbSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 225, 50, 55));

        JlbCajaCerrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbCajaCerrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Close Sign_40px.png"))); // NOI18N
        JpControlPanel.add(JlbCajaCerrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 283, 50, 55));

        JlbEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Aboutt_32px.png"))); // NOI18N
        JpControlPanel.add(JlbEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 50, 55));

        TituloHome.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        TituloHome.setForeground(new java.awt.Color(111, 174, 2));
        TituloHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloHome.setText("Home");
        JpControlPanel.add(TituloHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 100, 50));

        TituloCaja.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        TituloCaja.setForeground(new java.awt.Color(111, 174, 2));
        TituloCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloCaja.setText("Caja");
        JpControlPanel.add(TituloCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 100, 60));

        TituloDevoluciones.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        TituloDevoluciones.setForeground(new java.awt.Color(111, 174, 2));
        TituloDevoluciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloDevoluciones.setText("Devoluciones");
        JpControlPanel.add(TituloDevoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 120, 60));

        TituloSalida.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        TituloSalida.setForeground(new java.awt.Color(111, 174, 2));
        TituloSalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloSalida.setText("Gastos");
        JpControlPanel.add(TituloSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 100, 50));

        TituloCajaCerrada.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        TituloCajaCerrada.setForeground(new java.awt.Color(111, 174, 2));
        TituloCajaCerrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloCajaCerrada.setText("Cajas cerradas");
        JpControlPanel.add(TituloCajaCerrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 140, 60));

        TituloEmpleado.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        TituloEmpleado.setForeground(new java.awt.Color(111, 174, 2));
        TituloEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloEmpleado.setText("Información");
        JpControlPanel.add(TituloEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 100, 60));

        JbtnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Sign_Out_32px.png"))); // NOI18N
        JbtnLogout.setBorderPainted(false);
        JbtnLogout.setContentAreaFilled(false);
        JbtnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JbtnLogout.setFocusPainted(false);
        JbtnLogout.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Sign_Out_32px_1.png"))); // NOI18N
        JbtnLogout.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Sign_Out_32px_1.png"))); // NOI18N
        JbtnLogout.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Sign_Out_32px_1.png"))); // NOI18N
        JbtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnLogoutActionPerformed(evt);
            }
        });
        JpControlPanel.add(JbtnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 50, 90));

        JlPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PANEL.png"))); // NOI18N
        JpControlPanel.add(JlPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 497));

        getContentPane().add(JpControlPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 2, 230, 496));

        JpMenuOption.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Menu Vertical_32px.png"))); // NOI18N
        MenuOption.setBorderPainted(false);
        MenuOption.setContentAreaFilled(false);
        MenuOption.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuOption.setFocusable(false);
        MenuOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOptionActionPerformed(evt);
            }
        });
        JpMenuOption.add(MenuOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 70, 50));

        BtnReporte5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5.png"))); // NOI18N
        BtnReporte5.setToolTipText("Reporte de $5.00");
        BtnReporte5.setBorderPainted(false);
        BtnReporte5.setContentAreaFilled(false);
        BtnReporte5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnReporte5.setFocusable(false);
        BtnReporte5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReporte5ActionPerformed(evt);
            }
        });
        JpMenuOption.add(BtnReporte5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 40, 50));

        BtnReporte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1.png"))); // NOI18N
        BtnReporte1.setToolTipText("Reporte $1.00");
        BtnReporte1.setBorderPainted(false);
        BtnReporte1.setContentAreaFilled(false);
        BtnReporte1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnReporte1.setFocusable(false);
        BtnReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReporte1ActionPerformed(evt);
            }
        });
        JpMenuOption.add(BtnReporte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        Fnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu options/Fnd.png"))); // NOI18N
        JpMenuOption.add(Fnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 50));

        getContentPane().add(JpMenuOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 170, 50));

        TitulpPestaña.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        TitulpPestaña.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TitulpPestaña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 290, 50));

        JpTabla.setName("Local"); // NOI18N
        JpTabla.setOpaque(false);
        JpTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setOpaque(false);

        Tabla.setBackground(new java.awt.Color(111, 174, 2));
        Tabla.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        Tabla.setForeground(new java.awt.Color(255, 255, 255));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla.setFocusable(false);
        Tabla.setOpaque(false);
        Tabla.setRowHeight(20);
        jScrollPane1.setViewportView(Tabla);

        JpTabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 820, 280));

        Monto1.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        Monto1.setForeground(new java.awt.Color(204, 204, 204));
        Monto1.setText("(Monto $1.°°)");
        JpTabla.add(Monto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        LabelTotal.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        LabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        LabelTotal.setText("Total de gastos :");
        JpTabla.add(LabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        casillaTotal.setEditable(false);
        casillaTotal.setBackground(new java.awt.Color(50, 50, 50));
        casillaTotal.setForeground(new java.awt.Color(255, 0, 0));
        casillaTotal.setText("$0.00");
        casillaTotal.setColorTransparente(true);
        casillaTotal.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        casillaTotal.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        casillaTotal.setModoMaterial(true);
        casillaTotal.setOpaque(false);
        casillaTotal.setPlaceholder("$5,000.00");
        casillaTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaTotalActionPerformed(evt);
            }
        });
        JpTabla.add(casillaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, 210, 40));

        getContentPane().add(JpTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 950, 380));

        JpBackground.setName("Fondo"); // NOI18N
        JpBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Login.png"))); // NOI18N
        JpBackground.add(JlBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        getContentPane().add(JpBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbMinimizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbMinimizaActionPerformed
        this.setState(Inicio.ICONIFIED);
    }//GEN-LAST:event_JbMinimizaActionPerformed

    private void JbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_JbCerrarActionPerformed

    private void MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseClicked
        moverControlPanel();
    }//GEN-LAST:event_MenuMouseClicked
        
    private void SelectedDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedDevolucionesActionPerformed
        isModal = true;
        indexModal = 2;
        LineHome.setVisible(false);
        LineCaja.setVisible(false);
        LineDevoluciones.setVisible(true);
        LineSalida.setVisible(false);
        LineCajaCerrada.setVisible(false);
        LineAcerca.setVisible(false);
        this.BtnReporte1.setVisible(false);
        this.BtnReporte5.setVisible(false);
        TitulpPestaña.setText("Devolución");
        this.JpTabla.setVisible(false);
        habilitarMenuOption(true);
        cmp = this.getContentPane().getComponents();
        search.mostrarDatos(Tabla, "vistadevoluciones");
        if (isCmp(nameCmp[7]) == -1) {
            pD = new panelDevolucion();
            pD.setVisible(true);
            this.getContentPane().add(pD, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 950, 380));
            reorderCmp(nameCmp[7]);
        }
        if (isCmp(nameCmp[1]) == -1) {
            MD = new ModalDevolucion(pD.Tabla1, pD.Tabla5, pD, pS, MenuOption, Agregar, Editar, Eliminar, Consultar);
            MD.setVisible(true);
            this.getContentPane().add(MD, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 950, 380));
            reorderCmp(nameCmp[1]);
        }
        String[] excp = {nameCmp[1], nameCmp[7]};//No eliminamos el panel local, Entrada ni la de Search.
        remAnim(excp, true);
    }//GEN-LAST:event_SelectedDevolucionesActionPerformed

    private void SelectedHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedHomeActionPerformed
        isModal = false;
        LineHome.setVisible(true);
        LineCaja.setVisible(false);
        LineDevoluciones.setVisible(false);
        LineSalida.setVisible(false);
        LineCajaCerrada.setVisible(false);
        LineAcerca.setVisible(false);
        this.BtnReporte1.setVisible(false);
        this.BtnReporte5.setVisible(false);
        TitulpPestaña.setText("");
        this.JpTabla.setVisible(false);
        habilitarMenuOption(false);
        cmp = this.getContentPane().getComponents();
        if (isCmp(nameCmp[4]) == -1) {
            pH = new panelHome();
            pH.setVisible(true);
            this.getContentPane().add(pH, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 950, 380));
            reorderCmp(nameCmp[4]);
        }
        String[] excp = {nameCmp[4]};
        remAnim(excp, false);
    }//GEN-LAST:event_SelectedHomeActionPerformed

    private void SelectedSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedSalidasActionPerformed
        isModal = true;
        indexModal = 3;
        LineHome.setVisible(false);
        LineCaja.setVisible(false);
        LineDevoluciones.setVisible(false);
        LineSalida.setVisible(true);
        LineCajaCerrada.setVisible(false);
        LineAcerca.setVisible(false);
        this.BtnReporte1.setVisible(false);
        this.BtnReporte5.setVisible(false);
        this.Monto1.setVisible(true);
        this.LabelTotal.setVisible(true);
        this.casillaTotal.setVisible(true);
        TitulpPestaña.setText("Gastos");
        this.JpTabla.setVisible(true);
        this.casillaTotal.setText("$" + Inicio.v.presentardecimalFormat(CtrlCaja.getTotalGastos()));
        this.casillaTotal.setPlaceholder("$" + Inicio.v.presentardecimalFormat(CtrlCaja.getTotalGastos()));

        habilitarMenuOption(true);
        cmp = this.getContentPane().getComponents();
        search.mostrarDatos(Tabla, "vistagastos");
        if (isCmp(nameCmp[2]) == -1) {
            MG = new ModalGasto(Tabla, JpTabla, pS, MenuOption, Agregar, Editar, Eliminar, Consultar);
            MG.setVisible(true);
            this.getContentPane().add(MG, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 950, 380));
            reorderCmp(nameCmp[2]);
        }
        String[] excp = {nameCmp[2]};
        remAnim(excp, true);
    }//GEN-LAST:event_SelectedSalidasActionPerformed

    private void SelectedCajaCerradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedCajaCerradaActionPerformed
        IDReportCaja = 0;
        isCajaOpen = false;
        indexModal = 1;
        isModal = false;
        LineHome.setVisible(false);
        LineCaja.setVisible(false);
        LineDevoluciones.setVisible(false);
        LineSalida.setVisible(false);
        LineCajaCerrada.setVisible(true);
        LineAcerca.setVisible(false);
        this.BtnReporte1.setVisible(true);
        this.BtnReporte5.setVisible(true);
        this.Monto1.setVisible(false);
        this.LabelTotal.setVisible(false);
        this.casillaTotal.setVisible(false);
        TitulpPestaña.setText("Cajas cerradas");
        this.JpTabla.setVisible(true);
        search.mostrarDatos(Tabla, "vistacajaclose");
        rowSM = Tabla.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (indexModal == 1) {
                    ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                    if (!lsm.isSelectionEmpty()) {
                        IDReportCaja = Integer.parseInt(Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString());
                        //System.out.println("IDCaja Reporte := " + IDReportCaja);
                    }
                }

            }
        });
        habilitarMenuOption(false);
        this.MenuOption.setVisible(true);
        this.Consultar.setVisible(true);
        cmp = this.getContentPane().getComponents();
        String[] excpt = {"Other"};
        remAnim(excpt, true);
        isPanelSearch();
        pS.changeValueCmb();
        addPanelCaja(500);

        panelCaja.BtnCorte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Return_45px.png")));
        panelCaja.BtnCorte.setToolTipText("Regresar");
        String[] excp = {nameCmp[0], nameCmp[3], nameCmp[5]};
        remAnim(excp, true);
    }//GEN-LAST:event_SelectedCajaCerradaActionPerformed

    private void SelectedAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedAcercaActionPerformed
        isModal = true;
        indexModal = 4;
        LineHome.setVisible(false);
        LineCaja.setVisible(false);
        LineDevoluciones.setVisible(false);
        LineSalida.setVisible(false);
        LineCajaCerrada.setVisible(false);
        LineAcerca.setVisible(true);
        this.BtnReporte1.setVisible(false);
        this.BtnReporte5.setVisible(false);
        this.Monto1.setVisible(false);
        this.LabelTotal.setVisible(false);
        this.casillaTotal.setVisible(false);
        TitulpPestaña.setText("Información");
        this.JpTabla.setVisible(false);
        habilitarMenuOption(false);
        cmp = this.getContentPane().getComponents();
        if (isCmp(nameCmp[6]) == -1) {
            pA = new panelAcerca();
            pA.setVisible(true);
            this.getContentPane().add(pA, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 950, 378));
            reorderCmp(nameCmp[6]);
        }
        String[] excp = {nameCmp[6]};
        remAnim(excp, false);
        
    }//GEN-LAST:event_SelectedAcercaActionPerformed

    private void SelectedCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedCajaActionPerformed
        isCajaOpen = true;
        isModal = true;
        indexModal = 1;
        LineHome.setVisible(false);
        LineCaja.setVisible(true);
        LineDevoluciones.setVisible(false);
        LineSalida.setVisible(false);
        LineCajaCerrada.setVisible(false);
        LineAcerca.setVisible(false);
        this.BtnReporte1.setVisible(false);
        this.BtnReporte5.setVisible(false);
        TitulpPestaña.setText("Caja");
        this.JpTabla.setVisible(false);
        habilitarMenuOption(false);
        this.MenuOption.setVisible(true);
        this.Editar.setVisible(true);
        cmp = this.getContentPane().getComponents();
        String[] excpt = {"Other"};
        remAnim(excpt, true);
        addPanelCaja(120);
        panelCaja.BtnCorte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Ok_45px.png")));
        String[] excp = {nameCmp[0]};
        remAnim(excp, true);
    }//GEN-LAST:event_SelectedCajaActionPerformed
    private void addPanelCaja(int posY) {
        if (isCmp(nameCmp[0]) == -1) {
            pC = new panelCaja(JpTabla, pS, MenuOption, Consultar);
            pC.Recupera();
            pC.setVisible(true);
            this.getContentPane().add(pC, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, posY, 950, 380));
            reorderCmp(nameCmp[0]);
        }
    }

    private void isPanelSearch() {
        if (isCmp(nameCmp[3]) == -1) {//verifica que el panelSearch no haya sido agregado
            pS = new panelSearch(Tabla);
            pS.setVisible(true);
            this.getContentPane().add(pS, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 475, 50));
            cmp = this.getContentPane().getComponents();
            int posS = isCmp(nameCmp[3]);
            this.getContentPane().setComponentZOrder(cmp[posS], posS - 1);
            cmp = this.getContentPane().getComponents();
        } else {
            pS.setVisible(true);
        }
    }

    private void removeCmp(String[] excpNombre) {
        for (int i = 0; i < nameCmp.length; i++) {//recorro el arreglo de los nombres
            boolean bnd = true;
            for (int j = 0; j < excpNombre.length; j++) {
                if (nameCmp[i].equals(excpNombre[j])) {
                    bnd = false;//Encontro un nombre ubicado como execpcioon
                    break;
                }
            }
            if (bnd) {
                int pos = isCmp(nameCmp[i]);
                if (pos != -1) {
                    //System.out.println("Encontrado y emliminado:=" + pos + ":::" + nameCmp[i]);

                    switch (this.getContentPane().getComponent(pos).getName()) {
                        case "panelCaja":
                            pC = null;
                            break;
                        case "ModalDevolucion":
                            MD = null;
                            break;
                        case "ModalSalida":
                            MG = null;
                            break;                        
                        case "panelHome":
                            pH = null;
                            break;
                        case "panelSearch":
                            pS = null;
                            break;
                        case "panelDevolucion":
                            pD = null;
                            break;  
                        case "panelAcerca":
                            pA = null;
                            break;
                    }
                    this.getContentPane().remove(pos);
                    cmp = this.getContentPane().getComponents();
                }
            }
        }

    }

    private int isCmp(String name) {
        int valor = -1;
        for (int i = 0; i < cmp.length; i++) {
            //System.out.println((i) + ":=" + cmp[i].getName());
            if (cmp[i].getName() != null && cmp[i].getName().equals(name)) {
                valor = i;
            }
        }
        //System.out.println("valor:=" + valor);
        return valor;
    }
    private void MenuOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOptionActionPerformed
        MoveO();
    }//GEN-LAST:event_MenuOptionActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        Operacion = HMySQL.AGREGAR;
        accionGral();
    }//GEN-LAST:event_AgregarActionPerformed

    private void formWindowDeiconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeiconified
        if (isModal) {
            switch (indexModal) {
                case 1:
                    //movePanelSearch();
                    //movePanelLocal2(ML);
                    break;
                case 2:
                    //movePanelSearch();
                    //movePanelLocal2(ME);
                    break;
                case 3:
                    //movePanelSearch();
                    movePanelLocal2(MG);
                    break;
            }
            MoveO2();
        }
        moverControlPanel2();
    }//GEN-LAST:event_formWindowDeiconified

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        Operacion = HMySQL.ACTUALIZAR;
        accionGral();
    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        Operacion = HMySQL.ELIMINAR;
        accionGral();
    }//GEN-LAST:event_EliminarActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        Operacion = HMySQL.CONSULTAR;
        accionGral();
    }//GEN-LAST:event_ConsultarActionPerformed

    private void BtnReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReporte1ActionPerformed
        if (indexModal == 1) {
            if (IDReportCaja != 0) {
                new ControladorReporte(IDReportCaja, 1);
                //System.out.println("Valor del id Caja:= " + IDReportCaja);
            } else {
                Inicio.v.Msj("¡ Porfavor selecciona un registro para poder realizar el reporte correspondiente !", Constant.TITULO_ERROR, Id);
            }
        }
    }//GEN-LAST:event_BtnReporte1ActionPerformed

    private void casillaTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaTotalActionPerformed

    private void BtnReporte5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReporte5ActionPerformed
        if (indexModal == 1) {
            if (IDReportCaja != 0) {
                new ControladorReporte(IDReportCaja, 5);
                //System.out.println("Valor del id Caja:= " + IDReportCaja);
            } else {
                Inicio.v.Msj("¡ Porfavor selecciona un registro para poder realizar el reporte correspondiente !", Constant.TITULO_ERROR, Id);
            }
        }
    }//GEN-LAST:event_BtnReporte5ActionPerformed

    private void JbtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnLogoutActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "¿ Desea salir del sistema ?", "Exit", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_JbtnLogoutActionPerformed
    private void disableMenuOption() {
        if(indexModal==1)
        this.pS.setVisible(false);
        this.MenuOption.setVisible(false);
        this.Agregar.setVisible(false);
        this.Editar.setVisible(false);
        this.Eliminar.setVisible(false);
        this.Consultar.setVisible(false);
    }

    private void accionGral() {
        switch (indexModal) {
            case 1:
                accionCaja();
                break;
            case 2:
                accionDevolucion();//Entrada
                break;
            case 3:
                accionSalida();//Salida
                break;
        }
    }
    
    private void accionCaja() {
        switch (Operacion) {
            case 2:
                new MontoInicial(this, true, Operacion);
                //pC.Recupera();
                break;
            case 4:
                if (Tabla.getSelectedRows().length > 0) {
                    Id = Integer.parseInt(Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString());
                    disableMenuOption();
                    pC.Consulta(Id);
                    movePanel(pC);
                } else {
                    Inicio.v.Msj(Constant.SELECCIONA, Constant.TITULO_ERROR, 0);
                }
                break;
        }

    }

    private void accionDevolucion() {
        switch (Operacion) {
            case 1:
                disableMenuOption();
                MD.inicio();
                movePanel(MD);//Agregar
                
                break;
            case 2:
                accionSelectDevolucion();//Editar
                break;
            case 3:
                accionSelectDevolucion();//Eliminar
                break;
            case 4:
                accionSelectDevolucion();//Consultar
                break;
        }
    }
    
    private void accionSalida() {
        switch (Operacion) {
            case 1:
                disableMenuOption();
                MG.inicio();
                movePanel(MG);//Agregar
                
                break;
            case 2:
                accionSelectSalida();//Editar
                break;
            case 3:
                accionSelectSalida();//Eliminar
                break;
            case 4:
                accionSelectSalida();//Consultar
                break;
        }
    }

    private void accionSelectDevolucion() {
        if (pD.Tabla1.getSelectedRows().length > 0) {
            Id = Integer.parseInt(pD.Tabla1.getValueAt(pD.Tabla1.getSelectedRow(), 0).toString());
            disableMenuOption();
            MD.inicio();
            movePanel(MD);

        } else if (pD.Tabla5.getSelectedRows().length > 0) {
            Id = Integer.parseInt(pD.Tabla5.getValueAt(pD.Tabla5.getSelectedRow(), 0).toString());
            disableMenuOption();
            MD.inicio();
            movePanel(MD);
        } else {
            Inicio.v.Msj(Constant.SELECCIONA, Constant.TITULO_ERROR, 0);
        }
    }
    
    private void accionSelectSalida() {
        if (Tabla.getSelectedRows().length > 0) {
            Id = Integer.parseInt(Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString());
            disableMenuOption();
            MG.inicio();
            movePanel(MG);
        } else {
            Inicio.v.Msj(Constant.SELECCIONA, Constant.TITULO_ERROR, 0);
        }
    }

    private void movePanel(JPanel panel) {

        if (indexModal == 2) {
            //System.out.println("pD.getY():=" + pD.getY());
            if (this.pD.getY() == 120) {
                Animacion.bajar(120, 500, 1, 2, pD);
                Animacion.subir(500, 120, 1, 2, panel);
            } else {
                Animacion.subir(500, 120, 1, 2, pD);
                Animacion.bajar(120, 500, 1, 2, panel);
            }
        } else{
            if (this.JpTabla.getY() == 120) {
                Animacion.bajar(120, 500, 1, 5, JpTabla);
                Animacion.subir(500, 120, 1, 5, panel);

            } else {
                Animacion.subir(500, 120, 1, 5, JpTabla);
                Animacion.bajar(120, 500, 1, 5, panel);

            }
        }
    }

    private void movePanelLocal2(JPanel panel) {
        if (indexModal == 2) {
            if (this.pD.getY() == 120) {
                Animacion.bajar(120, 120, 1, 2, pD);
                Animacion.subir(500, 500, 1, 2, panel);
            } else {
                Animacion.subir(500, 500, 1, 2, pD);
                Animacion.bajar(120, 120, 1, 2, panel);
            }
        }else{
            if (this.JpTabla.getY() == 120) {
                Animacion.bajar(120, 120, 1, 2, JpTabla);
                Animacion.subir(500, 500, 1, 2, panel);
            } else {
                Animacion.subir(500, 500, 1, 2, JpTabla);
                Animacion.bajar(120, 120, 1, 2, panel);
            }
        }
    }

    private void moveOption(JButton btn) {
        int posicion = btn.getX();
        if (posicion == 930) {
            Animacion.mover_derecha(930, 1000, 2, 1, btn);
        } else {
            Animacion.mover_izquierda(1000, 930, 2, 1, btn);
        }
    }

    private void moveOption2(JButton btn) {
        int posicion = btn.getX();
        if (posicion == 930) {
            Animacion.mover_derecha(930, 930, 1, 2, btn);
        } else {
            Animacion.mover_izquierda(1000, 1000, 1, 2, btn);
        }
    }

    private void moverControlPanel() {
        int posicion = this.JpControlPanel.getX();
        if (posicion == -180) {
            Animacion.mover_derecha(-180, 0, 1, 5, JpControlPanel);
        } else {
            Animacion.mover_izquierda(0, -180, 1, 5, JpControlPanel);
        }
    }

    private void moverControlPanel2() {
        int posicion = this.JpControlPanel.getX();
        if (posicion == -180) {
            Animacion.mover_derecha(-180, -180, 1, 2, JpControlPanel);
        } else {
            Animacion.mover_izquierda(0, 0, 1, 2, JpControlPanel);
        }
    }

    public void habilitarMenuOption(boolean bnd) {
        this.MenuOption.setVisible(bnd);
        this.Agregar.setVisible(bnd);
        this.Editar.setVisible(bnd);
        this.Eliminar.setVisible(bnd);
        this.Consultar.setVisible(bnd);
    }

    private void MoveO() {
        moveOption(Agregar);
        moveOption(Editar);
        moveOption(Eliminar);
        moveOption(Consultar);
    }

    private void MoveO2() {
        moveOption2(Agregar);
        moveOption2(Editar);
        moveOption2(Eliminar);
        moveOption2(Consultar);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton BtnReporte1;
    private javax.swing.JButton BtnReporte5;
    private javax.swing.JButton Consultar;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JLabel Fnd;
    private javax.swing.JButton JbCerrar;
    private javax.swing.JButton JbMinimiza;
    private javax.swing.JButton JbtnLogout;
    private javax.swing.JLabel JlBackground;
    private javax.swing.JLabel JlPanel;
    private javax.swing.JLabel JlbCaja;
    private javax.swing.JLabel JlbCajaCerrada;
    private javax.swing.JLabel JlbDevoluciones;
    private javax.swing.JLabel JlbEmpleado;
    private javax.swing.JLabel JlbHome;
    private javax.swing.JLabel JlbSalida;
    private javax.swing.JPanel JpBackground;
    private javax.swing.JPanel JpControlPanel;
    private javax.swing.JPanel JpMenuOption;
    public static javax.swing.JPanel JpTabla;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel LineAcerca;
    private javax.swing.JLabel LineCaja;
    private javax.swing.JLabel LineCajaCerrada;
    private javax.swing.JLabel LineDevoluciones;
    private javax.swing.JLabel LineHome;
    private javax.swing.JLabel LineSalida;
    private javax.swing.JLabel Menu;
    private javax.swing.JButton MenuOption;
    private javax.swing.JLabel Monto1;
    private javax.swing.JButton SelectedAcerca;
    private javax.swing.JButton SelectedCaja;
    private javax.swing.JButton SelectedCajaCerrada;
    private javax.swing.JButton SelectedDevoluciones;
    private javax.swing.JButton SelectedHome;
    private javax.swing.JButton SelectedSalidas;
    public static javax.swing.JTable Tabla;
    private javax.swing.JLabel TituloCaja;
    private javax.swing.JLabel TituloCajaCerrada;
    private javax.swing.JLabel TituloDevoluciones;
    private javax.swing.JLabel TituloEmpleado;
    private javax.swing.JLabel TituloHome;
    private javax.swing.JLabel TituloSalida;
    private javax.swing.JLabel TitulpPestaña;
    public static rojeru_san.RSMTextFull casillaTotal;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
