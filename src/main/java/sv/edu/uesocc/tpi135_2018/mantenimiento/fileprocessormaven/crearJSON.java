package sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;
import sv.edu.uesocc.tpi135_2018.mantenimiento.definiciones.Bitacora;

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
        ProcesadorArchivo arc = new ProcesadorArchivo();
        List<List<String>> lista;
        String[] encabezado = new String[]{"N°", "Historico Mantenimientos", "N° Inventario", "Marca", "N° de Serie", "Modelo",
            "Responsable", "Sistema Operativo", "Versión", "Licencia (Si/No)", "Observaciones"};

        lista = arc.parser("src/main/resources/Sin-título-1.csv", false, ",");

        ArrayList<Bitacora> listB = new ArrayList<>();
        Bitacora obj = new Bitacora(0, "shobe se la come", "numeroInventario", "marca", "numeroSerie", "modelo", "responsable", "sistemaOperativo", "version", true, "observaciones");
        Bitacora obj1 = new Bitacora(0, "kevin se la come", "numeroInventario", "marca", "numeroSerie", "modelo", "responsable", "sistemaOperativo", "version", true, "observaciones");
        Bitacora obj2 = new Bitacora(0, "chepe se la come", "numeroInventario", "marca", "numeroSerie", "modelo", "responsable", "sistemaOperativo", "version", true, "observaciones");
        listB.add(obj);
        listB.add(obj1);
        listB.add(obj2);
        JSONArray jsArray = new JSONArray();
        JSONObject jsObj;
        for (int i = 0; i < listB.size(); i++) {
            jsObj = new JSONObject(listB.get(i));
            System.out.println(jsObj);
            jsArray.put(jsObj);
        }
        System.out.println(jsArray);

        jsObj = new JSONObject();
        jsObj.put("tipo", "Historial");
        jsObj.put("Registros", jsArray);
        System.out.println(jsObj);
        jsArray = new JSONArray();
        jsArray.put(jsObj);
        System.out.println(jsArray);

    }

}
