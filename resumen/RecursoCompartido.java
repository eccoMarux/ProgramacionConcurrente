package resumen;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RecursoCompartido {
    private int recurso;
    private Semaphore semBinario, semGeneral;
    private ReentrantLock lock, acceso;
    private Condition condicionSuma, condicionResta;

    public RecursoCompartido() {
        recurso = 10;
        // SEMAFOROS
        semBinario = new Semaphore(1, true); // El true hace que tenga orden de espera.
        semGeneral = new Semaphore(5);

        // LOCKS
        lock = new ReentrantLock(true); // El true hace que tenga orden de espera.
        acceso = new ReentrantLock();

        // CONDICIONES
        condicionSuma = acceso.newCondition();
        condicionResta = acceso.newCondition();
    }

    // METODOS SINCRONIZADO
    public synchronized void accesoSincronizado() {
        recurso -= 1;
        System.out.println("El recurso baja a: " + recurso + ". Cambiado por Synchonized");
    }

    public synchronized void salidaSincronizado() {
        recurso += 1;
        System.out.println("El recurso sube a: " + recurso + ". Cambiado por Synchonized");
    }

    // SEMAFORO BINARIO
    public void accesoSemBinario() throws InterruptedException {
        semBinario.acquire();
        recurso -= 1;
        System.out.println("El recurso baja a: " + recurso + ". Cambiado por semBinario");
    }

    public void salidaSemBinario() throws InterruptedException {
        recurso += 1;
        System.out.println("El recurso sube a: " + recurso + ". Cambiado por semBinario");
        semBinario.release();
    }

    // SEMAFORO GENERAL
    public void accesoSemGeneral() throws InterruptedException {
        semGeneral.acquire();
        recurso -= 1;
        System.out.println("El recurso baja a: " + recurso + ". Cambiado por semGeneral");
    }

    public void salidaSemGeneral() throws InterruptedException {
        recurso += 1;
        System.out.println("El recurso sube a: " + recurso + ". Cambiado por semGeneral");
        semGeneral.release();
    }
    
    // MONITOR
    public synchronized void accesoMonitor() throws InterruptedException {
        while (recurso <= 5) {
            System.out.println("El recurso es muy bajo, Monitor a esperar.");
            wait();
        }
        recurso -= 1;
        System.out.println("El recurso baja a: " + recurso + ". Cambiado por Monitor");
    }
    
    public synchronized void salidaMonitor() {
        recurso += 1;
        notify();
        System.out.println("El recurso sube a: " + recurso + ". Cambiado por Monitor");
    }
    
    // LOCK
    public void accesoLock() {
        lock.lock();
        recurso -= 1;
        System.out.println("El recurso baja a: " + recurso + ". Cambiado por Lock");
    }

    public void salidaLock() {
        recurso += 1;
        System.out.println("El recurso sube a: " + recurso + ". Cambiado por Lock");
        lock.unlock();
    }

    // LOCK Y CONDICIONES
    public void condicionSuma() throws InterruptedException {
        acceso.lock();
        while (recurso == 10) {
            System.out.println("El recurso está al maximo, CondicionSuma a esperar.");
            condicionResta.signal();
            condicionSuma.await();
        }
        recurso++;
        condicionResta.signal();
        System.out.println("El recurso sube a: " + recurso + ". Cambiado por CondicionSuma");
        acceso.unlock();
    }

    public void condicionResta() throws InterruptedException {
        acceso.lock();
        while (recurso == 0) {
            System.out.println("El recurso está al minimo, CondicionResta a esperar.");
            condicionSuma.signal();
            condicionResta.await();
        }
        recurso--;
        condicionSuma.signal();
        System.out.println("El recurso baja a: " + recurso + ". Cambiado por CondicionResta");
        acceso.unlock();
    }
}
