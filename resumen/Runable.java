package resumen;

import java.util.Random;

public class Runable implements Runnable {
    private RecursoCompartido recurso;
    private int i, j;
    Random rand = new Random();

    public Runable(RecursoCompartido recurso) {
        this.recurso = recurso;
        i = 0;
    }

    public void run() {
        try {
            while (i++ < 3) {
                j = rand.nextInt(7); // Asigna valor random entre 0 y 4 eligiendo un metodo al azar
                switch (j) {
                    case 0: // SINCRONIZADO
                        recurso.accesoSincronizado();
                        Thread.sleep(1000);
                        recurso.salidaSincronizado();
                        break;
                    case 1: // SEMAFORO BINARIO
                        recurso.accesoSemBinario();
                        Thread.sleep(1000);
                        recurso.salidaSemBinario();
                        break;
                    case 2: // SEMAFORO GENERAL
                        recurso.accesoSemGeneral();
                        Thread.sleep(1000);
                        recurso.salidaSemGeneral();
                        break;
                    case 3: // MONITOR
                        recurso.accesoMonitor();
                        Thread.sleep(1000);
                        recurso.salidaMonitor();
                        break;
                    case 4: // LOCK
                        recurso.accesoLock();
                        Thread.sleep(1000);
                        recurso.salidaLock();
                        break;
                    case 5: // CONDICION SUMA
                        recurso.condicionSuma();
                        Thread.sleep(1000);
                        break;
                    case 6: // CONDICION RESTA
                        recurso.condicionResta();
                        Thread.sleep(1000);
                        break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
