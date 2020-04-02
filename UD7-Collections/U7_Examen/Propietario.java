import java.io.Serializable;

public class Propietario implements Serializable {
    protected String nombre;
    protected String apellido;
    protected Integer nsocio;
    protected String pais;

    public Propietario(String nombre, String apellido, Integer nsocio, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nsocio = nsocio;
        this.pais = pais;
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

    public Integer getNsocio() {
        return nsocio;
    }

    public void setNsocio(Integer nsocio) {
        this.nsocio = nsocio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
