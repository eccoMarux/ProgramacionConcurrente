package Ejercicio01;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Sala {
    private final ReentrantLock lock;
    private final Condition temperaturaAlta;
    private final Condition jubiladosEsperando;
    
    private int cantidadPersonas;
    private int temperaturaInicial;
    private final int tUmbral; 
    private final int capacidadMaxima;
    private final int capacidadReducida;
    private boolean jubiladoEsperando;

    public Sala(boolean esJubilado) {
        this.cantidadPersonas = 0;
        this.temperaturaInicial = 25;
        this.tUmbral = 30;
        this.capacidadMaxima = 50;
        this.capacidadReducida = 35;
        this.jubiladoEsperando = esJubilado;
        this.lock = new ReentrantLock();
        this.temperaturaAlta = lock.newCondition();
        this.jubiladosEsperando = lock.newCondition();
    }

    public void entrarSala() {
        lock.lock();
        try {
            while (temperaturaInicial > tUmbral && cantidadPersonas >= capacidadReducida) {
                temperaturaAlta.await();
            }

            if (jubiladoEsperando) {
                jubiladosEsperando.signal();
            }

            cantidadPersonas++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void entrarSalaJubilado() {
        lock.lock();
        try {
            jubiladoEsperando = true;
            while (temperaturaInicial > tUmbral && cantidadPersonas >= capacidadReducida) {
                jubiladosEsperando.await();
            }
            jubiladoEsperando = false;

            cantidadPersonas++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void salirSala() {
        lock.lock();
        try {
            cantidadPersonas--;

            if (temperaturaInicial > tUmbral && cantidadPersonas < capacidadReducida) {
                temperaturaAlta.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void notificarTemperatura(int temperaturaInicial) {
        lock.lock();
        try {
            this.temperaturaInicial = temperaturaInicial;
            if (temperaturaInicial > tUmbral && cantidadPersonas > capacidadReducida) {
                temperaturaAlta.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
