package EjercicioSemaforos;

class Transportador extends Thread {
    private Fabrica fabrica;

    public Transportador(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    public void run() {
        while (true) {
            fabrica.transportar();
        }
    }
}
