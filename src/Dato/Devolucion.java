package Dato;
// Generated 18 ene. 2020 17:10:14 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Devolucion generated by hbm2java
 */
public class Devolucion  implements java.io.Serializable {


     private Integer id;
     private Caja caja;
     private Date fecha;
     private int tipo;
     private int cantidad;
     private boolean status;

    public Devolucion() {
    }

    public Devolucion(Caja caja, Date fecha, int tipo, int cantidad, boolean status) {
       this.caja = caja;
       this.fecha = fecha;
       this.tipo = tipo;
       this.cantidad = cantidad;
       this.status = status;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Caja getCaja() {
        return this.caja;
    }
    
    public void setCaja(Caja caja) {
        this.caja = caja;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int isTipo() {
        return this.tipo;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public boolean isStatus() {
        return this.status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }




}


