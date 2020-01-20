package Control;

import Dato.Caja;
import Dato.CajaOC;
import Vista.Inicio;
import java.sql.ResultSet;
/**
 *
 * @author hills
 */
public class ControlCaja {
    
    public Caja getCaja() {
        CajaOC caja = this.getCajaOpen();
        Caja c = new Caja(caja.getMonto1(), caja.getMonto5(), caja.getFechaAbierto(), caja.isCorte(), caja.isStatus());
        c.setId(caja.getId());
        return c;
    }
    
    public CajaOC getCajaOpen() {
       CajaOC caja = new CajaOC();
       String cadena = "select * from vistacajaopen;";
       ResultSet rs = Inicio.hmysql.consultaResulSetSQL(cadena);
       try {
           rs.next();
           caja.setId(rs.getInt("id"));          
           caja.setMonto1(rs.getInt("monto1"));
           caja.setMonto5(rs.getInt("monto5"));
           caja.setFechaAbierto(Inicio.v.getDatoFecha(rs.getString("fechaAbierto")));
           caja.setCorte(rs.getInt("corte") == 1);
           caja.setFechaCorte(Inicio.v.getDatoFecha(rs.getString("fechaCorte")));
           caja.setNota(rs.getString("nota"));
           caja.setTotaldevolucion1(rs.getInt("totaldevolucion1"));
           caja.setTotaldevolucion5(rs.getInt("totaldevolucion5"));
           caja.setTotalgastos(rs.getDouble("totalgastos"));
       } catch (Exception e) {
           e.printStackTrace();
       }
       return caja;
    }
    
    public CajaOC getCaja(int id){
       CajaOC caja = new CajaOC();
       String cadena = "select * from vistacajaclose where id = "+id;
       ResultSet rs = Inicio.hmysql.consultaResulSetSQL(cadena);
       try {
           rs.next();
           caja.setId(rs.getInt("id"));          
           caja.setMonto1(rs.getInt("monto1"));
           caja.setMonto5(rs.getInt("monto5"));
           caja.setFechaAbierto(Inicio.v.getDatoFecha(rs.getString("fechaAbierto")));
           caja.setCorte(rs.getInt("corte") == 1);
           caja.setFechaCorte(Inicio.v.getDatoFecha(rs.getString("fechaCorte")));
           caja.setNota(rs.getString("nota"));
           caja.setTotaldevolucion1(rs.getInt("totaldevolucion1"));
           caja.setTotaldevolucion5(rs.getInt("totaldevolucion5"));
           caja.setTotalgastos(rs.getDouble("totalgastos"));
       } catch (Exception e) {
           e.printStackTrace();
       }
       return caja;
    }
    
    public Double getTotalGastos(){
       Double gasto=0.0;
       String cadena="select sum(gasto) as total from vistagastos;";
       ResultSet rs = Inicio.hmysql.consultaResulSetSQL(cadena);
       try {
           while(rs.next()){
               gasto = rs.getDouble("total");
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return gasto;
   }
   public int getTotalDevoluciones5(){
       int dev = 0;
       String cadena="select sum(cantidad) as total from vistadevoluciones5;";
       ResultSet rs = Inicio.hmysql.consultaResulSetSQL(cadena);
       try {
           while(rs.next()){
               dev = rs.getInt("total");
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return dev;
   }
   public int getTotalDevoluciones1(){
       int dev=0;
       String cadena="select sum(cantidad) as total from vistadevoluciones1;";
       ResultSet rs = Inicio.hmysql.consultaResulSetSQL(cadena);
       try {
           while(rs.next()){
               dev = rs.getInt("total");
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return dev;
   }
}
