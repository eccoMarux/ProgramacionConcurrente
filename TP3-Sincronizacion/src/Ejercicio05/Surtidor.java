package Ejercicio05;

class Surtidor {
    private int combustibleDisponible;

    public Surtidor(int cantCombustibleDisponible) {
        this.combustibleDisponible = cantCombustibleDisponible;
    }

    public synchronized void cargarCombustible(int cantidad) {
        if (cantidad <= combustibleDisponible) {
            combustibleDisponible -= cantidad;
            System.out.println("Se han cargado " + cantidad + " litros de combustible.");
            System.out.println("Combustible disponible en el surtidor: " + combustibleDisponible + " litros.");
        } else {
            System.out.println("No hay suficiente combustible disponible.");
        }
    }

}