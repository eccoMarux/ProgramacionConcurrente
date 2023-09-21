package Ejercicio07;

public class Main {
    public static void main(String[] args) {
        Thread hiloA;
        Thread hiloB;
        Thread hiloC;
        hiloA = new Thread(new HiloRepetidor('A', 4));
        hiloB = new Thread(new HiloRepetidor('B', 2));
        hiloC = new Thread(new HiloRepetidor('C', 5));

        hiloA.start();
        hiloB.start();
        hiloC.start();

        try {
            hiloA.join();
            hiloB.join();
            hiloC.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //Revisar porque no funciona.

    }
}
