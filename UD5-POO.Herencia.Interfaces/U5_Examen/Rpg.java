package examen;

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
        if (this.personajes.length < 10) {
            for (int i = 0; i < this.personajes.length; i++) {
                if (this.personajes[i] == null) {
                    this.personajes[i] = personaje;
                    break;
                }
                if (this.personajes[i] != null && i == this.personajes.length-1 && this.personajes.length < 10) {
                    Personaje[] aux = new Personaje[this.personajes.length+1];
                    aux[this.personajes.length+1] = this.personajes[this.personajes.length-1];
                    this.personajes = aux;
                }
            }
        } else {
            System.out.println("Grupo de personajes completo.");
        }

    }

    public void borrarMuertos() {
        boolean muerto = false;
        for (int i = 0; i < this.personajes.length; i++) {
            if (this.personajes[i].getEnergia() <= 0) {
                muerto = true;
            }
            if (muerto && i < this.personajes.length-1) {
                this.personajes[i] = this.personajes[i+1];
            } else if (muerto && i == this.personajes.length-1) {
                Personaje[] aux = new Personaje[this.personajes.length-1];
                for (int j = 0; j < aux.length; j++) {
                    aux[j] = this.personajes[j];
                }
                this.personajes = aux;
            }
        }
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
        if (this.personajes.length == 1) {
            return Arrays.deepToString(this.personajes);
        } else {
            return "Aun no hay ganador.";
        }
    }

}
