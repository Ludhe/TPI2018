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

public boolean hasRequiredExtensions(final String path ) throws IOException{
   List<?> lista=new ArrayList<>();
   if(path!=null&&!path.isEmpty()){
       this.absolutePath=Paths.get(path);
   lista=Files.walk(absolutePath).
           filter(a -> validarPath(path)).
           map(a -> a.getFileName().toString().endsWith(".csv")).
           filter(o -> o.equals(true)).
           collect(toList());
   //return lista.size();
   }
           return lista.isEmpty();
}

public List<List<String>> parser(String nombreArchivo, boolean saltarLinea,String separador) throws IOException{
    List<List<String>> listaGeneral= new ArrayList<>();
    if(nombreArchivo!=null&&!nombreArchivo.trim().isEmpty()){
        Path pathArchivo = Paths.get(absolutePath.toString(),nombreArchivo);
        if(Files.isReadable(pathArchivo)){
        Files.lines(pathArchivo).
                skip(saltarLinea?1:0).
                filter(l -> l.contains(separador)).
                forEach((f)->{
                    listaGeneral.add(Arrays.asList(f.split(separador.concat(REGEX))));
                });
        }
    }
    return listaGeneral;
}
    
}
