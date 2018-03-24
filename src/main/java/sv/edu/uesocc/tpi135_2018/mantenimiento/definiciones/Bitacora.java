/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135_2018.mantenimiento.definiciones;

import java.io.Serializable;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zaldivar
 */
@XmlRootElement
public class Bitacora implements Serializable{
 
    public Bitacora(){
        super();
    }
    
    private int numero;
    private String historico;
    private String numeroInventario;
    private String marca;
    private String numeroSerie;
    private String modelo;
    private String responsable;
    private String sistemaOperativo;
    private String version;
    private boolean licencia;
    private String observaciones;

    public Bitacora(int numero, String historico, String numeroInventario, String marca, String numeroSerie, String modelo, String responsable, String sistemaOperativo, String version, boolean licencia, String observaciones) {
        this.numero = numero;
        this.historico = historico;
        this.numeroInventario = numeroInventario;
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.responsable = responsable;
        this.sistemaOperativo = sistemaOperativo;
        this.version = version;
        this.licencia = licencia;
        this.observaciones = observaciones;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getNumeroInventario() {
        return numeroInventario;
    }

    public void setNumeroInventario(String numeroInventario) {
        this.numeroInventario = numeroInventario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isLicencia() {
        return licencia;
    }

    public void setLicencia(boolean licencia) {
        this.licencia = licencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public JsonObject toJson(){
        JsonBuilderFactory factory=Json.createBuilderFactory(null);
        JsonObject object=factory.createObjectBuilder()
                .add("numero",this.numero)
                .add("historico",this.historico)
                .add("numeroInventario",this.numeroInventario)
                .add("marca",this.marca)
                .add("numeroSerie",this.numeroSerie)
                .add("modelo",this.responsable)
                .add("sistemaOperativo",this.sistemaOperativo)
                .add("version",this.version)
                .add("licencia",this.licencia)
                .add("observaciones",this.observaciones).build();
        
        return object;
    }

}
