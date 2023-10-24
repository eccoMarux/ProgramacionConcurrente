package Ejercicio03;

class Gato extends Thread {
    private Comedor comedor;

    public Gato(Comedor comedor, String unNombre) {
        super(unNombre);
        this.comedor = comedor;
    }

    public void run() {
        while (true) {
            try {
                comedor.comer();
                Thread.sleep(1000); // Simular que el perro come
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}