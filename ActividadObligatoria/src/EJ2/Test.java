package EJ2;
public class Test {
    public static void main(String[] args) {

        ControlTren unTren = new ControlTren(10);

        Pasajero[] arrPasajeros = new Pasajero[30];

        MaquinaTicket unaMaquina = new MaquinaTicket();

        for (int i = 0; i < arrPasajeros.length; i++) {
            arrPasajeros[i] = new Pasajero("Pajero "+i, unTren, unaMaquina);
            arrPasajeros[i].start();
        }

        unTren.start();

        try {
            unTren.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int j = 0; j < arrPasajeros.length; j++) {
            try {
                arrPasajeros[j].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("HOLI FUNCIONE?");

    }
}
