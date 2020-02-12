package examen;

public class Elfo extends Personaje implements Atacar {
    enum Tipo{BOSQUE, COSTA};

    private Tipo tipo;

    public Elfo(String nombre, int energia, int ataque, int defensa, boolean encantado, Tipo tipo) {
        super(nombre, energia, ataque, defensa, encantado);
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
        return super.toString() + ", Elfo Tipo = " + tipo + '\n';
    }
}
