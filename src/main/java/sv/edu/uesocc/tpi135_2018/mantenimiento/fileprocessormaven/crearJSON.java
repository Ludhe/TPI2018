package sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven;

import java.io.IOException;
import java.util.List;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author irvin
 */
public class crearJSON {

    JsonObject jsObj;
    JsonArray jsArray;
    ProcesadorArchivo arc = new ProcesadorArchivo();
    List<List<String>> lista;

    public JsonObject crear() throws IOException {
        lista = arc.parser("/home/usuario/prueba.csv", true, ",");

        for (int i = 0; i < lista.size(); i++) {
            jsObj.put("campo "+i, (JsonValue)lista);
            
//            for (int j = 0; j < lista.get(i).size(); j++) {
//                jsArray.add(jsObj);
//                
//            }

        }

        return jsObj;
    }
    
public static void main(String args[]) {
    System.out.println();
}

}



