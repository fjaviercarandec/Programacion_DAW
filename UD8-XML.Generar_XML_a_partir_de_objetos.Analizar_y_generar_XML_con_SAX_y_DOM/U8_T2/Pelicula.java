public class Pelicula {
    protected int id;
    protected String nombre;
    protected String director;
    protected int anyo;
    protected String pais;

    public Pelicula(int id, String nombre, String director, int anyo, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.anyo = anyo;
        this.pais = pais;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
