package EjercicioSemaforos;

public class Main {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();

        // Crear varios hilos de embotelladores de Vino
        for (int i = 0; i < 3; i++) {
            Embotellador embotelladorVino = new Embotellador(fabrica);
            embotelladorVino.setName("Vino" + (i + 1));
            embotelladorVino.start();
        }

        // Crear varios hilos de embotelladores de Agua
        for (int i = 0; i < 3; i++) {
            Embotellador embotelladorAgua = new Embotellador(fabrica);
            embotelladorAgua.setName("AguaSaborizada-" + (i + 1));
            embotelladorAgua.start();
        }

        // Crear un hilo de empaquetador
        Empaquetador empaquetador = new Empaquetador(fabrica);
        empaquetador.setName("Empaquetador");
        empaquetador.start();

        // Crear un hilo de transportador
        Transportador transportador = new Transportador(fabrica);
        transportador.setName("Transportador");
        transportador.start();
    }
}
