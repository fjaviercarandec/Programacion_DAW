package Tarea7;

import java.util.ArrayList;

public class Futbolista {
    private int id;
    private String nombre;
    private String equipo;
    private Estadistica estadisticas;

    public Futbolista(int id, String nombre, String equipo, Estadistica estadisticas) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.estadisticas = estadisticas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Estadistica getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Estadistica estadisticas) {
        this.estadisticas = estadisticas;
    }

    @Override
    public String toString() {
        return "Futbolista {" +
                "id = " + id +
                ", nombre = " + nombre + '\'' +
                ", equipo = " + equipo + '\'' +
                ", estadisticas = {" + estadisticas +
                '}';
    }
}
