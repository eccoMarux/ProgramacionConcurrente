package Ejercicio07.EjercicioB;
import Ejercicio07.EjercicioA.Cliente;

public class MainThread {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

        long initialTime = System.currentTimeMillis();

        CajeroThread cajero1 = new CajeroThread("Cajero 1", cliente1, initialTime);
        CajeroThread cajero2 = new CajeroThread("Cajero 2", cliente2, initialTime);

        cajero1.start();
        cajero2.start();

        try {
            cajero1.join();
            cajero2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
