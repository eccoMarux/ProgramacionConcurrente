package Ejercicio02.EjercicioA_SinSinc;

public class Energia {
    private int energia = 10;

    public int getEnergia(){
        return energia;
    }

    public void drenarEnergia(int cantDrenada){
        energia -= cantDrenada;
    }

    public void revitalizarEnergia(int cantRevitalizada){
        energia += cantRevitalizada;
    }
}
