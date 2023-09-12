package Ejercicio02.EjercicioC_ConSinc;

public class TestConSincronizacion {
    public static void main(String[] args) {
        EnergiaSinc energiaSinc = new EnergiaSinc();

        Thread criaturaOscura = new Thread(new CriaturaOscura(energiaSinc, 3));
        Thread sanador = new Thread(new Sanador(energiaSinc, 4));

        criaturaOscura.start();
        sanador.start();

        try {
            criaturaOscura.join();
            sanador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final de Energía: " + energiaSinc.getEnergia());
    }
}
