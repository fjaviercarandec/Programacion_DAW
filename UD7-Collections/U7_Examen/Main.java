import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //Creo 3 dueños.
        Propietario pro1 = new Propietario("Javier", "Carande", 1, "Espanya");
        Propietario pro2 = new Propietario("Ana", "Carande", 2, "Espanya");
        Propietario pro3 = new Propietario("Maria", "Carande", 3, "Espanya");


        //Creo 10 perros divididos en 3 razas.
        Perro p1 = new Perro("Nombre1",15,10,true, pro1, "Husky");
        Perro p2 = new Perro("Nombre2",10,15,true, pro1, "Husky");
        Perro p3 = new Perro("Nombre3",8,7,true, pro2, "Husky");
        Perro p4 = new Perro("Nombre4",2,3,true, pro2, "Husky");
        Perro p5 = new Perro("Nombre5",16,23,true, pro1, "Pastor Aleman");
        Perro p6 = new Perro("Nombre6",20,18,true, pro2, "Pastor Aleman");
        Perro p7 = new Perro("Nombre7",5,10,true, pro1, "Pastor Aleman");
        Perro p8 = new Perro("Nombre8",1,5,true, pro1, "Pastor Aleman");
        Perro p9 = new Perro("Nombre9",10,15,true, pro2, "Labrador");
        Perro p10 = new Perro("Nombre10",7,10,true, pro2, "Labrador");

        //Creo el concurso con su mapa de perros.
        Map<String, Set<Perro>> m1 = new HashMap<>();
        Concurso c1 = new Concurso("Concurso1", "Sevilla", m1);

        System.out.println("=====================");
        System.out.println("| Probamos addDog() |");
        System.out.println("=====================");
        //AddDog() que corresponde raza y raza del perro.
        c1.addDog("Husky", p1);
        //AddDog() donde no corresponde raza y raza del perro.
        c1.addDog("Labrador", p2);
        //Añado 5 perros mas.
        c1.addDog("Husky", p2);
        c1.addDog("Pastor Aleman", p5);
        c1.addDog("Pastor Aleman", p6);
        c1.addDog("Labrador", p9);
        c1.addDog("Labrador", p10);

        System.out.println(m1.toString());

        System.out.println("============================");
        System.out.println("| Probamos disqualifyDog() |");
        System.out.println("============================");
        //Descalifico al perro p2.
        c1.disqualifyDog(p2);
        //Intendo descalificar a un perro que no esta inscrito.
        c1.disqualifyDog(p3);

        System.out.println(m1.toString());


        System.out.println("========================");
        System.out.println("| Probamos ownerDogs() |");
        System.out.println("========================");
        //Mostramos al socio 1 y 2.
        c1.ownerDogs(1);
        c1.ownerDogs(2);
        //Mostramos un socio que no participa.
        c1.ownerDogs(3);

        System.out.println("==============================================");
        System.out.println("| Probamos perrosporPeso() y perrosporEdad() |");
        System.out.println("==============================================");
        //Añado un par de perros para visualizar mejor la ordenacion.
        c1.addDog("Husky", p4);
        c1.addDog("Pastor Aleman", p8);

        c1.perrosporPeso("Husky");
        c1.perrosporEdad("Pastor Aleman");

        //Guardo los perros.
        c1.guardarPerros();

        System.out.println("==============");
        System.out.println("| Concurso 2 |");
        System.out.println("==============");
        //Creo otro concurso y cargo "perros.dat".
        Map<String, Set<Perro>> m2 = new HashMap<>();
        Concurso c2 = new Concurso("Concurso2", "Sevilla", m2);
        c2.cargarPerros();
        System.out.println(m2.toString());

    }
}
