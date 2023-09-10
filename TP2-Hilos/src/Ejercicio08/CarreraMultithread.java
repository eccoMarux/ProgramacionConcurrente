package Ejercicio08;

public class CarreraMultithread {
    public static void main(String[] args) {
        
        //Realice el ejercicio 6 utilizando la interfaz Runnable
        
        int numCorredores = 5;
        Corredor[] corredores = new Corredor[numCorredores];
        Thread[] hilos = new Thread[numCorredores];

        // Crear corredores y hilos
        for (int i = 0; i < numCorredores; i++) {
            corredores[i] = new Corredor("Corredor " + (i + 1));
            hilos[i] = new Thread(corredores[i]);
        }

        // Iniciar los hilos (comienza la carrera)
        for (Thread hilo : hilos) {
            hilo.start();
        }

        // Esperar a que todos los corredores terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Encontrar al corredor que recorrió la mayor distancia
        Corredor ganador = corredores[0];
        for (int i = 1; i < numCorredores; i++) {
            if (corredores[i].getDistanciaRecorrida() > ganador.getDistanciaRecorrida()) {
                ganador = corredores[i];
            }
        }

        System.out.println("El corredor ganador es " + ganador.getNombre() +
                " con una distancia recorrida de " + ganador.getDistanciaRecorrida() + " metros.");
    }
}