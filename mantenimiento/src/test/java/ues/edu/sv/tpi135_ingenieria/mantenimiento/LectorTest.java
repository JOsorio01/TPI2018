package ues.edu.sv.tpi135_ingenieria.mantenimiento;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author airmind
 */
public class LectorTest {
  
  public LectorTest() {
    try {
      this.lector = new Lector(tempFolder.newFile("tempFile.csv").getPath(), ",", false);
    } catch (IOException ex) {
      Logger.getLogger(LectorTest.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
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
  
  @Rule
  TemporaryFolder tempFolder = new TemporaryFolder();
  
  Lector lector;
  
  /**
   * Test of validarPath method, of class Lector.
   */
  @Test
  public void testValidarPath() {
    System.out.println("validarPath");
    String path = lector.getPath();
    boolean expResult = true;
    boolean result = lector.validarPath(path);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    // fail("The test case is a prototype.");
  }

  /**
   * Test of validarPathDirectorio method, of class Lector.
   */
  @Test
  public void testValidarPathDirectorio() {
    System.out.println("validarPathDirectorio");
    String path = lector.getPath();
    boolean expResult = true;
    boolean result = lector.validarPathDirectorio(path);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    // fail("The test case is a prototype.");
  }

  /**
   * Test of obtenerArchivos method, of class Lector.
   */
  @Test
  public void testObtenerArchivos() {
    System.out.println("obtenerArchivos");
    String path = lector.getPath();
    ArrayList<String> expResults = new ArrayList<>();
    expResults.add("/home/airmind/text2.csv");
    expResults.add("/home/airmind/text.csv");
    ArrayList<String> expResult = expResults;
    ArrayList<String> result = lector.obtenerArchivos(path);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of leerArchivo method, of class Lector.
   */
  @Test
  public void testLeerArchivo() {
    System.out.println("leerArchivo");
    List<String> listaArchivos = lector.obtenerArchivos(lector.getPath());
    List<List<String>> expResults = new ArrayList<>();
    expResults.add(lector.separador("shit, the world is already gone", ","));
    expResults.add(lector.separador("hola, mundo", ","));
    List<List<String>> expResult = expResults;
    List<List<String>> result = lector.leerArchivo(listaArchivos, ",", false);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of separador method, of class Lector.
   */
  @Test
  public void testSeparador() {
    System.out.println("separador");
    String linea = "hola, mundo";
    ArrayList<String> expResults = new ArrayList<>();
    expResults.add("hola");
    expResults.add(" mundo");
    ArrayList<String> expResult = expResults;
    List<String> result = lector.separador(linea, ",");
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }
  
}
