/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.restutils;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.net.URI;
import sv.edu.uesocc.tpi135_2018.mantenimiento.definiciones.Mantenimiento;

/**
 *
 * @author doratt
 */
public class EnvioRest {
    
    Client cliente ;
    
    public URI Envio(Mantenimiento obj) throws IOException {
        
        WebTarget target = cliente.target("/hola");
        URI salida = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(mnt, MediaType.APPLICATION_JSON), URI.class);
        return salida;

    }
    
}
