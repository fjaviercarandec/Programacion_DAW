import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Concurso {
    protected String nombre;
    protected String localidad;
    protected Map<String, Set<Perro>> perros;

    public Concurso(String nombre, String localidad, Map<String, Set<Perro>> perros) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.perros = perros;
    }

    public void addDog(String raza, Perro p) {
        if (!(raza.equals(p.getRaza()))) {
            System.out.println("La raza " + raza + " no pertenece a este perro.");
        } else {
            if (perros.containsKey(raza)) {
                Set<Perro> aux = perros.get(raza);
                aux.add(p);
                perros.put(raza, aux);
            } else {
                Set<Perro> aux = new HashSet<>();
                aux.add(p);
                perros.put(raza,aux);
            }
        }
    }

    public void disqualifyDog(Perro perro) {
        if (perros.containsKey(perro.getRaza())) {
            Set<Perro> aux = perros.get(perro.getRaza());
            if (aux.contains(perro)) {
                aux.remove(perro);
                perros.put(perro.getRaza(), aux);
            } else {
                System.out.println("Perro no inscrito.");

            }
        }
    }

    public void ownerDogs(Integer nsocio) {
        boolean aux = false;
        for (Set<Perro> p : perros.values()) {
            for (Perro perro : p) {
                if (perro.getPropietario().getNsocio() == nsocio) {
                    aux = true;
                    System.out.println(perro.toString());
                }
            }
        }
        if (!aux) {
            System.out.println("Este socio no tiene perros inscritos");
        }
    }

    public void perrosporPeso(String raza) {
        if (perros.containsKey(raza)) {
            List<Perro> listperro = new LinkedList<>();
            listperro.addAll(perros.get(raza));
            listperro.sort(new OrdenaPorPeso());
            System.out.println(listperro.toString());
        } else {
            System.out.println("No existe la raza " + raza);
        }
    }

    public void perrosporEdad(String raza) {
        if (perros.containsKey(raza)) {
            List<Perro> listperro = new LinkedList<>();
            listperro.addAll(perros.get(raza));
            listperro.sort(new OrdenarPorEdad());
            System.out.println(listperro.toString());
        } else {
            System.out.println("No existe la raza " + raza);
        }
    }

    public void cargarPerros() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("perros.dat"));
            while (true) {
                Perro aux = (Perro) in.readObject();
                if (perros.containsKey(aux.getRaza())) {
                    Set<Perro> auxp = perros.get(aux.getRaza());
                    auxp.add(aux);
                } else {
                    Set<Perro> auxp = new HashSet<>();
                    auxp.add(aux);
                    perros.put(aux.getRaza(),auxp);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void guardarPerros() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("perros.dat"));
            for (Set<Perro> p : perros.values()) {
                for (Perro perro : p) {
                    out.writeObject(perro);
                }
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
