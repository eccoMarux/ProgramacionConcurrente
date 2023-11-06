package Ejercicio03;

import java.util.concurrent.Semaphore;

class Comedor {
    private Semaphore comenGatos; // Generico
    private Semaphore comenPerros; // Generico
    private int cantComederos;
    private int contador;

    public Comedor(int capacidad) {
        comenGatos = new Semaphore(capacidad);
        comenPerros = new Semaphore(0);
        cantComederos = capacidad;
        contador = 0;
    }

    public void comer() throws InterruptedException {
        char tipoAnimal = Thread.currentThread().getName().charAt(0);
        if (tipoAnimal == 'G') {
            if (comenGatos.availablePermits() == 0 || contador > cantComederos) {
                comenPerros.release(cantComederos);
                contador =0;
            }
            try {
                contador++;
                comenGatos.acquire();
                System.out.println(Thread.currentThread().getName() + " está comiendo.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (tipoAnimal == 'P') {
            if (comenPerros.availablePermits() == 0 || contador > cantComederos) {
                comenGatos.release(cantComederos);
                contador =0;
            }
            try {
                contador++;
                comenPerros.acquire();
                System.out.println(Thread.currentThread().getName() + " está comiendo.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}