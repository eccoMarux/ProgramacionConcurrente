package Ejercicio07.EjercicioA;

public class Cliente {
    private String nombre;
    private int[] carroCompra;

    // Constructor y métodos de acceso
    public Cliente(String nombre, int[] carroCompra) {
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getCarroCompra() {
        return carroCompra;
    }
}