package Reportes;

import Vista.Inicio;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Salatiel
 */
public class ControladorReporte {

    public ControladorReporte(int id,int tipo) {
        verReporte(id,tipo);
    }

    /*private void Reporte() {
        //GEN-FIRST:event_btnReporteMouseClicked
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea Generar el Reporte de Entradadas y Gastos?", "Confirmar", 2);
        if (confirmacion == 0) {
            Map<String,Object> p = new HashMap();
            JasperReport report;
            JasperPrint print;
            try {
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath() + "/src/Reportes/ReporteFinal.jrxml");
                print = JasperFillManager.fillReport(report, p, m.getConexion());
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Reporte Entradas y Gastos");
                view.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }*/

    private void verReporte(int idCaja, int tipo) {
        JasperReport report;
        JasperPrint re;
        String archivo = "C:\\Sistema Machines\\Resources\\FinalReport\\ReportePrincipal.jasper";
        if(tipo == 5)
            archivo = "C:\\Sistema Machines\\Resources\\FinalReport\\Monto 5M.jasper";
        try {
            report = (JasperReport) JRLoader.loadObjectFromFile(archivo);
            Map<String,Object> parametros = new HashMap();
            parametros.put("cajaId", idCaja);
            re = JasperFillManager.fillReport(report, parametros); //Muestra en una ventana externa el reporte, sin necesidad de programar
            JasperViewer view = new JasperViewer(re,false);
            view.setTitle("Reporte de caja "+idCaja);
            view.setVisible(true);
            
        } catch (Exception e) {
            //System.out.println("Error al consultar el reporte");
            e.printStackTrace();
        }
    }
}
