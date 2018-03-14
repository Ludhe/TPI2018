/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
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
 * @author zaldivar
 */
public class ProcesadorArchivoTest {
    
    public ProcesadorArchivoTest() {
    }
    
    @Rule
    public TemporaryFolder folder= new TemporaryFolder();
    
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
     * Test of hasRequiredExtensions method, of class ProcesadorArchivo.
     */
//    @Test
//    public void testHasRequiredExtensions() throws Exception {
//        System.out.println("hasRequiredExtensions");
//        String path = "";
//        ProcesadorArchivo instance = new ProcesadorArchivo();
//        List<Object> expResult = null;
//        List<Object> result = instance.hasRequiredExtensions(path);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of parser method, of class ProcesadorArchivo.
     * @throws java.lang.Exception
     */
    @Test
    public void testParser() throws Exception {
        System.out.println("parser");
        
        boolean saltarLinea = false;
        String separador = ",";
        ProcesadorArchivo instance = new ProcesadorArchivo();
        List<List<String>> expResult = null;
        List<Object> result = instance.parser(false,"/home/zaldivar/csv/testCsv.csv", saltarLinea, separador);
        
        assertEquals(4, result.size());
    }

    /**
     * Test of hasRequiredExtensions method, of class ProcesadorArchivo.
     * @throws java.lang.Exception
     */
    @Test
    public void testHasRequiredExtensions() throws Exception {
        System.out.println("hasRequiredExtensions");
        String path = "";
        ProcesadorArchivo instance = new ProcesadorArchivo();
        List<Object> expResult = null;
        List<Object> result = instance.hasRequiredExtensions(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
