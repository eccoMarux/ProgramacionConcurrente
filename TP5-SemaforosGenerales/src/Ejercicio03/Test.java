package Ejercicio03;
public class Test {

    public static void main(String[] args) {
        int capacidad =2;

        Comedor comedor = new Comedor(capacidad);

        Perro perros[] = new Perro[capacidad];
        //Gato gatos[] = new Gato[capacidad];

        for (int i = 0; i < capacidad; i++) {
            perros[i] = new Perro(comedor, "Perro "+i);
            perros[i].start();

            //gatos[i] = new Gato(comedor, "Gato "+i);
            //gatos[i].start();
        }

    }
    
}