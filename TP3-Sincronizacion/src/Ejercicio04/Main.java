package Ejercicio04;

public class Main {
  public static void main(String[] args) {
    Reserva reserva = new Reserva(10);

    Thread cliente1 = new Thread(new Cliente(reserva, 5));
    Thread cliente2 = new Thread(new Cliente(reserva, 3));
    Thread cliente3 = new Thread(new Cliente(reserva, 4));

    cliente1.start();
    cliente2.start();
    cliente3.start();
  }
}