package Ejercicio04;

public class ThreadRunnable implements Runnable {
    
    String nombre;

    public ThreadRunnable(String str) {
        nombre = str;
    }

    public void run() {
        for (int i = 0; i < 10 ; i++)
        System.out.println(i + " " + nombre);
        System.out.println("Termina thread " + nombre);
    }
}