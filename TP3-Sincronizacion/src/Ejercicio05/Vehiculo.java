package Ejercicio05;

class Vehiculo {
    protected String patente;
    protected String modelo;
    protected String marca;
    protected int kilometraje;

    public Vehiculo(String patente, String modelo, String marca) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.kilometraje = 0;
    }

    public void setKilometraje(int distancia) {
        this.kilometraje += distancia;
    }
}