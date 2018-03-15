/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135_ingenieria.mantenimiento;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * @author kevin
 */
public class LectorTest {

    @Rule
    public TemporaryFolder carpetaTemp = new TemporaryFolder();

    @Before
    public void crearArchivosTemp() throws IOException {
        String texto = "id_mantenimiento,historico,n_inventario,marca,n_serie,modelo"
                + ",responsable,sistema_operativo,version,observaciones\n"
                + "1,HP1,12040.3334.080.0017,Lenovo,MJVZLKF,ThinkCentre M82"
                + ",Lic Rina de Zometa,Windows,7.0 Professional SP 64 bits,office pirata \n"
                + "2,HP2,12040.3334.080.0008,Dell,551LHY,Vostron 220,Lic Rina de Zometa"
                + ",Windows,7.0 Professional SP 64 bits,Office Original";

        String texto2 = "id_mantenimiento,historico,n_inventario,marca,n_serie,modelo"
                + ",responsble,sistema_operativo,version,observaciones\n "
                + "1,HP2,12040.3334.080.0008,Dell,551LHY,Vostron 220,Lic Rina de Zometa"
                + ",Windows,7.0 Professional SP 64 bits,Office Original";

        File tempfile = carpetaTemp.newFile("prueba.csv");
        File tempfile2 = carpetaTemp.newFile("prueba2.csv");

        try (FileWriter fw = new FileWriter(tempfile.getAbsolutePath());
                PrintWriter pw = new PrintWriter(fw)) {
            pw.println(texto);
        }
        try (FileWriter fw = new FileWriter(tempfile2.getAbsolutePath());
                PrintWriter pw = new PrintWriter(fw)) {
            pw.println(texto2);
        }

    }

    public LectorTest() {
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

    /**
     * Test of verificarArchivo method, of class Lector.
     */
    @Test
    public void testVerificarArchivo() throws IOException {
        System.out.println("verificarArchivo");
        
        String path = carpetaTemp.getRoot().toString()+"/prueba.csv";
        Lector instance = new Lector();
        boolean expResult = true;
        boolean result = instance.verificarArchivo(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of verificarDirectorio method, of class Lector.
     */
    @Test
    public void testVerificarDirectorio() {
        System.out.println("verificarDirectorio");
        String path = carpetaTemp.getRoot().toString();
        Lector instance = new Lector();
        boolean expResult = true;
        boolean result = instance.verificarDirectorio(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerArchivos method, of class Lector.
     */
    @Test
    public void testObtenerArchivos() throws IOException {
        System.out.println("obtenerArchivos");

        String path = carpetaTemp.getRoot().getPath();
        Lector instance = new Lector();
        List<String> expResult = new ArrayList<>();
        expResult.add(path + "/prueba.csv");
        expResult.add(path + "/prueba2.csv");
        List<String> result = instance.obtenerArchivos(path);
        assertEquals(expResult, result);
    }

    /**
     * Test of parser method, of class Lector.
     */
    @Test
    public void testParser() throws Exception {
        System.out.println("Parser");

        String paths = carpetaTemp.getRoot().toString();
        boolean saltarLinea = true;
        String separador = ",";
        Lector instance = new Lector();
        List<List<String>> expResult = new ArrayList<>();
        List<String> parse = new ArrayList<>();
        List<String> parse2 = new ArrayList<>();
        List<String> parse3 = new ArrayList<>();

        String[] lista = {"1", "HP1", "12040.3334.080.0017", "Lenovo", "MJVZLKF",
            "ThinkCentre M82", "Lic Rina de Zometa", "Windows", "7.0 Professional SP 64 bits", "office pirata"};
        String[] lista2 = {"2", "HP2", "12040.3334.080.0008", "Dell", "551LHY",
            "Vostron 220", "Lic Rina de Zometa",
            "Windows", "7.0 Professional SP 64 bits", "Office Original"};
        String[] Lista3 = {"1", "HP2", "12040.3334.080.0008", "Dell", "551LHY",
            "Vostron 220", "Lic Rina de Zometa",
            "Windows", "7.0 Professional SP 64 bits", "Office Original"};

        parse.addAll(Arrays.asList(lista));
        parse2.addAll(Arrays.asList(lista2));
        parse3.addAll(Arrays.asList(Lista3));
        expResult.add(0, parse);
        expResult.add(1, parse2);
        expResult.add(2, parse3);
        List<String> path = instance.obtenerArchivos(paths);
        List<List<String>> result = instance.parser(path, saltarLinea, separador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
