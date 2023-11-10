package Rendezvous;

public class Entrevista extends Thread{
    private Hemoterapia clinica;

    public Entrevista(Hemoterapia clinica){
        this.clinica = clinica;
    }

    public void run(){
        try {
            while (true) {
                clinica.empezarEntrevista();
                Thread.sleep(5000);
                clinica.terminarEntrevista();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
