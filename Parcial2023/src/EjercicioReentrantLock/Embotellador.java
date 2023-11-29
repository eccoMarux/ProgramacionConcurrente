package EjercicioReentrantLock;

public class Embotellador extends Thread {
    Planta planta;
    boolean vino;

    public Embotellador(Planta planta, boolean vino) {
        this.planta = planta;
        this.vino = vino;
    }

    public void run() {
        while (true) {
            if (vino) {
                planta.empezarVino();
                planta.terminarVino();
            } else {
                planta.empezarAgua();
                planta.terminarAgua();
            }
        }
    }
}
