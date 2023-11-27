package EjercicioSemaforos;

class Embotellador extends Thread {
    private Fabrica fabrica;

    public Embotellador(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    public void run() {
        while (true) {
            fabrica.embotellar();
        }
    }
}

