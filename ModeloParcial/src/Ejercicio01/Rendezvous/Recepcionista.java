package Rendezvous;

public class Recepcionista extends Thread{
    private Hemoterapia clinica;

    public Recepcionista(Hemoterapia clinica){
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
