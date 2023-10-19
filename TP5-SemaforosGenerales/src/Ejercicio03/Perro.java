package Ejercicio03;

class Perro extends Thread {
    private Comedor comedor;

    public Perro(Comedor comedor) {
        this.comedor = comedor;
    }

    public void run() {
        try {
            while (true) {
                comedor.comePerro();
                comedor.liberarComedor();
                // Simulación de tiempo entre comidas de perros
                Thread.sleep(2500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}