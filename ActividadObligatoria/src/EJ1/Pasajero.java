package EJ1;

public class Pasajero extends Thread {
    private ControlTren trenViaje;
    private boolean viajo;

    // Contructor
    public Pasajero(String unNombre, ControlTren unTren) {
        super(unNombre);
        this.trenViaje = unTren; 
        this.viajo = false;
    }

    public void run() {
        int nroAsiento = this.trenViaje.verificarAsiento();
        // Mientras no viaje, va a seguir intentando viajar.
        while (!viajo) {
            if (nroAsiento >= 0) {
                this.trenViaje.ocuparAsiento(nroAsiento);
                System.out.println("El pasajero "+this.getName()+" se sentó.");
                if(this.trenViaje.estadoViaje() == 0){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                this.trenViaje.liberarAsiento(nroAsiento);
                System.out.println("El pasajero "+this.getName()+" se bajó.");
                viajo = true;
            }
        }

    }

}
