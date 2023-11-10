package ej1;

public class Donante extends Thread{
    private Emoterapia clinica;

    public Donante(Emoterapia clinica){
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
