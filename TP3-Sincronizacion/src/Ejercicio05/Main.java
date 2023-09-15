package Ejercicio05;

public class Main {
    public static void main(String[] args) {
        Surtidor surtidor = new Surtidor(100); // Capacidad inicial del surtidor

        Auto auto1 = new Auto("Auto1", "Modelo1", "Marca1", 50, 10, 1000, surtidor); 
        Thread thread1 = new Thread(auto1);

        Auto auto2 = new Auto("Auto2", "Modelo2", "Marca2", 50, 10, 500, surtidor); 
        Thread thread2 = new Thread(auto2);

        Auto auto3 = new Auto("Auto3", "Modelo3", "Marca3", 50, 10, 600, surtidor); 
        Thread thread3 = new Thread(auto3);

        Auto auto4 = new Auto("Auto4", "Modelo4", "Marca4", 50, 10, 400, surtidor); 
        Thread thread4 = new Thread(auto4);

        Auto auto5 = new Auto("Auto5", "Modelo5", "Marca5", 50, 10, 200, surtidor); 
        Thread thread5 = new Thread(auto5);

        // Iniciar los hilos de los autos
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

