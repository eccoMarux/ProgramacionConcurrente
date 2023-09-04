package Ejercicio01;
public class Cliente extends Thread {
    public void run() {
        System.out.println("Estoy en Clase Cliente. Soy " + Thread.currentThread().getName());
        Recurso.uso();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        ;
    };
}
