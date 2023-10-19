package Ejercicio03;
public class Test {
    public static void main(String[] args) {
        int cantidadComedores = 5;
        Comedor comedor = new Comedor(cantidadComedores);

        for (int i = 0; i < 2; i++) {
            new Gato(comedor).start();
            new Perro(comedor).start();
        }
    }
}