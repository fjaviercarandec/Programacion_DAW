package examenHerenciaInterface;

public interface Magia {
    default void encantar(Personaje personaje) {
        personaje.setEncantado(true);
    }
    default void desencantar(Personaje personaje) {
        personaje.setEncantado(false);
    }
}
