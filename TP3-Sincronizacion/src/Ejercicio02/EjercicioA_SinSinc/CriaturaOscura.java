package Ejercicio02.EjercicioA_SinSinc;

public class CriaturaOscura implements Runnable {
    private Energia energia;
    private int inicioPeleaEpica, finPeleaEpica;

    public CriaturaOscura(Energia energiaNueva, int turnosDeLaCriatura) {
        this.energia = energiaNueva;
        this.finPeleaEpica= turnosDeLaCriatura;
    }

    public void run() {
        for (inicioPeleaEpica = 0; inicioPeleaEpica < finPeleaEpica; inicioPeleaEpica++) {
            energia.drenarEnergia(3);
            System.out.println("Criatura Oscura drenó 3 unidades de Energía. Energia: " + energia.getEnergia());
        }

    }
}
