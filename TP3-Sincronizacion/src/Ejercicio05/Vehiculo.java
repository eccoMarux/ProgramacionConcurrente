package Ejercicio05;

public class Vehiculo {
    protected String patente;
    protected String modelo;
    protected String marca;
    protected int km;

    //recordar que protected sirve para encapsular objetos. Solo Auto puede acceder a Vehiculo porque es
    //subclase.

    public Vehiculo(String patente, String modelo, String marca, int km) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.km = km;
    }
}
