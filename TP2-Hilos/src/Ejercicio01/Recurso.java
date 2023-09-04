package Ejercicio01;

public class Recurso {
    static void uso() {
        Thread t = Thread.currentThread();
        System.out.println("Estoy en Clase Recurso: Soy " + t.getName());
    }
}


