package Ejercicio05;

class Auto extends Vehiculo implements Runnable {
    private int tanque; //se asume que estos autos tendran tanque y no seran electricos.
    public Auto(String patente, String modelo, String marca, int km, int capacidadTanque) {
        super(patente, modelo, marca, km);
        this.tanque = capacidadTanque;
    }

    public void run() {
        //Terminar logica.
    }
}
