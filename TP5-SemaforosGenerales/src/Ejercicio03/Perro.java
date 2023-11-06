package Ejercicio03;

class Perro extends Thread {
    private Comedor comedor;

    public Perro(Comedor comedor, String unNombre) {
        super(unNombre);
        this.comedor = comedor;
    }

    public void run() {
        while (true) {
            try {
                comedor.comer();
                Thread.sleep(2000); // Simular que el perro come
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}