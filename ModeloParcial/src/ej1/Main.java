package ej1;

public class Main {
    
    public static void main(String[] args) {
        Emoterapia clinica = new Emoterapia(5);
        Donante unDonante;
        Recepcionista unRecepcionista = new Recepcionista(clinica);
        Entrevista unEntrevista = new Entrevista(clinica);
        Especialista unEspecialista = new Especialista(clinica);
        int i = 0;

        unRecepcionista.setName("Recepcionista");
        unEntrevista.setName("Entrevistador");
        unEspecialista.setName("Especialista");

        unRecepcionista.start();
        unEntrevista.start();
        unEspecialista.start();

        while (i++ < 1) {
            unDonante = new Donante(clinica);
            unDonante.setName("D"+i);
            unDonante.start();
        }
    }
}
