package Ejercicio02.EjercicioC_ConSinc;

public class Sanador implements Runnable {
    private EnergiaSinc energia;
    int inicioPeleaEpica, finPeleaEpica;

    public Sanador(EnergiaSinc energiaNueva, int turnosDelSanador) {
        this.energia = energiaNueva;
        this.finPeleaEpica = turnosDelSanador;
    }

    public synchronized void run() {
        for(inicioPeleaEpica =0; inicioPeleaEpica<finPeleaEpica; inicioPeleaEpica++){
        energia.revitalizarEnergia(3);
        System.out.println("Sanador revitalizó 3 unidades de Energía. Energia: " + this.energia.getEnergia());
        }
    }
}
