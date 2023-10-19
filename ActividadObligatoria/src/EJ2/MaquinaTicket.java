package EJ2;

public class MaquinaTicket {

    private int cantVendidos;

    // Constructor
    public MaquinaTicket(){
        this.cantVendidos = 0;
    }

    // Metodo sincronizado de venta de tickets.
    public synchronized void venderTicket(){
        System.out.println("El pasajero "+Thread.currentThread().getName()+" esta comprando un ticket.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("El pasajero "+Thread.currentThread().getName()+" tiene un ticket.");
        this.cantVendidos++;
    }
    
}
