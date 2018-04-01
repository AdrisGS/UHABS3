/*
Clase ControlAltaTarjetón permite a al sistema llevar el control sobre los atributos y métodos necesarios
para administrar el Alta un Tarjetón. 
*/
//sentencia del paquete
package uhv1.Negocio;
//sentencia de importación
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import uhv1.Persistencia.DAOTarjeton;

//Declaracion de clase 
public class ControlAltaTarjeton {
    
    public ControlAltaTarjeton(){//constuctor default
    }
    
    //inicio de flujo de US
    public void inicia(Responsable hab){
        ControlVentanaAltaTarjeton cvat = new ControlVentanaAltaTarjeton();
        cvat.creaVentanaAltaTarjeton(hab);
    }
    
    //metodo que recibe los datos la ventana alta tarjeton
    public boolean recibeDatosFormulario(Responsable hab, String plac) throws SQLException{
        boolean exito;//boolenao para decidir si el responsable tiene asignados dos  tarjetones
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");//Instancia un formato para las fechas 
        java.sql.Date fechaActual; //calcula la fecha actual
        fechaActual = java.sql.Date.valueOf(LocalDate.now());
        Calendar cal = Calendar.getInstance();//intsancia para sumar un mes a la fecha actual
        cal.add(Calendar.MONTH, 1);//suma un mes
        java.sql.Date fechaFin = new java.sql.Date(cal.getTimeInMillis());//cast tipo Date
        String fechaImpresion = fechaActual.toString();
        String fechaVencimiento = fechaFin.toString();
        String estado = "Activo";
        //Instancia tarjeton; 
        Tarjeton tarj = new Tarjeton(0, 0, plac,fechaImpresion ,fechaVencimiento ,estado );
        DAOTarjeton daot = new DAOTarjeton();
        //llamada a DAO para agregar tarjetón recibe false si se cuentan 2 o más tarjetones
        exito = daot.agregaTarjeton(hab, tarj);
        ControlVentanaAltaTarjeton cvat = new ControlVentanaAltaTarjeton();
        cvat.ventanaExito(exito); //Envía el booleano para decidir que mensaje mostrar.
        return (exito);
    }
    
    //En caso de falla de la base de datos ejecuta el siguiente método
    public void errorDAO(){
    ControlVentanaAltaTarjeton cvat = new ControlVentanaAltaTarjeton();
    cvat.ventanaError();
    }
   
}
