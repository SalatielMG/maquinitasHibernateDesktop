package Util;

/**
 *
 * @author Salatiel
 */

public class Constant {

    public static final byte ALTAS = 1;
    public static final byte CAMBIOS = 2;
    public static final byte BAJAS = 3;
    public static final byte CONSULTAS = 4;

    public static final int[] anchoColumnasCajas = {80, 180, 205, 205, 150};//820 px
    public static final int[] anchoColumnasVistaDevoluciones = {80, 210, 265, 265};//820 px
    public static final int[] anchoColumnasVistaGastos = {80, 150, 160, 280, 150};//820 px
    public static final int[] anchoColumnasVistaEmpleados = {80, 150, 160, 280, 150};//820 px
    public static final int[] anchoColumnasVistaLocales = {80, 170, 270, 300, 150};//820 px130
    public static final int[] anchoColumnasVistaEntradas = {80, 150, 160, 280, 150};//820 px
    
    
    public static final String[] headerTableCajas = {"Id", "Fecha recibido", "Monto inicial $1.°°", "Monto inicial $5.°°", "Fecha corte"};
    public static final String[] headerTableVistaDevoluciones = {"Id", "Fecha de entrega", "Tipo devolucion", "Cantidad devuelto"};
    public static final String[] headerTableVistaGastos = {"Id", "Fecha", "Tipo de gasto", "Descripción", "Gasto"};
    public static final String[] headerTableVistaEmpleados = {"Id", "Nombre", "Apellidos", "Domicilio", "Telefono"};
    public static final String[] headerTableVistaLocales = {"Id", "Nombre", "Domicilio", "Descripcion"};
    public static final String[] headerTableVistaEntradas = {"Id", "Local", "Fecha", "Monto $1.00", "Monto $5.00"};
    
    public static final String[] columnTableCajas = {"id", "fechaAbierto", "monto1", "monto5", "fechaCorte"};
    public static final String[] columnTableVistaDevoluciones = {"id", "fecha", "tipo", "cantidad"};
    public static final String[] columnTableVistaGastos = {"id", "fecha", "nombre", "descripcion", "gasto"};
    public static final String[] columnTableVistaEmpleados = {"id", "nombre", "apellidos", "domicilio", "telefono"};
    public static final String[] columnTableVistaLocales = {"id", "nombre", "domicilio", "descripcion"};
    public static final String[] columnTableVistaEntradas = {"id", "local", "fecha", "monto1", "monto5"};
    
    public static final String BD = "¡¡¡ No se ha iniciado el Servicio de la Base de Datos !!!\nPorfavor cierre el programa, ejecuta el servicio de la Base de datos\ny luego vuelva a iniciar el programa";
    public static final String SELECCIONA = "¡ Selecciona un registro porfavor !";
    public static final String SATISFACTORIO = "¡ Transacción ejecutada exitosamente !";
    public static final String INSATISFACTORIO = "¡ No se pudo ejecutar la operación solicitada !";
    public static final String TITULO_ERROR = "..:: Error ::..";
    public static final String TITULO_EXITO = "..:: Felecitaciones ::..";
    public static final String TITULO_ERROR_VALID = "--- Error de validación ---";

}
