package Ejercicio05;
class Surtidor {
    private int capacidadActual;

    public Surtidor(int capacidadInicial) {
        this.capacidadActual = capacidadInicial;
    }

    public synchronized void abastecer(Auto auto) {
        //Se asume que se carga el tanque completamente.
        if (this.capacidadActual < auto.getCapacidadTanque()) {
            this.capacidadActual -= auto.getCapacidadTanque();
            System.out.println("El auto " + auto.patente + " cargó combustible del surtidor. \nNivel actual del surtidor: " + capacidadActual + " litros.");
        }
    }
}