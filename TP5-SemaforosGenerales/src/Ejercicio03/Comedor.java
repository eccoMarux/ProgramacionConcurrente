package Ejercicio03;

import java.util.concurrent.Semaphore;

class Comedor {
    private Semaphore seccionCriticaSemaforo;
    private Semaphore gatos;
    private Semaphore perros;
    private int cantidadComedores;

    public Comedor(int cantidad) {
        this.cantidadComedores = cantidad;
        this.seccionCriticaSemaforo = new Semaphore(1);
        this.gatos = new Semaphore(cantidad);
        this.perros = new Semaphore(cantidad);
    }

    /*
     * PENSAR!
     * Hola! COMENTARIO!! +
     * CUIDADO! Creo que se puede obviar la variable cantidad de comederos +
     * y evaluar en base a semaforos de perros y gatos que ya manejan la cantidad. +
     */

    public void comeGato() throws InterruptedException {
        seccionCriticaSemaforo.acquire();
        if (cantidadComedores > 0 && gatos.availablePermits() > 0) {
            gatos.acquire(); // Adquiere un plato.
            cantidadComedores--;
            // Informacion:
            System.out.println("Gatito está comiendo :3");
            seccionCriticaSemaforo.release(); // Una vez aqui puede soltar el permiso.
            Thread.sleep(1000); // Simulación de que come.
            gatos.release(); // Libera el plato
            // Informacion:
            System.out.println("Gatito terminó de comer :3");
        } else {
            System.out.println("No hay comederos disponibles para gatos :c");
            seccionCriticaSemaforo.release(); // Libera el permiso porque no hay comederos.
        }
    }

    public void comePerro() throws InterruptedException {
        seccionCriticaSemaforo.acquire();
        if (cantidadComedores > 0 && perros.availablePermits() > 0) {
            perros.acquire();// Adquiere un plato.
            cantidadComedores--;
            System.out.println("Perro comiendo :P");
            seccionCriticaSemaforo.release(); // Una vez aqui puede soltar el permiso.
            Thread.sleep(1000); // Simulación de que come.
            perros.release();
            // Informacion:
            System.out.println("Perro terminó de comer :P");
        } else {
            // Informacion:
            System.out.println("No hay comederos disponibles para perros :c");
            seccionCriticaSemaforo.release(); // Libera el permiso porque no hay comederos.
        }
    }

    public void liberarComedor() {
        boolean adquirido = false;
        try {
            adquirido = seccionCriticaSemaforo.tryAcquire(); // Intentar adquirir el semáforo de la sección crítica
            if (adquirido) {
                cantidadComedores++;
            } else {
                System.out.println("¡¡¡No se pudo adquirir el semáforo en liberarComedor()!!!");
            }
        } finally {
            if (adquirido) { // Liberar el semáforo si fue adquirido con éxito
                seccionCriticaSemaforo.release();
            }
        }
    }

}
