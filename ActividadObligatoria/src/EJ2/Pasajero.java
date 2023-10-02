package EJ2;

public class Pasajero extends Thread {
    private ControlTren trenViaje;
    private boolean viajo;
    private MaquinaTicket maquina;
    private boolean tieneTicket;

    // Contructor
    public Pasajero(String unNombre, ControlTren unTren, MaquinaTicket unaMaquina) {
        super(unNombre);
        this.trenViaje = unTren; 
        this.viajo = false;
        this.maquina = unaMaquina;
        this.tieneTicket = false;
    }

    public void run() {
        int nroAsiento = this.trenViaje.verificarAsiento();
        // Mientras no viaje, va a seguir intentando viajar.
        while (!viajo) {
            this.comprarTicket();
            if(tieneTicket){
                if (nroAsiento >= 0) {
                this.trenViaje.ocuparAsiento(nroAsiento);
                System.out.println("El pasajero "+this.getName()+" se sentó.");
                if(this.trenViaje.estadoViaje() == 0){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
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

    public void comprarTicket(){
        this.maquina.venderTicket();
        this.tieneTicket = true;
    }

}
