package Ejercicio03;

public class Hamster implements Runnable {
    private String nombre;
    private Jaula jaula;

    public Hamster(String unNombre, Jaula unaJaula) {
        this.nombre = unNombre;
        this.jaula = unaJaula;
    }

    public void run() {
        jaula.comer(nombre);
        jaula.correr(nombre);
        jaula.descansar(nombre);
    }
}
