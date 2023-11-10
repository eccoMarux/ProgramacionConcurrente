package Ejercicio01;
import java.util.Random;

public class TemperaturaMedicion implements Runnable {
    private final Sala unaSala;

    public TemperaturaMedicion(Sala estaSala) {
        this.unaSala = estaSala;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int temperatura = medirTemperatura(); // Simula la medición de la temperatura.
                unaSala.notificarTemperatura(temperatura);
                Thread.sleep(1000); // Espera un segundo antes de la próxima medición.
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private int medirTemperatura() {
        // Simula la medición de la temperatura, puedes implementar tu lógica real aquí.
        Random random = new Random();
        return 25 + random.nextInt(11); // Temperatura aleatoria entre 25 y 35.
    }
}