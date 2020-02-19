package examenHerenciaInterface;

import java.util.Arrays;

public class Rpg{
    private int tamanyo;
    private Personaje[] personajes;

    public Rpg(int tamanyo) {
        if (tamanyo <= 10) {
            this.personajes = new Personaje[tamanyo];
        }
    }

    public int getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(int tamanyo) {
        this.tamanyo = tamanyo;
    }

    public Personaje[] getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Personaje[] personajes) {
        this.personajes = personajes;
    }

    public void añadirPersonaje(Personaje personaje) {
        if (personajes!=null) {
            if (personajes.length==10) {
                System.out.println("No se pueden añadir más personajes a la partida");
            } else {
                Personaje[] p1 = new Personaje[personajes.length+1];
                for (int i = 0; i < personajes.length ; i++) {
                    p1[i] = personajes[i];
                }
                p1[personajes.length] = personaje;
                personajes = p1;
            }
        } else {
            personajes = new Personaje[1];
            personajes[0] = personaje;
        }
    }

    public void borrarMuertos() {
        int numMuertos = 0;
        for (int i = 0; i < personajes.length ; i++) {
            if (personajes[i].getEnergia() <= 0) {
                numMuertos++;
            }
        }
        Personaje[] p1 = new Personaje[personajes.length-numMuertos];
        int j=0;
        for (int i = 0; i < personajes.length ; i++) {
            if (personajes[i].getEnergia() > 0) {
                p1[j] = personajes[i];
                j++;
            }
        }
        personajes = p1;
    }

    public String mostrarEstado() {
        Arrays.sort(this.personajes);
        return Arrays.deepToString(this.personajes);
    }

    public String mostarxAtaque() {
        Arrays.sort(this.personajes, new ComparaPorAtaque());
        return Arrays.deepToString(this.personajes);
    }

    public String mostrarxDefensa() {
        Arrays.sort(this.personajes, new ComparaPorDefensa());
        return Arrays.deepToString(this.personajes);
    }

    public String hayGanador() {
        String res = "Aun no existe ganador.";
        if (this.personajes.length == 1 && this.personajes[0].getEnergia() > 0) {
            res = this.personajes[0].getNombre() + " es el ganador.";
        }
        return res;
    }

}
