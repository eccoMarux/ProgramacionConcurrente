package ej1;

public class Especialista extends Thread{
    private Emoterapia clinica;

    public Especialista(Emoterapia clinica){
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
