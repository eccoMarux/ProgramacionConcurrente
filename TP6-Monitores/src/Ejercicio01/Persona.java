package Ejercicio01;

import java.util.Random;

public class Persona extends Thread {
    private final Sala unaSala;
    private final boolean esJubilado;

    public Persona(Sala unaSala, boolean esJubilado) {
        this.unaSala = unaSala;
        this.esJubilado = esJubilado;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000)); // Simula el tiempo antes de entrar a la sala.

            if (esJubilado) {
                unaSala.entrarSalaJubilado();
                System.out.println("Persona jubilada entró a la sala.");
            } else {
                unaSala.entrarSala();
                System.out.println("Persona entró a la sala.");
            }

            Thread.sleep(new Random().nextInt(1000)); // Simula el tiempo dentro de la sala.

            unaSala.salirSala();
            System.out.println("Persona salió de la sala.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
