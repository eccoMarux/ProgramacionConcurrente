package AlternativaMonserrat;

import java.util.concurrent.Semaphore;

public class controlTren extends Thread {
    private int capacidad;
    private Pasajero[] filaPasajeros;
    private Pasajero[] pasajerosSentados;
    Semaphore trenSale;
    Semaphore trenLLega;

    public controlTren(int capacidadTren, Pasajero[] arrPasajeros) {
        this.capacidad = capacidadTren;
        this.filaPasajeros = arrPasajeros;
    }

    public void run() {
        int cantPasajerosFila = this.filaPasajeros.length;
        while (cantPasajerosFila > 0) {
            // llamado a los modulos
        }
    }

    public void llenarTren() {
        for (int i = 0; i < this.capacidad; i++) {
            /*
             * arreglo de pasajeros sentados llenarlo simulando entran. Si estan en el
             * arreglo, no pueden bajarse. Semaforo retenido.
             */
        }
        System.out.println("El tren esta lleno.");
    }

    public void bajarTren() {
        // Permitir la bajada de pasajeros. Semaforo devuelto a los pasajeros. 
    }

    public void viajarTren() {
        System.out.println("El tren esta viajando!!! :D");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
