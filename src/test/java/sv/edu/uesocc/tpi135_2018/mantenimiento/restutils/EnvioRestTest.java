/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.restutils;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import sv.edu.uesocc.tpi135_2018.mantenimiento.definiciones.Bitacora;
import sv.edu.uesocc.tpi135_2018.mantenimiento.definiciones.Historico;
import sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven.crearJSON;

/**
 *
 * @author doratt
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ClientBuilder.class)
public class EnvioRestTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    final Client mockClient = Mockito.mock(Client.class);
    final Response mockResponse = Mockito.mock(Response.class);

    @Before
    public void Inicializar() throws URISyntaxException {

        Mockito.when(this.mockResponse.getStatus()).thenReturn(Status.CREATED.getStatusCode());
        Mockito.when(this.mockResponse.getLocation()).thenReturn(new URI("http://localhost:8080/migracion"));
        final Builder mockBuilder = Mockito.mock(Builder.class);
        Mockito.when(mockBuilder.post(Matchers.any())).thenReturn(this.mockResponse);

        final WebTarget mockWebTarget = Mockito.mock(WebTarget.class);
        Mockito.when(mockWebTarget.path(Matchers.anyString())).thenReturn(mockWebTarget);
        Mockito.when(mockWebTarget.request(MediaType.APPLICATION_JSON)).thenReturn(mockBuilder);

        Mockito.when(this.mockClient.target(Matchers.anyString())).thenReturn(mockWebTarget);

        PowerMockito.mockStatic(ClientBuilder.class);
        PowerMockito.when(ClientBuilder.newClient()).thenReturn(mockClient);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of Envio method, of class EnvioRest.
     */
      @Test
    public void testGenerarJSON() throws Exception {
        System.out.println("generarJSON");
        
        
        List<List<Object>> listB =  new ArrayList<>();
        ArrayList<Object> listC = new ArrayList<>();
        Bitacora go = new Bitacora(1, "historico1", "numeroInventario1", "marca1", "numeroSerie1", "modelo1", "responsable1", "sistemaOperativo1", "version1", true, "observaciones1");
        Bitacora go1 = new Bitacora(2, "historico2", "numeroInventario2", "marca2", "numeroSerie2", "modelo2", "responsable2", "sistemaOperativo2", "version2", true, "observaciones2");
        listC.add(go);
        listC.add(go1);
        System.out.println(listC.get(0));   
        
//        List<List<Object>> listD =  new ArrayList<>();
        ArrayList<Object> listE = new ArrayList<>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            d = sdf.parse("07/03/2017");
        } catch (ParseException ex) {
            Logger.getLogger(EnvioRestTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Historico to = new Historico(1, 1, d, "mantenimiento1", "observacionesSoftware1", "observacionesHardware1");
        Historico to1 = new Historico(2, 2, d, "mantenimiento2", "observacionesSoftware2", "observacionesHardware2");
        Historico to2 = new Historico(3, 3, d, "mantenimiento3", "observacionesSoftware3", "observacionesHardware3");
        listE.add(to);
        listE.add(to1);
        listE.add(to2);
        
        
        listB.add(listC);
        listB.add(listE);
//        System.out.println(listC);
//        System.out.println(listE);
System.out.println(listB.get(1));
        
        
        boolean[] historicoOBitacora = {false,true};
        crearJSON instance = new crearJSON();
        String js = "{}";
        JSONObject jsonArr;
        jsonArr = new  JSONObject(js);
        
        JSONObject expResult = jsonArr;
        JSONObject result = instance.generarJSON(listB, historicoOBitacora);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }


}
