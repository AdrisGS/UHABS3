/*
La clase ControlVentanaAltaTarjeton permite la instancia de la ventanaTarjetón que despliega
una los datos de la instancia Responsable y de su instancia de Casa.
*/
package uhv1.Negocio;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uhv1.ControlPrincipal;
import uhv1.Vistas.VentanaAltaTarjeton;


public class ControlVentanaAltaTarjeton {

    public ControlVentanaAltaTarjeton() {//constructo vacio default
    }
    
    //método creaVentanaAltaTargetón crea una instancia de VentanaAltaTarjeton para desplegar los datos y
    //campos necesarios para el alta tarjeton
    public void creaVentanaAltaTarjeton(Responsable hab){
        //Se evalua si el Responsable tiene retasos acumulados en su pago de cuotas de mantenimiento.
        if(hab.getSaldo()>80){
            //En caso de retraso se despliega una ventana con el aviso de retraso
            JOptionPane.showMessageDialog(null, "Aviso: Este habitante cuenta con retrasos de cuota de \nmantenimiento por lo que no es posible asignar nuevo tarjetón.", "Aviso:",JOptionPane.INFORMATION_MESSAGE);
            ControlPrincipal cp = new ControlPrincipal();
            cp.inicia();
        }else{
        //En caso que se encuentre que el Responsable está al corriente en sus pagos continua
        java.awt.EventQueue.invokeLater(() -> {
            try {
                //Se instancia la VentanaAltaTarjeton y se despliega
                new VentanaAltaTarjeton(hab).setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(ControlVentanaAltaTarjeton.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        }
    }
    //enviaDatosFormulario envía los datos capturados en el formulario y los envía a ControlAltaTarjeton
    public void enviaDatosFormulario(Responsable hab, String plac) throws SQLException{
        ControlAltaTarjeton cat = new ControlAltaTarjeton();
        //se envian los datos que recibe del formulario
        cat.recibeDatosFormulario(hab, plac);
    }
    
    //En caso que se halle un error en la asignación del DAO despliega este aviso
    public void ventanaError(){
    JOptionPane.showMessageDialog(null, "Aviso: No se realizó el registro del Tarjetón.", "Aviso:",JOptionPane.INFORMATION_MESSAGE);
    }
    
    //ventanaExito recibe de ControlAltaTarjetón true si se realizó agregó correctamente
    public void ventanaExito(boolean result){
        if(result==true){
            JOptionPane.showMessageDialog(null, "Aviso: Se realizó el registro correcto del Alta del Tarjetón al habitante", "Aviso:",JOptionPane.INFORMATION_MESSAGE);
        }else{
            //En caso de recibir false de ControlAltaTarjetón se despliegiega el aviso de que existen 2 o más tarjetones activos
            JOptionPane.showMessageDialog(null, "Aviso: El avitante ya cuenta con 2 Tarjetones activos\nNo se realizó el registro del Tarjetón.", "Aviso:",JOptionPane.INFORMATION_MESSAGE);           
        }
        ControlPrincipal cp = new ControlPrincipal();
        cp.inicia();
    } 
}
