package Ejercicio03;

class Gato extends Thread {
    private Comedor comedor;

    public Gato(Comedor comedor) {
        this.comedor = comedor;
    }

    public void run() {
        try {
            while (true) {
                comedor.comeGato();
                comedor.liberarComedor();
                // Simulación de tiempo entre comidas de gatos
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}