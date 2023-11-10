package Ejercicio06;

public class AvionAterriza extends Thread{
    private Torre torre;

    public AvionAterriza(Torre torre){
        this.torre = torre;
    }

    public void run(){
        try {
            torre.empezarAterrizaje();
            Thread.sleep(1000);
            torre.finAterrizaje();
        } catch (Exception e) {
            
        }
    }
}