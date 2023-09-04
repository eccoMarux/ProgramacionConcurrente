package Ejercicio06;

public class CarreraMultiThread {
    public static void main(String[] args) {
        int numCorredores = 3; // Cambiar dependiendo de cantidad de corredores.

        Corredor[] corredores = new Corredor[numCorredores];
        Thread[] hilos = new Thread[numCorredores];

        /*
         * Inicializa los corredores con su nombre y los hilos. Ademas los deja en
         * estado Listo.
         */
        for (int i = 0; i < numCorredores; i++) {
            corredores[i] = new Corredor("Corredor " + (i));
            /* hilos[i] = new Thread(corredores[i], "Hilo " + (i + 1));
             * se agrega el segundo parametro para que coincida el nombre del hilo
             * con el nombre del corredor.
             * De no hacerlo los nombres de los hilos se asignan automáticamente por el
             * sistema y puede no coincidir con el nombre del corredor.
             */
            hilos[i] = new Thread(corredores[i]);
            hilos[i].start();
        }

        // Espera a que todos los corredores terminen de ejecutarse para continuar.
        try {
            for (int i = 0; i < numCorredores; i++) {
                hilos[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Encuentra al corredor con la mayor distancia recorrida.
        Corredor ganador = corredores[0];
        for (int i = 1; i < numCorredores; i++) {
            if (corredores[i].getDistanciaRecorrida() > ganador.getDistanciaRecorrida()) {
                ganador = corredores[i];
            }
        }

        // Muestra info. del ganador.
        System.out.println("El ganador es " + ganador.getNombre() + " (Nombre del hilo: " + ganador.getName()
                + ") con una distancia de " + ganador.getDistanciaRecorrida() + " metros.");
    }
}
