package Ejercicio05.EjercicioC_extendThread;

class MiHiloThread extends Thread {
    String nombreHilo;

    public MiHiloThread(String nombre) {
        nombreHilo = nombre;
    }

    // Punto de entrada del hilo
    // Los hilos comienzan a ejecutarse aquí
    public void run() {

        System.out.println("Comenzando " + nombreHilo);

        for (int contar = 0; contar < 10; contar++) {
            // Thread.sleep(400);
            System.out.println("En " + nombreHilo + ", el recuento " + contar);
        }

        System.out.println("Terminando " + nombreHilo);
    }
}