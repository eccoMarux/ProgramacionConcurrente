package ej1;

public class Entrevista extends Thread{
    private Emoterapia clinica;

    public Entrevista(Emoterapia clinica){
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
