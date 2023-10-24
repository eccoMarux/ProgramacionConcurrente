package Ejercicio03;

import java.util.concurrent.Semaphore;

class Comedor {
    private Semaphore comenGatos; // Generico
    private Semaphore comenPerros; // Generico
    private int cantComederos;

    public Comedor(int capacidad) {
        comenGatos = new Semaphore(capacidad);
        comenPerros = new Semaphore(0);
        cantComederos = capacidad;
    }

    public void comer() throws InterruptedException {
        char tipoAnimal = Thread.currentThread().getName().charAt(0);
        if (tipoAnimal == 'G') {
            if (comenGatos.availablePermits() == 0) {
                comenPerros.release(cantComederos);
            }
            try {
                comenGatos.acquire();
                System.out.println(Thread.currentThread().getName() + " está comiendo.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (tipoAnimal == 'P') {
            if (comenPerros.availablePermits() == 0) {
                comenGatos.release(cantComederos);
            }
            try {
                comenPerros.acquire();
                System.out.println(Thread.currentThread().getName() + " está comiendo.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}