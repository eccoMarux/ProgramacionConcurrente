package Secuencial;

public class Main {
    public static void main(String[] args) {
        Hemoterapia clinica = new Hemoterapia(5);
        Donante unDonante;
        int i = 0;

        while (i++ < 2) {
            unDonante = new Donante(clinica);
            unDonante.setName("Donante " + i);
            unDonante.start();
        }
    }
}
