/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.restutils;


import java.io.IOException;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author doratt
 */
public class EnvioRest {
      Client cliente;
    public Response Envio(List<List<List<String>>> migracion) throws IOException {
        JsonObject nuevo = Json.createObjectBuilder().build();
        WebTarget raiz;
        raiz = cliente.target("/hola");
        Response respuesta = raiz.path("").request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(Entity.json(nuevo));
        return respuesta;
    } 
}
