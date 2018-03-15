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

   public JSONObject generarJSON(List<List<Object>> listB, boolean[] historicoOBitacora) throws IOException {

        JSONArray jsArray = new JSONArray();
        JSONArray jsArray2 = new JSONArray();
        JSONObject jsObj = null;

//        listB = arc.parser("src/main/resources/bitacora.csv", false, ",");
        for (int i = 0; i < listB.size(); i++) {
            jsArray = new JSONArray();

            for (int j = 0; j < listB.get(i).size(); j++) {
                jsObj = new JSONObject(listB.get(i).get(j));
                //System.out.println(jsObj);
                jsArray.put(jsObj);
                //System.out.println(jsArray);
            }
           System.out.println(jsArray);
//            jsArray.put(jsObj);
//System.out.println(jsObj);

            jsObj = new JSONObject();

            if (historicoOBitacora[i] == true) {
                jsObj.put("tipo", "Historico");
                jsObj.put("Registros", jsArray);
                System.out.println(jsObj);

            } else if (historicoOBitacora[i] == false) {
                
                jsObj.put("tipo", "Bitacora");
                jsObj.put("Registros", jsArray);
                System.out.println(jsObj);
            }
            jsArray2.put(jsObj);
        }
//        jsArray = new JSONArray();
        //jsArray2.put(jsObj);

        System.out.println(jsArray2);
        jsObj =  new JSONObject();
        jsObj.put("Archivos", jsArray2);
        System.out.println(jsObj);
        

        return jsObj;
    }

}
