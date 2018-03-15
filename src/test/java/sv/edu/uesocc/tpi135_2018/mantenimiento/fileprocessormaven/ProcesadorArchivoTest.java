/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
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
     * @throws java.lang.Exception
     */
    @Test
    public void testHasRequiredExtensions() throws Exception {
        System.out.println("hasRequiredExtensions");
        String path = "";
        File carpeta = folder.newFolder("carpeta");
        File archivo1=File.createTempFile("Archivo1", ".csv", carpeta);
        File archivo2 = File.createTempFile("Archivo2", ".csv", carpeta);
        System.out.println("Path absoluto\t"+archivo1.getAbsolutePath());
        ProcesadorArchivo instance = new ProcesadorArchivo();
        List<Object> expResult = null;
        List<Object> result = instance.hasRequiredExtensions(carpeta.getAbsolutePath());
        assertEquals(2, result.size());
    }

    /**
     * Test of validarPath method, of class ProcesadorArchivo.
     * @throws java.io.IOException
     */
    @Test
    public void testValidarPath() throws IOException {
        System.out.println("validarPath");
        File file=folder.newFolder("testFolder");
        ProcesadorArchivo instance = new ProcesadorArchivo();
        boolean expResult = true;
        boolean result = instance.validarPath(file.getAbsolutePath());
        assertEquals(expResult, result);
    }

    /**
     * Test of parser method, of class ProcesadorArchivo.
     */
    @Test
    public void testParser() throws Exception {
        System.out.println("parser");
        boolean historico = true;
        File tempFile=folder.newFile("tmp.csv");
        Files.write("1,NumInventario,20/03/2018,mantenimiento,observacionesSoftware,observacionesHardware", tempFile.getAbsoluteFile(), Charset.forName("UTF-8"));
        String separador = ",";
        System.out.println("Existe........................."+tempFile.exists());
        ProcesadorArchivo instance = new ProcesadorArchivo();
//        List<List<Object>> expResult = ;
        List<List<Object>> result = instance.parser(historico,"src/test/resources/historico.csv", separador);
        assertEquals("12040.3334.080.0017",result.get(0).get(0));
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}

