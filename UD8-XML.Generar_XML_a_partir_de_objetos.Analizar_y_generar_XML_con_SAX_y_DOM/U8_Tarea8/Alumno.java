package Tarea8;

import java.util.ArrayList;

public class Alumno {
    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    private ArrayList<Asignatura> asignaturas;

    public Alumno(int id, String nombre, String apellidos, int edad, ArrayList<Asignatura> asignaturas) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.asignaturas = asignaturas;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Alumno {" +
                " id = " + id +
                ", nombre = " + nombre + '\'' +
                ", apellido = " + apellidos + '\'' +
                ", edad = " + edad +
                ", asignaturas = " + asignaturas +
                '}';
    }
}
