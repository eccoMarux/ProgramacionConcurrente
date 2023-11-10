package Ejercicio02;

public class Test {
    public static void main(String[] args) {
        GestorCruce cruce = new GestorCruce();
        Semaforo semaforo = new Semaforo(cruce);
        semaforo.start();
        Coche coche;

        int i = 0;
        while (i++ < 9) {
            coche = new Coche(cruce);
            coche.setName("Coche-" + i);
            coche.start();
        }

    }
}
