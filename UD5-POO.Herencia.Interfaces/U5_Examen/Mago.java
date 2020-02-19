package examenHerenciaInterface;

public class Mago extends Hombre implements Magia{
    private int barba;

    public Mago(String nombre, int energia, int ataque, int defensa, boolean encantado, int barba) {
        super(nombre, energia, ataque, defensa, encantado);
        this.barba = barba;
    }

    public int getBarba() {
        return barba;
    }

    public void setBarba(int barba) {
        this.barba = barba;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mago Barba = " + barba + '\n';
    }


}
