/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sv.edu.uesocc.tpi135_2018.mantenimiento.definiciones.Bitacora;
import sv.edu.uesocc.tpi135_2018.mantenimiento.definiciones.Historico;
import sv.edu.uesocc.tpi135_2018.mantenimiento.restutils.EnvioRestTest;

/**
 *
 * @author doratt
 */
public class crearJSONTest {

    public crearJSONTest() {
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
     * Test of convertirAEntidades method, of class crearJSON.
     */
    @Test
    public void testConvertirAEntidades() throws Exception {
        System.out.println("convertirAEntidades");

        Historico hist = new Historico();
        List<List<List<Object>>> lista = new ArrayList<>();
        List<List<Object>> listB = new ArrayList<>();
        List<Object> listC = new ArrayList<>();
        List<Object> listaObj = new ArrayList<>();
        List<List<Object>> listaMayor= new ArrayList<>();
        
        listaObj.add(hist);
        listaMayor.add(listaObj);
        
        listC.add("000001");
        listC.add("1");
        listC.add("25/10/2017");
        listC.add("2");
        listC.add("observacionesHardware");
        listC.add("observacionesSoftware");
        
        listB.add(listC);
        lista.add(listB);
        
        boolean[] historicoOBitacora = new boolean[]{true};
        crearJSON instance = new crearJSON();
        List<List<Object>> result = instance.convertirAEntidades(lista, historicoOBitacora);
        System.out.println(result.get(0).get(0));
        
        assertEquals(result.get(0).get(0).getClass(), listaMayor.get(0).get(0).getClass());
        

    }

    /**
     * Test of generarJSON method, of class crearJSON.
     */
    @Test
    public void testGenerarJSON() throws Exception {
        System.out.println("generarJSON");
        List<List<Object>> listB = new ArrayList<>();
        ArrayList<Object> listC = new ArrayList<>();
        Bitacora go = new Bitacora(1, "historico1", "numeroInventario1", "marca1", "numeroSerie1", "modelo1", "responsable1", "sistemaOperativo1", "version1", true, "observaciones1");
        Bitacora go1 = new Bitacora(2, "historico2", "numeroInventario2", "marca2", "numeroSerie2", "modelo2", "responsable2", "sistemaOperativo2", "version2", true, "observaciones2");
        listC.add(go);
        listC.add(go1);
        ArrayList<Object> listE = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            d = sdf.parse("07/03/2017");
        } catch (ParseException ex) {
            Logger.getLogger(EnvioRestTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Historico to = new Historico("1", 1, d, "mantenimiento1", "observacionesHardware1", "observacionesSoftware1");
        Historico to1 = new Historico("2", 2, d, "mantenimiento2", "observacionesHardware2", "observacionesSoftware2");
        Historico to2 = new Historico("3", 3, d, "mantenimiento3", "observacionesHardware3", "observacionesSoftware3");
        listE.add(to);
        listE.add(to1);
        listE.add(to2);
        listB.add(listC);
        listB.add(listE);
        boolean[] historicoOBitacora = {false, true};
        crearJSON instance = new crearJSON();
        String js = "{\"Archivos\":[{\"tipo\":\"Bitacora\",\"Registros\":[{\"marca\":\"marca1\",\"numeroSerie\":\"numeroSerie1\",\"responsable\":\"responsable1\",\"sistemaOperativo\":\"sistemaOperativo1\",\"licencia\":true,\"numeroInventario\":\"numeroInventario1\",\"numero\":1,\"historico\":\"historico1\",\"observaciones\":\"observaciones1\",\"version\":\"version1\",\"modelo\":\"modelo1\"},{\"marca\":\"marca2\",\"numeroSerie\":\"numeroSerie2\",\"responsable\":\"responsable2\",\"sistemaOperativo\":\"sistemaOperativo2\",\"licencia\":true,\"numeroInventario\":\"numeroInventario2\",\"numero\":2,\"historico\":\"historico2\",\"observaciones\":\"observaciones2\",\"version\":\"version2\",\"modelo\":\"modelo2\"}]},{\"tipo\":\"Historico\",\"Registros\":[{\"fecha\":\"Tue Mar 07 00:00:00 CST 2017\",\"numero\":1,\"observacionesSoftware\":\"observacionesSoftware1\",\"observacionesHardware\":\"observacionesHardware1\",\"mantenimiento\":\"mantenimiento1\",\"numInventario\":\"1\"},{\"fecha\":\"Tue Mar 07 00:00:00 CST 2017\",\"numero\":2,\"observacionesSoftware\":\"observacionesSoftware2\",\"observacionesHardware\":\"observacionesHardware2\",\"mantenimiento\":\"mantenimiento2\",\"numInventario\":\"2\"},{\"fecha\":\"Tue Mar 07 00:00:00 CST 2017\",\"numero\":3,\"observacionesSoftware\":\"observacionesSoftware3\",\"observacionesHardware\":\"observacionesHardware3\",\"mantenimiento\":\"mantenimiento3\",\"numInventario\":\"3\"}]}]}";

        JSONObject jsonArr;
        jsonArr = new JSONObject(js);
        JSONObject expResult = jsonArr;
        JSONObject result = instance.generarJSON(listB, historicoOBitacora);
        assertEquals(expResult.toString().split("marca\":\"")[1].split(",")[0], "marca1\"");
    }
}
