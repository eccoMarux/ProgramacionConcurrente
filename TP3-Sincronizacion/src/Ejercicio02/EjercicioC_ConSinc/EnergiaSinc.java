package Ejercicio02.EjercicioC_ConSinc;

public class EnergiaSinc {
    private int energia = 10;
    private final Object lock = new Object();

    public int getEnergia() {
        synchronized (lock){
            return this.energia;
        }
    }

    public void drenarEnergia(int cantDrenada) {
        synchronized (lock) {
            energia -= cantDrenada;
        }

    }

    public void revitalizarEnergia(int cantRevitalizada) {
        synchronized (lock) {
            energia += cantRevitalizada;
        }
    }
}
