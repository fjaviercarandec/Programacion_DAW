package examenHerenciaInterface;

public class Guerrero extends Hombre implements Atacar{
    private int edad;

    public Guerrero(String nombre, int energia, int ataque, int defensa, boolean encantado, int edad) {
        super(nombre, energia, ataque, defensa, encantado);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
        return super.toString() + ", Guerrero Edad = " + edad + '\n';
    }
}
