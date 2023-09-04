package Ejercicio03;

public class TestThreadEjemplo {
    public static void main(String[] args) {
        new ThreadEjemplo("Maria Jose").start();
        new ThreadEjemplo("Jose Maria").start();
        System.out.println("Termina thread main");
    }
}
