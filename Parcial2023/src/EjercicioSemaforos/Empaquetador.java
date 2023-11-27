package EjercicioSemaforos;

class Empaquetador extends Thread {
    private Fabrica fabrica;

    public Empaquetador(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    public void run() {
        while (true) {
            fabrica.empaquetar();
        }
    }
}

