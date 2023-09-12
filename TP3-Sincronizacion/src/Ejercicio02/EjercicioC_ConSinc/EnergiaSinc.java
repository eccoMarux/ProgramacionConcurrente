package Ejercicio02.EjercicioC_ConSinc;

public class EnergiaSinc {
    private int energia = 10;

    public synchronized int getEnergia() {
        return this.energia;
    }

    public synchronized void drenarEnergia(int cantDrenada) {
        //Drenar energia usando el valor que entra por parametro.
        this.energia -= cantDrenada;
        System.out.println("Criatura Oscura drenó 3 unidades de Energía. Energia: " + this.energia);
    }

    public synchronized void revitalizarEnergia(int cantRevitalizada) {
        //Revitalizar energia usando el valor que entra por parametro.
        this.energia += cantRevitalizada;
        System.out.println("Sanador revitalizó 3 unidades de Energía. Energia: " + this.energia);
    }
}
