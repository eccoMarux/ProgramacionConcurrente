package Ejercicio04;

class Cliente implements Runnable {
  private Reserva reserva;
  private int cantidadReserva;

  public Cliente(Reserva reserva, int cantidadReserva) {
    this.reserva = reserva;
    this.cantidadReserva = cantidadReserva;
  }

  public void run() {
    boolean reservaExitosa = reserva.realizarReserva(cantidadReserva);
    if (reservaExitosa) {
      System.out.println("Reserva exitosa para " + cantidadReserva + " asientos.");
    } else {
      System.out.println("No hay suficientes asientos disponibles para la reserva de " + cantidadReserva + " asientos.");
    }
  }
}