package Util;

import Dato.Caja;
import Dato.Tipogasto;
import Vista.Inicio;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Salatiel
 */
public class Validacion {
    private int in=0;
    private HMySQL mysql=new HMySQL();
    
    public boolean hayCajaAbierta(){
        List<Caja> cajasActivas = Inicio.hmysql.consultaSQLObjetos("select * from vistacajaopen");
        System.out.println("cajasActivas" + cajasActivas.size());
     
        return (cajasActivas.size() > 0) ? true: false;
    }
    
    public String getFechaHoraSistema(){
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");
        return hourdateFormat.format(date);
    }
    
    public String getFecha(Date datoFecha) {
        int Año=(datoFecha.getYear()+1900);
        int Mes=(datoFecha.getMonth()+1);
        int Dia=datoFecha.getDate();
        return ""+Año+"-"+((Mes<10)?"0"+Mes:""+Mes)+"-"+((Dia<10)?"0"+Dia:""+Dia);
    }
    public Date fechaActual(){
        Calendar fecha = Calendar.getInstance();
        return fecha.getTime();
    }
    public Date getDatoFecha(String fecha) {
        if (fecha == null) return null;
        System.out.println("Fecha: " + fecha);
        Calendar fechaDate = Calendar.getInstance();
        Date f=fechaDate.getTime();
        String []date=fecha.split("-");
        f.setYear(Integer.parseInt(date[0])-1900);
        f.setMonth((Integer.parseInt(date[1])-1));
        f.setDate(Integer.parseInt(date[2]));
        return f;
    }
    public boolean validaFechaReporte(Date desde, Date hasta){
        int AñoDesde,MesDesde,DiaDesde, AñoHasta, MesHasta, DiaHasta;
        AñoDesde=desde.getYear();
        MesDesde=desde.getMonth();
        DiaDesde=desde.getDate();
        AñoHasta=hasta.getYear();
        MesHasta=hasta.getMonth();
        DiaHasta=hasta.getDate();
        if(AñoHasta>=AñoDesde&&MesHasta>=MesDesde&&DiaHasta>=DiaDesde)
            return true;
        else
            return false;
        
    }
    public boolean bndRegistro(){
        boolean bnd=false;
        ResultSet FM=(ResultSet) mysql.consultaObjeto("Select FechaMinima()as FM;");
        try {
            if(!FM.wasNull()){
                bnd=true;
            }
        } catch (Exception e) {
            bnd=false;
            System.out.println("Ocurrio un error");
        }
        return bnd;
    }
    public String obtFechaMinima(){
        String fecha="";
        ResultSet FM=(ResultSet) mysql.consultaObjeto("Select FechaMinima()as FM;");
        try {
            FM.next();
            fecha=FM.getString("FM");
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
        return fecha;
    }
    public boolean validaFechaDesde(Date datoFecha) {
        String FechaDesde=getFecha(datoFecha);
        ResultSet rEntrada, rGasto;
        String cadenaEntrada="Select verificaFechaDesdeEntradas('"+FechaDesde+"') as VFDE;";
        System.out.println("Consult aEntrada:= "+cadenaEntrada);
        rEntrada=(ResultSet) mysql.consultaObjeto(cadenaEntrada);
        String cadenaGasto="Select verificaFechaDesdeSalidas('"+FechaDesde+"') as VFDS;";                System.out.println("Consult aGasto:= "+cadenaGasto);
        rGasto=(ResultSet) mysql.consultaObjeto(cadenaGasto);
        try {
            rEntrada.next();
            rGasto.next();
            
            if(rEntrada.getInt("VFDE")==1||rGasto.getInt("VFDS")==1)
                return true;
        } catch (Exception e) {
            System.out.println("Ocurrio un Error");
        }
        Msj("¡ No hay registros desde el : "+presentacionFecha(datoFecha)+" !\n"
                + "Porfavor busca Registros desde la Fecha: "+presentacionFecha(getDatoFecha(obtFechaMinima())), Constant.TITULO_ERROR, 2);
        return  false;
    }
    public String presentacionFecha(Date fecha){
        SimpleDateFormat Fecha=new SimpleDateFormat("dd MMMM yyyy");
        return Fecha.format(fecha);
    }
    public void Msj(String msj, String titulo, int jk) {
        JOptionPane.showMessageDialog(null, msj, titulo, jk);
    }
    public void MsjAlert(String msj) {
        JOptionPane.showMessageDialog(null, msj);
    }
    public int[] ItemCombo(JComboBox cmb,String tabla,String texto,JTextField casilla, String uno) {
        int indice=0;
        int[]ids=new int[Count(tabla)];        
        cmb.removeAllItems();
        List <Tipogasto> lb = Inicio.hmysql.consultaObjetos("from Tipogasto");
        for(Tipogasto tipogasto: lb){
            cmb.addItem(tipogasto);
            ids[indice]=tipogasto.getId();
            indice++;
        }
         
        return ids;
    }
    private int Count(String tabla) {
        
        ResultSet ss= (ResultSet)mysql.consultaResulSetSQL("select count(id) as total from "+tabla+" where status=1");
        try {
            ss.next();
            return ss.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int obtIndex(int[] iDs, int valor) {
        for (int i = 0; i < iDs.length; i++) {
            if (valor == iDs[i]) {
                return i;
            }
        }
        return 0;
    }
    
    public void validarCasilla(KeyEvent evt, String texto, String match) {
        texto = texto + String.valueOf(evt.getKeyChar());
        if (!texto.matches(match)) {
            evt.consume();
        }
    }

    public int ItemSeleccioanado(JComboBox Buscar, String item) {
        //dEVUELVE LA POSICION DEL ITEM SELECCIONADO
        for (int i = 0; i < Buscar.getItemCount(); i++) {
            if (Buscar.getItemAt(i).equals(item)) {
                return i;
            }
        }
        return 0;
    }

    public void limCaracter(KeyEvent evt, JTextField casillla, String match, int num) {
        String texto = casillla.getText() + String.valueOf(evt.getKeyChar());
        if (!texto.matches("" + match + "{1," + num + "}$")) {
            evt.consume();
        }
    }
    public void limCaracter(KeyEvent evt, JTextArea casillla, String match, int num) {
        String texto = casillla.getText() + String.valueOf(evt.getKeyChar());
        if (!texto.matches("" + match + "{1," + num + "}$")) {
            evt.consume();
        }
    }
    public void limCaracter(KeyEvent evt, JTextField casillla, int num) {
        String texto = casillla.getText() + String.valueOf(evt.getKeyChar());
        if (!texto.matches("{1," + num + "}")) {
            evt.consume();
        }
    }

    public boolean ItemNoSelecionado(JComboBox B) {
        //VERIFICCA QUE SI NO HA SELECCIONADO NINGUNA OPCION
        if (B.getSelectedIndex() == 0) {
            return true;
        }
        return false;
    }
    public boolean limita(KeyEvent e, JTextField casilla, int limite) {
        if (casilla.getText().length() == limite) {
            e.consume();
            return true;
        }
        return false;
    }
    public boolean validaNumero(String dato, JTextField casilla){
        try {
            Integer.parseInt(dato);
        } catch (NumberFormatException e) {
            Msj("¡¡¡ Error en la validacion del termino de Busqueda !!!\nPorfavor Ingrese un dato numerico", "..:: --- Error --- ::..", 0);
            //e.printStackTrace();
            casilla.setText("");
            return false;
        }
        return true;
    }
    public boolean validaDouble(String texto){
        try {
            Double.parseDouble(texto);
        } catch (Exception e) {
            //e.printStackTrace();
            //Msj("¡ Porfavor ingrese un valor Valido !", Constant.TITULO_ERROR_VALID, 2);
            //casilla.requestFocus();
            return false;
        } 
        return true;
    }
    public String decimalFormat(Double Dato){
        if(Dato==null)
            Dato=0.0;
        DecimalFormat df = new DecimalFormat("0.00");
        //df.setMaximumFractionDigits(2);
        return df.format(Dato);
    }
    public String presentardecimalFormat(Double Dato){
        if(Dato==null)
            Dato=0.0;
        DecimalFormat df = new DecimalFormat("###,###,###,###,###,###,###,##0.00");
        //df.setMaximumFractionDigits(2);
        return df.format(Dato);
    }    
    public void dosDecimales(KeyEvent evt, JTextField casillla){
        String texto = casillla.getText() + String.valueOf(evt.getKeyChar());
        if(casillla.getText().indexOf(".")!=-1){
            String other=texto.substring(casillla.getText().indexOf(".")+1, texto.length());
            if (!other.matches("^[0-9]{0,2}$")) {
                evt.consume();
                return;            
            } 
        }
        if (!texto.matches("^\\d*\\.?\\d*$")) {
            evt.consume();
        }      
    }

    
}
