package AlternativaMonserrat;

import java.util.concurrent.Semaphore;

public class Pasajero extends Thread {
    private Semaphore pasajeroRetenido;

    public Pasajero(String unNombre) {
        super(unNombre);
    }

    @Override
    public void run() {
        this.abordarTren();
        this.bajarDelTren();
    }

    private void abordarTren() {
        
        try {
            this.pasajeroRetenido.acquire();
            System.out.println("El pasajero "+this.getName()+" se sentó.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void bajarDelTren() {
        this.pasajeroRetenido.release();
        System.out.println("Pasajero " + this.getName() + " bajando del tren.");
    }
}
