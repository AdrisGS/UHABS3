/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;


import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import uhv1.ControlPrincipal;
import uhv1.Persistencia.DAOEvento;
import uhv1.Persistencia.DAOPagos;
import uhv1.Vistas.VentanaAbonaEvento;

/**
 *
 * @author adrianags
 */
public class ControlAbonaEvento {
    Evento even;
    DAOEvento dahoeven;
    pagos pago;
    
    //Constructor que recibe como parametros objeto Evento y DAOEvento
    public ControlAbonaEvento(DAOEvento dahoeven, Evento even) {
        this.dahoeven = dahoeven;
        this.even = even;
    }
    
    //Metodo que crea una instancia de VentanaAbonaEvento y apertura la aventana al usuario
    public void inicia(){
        VentanaAbonaEvento ventaAbona = new VentanaAbonaEvento(this);
        ventaAbona.setVisible(true);
    }
    
    public void aceptaAbonar(){
        ControlImprimeAbonoE CIA = new ControlImprimeAbonoE();
        
        CIA.imprimeAbono();
    }
    //Metodo que actualiza la vaiable saldo desde Entidad Evento y envia a DAO el objeto Evento para actaulizar en base de datos
    public boolean registraSaldo(double saldo){
        boolean status;
        even.setSaldo((float) saldo);                      //actualizando atributo saldo de objeto Evento mediante setSaldo, se realiza cast de double a float 
        status = dahoeven.actualizaAbonoEvento(even);      //Se envia el objeto Evento al DAOEvento por medio de su metodo actualizaAbonoEvento y recibe como respuesta un boolean        
        return status;
    }
    
    //Metodo que genera objeto pagos y lo envia a clase DAOPagos para crear el registro en la Base de datos 
    public boolean registraPago() {
        DAOPagos daoPagos = new DAOPagos();
        
        boolean estado;   
        
        String fecha = convertStringToDate(even.getFechaReservacion()); //Manda la viarble fecha de reservacion a metodo que convierte tipo de dato Date a String
        //System.out.println("en controlAbonaEvento convirtiendo date a string " + fecha);
        pago = new pagos(0, fecha, even.getSaldo(), even.getHabitante().getId(), even.getEstado()); //creando objeto pago
        
        
        estado = daoPagos.creaPagoEvento(pago); //eenviando objeto pago a DAOPago para su registro en base de datos
        return estado;
    }
    //Metodo  que muestra la ventana principal del sistema
    public void botonCancelar(){
        ControlPrincipal ctrlPrincipal = new ControlPrincipal();
        ctrlPrincipal.inicia();
    }
    
    //Metodo que convierte variable de tipo Date a String
    public String convertStringToDate(Date indate){
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            dateString = sdfr.format( indate );
        }catch (Exception ex ){
            System.out.println(ex);
        }
        return dateString;
    }
}
