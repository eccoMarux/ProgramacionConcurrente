package Ejercicio03;

public class Main {
    public static void main(String[] args) {
        Jaula jaula = new Jaula();

        Thread hamsterMushu = new Thread(new Hamster("Mushu", jaula));
        hamsterMushu.start();
        Thread hamsterToby = new Thread(new Hamster("Toby", jaula));
        hamsterToby.start();
        Thread hamsterMusha = new Thread(new Hamster("Musha", jaula));
        hamsterMusha.start();
    }
}
