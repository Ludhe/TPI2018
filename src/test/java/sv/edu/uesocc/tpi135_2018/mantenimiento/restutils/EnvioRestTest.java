/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.restutils;

import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
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
    public void testEnvio() throws Exception {
        JSONObject migracion = new JSONObject("{}");
        System.out.println("Envio");
        String path = "/migracion";
        EnvioRest instance = new EnvioRest();
        URI expResult = URI.create("http://localhost:8080/migracion");
        URI result = instance.Envio(migracion, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
}
