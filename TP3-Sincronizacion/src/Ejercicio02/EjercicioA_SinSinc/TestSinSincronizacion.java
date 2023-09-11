package Ejercicio02.EjercicioA_SinSinc;


public class TestSinSincronizacion {
    public static void main(String[] args) {
        Energia energiaSinSinc = new Energia();

        Thread criaturaOscura = new Thread(new CriaturaOscura(energiaSinSinc, 4));
        Thread sanador = new Thread(new Sanador(energiaSinSinc, 4));

        criaturaOscura.start();
        sanador.start();

        try {
            criaturaOscura.join();
            sanador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final de Energía: " + energiaSinSinc.getEnergia());
    }
}
