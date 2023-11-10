package Rendezvous;

public class Especialista extends Thread{
    private Hemoterapia clinica;

    public Especialista(Hemoterapia clinica){
        this.clinica = clinica;
    }

    public void run(){
        try {
            while (true) {
                clinica.empezarExtraccion();
                Thread.sleep(5000);
                clinica.terminarExtraccion();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
