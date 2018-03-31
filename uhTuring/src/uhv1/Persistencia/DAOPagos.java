/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Persistencia;

/**
 *
 * @author Jose Luis
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uhv1.Negocio.Evento;
import uhv1.Negocio.Responsable;
import uhv1.Negocio.pagos;
import uhv1.Persistencia.ManejadorBD;

public class DAOPagos {
    
    Responsable  hab;
    Evento even;
    pagos pago;
    
    public DAOPagos(){
    }
    
    public pagos[] Recupera(Responsable hab){        
        Statement statement;
        ArrayList<pagos> pagosTemp = new ArrayList<pagos>();
        try {
            statement = ManejadorBD.dameConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM pagos where Habitantes_idHabitante =" + hab.getId() + ";");
            while(rs.next()){ // mientras tenga datos que imprimir
                pagos pago = new pagos(rs.getInt("idPago"), rs.getString("fecha"), rs.getFloat("monto"),rs.getInt("Habitantes_idhabitante"),rs.getInt("concepto"));
                System.out.println(pago.getFecha());
                pagosTemp.add(pago);
            }
            pagos pagosTempArreglo[] = new pagos[pagosTemp.size()];
            pagosTemp.toArray(pagosTempArreglo);
            return pagosTempArreglo;
        }catch (SQLException e) {
             e.printStackTrace();
             return null;
        }        
    }
    
    //Metodo que registra los datos de objeto pago en la tabla Pagos de la base de datos
    public boolean creaPagoEvento(pagos pago) {

        int llave;
        try {
            // Crea el statement
            Statement statement = ManejadorBD.dameConnection().createStatement();
            statement.execute("INSERT into Pagos (fecha, monto, Habitantes_idHabitante, concepto, saldo_actual) values ('" + pago.getFecha() + "', " + pago.getMonto() + "," + pago.getId_habitante() + "," + pago.getConcepto() + "," + pago.getMonto() + ");", Statement.RETURN_GENERATED_KEYS); //insertando los datos de objeto pago en tabla Pagos

            ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave primaria de la tabla Pagos

            if (rs != null && rs.next()) {
                llave = rs.getInt(1);
                
                pago.setId(llave); // Asigna la llave primaria al pago
            }
            return true;
        } catch (SQLException e) {
            return false;
        }

    }
}
     

