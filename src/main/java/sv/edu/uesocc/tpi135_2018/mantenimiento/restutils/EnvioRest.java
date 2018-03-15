/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.restutils;

import java.io.IOException;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
/**
 *
 * @author doratt
 */
public class EnvioRest {
    Client cliente = ClientBuilder.newClient();
    public URI Envio(JSONObject migracion, String path) throws Exception{
        WebTarget raiz = cliente.target(path);
        Response respuesta = raiz.request(MediaType.APPLICATION_JSON).post(Entity.json(migracion));
        if(respuesta.getStatus() == Response.Status.CREATED.getStatusCode()){
               return respuesta.getLocation();
        }else{
            return null;
        }
        
    }
}




