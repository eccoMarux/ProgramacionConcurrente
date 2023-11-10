package Ejercicio02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class GestorCruce{
    private int semaforo;
    private ReentrantLock cruce;
    private Condition cochesNorte, cochesOeste;

    public GestorCruce() {
        cruce = new ReentrantLock(true);
        cochesNorte = cruce.newCondition();
        cochesOeste = cruce.newCondition();
        semaforo = 0; //0 pasa Oeste, 1 pasa Norte
    }

    public void llegaNorte() throws InterruptedException{ 
        cruce.lock();
        if (semaforo == 0) {
            System.out.println("El semaforo del Norte está en rojo. "+ Thread.currentThread().getName()+" está detenido.");
            cochesNorte.await();
        }
        cruce.unlock();
    }

    public void llegaOeste() throws InterruptedException{ 
        cruce.lock();
        if (semaforo == 1) {
            System.out.println("El semaforo del Oeste está en rojo. "+ Thread.currentThread().getName()+" está detenido.");
            cochesOeste.await();
        }
        cruce.unlock();
    }

    public void sale(){
        System.out.println(Thread.currentThread().getName() + " pasó.");
    }

    public void cambiaSemaforo() {
        cruce.lock();
        System.out.println("El semaforo cambia: "+ semaforo);
        if (semaforo == 1) { //Pasa Norte
            semaforo = 0;
            cochesNorte.signalAll();
        } else { //Pasa Oeste
            semaforo = 1;
            cochesOeste.signalAll();
        }
        cruce.unlock();
    }
}