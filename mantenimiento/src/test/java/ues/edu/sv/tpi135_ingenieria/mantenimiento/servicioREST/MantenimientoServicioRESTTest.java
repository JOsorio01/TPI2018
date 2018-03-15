package ues.edu.sv.tpi135_ingenieria.mantenimiento.servicioREST;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Application;
import org.codehaus.jettison.json.JSONException;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author esperanza
 */
public class MantenimientoServicioRESTTest{
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
    @Test
    public void setMantenimientosTest(){
        try {
            System.out.println("Prueba post mantenimientos");
            List<List<String>> mtn = new ArrayList<>();
            mtn.get(0).add("1");
            mtn.get(0).add("Toshiba");
            
            MantenimientoServicioREST instance = new MantenimientoServicioREST();
            URI expResult = null;
            URI result = instance.crearMantenimiento(mtn);
            assertEquals(expResult, result);
        } catch (JSONException ex) {
            Logger.getLogger(MantenimientoServicioRESTTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    * */
    }
