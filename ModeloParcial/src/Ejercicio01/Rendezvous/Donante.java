package Rendezvous;

public class Donante extends Thread{
    private Hemoterapia clinica;

    public Donante(Hemoterapia clinica){
        this.clinica = clinica;
    }

    public void run() {
        try {
            clinica.llamar();
            Thread.sleep(5000);
            clinica.salaEspera();
            clinica.desayuno();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
