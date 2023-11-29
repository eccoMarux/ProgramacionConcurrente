package EjercicioReentrantLock;

public class Repartidor extends Thread{
    Planta planta;

    public Repartidor(Planta planta) {
        this.planta = planta;
    }

    public void run() {
        try {
            while (true) {
                planta.transportar();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
