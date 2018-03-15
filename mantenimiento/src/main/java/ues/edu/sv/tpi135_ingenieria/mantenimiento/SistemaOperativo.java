package ues.edu.sv.tpi135_ingenieria.mantenimiento;

/**
 *
 * @author esperanza
 */
public class SistemaOperativo {
    private int id_os;
    private String os;
    private String version;
    private boolean licencia;

    public SistemaOperativo() {
    }

    public SistemaOperativo(int id_os, String os, String version, boolean licencia) {
        this.id_os = id_os;
        this.os = os;
        this.version = version;
        this.licencia = licencia;
    }

    public int getId_os() {
        return id_os;
    }

    public void setId_os(int id_os) {
        this.id_os = id_os;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
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
}
