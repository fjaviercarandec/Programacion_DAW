package examenHerenciaInterface;

public class Orco extends Personaje implements Atacar{
    private double tonelaje;

    public Orco(String nombre, int energia, int ataque, int defensa, boolean encantado, double tonelaje) {
        super(nombre, energia, ataque, defensa, encantado);
        this.tonelaje = tonelaje;
    }

    public double getTonelaje() {
        return tonelaje;
    }

    public void setTonelaje(double tonelaje) {
        this.tonelaje = tonelaje;
    }

    @Override
    public String atacarPersonaje(Personaje personaje) {
        if (personaje.getClass().equals(getClass())) {
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
        return super.toString() + ", Orco Tonelaje = " + tonelaje + '\n';
    }
}
