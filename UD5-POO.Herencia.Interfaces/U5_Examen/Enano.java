package examen;

public class Enano extends Personaje implements Atacar{
    private int altura;

    public Enano(String nombre, int energia, int ataque, int defensa, boolean encantado, int altura) {
        super(nombre, energia, ataque, defensa, encantado);
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String atacarPersonaje(Personaje personaje) {
        if (personaje.getNombre().equals(getNombre())) {
            return "Te atacas tu mismo. No surge efecto.";
        } else {
            if (personaje.isEncantado()) {
                personaje.setEnergia(personaje.getEnergia() - ((getAtaque() - personaje.getDefensa())*2));
            } else {
                personaje.setEnergia(personaje.getEnergia() - (getAtaque() - personaje.getDefensa()));
            }
            return getNombre().toUpperCase() + " - ATACANDO";
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Enano Altura = " + altura + '\n';
    }
}
