package sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven;

import java.io.IOException;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;

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
        JSONArray jsArray = new JSONArray();
        ProcesadorArchivo arc = new ProcesadorArchivo();
        List<List<String>> lista;
        String[] encabezado = new String[]{"N°", "Historico Mantenimientos", "N° Inventario", "Marca", "N° de Serie", "Modelo",
            "Responsable", "Sistema Operativo", "Versión", "Licencia (Si/No)", "Observaciones"};

        lista = arc.parser("src/main/resources/Sin-título-1.csv", false, ",");

        for (int i = 0; i < lista.size(); i++) {
            JSONObject jsObj = new JSONObject();

            for (int j = 0; j < lista.get(i).size(); j++) {
                jsObj.put(encabezado[j], lista.get(i).get(j));
            }
            jsArray.put(jsObj);
            System.out.println(jsObj);

        }
        System.out.println(jsArray);
    }

}
