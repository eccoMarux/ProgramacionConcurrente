package Ejercicio05.EjercicioC_extendThread;

public class UsoHilosThread {
    public static void main(String[] args) {

        System.out.println("Hilo principal iniciando.");
        // Primero, construye un objeto unHilo.
        new MiHiloThread("#1").start();
        new MiHiloThread("#2").start();
        new MiHiloThread("#3").start();

        for (int i = 0; i < 50; i++) {
            System.out.print(" .");
        }

        System.out.println("Hilo principal finalizado.");

    }

}