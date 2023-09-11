package Ejercicio03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Jaula {
    private Lock lockComedero = new ReentrantLock();
    private Lock lockRueda = new ReentrantLock();
    private Lock lockHamaca = new ReentrantLock();

    public void comer(String nombre) {
        lockComedero.lock();
        try {
            System.out.println("Hámster " + nombre + " está comiendo.");
            Thread.sleep(2000); // Simular tiempo de comer
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockComedero.unlock();
        }
    }

    public void correr(String nombre) {
        lockRueda.lock();
        try {
            System.out.println("Hámster " + nombre + " está corriendo en la rueda.");
            Thread.sleep(1500); // Simular tiempo de correr
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockRueda.unlock();
        }
    }

    public void descansar(String nombre) {
        lockHamaca.lock();
        try {
            System.out.println("Hámster " + nombre + " está descansando en la hamaca.");
            Thread.sleep(3000); // Simular tiempo de descanso
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockHamaca.unlock();
        }
    }
}
