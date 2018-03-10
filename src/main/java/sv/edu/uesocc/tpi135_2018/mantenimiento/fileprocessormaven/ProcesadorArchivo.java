/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author zaldivar
 */
public class ProcesadorArchivo {
    
private Path absolutePath;
    
private static final String REGEX="((?=[^\"']|\"[^\"]*\")+$)";
    
private boolean validarPath(final String path){
  
    if(path!=null&&!path.trim().isEmpty()){
       File file=new File(path);
       
       return file.exists()&&file.isDirectory();
    }
    return false;
}

public List<Object> hasRequiredExtensions(final String path ) throws IOException{
   List<Object> lista=new ArrayList<>();
   if(path!=null&&!path.isEmpty()){
       this.absolutePath=Paths.get(path);
   lista=Files.walk(absolutePath).
           filter(a -> validarPath(path)).
           filter(a -> a.getFileName().toString().endsWith(".csv")).
           collect(toList());
   }
           return lista;
}

public List<List<List<String>>> parser(List<String> paths, boolean saltarLinea,String separador) throws IOException{
    List<List<String>> listaGeneral= new ArrayList<>();
    List<List<List<String>>> listaMayor = new ArrayList<>();
    if(!paths.isEmpty()){
        for (String path : paths) {
            Path pathArchivo = Paths.get(path);
        if(Files.isReadable(pathArchivo)){
        Files.lines(pathArchivo).
                skip(saltarLinea?1:0).
                filter(l -> l.contains(separador)).
                forEach((f)->{
                    listaGeneral.add(Arrays.asList(f.split(separador.concat(REGEX))));
                });
        }
        listaMayor.add(listaGeneral);
        }
    }
    return listaMayor;
}


    
}
