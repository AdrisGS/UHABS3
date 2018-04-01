/*
Esta es la clase de prueba para el Control de Alta tarjeton
Todas la pruebas se realizarán para el Habitante con identificador 100
En la primera prueba se agrega un nuevo tarjeton a un habitante que no tiene ninguno tarjeton previamente asignado 
y retorna true.

En la segunda prueba se agrega un nuevo tarjeton al mismo habitante que ya tiene un tarjeton asignado y retorna true.

En la tercera prueba se intenta asignar un tercer tarjeton al mismo habitante pero como ya cuenta con dos previos 
el sistema retorna false.
*/

package uhv1.Negocio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author evil5
 */
public class ControlAltaTarjetonTest {
    
    public ControlAltaTarjetonTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    /**
     * Test of recibeDatosFormulario method, of class ControlAltaTarjeton.
     * Esta prueba instancia un Responsable con identificador 100 y Agrega un Tarjeton a la base de datos
     */
    @Test
    public void testRecibeDatosFormulario1() throws Exception {
        System.out.println("Inicia prueba recibeDatosFormulario");
        Casa cas = new Casa(100, "D", 13);
        Responsable res = new Responsable(100, "nombrePrueba", "aPatPrueba", "aMatPrueba" ,1234567, cas, 0);
        String plac = "123FFF";
        ControlAltaTarjeton instance = new ControlAltaTarjeton();
        
        boolean expResult = true;
        boolean result = instance.recibeDatosFormulario(res, plac);
        assertEquals(expResult, result);
        if(expResult!=result){
            fail("Falla de prueba No se agregó el tarjeton");    
        }
    }
    
    @Test
    public void testRecibeDatosFormulario2() throws Exception {    
        System.out.println("Inicia prueba recibeDatosFormulario");
        Casa cas = new Casa(100, "D", 13);
        Responsable res = new Responsable(100, "nombrePrueba", "aPatPrueba", "aMatPrueba" ,1234567, cas, 0);
        String plac = "123FFF";
        ControlAltaTarjeton instance = new ControlAltaTarjeton();
        
        boolean expResult = true;
        boolean result = instance.recibeDatosFormulario(res, plac);
        assertEquals(expResult, result);
        if(expResult!=result){
            fail("Falla de prueba No se agregó el tarjeton");    
        }
    }
    
    @Test
    public void testRecibeDatosFormulario3() throws Exception {    
        System.out.println("Inicia prueba recibeDatosFormulario");
        Casa cas = new Casa(100, "D", 13);
        Responsable res = new Responsable(100, "nombrePrueba", "aPatPrueba", "aMatPrueba" ,1234567, cas, 0);
        String plac = "123FFF";
        ControlAltaTarjeton instance = new ControlAltaTarjeton();
        
        boolean expResult = false;
        boolean result = instance.recibeDatosFormulario(res, plac);
        assertEquals(expResult, result);
        if(expResult!=result){
            fail("Falla de prueba");    
        }
        
    }
    
    
}
