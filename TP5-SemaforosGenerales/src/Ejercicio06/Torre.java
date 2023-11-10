package Ejercicio06;

import java.util.concurrent.Semaphore;

public class Torre {
    private Semaphore pista, aterrizaje, despegue;

    public Torre() {
        pista = new Semaphore(1, true);
        aterrizaje = new Semaphore(10);
        despegue = new Semaphore(0);
    }

    public void empezarAterrizaje() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " va a aterrizar");
        if (!aterrizaje.tryAcquire()) {
            despegue.release();
            aterrizaje.acquire();
        }
        pista.acquire();
    }

    public void empezarDespegue() throws InterruptedException {
        despegue.acquire();
        System.out.println(Thread.currentThread().getName() + " va a despegar");
        pista.acquire();
    }

    public void finAterrizaje() {
        System.out.println(Thread.currentThread().getName() + " aterrizó");
        pista.release();
    }
    
    public void finDespegue() {
        System.out.println(Thread.currentThread().getName() + " despegó");
        aterrizaje.release(10);
    }
}