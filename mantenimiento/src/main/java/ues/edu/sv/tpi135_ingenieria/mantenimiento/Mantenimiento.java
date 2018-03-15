/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135_ingenieria.mantenimiento;

/**
 *
 * @author esperanza
 */
public class Mantenimiento {
    //Aqui van todas las propiedades del mantenimiento que luego se van a convertir en JSON(?)
    //Todo lo saque de los pdf del aula virtual :v
    private int id_mantenimiento;
    private int id_responsable;
    private String historico; //No se a que se refiere exactamente con el historico
                              //Pero lo pongo de todos modos 
    private String numero_inventario;
    private String numero_serie;
    private String marca;
    private String modelo;
    private String OS;
    private boolean licencia;
    private String version;
    private String observaciones;
    
    //De aqui en adelante, codigo generado por netbeans
    //Constructo, getters y setters

    public Mantenimiento(){}
    
    public Mantenimiento(int id_mantenimiento, int id_responsable, String historico, String numero_inventario, String numero_serie, String marca, String modelo, String OS, boolean licencia, String version, String observaciones) {
        this.id_mantenimiento = id_mantenimiento;
        this.id_responsable = id_responsable;
        this.historico = historico;
        this.numero_inventario = numero_inventario;
        this.numero_serie = numero_serie;
        this.marca = marca;
        this.modelo = modelo;
        this.OS = OS;
        this.licencia = licencia;
        this.version = version;
        this.observaciones = observaciones;
    }

    public int getId_mantenimiento() {
        return id_mantenimiento;
    }

    public void setId_mantenimiento(int id_mantenimiento) {
        this.id_mantenimiento = id_mantenimiento;
    }

    public int getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getNumero_inventario() {
        return numero_inventario;
    }

    public void setNumero_inventario(String numero_inventario) {
        this.numero_inventario = numero_inventario;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public boolean isLicencia() {
        return licencia;
    }

    public void setLicencia(boolean licencia) {
        this.licencia = licencia;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }    
}
