package ej1;

public class Recepcionista extends Thread{
    private Emoterapia clinica;

    public Recepcionista(Emoterapia clinica){
        this.clinica = clinica;
    }

    public void run(){
        try {
            while (true) {
                clinica.atenderLlamado();
                Thread.sleep(5000);
                clinica.terminarLlamado();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
