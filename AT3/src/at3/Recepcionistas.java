package at3;

public class Recepcionistas extends Thread {

    // Criação dos recepcionistas, que fazem check-in e check-out dos hóspedes
    private Quartos quartos;
    
    public Recepcionistas(Quartos quartos) {
        this.quartos = quartos;
    }
    
    @Override
    public void run() {
        while(true) {
            quartos.checkIn();
            quartos.checkOut();
        }
    }
}
