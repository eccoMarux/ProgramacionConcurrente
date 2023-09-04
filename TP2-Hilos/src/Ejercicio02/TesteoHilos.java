package Ejercicio02;

public class TesteoHilos {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread miHilo = new MiEjecucion();
            miHilo.start();
            System.out.println("En el main. ");
        }

        System.out.println("--------- Modificado ---------");

        for (int i = 0; i < 10; i++) {
            Thread miHilo = new MiEjecucion();
            miHilo.start();
            System.out.println("En el main. ");
            try {
                miHilo.join();    
            } catch (Exception error) {
                System.err.println(error);
            }
        }

    }
}
