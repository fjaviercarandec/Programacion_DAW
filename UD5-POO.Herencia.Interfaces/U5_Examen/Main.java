package examenHerenciaInterface;

public class Main {
    public static void main(String[] args) {
        //Creamos 5 personajes
        Elfo elf = new Elfo("Sylvanas", 500, 650, 100, true, Elfo.Tipo.BOSQUE);
        Orco orc = new Orco("Thrall", 850, 375, 250, false, 90);
        Enano ena = new Enano("Muradin", 900, 250, 400, false, 150);
        Guerrero war = new Guerrero("Varian", 600, 450, 200, false, 45);
        Mago wiz = new Mago("Jaina", 300, 800, 50, true, 60);

        //Creamos el rpg y llenamos la lista de Personajes
        Rpg warcraft = new Rpg(5);

        warcraft.añadirPersonaje(elf);
        warcraft.añadirPersonaje(wiz);
        warcraft.añadirPersonaje(orc);
        warcraft.añadirPersonaje(ena);
        warcraft.añadirPersonaje(war);

        //El mago realiza encantamientos
        wiz.desencantar(elf);
        wiz.encantar(ena);

        //Realizamos 5 ataques
        System.out.println(elf.atacarPersonaje(war));
        System.out.println(orc.atacarPersonaje(wiz));
        System.out.println(war.atacarPersonaje(ena));
        System.out.println(ena.atacarPersonaje(ena));
        System.out.println(war.atacarPersonaje(elf));
        System.out.println(war.atacarPersonaje(elf));

        //Eliminamos los muertos si es que hay
        warcraft.borrarMuertos();
        warcraft.borrarMuertos();

        //Mostramos el campo de batalla
        System.out.println("Mostrando campo ordenados por Energia...");
        System.out.println(warcraft.mostrarEstado());
        System.out.println("Mostrando campo ordenados por Ataque...");
        System.out.println(warcraft.mostarxAtaque());
        System.out.println("Mostrando campo ordenados por Defensa...");
        System.out.println(warcraft.mostrarxDefensa());

    }
}
