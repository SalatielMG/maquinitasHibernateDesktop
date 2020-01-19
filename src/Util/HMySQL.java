package Util;

import java.util.List;
import org.hibernate.Criteria;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import Util.HibernateUtil;
import Vista.Inicio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.jdbc.Work;

public class HMySQL {

    public Connection cnt = null;
    public static final int AGREGAR = 1;
    public static final int ELIMINAR = 3;
    public static final int ACTUALIZAR = 2;
    public static final int CONSULTAR = 4;
    public static final int AGREGAR_ACTUALIZAR = 5;
    private static SessionFactory sf;
    private Session sesion;
    
    public HMySQL() {
        this.crearConexion();
    }
    
    public void crearConexion() {
        this.sf = HibernateUtil.getSessionFactory();
        this.sesion = sf.openSession();
    }

    public boolean ejecutaTransaccion(Object o, Class c, int accion) {        
        boolean bnd = false;
        Transaction tx = null; //Se pueden utilizas los beggin, comit, rollback
        try {
            //Session sesion = sf.openSession();
            tx = sesion.beginTransaction();
            switch (accion) {
                case AGREGAR:
                    sesion.save(c.cast(o));
                    sesion.flush();
                    break;
                case ELIMINAR:
                    sesion.delete(c.cast(o));
                    break;
                case ACTUALIZAR:
                    sesion.update(c.cast(o));
                    break;
                case AGREGAR_ACTUALIZAR:
                    sesion.saveOrUpdate(c.cast(o));
                    break;
            }
            tx.commit();
            sesion.flush();
            sesion.clear();
            bnd = true;
        } catch (Exception ex) {
            tx.rollback();
            System.out.println("Ocurrio un error en la transaccion");
            ex.printStackTrace();
        }
        return bnd;
    }

   

    public Object consultaObjeto(Class clase, int campoId) {
        //Session sesion = sf.openSession();
        Object objetoBD = sesion.get(clase, campoId);
        //sesion.close();
        return objetoBD;
    }

    public Object consultaObjeto(Class clase, String campoId) {
        //Session sesion = sf.openSession();
        Object objetoBD = sesion.get(clase, campoId);
        //sesion.close();
        return objetoBD;
    }

    public Object consultaObjeto(String hql) {
        //Devuelve un solo objeto
        //Session sesion = sf.openSession();
        Query qry = sesion.createQuery(hql); //El hql de hibernate
        List objetosBd = qry.list();
        //sesion.close();
        return (objetosBd.isEmpty() ? null : objetosBd.get(0));
    }

    public List consultaObjetos(String hql) {
        List lista = null;
        //Session sesion = null;
        try {
            //sesion = sf.openSession();
            Query qry = sesion.createQuery(hql);
            lista = qry.list();
            //sesion.close();
        } catch (HibernateException e) {
            System.out.println("Ocurrio un error en: " + hql);
        }
        return lista;
    }

    public Object consultaSQLObjeto(String sql) {
        //Devuelve un solo objeto
        //Session sesion = sf.openSession();
        Query qry = sesion.createSQLQuery(sql); //El hql de hibernate
        List objetosBd = qry.list();
        //sesion.close();
        System.out.println("objetosBd.get(0) " + objetosBd.get(0));
        return (objetosBd.isEmpty() ? null : objetosBd.get(0));
    }

    public List consultaSQLObjetos(String sql) {
        List lista = null;
        //Session sesion = null;
        try {
            //sesion = sf.openSession();
            Query qry = sesion.createSQLQuery(sql);
            lista = qry.list();
            //sesion.close();
        } catch (HibernateException e) {
            System.out.println("Ocurrio un error en: " + sql);
        }
        return lista;
    }

    public int maxElemento(Class c, String campo) {
        //Session sesion;
        //sesion = sf.openSession();
        Criteria criteria = sesion.createCriteria(c)
                .setProjection(Projections.max(campo));
        int max = (Integer) criteria.uniqueResult();
        //sesion.close();
        return max;
        //Recordar abrir y cerrar las sesiones o hilos.
    }

    public Connection getConexion() {//Cuandose hagan reportes.       
        cnt = sesion.doReturningWork((cnctn) -> {
            return cnctn; //To change body of generated lambdas, choose Tools | Templates.
        });
        try {
            if (cnt.isClosed()){
                this.crearConexion();
                this.getConexion();
                System.out.println("Reestableciendo la conexiona a la base de datos.");
            }
        } catch (SQLException ex) {
            this.crearConexion();
            this.getConexion();
            System.out.println("Reestableciendo la conexiona a la base de datos.");
            //Logger.getLogger(HMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnt;
    }

    public ResultSet consultaResulSetSQL(String consulta) {/*"sELECT * from alumno;"*/
        ResultSet cursor = null;
        try {
            Statement consultaQRY = this.getConexion().createStatement();
            
            cursor = consultaQRY.executeQuery(consulta);//Relaiza una consulta y deuelve los datos de la base de datos.
            //consultaQRY.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursor;
    }

}
