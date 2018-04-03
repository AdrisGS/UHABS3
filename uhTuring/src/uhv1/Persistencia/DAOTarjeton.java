/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uhv1.Negocio.Tarjeton;

/**
 *
 * @author adriana gs
 */
public class DAOTarjeton {
       
    /*
    En este metodo regresa la lista de los tarjetones que tiene un habitante 
    buscando solamente los que están activos y que coinciden con el id de un habitante,
    
    Este metodo recibe un mensaje de control baja dicho metodo ejecuta un query para eliminar
    al habitante de la base de datos
    */
    public Tarjeton[] buscaTarjeton(int id){
       
        System.out.println("Esta en busca DAOTarjeton ");
        
        Statement statement;
        ArrayList<Tarjeton> tarjeton = new ArrayList<Tarjeton>();
        
        try{
            statement = ManejadorBD.dameConnection().createStatement();
            /*
            nombre='" + res.getNombre() + "'AND aPat='" + res.getaPat() + "';"
            */
            ResultSet rs = statement.executeQuery("SELECT * FROM Tarjeton WHERE Habitantes_idHabitante= '"+id +"'AND estado='"+"Activo"+"';");
            while(rs.next()){
                Tarjeton tarje = new Tarjeton(rs.getInt("Habitantes_idHabitante"),rs.getInt("num_estacionamiento"),rs.getString("placas"),rs.getString("fecha_impresion"),rs.getString("fecha_vencimiento"),rs.getString("estado"));
                tarjeton.add(tarje);
            }
 
            Tarjeton tarjetones []= new Tarjeton[tarjeton.size()];
            tarjeton.toArray(tarjetones);
            
            return tarjetones;
        }catch(SQLException e){
            System.out.println("Hubo un error al buscar tarjetones");
            e.printStackTrace();
            return null;
        }
    }
    
    /*
     En este metodo se le manda  el tarjeton de dicho habitante
     para que su estado del tarjeton cambie a cancelado
    */
    public Boolean actulizarEstado(Tarjeton tarje) {
        
     try {
            Statement statement = ManejadorBD.dameConnection().createStatement();

            statement.execute("UPDATE tarjeton SET estado='" + tarje.getEstado()
                    + "'  where num_estacionamiento = '" + tarje.getNum_estacionamiento()+ "';"
            );
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return false;
        }
    
    }
    
    /*
    Este metodo busca el tarjeton buscado por numero de estacionamiento y que coincida el id de dicho habitante
    y regresa el tarjeron que se requiere o null en caso de no existir
    */
    public Tarjeton buscarTarjetonNum (int numEstacionamiento, int idHabitante){
        try {
            
            Statement statement = ManejadorBD.dameConnection().createStatement();
            
          
            ResultSet rs=statement.executeQuery("SELECT * FROM tarjeton WHERE num_estacionamiento= '"+numEstacionamiento+"' AND Habitantes_idHabitante='"+idHabitante+"' AND estado='"+"Activo"+"';");
            
            rs.next();
            Tarjeton tarjeton = new Tarjeton(rs.getInt("Habitantes_idHabitante"),rs.getInt("num_estacionamiento"),rs.getString("placas"),rs.getString("fecha_impresion"),rs.getString("fecha_vencimiento"),rs.getString("estado"));
           
            rs.close();
            return tarjeton;
            
        }catch (SQLException e){
            System.out.println("Hubo un error al buscar tarjeton");
            e.printStackTrace();
            return null;
        }
        
    }
}
