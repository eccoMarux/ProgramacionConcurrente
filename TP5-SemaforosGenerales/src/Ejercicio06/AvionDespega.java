package Ejercicio06;

public class AvionDespega extends Thread{
    private Torre torre;

    public AvionDespega(Torre torre){
        this.torre = torre;
    }

    public void run(){
        try {
            torre.empezarDespegue();
            Thread.sleep(5000);
            torre.finDespegue();
        } catch (Exception e) {
            
        }
    }
}