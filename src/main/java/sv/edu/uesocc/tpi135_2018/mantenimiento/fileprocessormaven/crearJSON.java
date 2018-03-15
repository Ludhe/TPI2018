package sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;
import sv.edu.uesocc.tpi135_2018.mantenimiento.definiciones.Bitacora;
import sv.edu.uesocc.tpi135_2018.mantenimiento.definiciones.Historico;

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

    public List<List<Object>> convertirAEntidades(List<List<List<Object>>> lista, boolean[] historicoOBitacora) throws ParseException {
        List<List<Object>> convertida = new ArrayList<>();

        List<Object> listaEntidad = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(i).size(); j++) {
                if (historicoOBitacora[i]) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date d = null;
                    d= sdf.parse(lista.get(i).get(j).get(2).toString());
                    
                    System.out.println("lista en convertirAEntidades");
                    System.out.println(lista.get(i).get(j));
                    listaEntidad.add(new Historico(lista.get(i).get(j).get(0).toString(),
                            Integer.parseInt(lista.get(i).get(j).get(1).toString()),
                            d, 
                            lista.get(i).get(j).get(3).toString(),
                            lista.get(i).get(j).get(4).toString(), 
                            lista.get(i).get(j).get(5).toString() ) );
                    System.out.println("Termino una entidad");
                    System.out.println(listaEntidad);
                }else{
                    listaEntidad.add(new Bitacora(Integer.parseInt(lista.get(i).get(j).get(0).toString()),
                            lista.get(i).get(j).get(1).toString(), 
                            lista.get(i).get(j).get(2).toString(), 
                            lista.get(i).get(j).get(3).toString(), 
                            lista.get(i).get(j).get(4).toString(),
                            lista.get(i).get(j).get(5).toString(), 
                            lista.get(i).get(j).get(6).toString(), 
                            lista.get(i).get(j).get(7).toString(), 
                            lista.get(i).get(j).get(8).toString(), 
                            ((lista.get(i).get(j).get(9).toString() != null) && !lista.get(i).get(j).get(9).toString().isEmpty() ), 
                            lista.get(i).get(j).get(11).toString() ) );
                }
            }
            convertida.add(listaEntidad);
            listaEntidad = new ArrayList<>();
        }

        return convertida;
    }

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
        jsObj = new JSONObject();
        jsObj.put("Archivos", jsArray2);
        System.out.println(jsObj);

        return jsObj;
    }

}
