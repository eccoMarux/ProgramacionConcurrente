package Secuencial;

import java.util.concurrent.Semaphore;

public class Hemoterapia {
    private Semaphore llamada, salaEspera, entrevista, extraccion;

    public Hemoterapia(int cant) {
        llamada = new Semaphore(1, true);
        salaEspera = new Semaphore(cant, true);
        entrevista = new Semaphore(1, true);
        extraccion = new Semaphore(1, true);
    }

    public void llamar() throws InterruptedException {
        llamada.acquire();
        System.out.println(Thread.currentThread().getName() + " está llamando.");
        Thread.sleep(1000);
        llamada.release();
    }

    public void salaEspera() throws InterruptedException {
        salaEspera.acquire();
        System.out.println(Thread.currentThread().getName() + " está esparando.");
        Thread.sleep(1000);
    }

    public void entrevistaMedica() throws InterruptedException {
        entrevista.acquire();
        System.out.println(Thread.currentThread().getName() + " empezó entrevista.");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " terminó entrevista");
        entrevista.release();
    }

    public void extraccionSangre() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " no volverá a la sala de espera. El asiento quedó libre.");
        salaEspera.release();
        extraccion.acquire();
        System.out.println(Thread.currentThread().getName() + " le estan extrayendo sangre.");
        Thread.sleep(1000);
        System.out.println("Terminó la extracción. " + Thread.currentThread().getName() + " recibe certificado. ");
        extraccion.release();
    }

    public void desayuno() throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " está desayunando.");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " se fué");
    }
}
