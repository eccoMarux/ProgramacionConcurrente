package Ejercicio02.EjercicioA_SinSinc;

public class Energia {
    private int energia = 10;

    public int getEnergia(){
        return this.energia;
    }

    public void drenarEnergia(int cantDrenada){
        this.energia -= cantDrenada;
    }

    public void revitalizarEnergia(int cantRevitalizada){
        this.energia += cantRevitalizada;
    }
}
