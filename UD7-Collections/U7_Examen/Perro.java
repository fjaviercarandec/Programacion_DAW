import java.io.Serializable;

public class Perro implements Serializable {
    protected String nombre;
    protected Integer edad;
    protected Integer peso;
    protected Boolean vacuna;
    protected Propietario propietario;
    protected String raza;

    public Perro(String nombre, Integer edad, Integer peso, Boolean vacuna, Propietario propietario, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.vacuna = vacuna;
        this.propietario = propietario;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Boolean getVacuna() {
        return vacuna;
    }

    public void setVacuna(Boolean vacuna) {
        this.vacuna = vacuna;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Perro {" +
                "Nombre = " + nombre + ", Raza = " + raza + ", Peso = " + peso + ", Edad = " + edad +
                ", Propietario = " + propietario.getNombre() + "}\n";
    }
}
