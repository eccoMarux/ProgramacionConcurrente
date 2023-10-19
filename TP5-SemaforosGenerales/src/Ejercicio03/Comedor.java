package Ejercicio03;

import java.util.concurrent.Semaphore;

class Comedor {
    private Semaphore seccionCriticaSemaforo;
    private Semaphore gatos;
    private Semaphore perros;
    private int cantComederos;

    public Comedor(int cantidadComederos) {
        this.cantComederos = cantidadComederos;
        this.seccionCriticaSemaforo = new Semaphore(1);
        this.gatos = new Semaphore(cantidadComederos);
        this.perros = new Semaphore(cantidadComederos);
    }

    /* PENSAR!
     * Hola! Dejo COMENTARIOS Y MEJORAS!! 
     * CUIDADO 1! Creo que se puede obviar la variable cantComederos de comederos 
     * y evaluar en base a semaforos de perros y gatos que ya manejan la cantComederos. 
     * CUIDADO 2! Verificar si liberarComedor() puede trabajar de otra forma.
     */

    public void comeGato() throws InterruptedException {
        seccionCriticaSemaforo.acquire();//INICIO SECCION CRITICA.
        if (cantComederos > 0 && gatos.availablePermits() > 0) {
            gatos.acquire(); // Adquiere un plato.
            cantComederos--;
            // Informacion:
            System.out.println("Gatito está comiendo :3");
            seccionCriticaSemaforo.release(); //FIN SECCION CRITICA.
            Thread.sleep(1000); // Simulación de que come.
            gatos.release(); // Libera el plato.
            // Informacion:
            System.out.println("Gatito terminó de comer :3");
        } else {
            System.out.println("No hay comederos disponibles para gatos :c");
            seccionCriticaSemaforo.release(); // Libera el permiso porque no hay comederos.
        }
    }

    public void comePerro() throws InterruptedException {
        seccionCriticaSemaforo.acquire();//INICIO SECCION CRITICA.
        if (cantComederos > 0 && perros.availablePermits() > 0) {
            perros.acquire();// Adquiere un plato.
            cantComederos--;
            System.out.println("Perro comiendo :P");
            seccionCriticaSemaforo.release(); // FIN SECCION CRITICA.
            Thread.sleep(1000); // Simulación de que come.
            perros.release(); // Libera el plato.
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
            adquirido = seccionCriticaSemaforo.tryAcquire(); // Intentar adquirir el semáforo de la sección crítica.
            if (adquirido) {
                cantComederos++;
            } else {
                System.out.println("¡¡¡No se pudo adquirir el semáforo en liberarComedor()!!!");
            }
        } finally { 
            if (adquirido) { // Liberar el semáforo si fue adquirido.
                seccionCriticaSemaforo.release();
            }
        }
    }

}
