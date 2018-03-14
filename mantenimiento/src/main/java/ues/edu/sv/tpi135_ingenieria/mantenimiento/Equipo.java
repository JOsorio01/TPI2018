package ues.edu.sv.tpi135_ingenieria.mantenimiento;

/**
 *
 * @author esperanza
 */
public class Equipo {
    private String numero_serie;
    private String numero_inventario;
    private int id_modelo;
    private int id_marca;
    private int OS;

    public Equipo() {
    }

    public Equipo(String numero_serie, String numero_inventario, int id_modelo, int id_marca, int OS) {
        this.numero_serie = numero_serie;
        this.numero_inventario = numero_inventario;
        this.id_modelo = id_modelo;
        this.id_marca = id_marca;
        this.OS = OS;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getNumero_inventario() {
        return numero_inventario;
    }

    public void setNumero_inventario(String numero_inventario) {
        this.numero_inventario = numero_inventario;
    }

    public int getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public int getOS() {
        return OS;
    }

    public void setOS(int OS) {
        this.OS = OS;
    }
    
    
    
}
