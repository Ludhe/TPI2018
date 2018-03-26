/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author zaldivar
 */
public class ProcesadorArchivo {
    
    public enum Extension{
        CSV(".csv"),
        TXT(".txt");
        
        private final String type;
        private Extension(String type){
            this.type=type;
        }
        @Override
        public String toString(){
            return type;
        }
    }

    private Path absolutePath;

    private static final String REGEX = "(?=([^\"']|\"[^\"]*\"|\"[^\"]*)+$)";

    public boolean validarPath(final String path) {

        if (path != null && !path.trim().isEmpty()) {
            File file = new File(path);

            return file.exists() && file.isDirectory();
        }
        return false;
    }

    public List<Object> hasRequiredExtensions(final String path,final Extension extension)throws IOException {
        List<Object> lista = new ArrayList<>();
        if (path != null && !path.isEmpty()) {
            this.absolutePath = Paths.get(path);
            lista = Files.walk(absolutePath).
                    filter(a -> validarPath(path)).
                    filter(a -> a.getFileName().toString().endsWith(extension.toString())).
                    collect(toList());
        }
        return lista;
    }

    public List<List<Object>> parser(boolean historico, String path, String separador) throws IOException {//si el primer split es vacio,no tomar en cuenta linea
        List<List<Object>> listaGeneral = new ArrayList<>();
        if (path != null && !path.isEmpty()) {
            Path pathArchivo = Paths.get(path);
            if (Files.isReadable(pathArchivo)) {

                FileReader fr = new FileReader(new File(path));
                BufferedReader br = new BufferedReader(fr);

                String linea;
                List<Object> objParcial = new ArrayList<>();
                int contadorLineas = 0;
                String NumInventario = "";
                boolean comillasImpares = false;
                
                if(historico){
                    while ((linea = br.readLine()) != null) {
                    if (contadorLineas < 7) {
                        if(contadorLineas == 3){
                            NumInventario = linea.split(separador.concat(REGEX))[1];
                        }
                        contadorLineas++;
                        continue;
                    }

                    //comenzando objeto
                    if (objParcial.isEmpty()) {
                        objParcial.add(NumInventario);
                        Object[] arrayLinea = linea.split(separador.concat(REGEX));

                        for (Object o : arrayLinea) {
                            objParcial.add(o);
                        }


                        if (linea.split("\"").length % 2 == 0) {
                            comillasImpares = true;
                            continue;
                        } else {
                            //EVALUAR GUARDAR
                            if (objParcial.size() == 6) {
                                
                                listaGeneral.add(objParcial);
                               
                                comillasImpares = false;
                                objParcial = new ArrayList<>();
                            }
                        }
                       
                        //objeto a medias
                    } else if (objParcial.size() < 6 || comillasImpares) {
                        if (comillasImpares) {
                            Object[] arrayLinea = linea.split(separador.concat(REGEX));
                            
                            if (!linea.contains("\"")) {
                                
                                objParcial.set(objParcial.size() - 1, objParcial.get(objParcial.size() - 1).toString().concat("\n"+arrayLinea[0].toString()));
                            } else {
                                
                                objParcial.set(objParcial.size() - 1, objParcial.get(objParcial.size() - 1).toString().concat("\n"+arrayLinea[0].toString()));
                                if(!linea.contains("\",\"")){
                                    comillasImpares = false;
                                }else{
                                    objParcial.set(objParcial.size() - 1, objParcial.get(objParcial.size() - 1).toString().concat("\""));
                                }
                                for (int i = 1; i < arrayLinea.length; i++) {
                                    if (arrayLinea[i] != null && !arrayLinea[i].toString().isEmpty()) {
                                        objParcial.add(arrayLinea[i]);
                                    }
                                }
                                //EVALUAR GUARDAR
                                
                                if (objParcial.size() == 6 && !comillasImpares) {
                                   
                                    listaGeneral.add(objParcial);
                                    
                                    comillasImpares = false;
                                    objParcial = new ArrayList<>();
                                }
                                
                                if(!linea.contains("\",\"")){
                                    comillasImpares = false;
                                }
                            }
                            //objeto terminado
                        } else {
                            //EVALUAR GUARDAR
                            if (objParcial.size() == 6) {
                                
                                listaGeneral.add(objParcial);
                               
                                comillasImpares = false;
                                objParcial = new ArrayList<>();
                            }
                        }
                    }
                    contadorLineas++;
                }
                    
                //BITACORA
                }else{
                    while ((linea = br.readLine()) != null) {
                    if (contadorLineas < 5) {
                        contadorLineas++;
                        continue;
                    }

                    //comenzando objeto
                    if (objParcial.isEmpty()) {
                        
                        Object[] arrayLinea = linea.split(separador.concat(REGEX));

                        for (Object o : arrayLinea) {
                            objParcial.add(o);
                        }

                        

                        if (linea.split("\"").length % 2 == 0) {
                            comillasImpares = true;
                            continue;
                        } else {
                            //EVALUAR GUARDAR
                            if (objParcial.size() == 12) {
                                
                                listaGeneral.add(objParcial);
                               
                                comillasImpares = false;
                                objParcial = new ArrayList<>();
                            }
                        }
                        
                        //objeto a medias
                    } else if (objParcial.size() < 12 || comillasImpares) {
                        if (comillasImpares) {
                            Object[] arrayLinea = linea.split(separador.concat(REGEX));
                          
                            if (!linea.contains("\"")) {
                                
                                objParcial.set(objParcial.size() - 1, objParcial.get(objParcial.size() - 1).toString().concat("\n"+arrayLinea[0].toString()));
                            } else {
                               
                                objParcial.set(objParcial.size() - 1, objParcial.get(objParcial.size() - 1).toString().concat("\n"+arrayLinea[0].toString()));
                                if(!linea.contains("\",\"")){
                                    comillasImpares = false;
                                }else{
                                    objParcial.set(objParcial.size() - 1, objParcial.get(objParcial.size() - 1).toString().concat("\""));
                                }
                                for (int i = 1; i < arrayLinea.length; i++) {
                                    if (arrayLinea[i] != null && !arrayLinea[i].toString().isEmpty()) {
                                        objParcial.add(arrayLinea[i]);
                                    }
                                }
                                //EVALUAR GUARDAR
                                
                                if (objParcial.size() == 12 && !comillasImpares) {
                                    
                                    listaGeneral.add(objParcial);
                                    
                                    comillasImpares = false;
                                    objParcial = new ArrayList<>();
                                }
                                
                                if(!linea.contains("\",\"")){
                                    comillasImpares = false;
                                }
                            }
                            //objeto terminado
                        } else {
                            //EVALUAR GUARDAR
                            if (objParcial.size() == 12) {
                                
                                listaGeneral.add(objParcial);
                               
                                comillasImpares = false;
                                objParcial = new ArrayList<>();
                            }
                        }
                    }
                    contadorLineas++;
                }
                }
                
                

            }
        }

        System.out.println("LISTA GENERAL " + listaGeneral);
        return listaGeneral;
    }

}
