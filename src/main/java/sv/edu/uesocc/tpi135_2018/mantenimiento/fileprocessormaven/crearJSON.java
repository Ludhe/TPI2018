package sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven;

import java.io.IOException;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
//import sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven.ProcesadorArchivo;

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

    public static void main(String args[]) throws IOException {
        JSONObject jsObj = new JSONObject();
        JSONArray jsArray = new JSONArray();
        ProcesadorArchivo arc = new ProcesadorArchivo();
        List<List<String>> lista;

        lista = arc.parser("src/main/resources/archivoaleer.csv", false, ",");

        for (int i = 0; i < lista.size(); i++) {
//            jsObj.put("campo " + i, lista);
//            jsArray.add(lista);

//            jsObj.put("campo " + i, lista.get(i));
//            jsArray.add(lista.get(i));

            for (int j = 0; j < lista.get(i).size(); j++) {
//                jsObj.put("campo " + i, lista.get(i));
//                jsArray.add(lista.get(i));

                jsObj.put("campo " + i, lista.get(i).get(j));
                jsArray.add(lista.get(i).get(j));
                
            }
        }

        System.out.println(jsObj);
        System.out.println(jsArray);
    }

}
