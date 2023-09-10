package Ejercicio08;

import java.util.Random;

class Corredor implements Runnable {

    //Realice el ejercicio 6 utilizando la interfaz Runnable
    
    private String nombre;
    private int distanciaRecorrida;

    public Corredor(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }

    public void run() {
        System.out.println(nombre + " comienza la carrera.");
        Random random = new Random();

        for (int paso = 1; paso <= 100; paso++) {
            int avance = random.nextInt(10) + 1;
            distanciaRecorrida += avance;
            System.out.println(nombre + " avanzó " + avance + " metros (Distancia total: " + distanciaRecorrida + " metros)");

            try {
                Thread.sleep(100); // Simula el tiempo entre pasos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(nombre + " ha terminado la carrera.");
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public String getNombre() {
        return nombre;
    }
}