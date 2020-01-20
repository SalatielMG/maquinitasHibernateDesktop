package Control;

import Dato.Caja;
import Vista.Inicio;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author hills
 */
public class ControlDevolucion {
    
    private ControlCaja CtrlCaja = new ControlCaja();
    
    public void rellenaCombo(JComboBox cmb, JTextField casilla) {
        Caja caja = CtrlCaja.getCaja();
        cmb.removeAllItems();
        cmb.removeAll();
        cmb.addItem("Monto de $1.00");
        cmb.addItem("Monto de $5.00");
        cmb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getItem().toString().equals("Monto de $1.00")) {
                    //Monto.setText("Monto inicial $1.°° :");
                    casilla.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getMonto1())));
                } else {
                    //Monto.setText("Monto inicial $5.°° :");
                    casilla.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getMonto5())));
                }
            }
        });
        casilla.setText("$" + Inicio.v.presentardecimalFormat(Double.parseDouble("" + caja.getMonto1())));
                
    }

}
