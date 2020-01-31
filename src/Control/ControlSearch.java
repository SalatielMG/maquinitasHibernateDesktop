
package Control;

import Util.Constant;
import Vista.Inicio;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author hills
 */

public class ControlSearch {
    private String[] column = null;
    private String[] header = null;
    private int[] ancho = null;
    public void mostrarDatos(JTable Tabla, String nameVista) {
        String cadena = "select * from " + nameVista+" ORDER BY id DESC;";
        //System.out.println("Consulta:= " + cadena);
        ResultSet rs = (ResultSet) Inicio.hmysql.consultaResulSetSQL(cadena);
        DefaultTableModel dtm = DTM(Tabla);
        colocarDatos(rs, dtm);
    }

    public void mostrarDatos(JTable Tabla, String nameTable, String columnTable, String type, String search) {

        String cadena = "Select * from " + nameTable + " where " + columnTable + " " + type + " " + search + ";";
        //System.out.println("Consulta:= " + cadena);
        ResultSet rs = (ResultSet) Inicio.hmysql.consultaResulSetSQL(cadena);
        try {
            if (!rs.next()) {
                Inicio.v.Msj("No se econtro ningun registro con el criterio de Busqueda.", "..:: --- ¡ Error ! ---", 0);
                //return;
            } else {
                rs.beforeFirst();
                DefaultTableModel dtm = DTM(Tabla);
                colocarDatos(rs, dtm);
            }
        } catch (Exception ex) {
            Logger.getLogger(ControlSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void colocarDatos(ResultSet rs, DefaultTableModel dtm) {
        Object[] datos = new Object[column.length];
        try {
            while (rs.next()) {
                for (int i = 0; i < column.length; i++) {
                    if (i == 1 && Inicio.indexModal != 4 && Inicio.indexModal != 5) {
                        datos[i] = Inicio.v.presentacionFecha(Inicio.v.getDatoFecha(rs.getString(column[i])));

                    } else {
                        datos[i] = rs.getObject(column[i]);
                        switch (Inicio.indexModal) {
                            case 1:
                                if (i == 2 || i == 3) {
                                    datos[i] = "$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + rs.getInt(column[i])));

                                } else if (i == 4) {
                                    datos[i] = Inicio.v.presentacionFecha(Inicio.v.getDatoFecha(rs.getString(column[i])));
                                }

                                break;
                            case 2:
                                if (i == 2) {
                                    datos[i] = returnTipoDev(rs.getInt(column[i]));
                                } else if (i == 3) {
                                    datos[i] = "$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + rs.getInt(column[i])));

                                }
                                break;
                            case 3:
                                if (i == 4) {
                                    datos[i] = "$" + Inicio.v.presentardecimalFormat(rs.getDouble(column[i]));

                                }
                                break;
                        }
                    }

                }
                dtm.addRow(datos);
            }
        } catch (SQLException e) {
            //System.out.println("Ocurrio un error");
        }
    }
    
    private DefaultTableModel DTM(JTable Tabla) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {                
                return false;
            }
        };
        Tabla.setModel(dtm);
        switch (Inicio.indexModal) {
            case 1:
                column = Constant.columnTableCajas;
                header = Constant.headerTableCajas;
                ancho = Constant.anchoColumnasCajas;
                break;
            case 2:
                header = Constant.headerTableVistaDevoluciones;
                column = Constant.columnTableVistaDevoluciones;
                ancho = Constant.anchoColumnasVistaDevoluciones;
                break;
            case 3:
                header = Constant.headerTableVistaGastos;
                column = Constant.columnTableVistaGastos;
                ancho = Constant.anchoColumnasVistaGastos;
                break;
                case 4:
                header = Constant.headerTableVistaEmpleados;
                column = Constant.columnTableVistaEmpleados;
                ancho = Constant.anchoColumnasVistaEmpleados;
                break;
                case 5:
                header = Constant.headerTableVistaLocales;
                column = Constant.columnTableVistaLocales;
                ancho = Constant.anchoColumnasVistaLocales;
                break;
                case 6:
                header = Constant.headerTableVistaEntradas;
                column = Constant.columnTableVistaEntradas;
                ancho = Constant.anchoColumnasVistaEntradas;
                break;
        }
        for (int i = 0; i < header.length; i++) {
            if (Inicio.indexModal == 1 && i == 0) {
                dtm.addColumn("Caja");
            } else {
                dtm.addColumn(header[i]);
            }            
        }
        Tabla.getTableHeader().setReorderingAllowed(false);
        JTableHeader Theader = Tabla.getTableHeader();
        /*Theader.setBackground(Color.red); // change the Background color
        Theader.setForeground(Color.WHITE); // change the Foreground
         */
        Theader.setFont(new Font("Decker", Font.BOLD, 25)); // font name style size
        Tabla.setFont(new Font("Decker", Font.PLAIN, 18));
        TableColumnModel columnModel = Tabla.getColumnModel();
        for (int i = 0; i < column.length; i++) {
            
            columnModel.getColumn(i).setPreferredWidth(ancho[i]);
        }
        if (Inicio.indexModal != 1) {
            columnModel.getColumn(0).setPreferredWidth(0);
            columnModel.getColumn(0).setMinWidth(0);
            columnModel.getColumn(0).setMaxWidth(0);
            columnModel.getColumn(0).setWidth(0);
            columnModel.getColumn(0).setResizable(false);
        }
        return dtm;
    }
    
    private String returnTipoDev(int tipo) {
        if (tipo == 0) {
            return "Monto de $1.00";
        }
        return "Monto de $5.00";
    }
    
}
