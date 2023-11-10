package Ejercicio06;

public class Test {
    public static void main(String[] args) {
        Torre control = new Torre();
        int i = 0;
        AvionAterriza ater;
        AvionDespega desp = new AvionDespega(control);
        desp.setName("Avion Despegue");
        desp.start();

        while( i++ < 20){
            ater = new AvionAterriza(control);
            ater.setName("Avion " + i);
            ater.start();
        }
    }
}