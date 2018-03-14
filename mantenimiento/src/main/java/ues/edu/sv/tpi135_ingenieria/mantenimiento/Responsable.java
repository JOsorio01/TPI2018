package ues.edu.sv.tpi135_ingenieria.mantenimiento;

/**
 *
 * @author esperanza
 */
public class Responsable {
    private int id_responsable;
    private String nombre;
    private String apellido;
    private String email;

    public Responsable() {
    }

    public Responsable(int id_responsable, String nombre, String apellido, String email) {
        this.id_responsable = id_responsable;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public int getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}
