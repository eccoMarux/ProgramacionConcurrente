package EjercicioReentrantLock;

public class Main {
    public static void main(String[] args) {
        Planta planta = new Planta();
        Empaquetador emp = new Empaquetador(planta);
        Repartidor rep = new Repartidor(planta);
        int i = 0;

        emp.start();
        rep.start();
        while (i++ < 50) {
            Embotellador vino = new Embotellador(planta, true);
            vino.start();
            Embotellador agua = new Embotellador(planta, false);
            agua.start();
        }
    }
}   
