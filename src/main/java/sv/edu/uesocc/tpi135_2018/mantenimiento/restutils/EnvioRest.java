/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.restutils;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.net.URI;
import javax.json.Json;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import sv.edu.uesocc.tpi135_2018.mantenimiento.definiciones.Mantenimiento;

/**
 *
 * @author doratt
 */
public class EnvioRest {
      Client cliente;
      ClientBuilder newClientBuilder; 
    public URI Envio(Mantenimiento obj) throws IOException {
        WebTarget raiz;
        raiz = cliente.target("/hola");
//        Response respuesta = raiz.path("").request(MediaType.JSON).accept(MediaType.).post(Entity.json(raiz));
    return null;
    }
    
}
