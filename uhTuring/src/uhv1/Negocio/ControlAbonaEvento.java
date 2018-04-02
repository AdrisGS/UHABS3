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
    //VentanaAbonaEvento ventanaAbona;
    float sald;
    
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
        ControlVentanaImprimeComprobante CIA = new ControlVentanaImprimeComprobante(evento, pago);        
        CIA.iniciar();
    }
    
    //Metodo que actualiza la vaiable saldo desde Entidad Evento y envia a DAO el objeto Evento para actaulizar en base de datos
    public boolean registraSaldo(String saldo){
        
        VentanaAbonaEvento ventanaAbona = new VentanaAbonaEvento();   //Se crea instancia de VentanaAbonaEvento para mandar a llamar metodos de notificacion a usuario
        float sald;
        boolean capturado;
        boolean status = validaCadena(saldo);        //Este metodo valida si la cadena saldo es vacia o contiene letras devolviendo false, pero si contiene unicamente numeros devuelve true
            
            if(status){      //Si la cadena saldo contiene unicamente numeros                                     
                sald = Float.parseFloat(saldo);      //se convierte la variable saldo en tipo Float y se guarda en variable sald
                even.setSaldo(sald);                 //actualizando variable saldo de objeto Evento mediante setSaldo pasando como parametro la variable sald
                ventanaAbona.mensajeSaldoExitoso();               // Si saldo se actualizo correctamente emite mensaje de exito al usuario
                                                                         
                capturado = dahoeven.actualizaAbonoEvento(even);    //Se envia el objeto Evento al DAOEvento por medio de su metodo actualizaAbonoEvento y recibe como respuesta un boolean
                registraPago();                                    // Manda a llamar metodo  registraPago para crear objeto pago
            
            }else{                                                 // Si la cadena saldo es vacia o contiene letras emite un mensaje de error al usuario
                ventanaAbona.mensajeCampoVacio();
                capturado = false;
            }
                     
        return capturado;
        
    }
    //Metodo que identifica si la cadena saldo contiene unicamente numeros y lo convierte a float 
    public boolean validaCadena(String saldo){
        float num;                              
        try{
            num = Float.parseFloat(saldo);       //cast de  cadena de tipo String a float, ya que el campo saldo el sistema lo contempla como String
            return true;
        }catch(Exception e){                    //Si la cadena saldo esta vacia o contiene letras, devuelve false
            return false;
        }
    }
    
    //Metodo que genera objeto pagos y lo envia a clase DAOPagos para crear el registro en la Base de datos 
    public boolean registraPago() {
        DAOPagos daoPagos = new DAOPagos();        
        boolean estado;          
        pago = new pagos (0, even.getFechaReservacion(), even.getSaldo(), even.getHabitante().getId(), even.getEstado(), even.getSaldo());//creando objeto pago
        estado = daoPagos.creaPagoEvento(pago); //eenviando objeto pago a DAOPago para su registro en base de datos
        return estado;
    }
    
    //Metodo  que muestra la ventana principal del sistema
    public void botonCancelar(){
        ControlPrincipal ctrlPrincipal = new ControlPrincipal();
        ctrlPrincipal.inicia();
    }
    
}
