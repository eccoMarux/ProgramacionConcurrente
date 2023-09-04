package Ejercicio06;

import java.util.Random;

class Corredor extends Thread {
    private String nombre;
    private int distanciaRecorrida;

    public Corredor(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }

    public void run() {
        Random random = new Random();

        //Cada hilo hara 10 repeticiones.
        for (int i = 0; i < 10; i++) {
            int avance = random.nextInt(10) + 1;
            distanciaRecorrida += avance;

            System.out.println(
                    nombre + " ha avanzado " + avance + " metros. Distancia total: " + distanciaRecorrida + " metros.");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public String getNombre() {
        return nombre;
    }
}
