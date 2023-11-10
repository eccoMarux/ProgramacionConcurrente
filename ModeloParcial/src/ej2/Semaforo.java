package ej2;

public class Semaforo extends Thread{
    private GestorCruce cruce;

    public Semaforo(GestorCruce cruce) {
        this.cruce = cruce;
    }

    public void run(){
        try {
            while(true) {
                Thread.sleep(5000);
                cruce.cambiaSemaforo();
            }
        } catch (Exception e) {
            
        }
    }
}
