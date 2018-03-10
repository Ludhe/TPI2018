/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.definiciones;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zaldivar
 */
@XmlRootElement
public class Mantenimiento implements Serializable{
    String tipoMantenimiento;
    String responsable;
    int idMantenimiento;
    
    
    public Mantenimiento(){
        super();
    }
    
    public Mantenimiento(String tipoMantenimieto, String resp,int idMantenimiento){
        super();
        this.tipoMantenimiento=tipoMantenimieto;
        this.responsable=resp;
        this.idMantenimiento=idMantenimiento;
    }

    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

   

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    
}
