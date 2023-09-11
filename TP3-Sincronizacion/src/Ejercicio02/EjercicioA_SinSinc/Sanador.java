package Ejercicio02.EjercicioA_SinSinc;

public class Sanador implements Runnable {
    private Energia energia;
    int inicioPeleaEpica, finPeleaEpica;

    public Sanador(Energia energiaNueva, int turnosDelSanador) {
        this.energia = energiaNueva;
        this.finPeleaEpica = turnosDelSanador;
    }

    public void run() {
        for(inicioPeleaEpica =0; inicioPeleaEpica<finPeleaEpica; inicioPeleaEpica++){
        energia.revitalizarEnergia(3);
        System.out.println("Sanador revitalizó 3 unidades de Energía. Energia: " + energia.getEnergia());
        }
    }
}
