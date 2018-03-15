/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.definiciones;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author andrea
 */
@XmlRootElement
public class Historico implements Serializable{
    
    public Historico(){
        super();
    }
    
    private int numero;
    private String numInventario;
    private Date fecha;
    private String mantenimiento;
    private String observacionesSoftware;
    private String observacionesHardware;
    
    public Historico( String numInventario,int numero, Date fecha, String mantenimiento, String observacionesSoftware, String observacionesHardware ){
        this.numero = numero;
        this.numInventario = numInventario;
        this.fecha = fecha;
        this.mantenimiento = mantenimiento;
        this.observacionesSoftware = observacionesSoftware;
        this.observacionesHardware = observacionesHardware;
        
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the mantenimiento
     */
    public String getMantenimiento() {
        return mantenimiento;
    }

    /**
     * @param mantenimiento the mantenimiento to set
     */
    public void setMantenimiento(String mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    /**
     * @return the observacionesSoftware
     */
    public String getObservacionesSoftware() {
        return observacionesSoftware;
    }

    /**
     * @param observacionesSoftware the observacionesSoftware to set
     */
    public void setObservacionesSoftware(String observacionesSoftware) {
        this.observacionesSoftware = observacionesSoftware;
    }

    /**
     * @return the observacionesHardware
     */
    public String getObservacionesHardware() {
        return observacionesHardware;
    }

    /**
     * @param observacionesHardware the observacionesHardware to set
     */
    public void setObservacionesHardware(String observacionesHardware) {
        this.observacionesHardware = observacionesHardware;
    }

    /**
     * @return the numInventario
     */
    public String getNumInventario() {
        return numInventario;
    }

    /**
     * @param numInventario the numInventario to set
     */
    public void setNumInventario(String numInventario) {
        this.numInventario = numInventario;
    }
            
}
