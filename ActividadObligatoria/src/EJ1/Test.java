package EJ1;
public class Test {
    public static void main(String[] args) {

        ControlTren unTren = new ControlTren(10);

        Pasajero[] arrPasajeros = new Pasajero[30];

        for (int i = 0; i < arrPasajeros.length; i++) {
            arrPasajeros[i] = new Pasajero("Pajero "+i, unTren);
            arrPasajeros[i].start();
        }

        unTren.start();

        try {
            unTren.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int j = 0; j < arrPasajeros.length; j++) {
            try {
                arrPasajeros[j].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("HOLI FUNCIONE?");

    }
}
