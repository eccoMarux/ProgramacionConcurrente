package Secuencial;

public class Donante extends Thread{
    private Hemoterapia clinica;

    public Donante(Hemoterapia clinica){
        this.clinica = clinica;
    }

    public void run() {
        try {
            clinica.llamar();
            clinica.salaEspera();
            clinica.entrevistaMedica();
            clinica.extraccionSangre();
            clinica.desayuno();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
