package at3;

public class Hotel {

    public static final int NUM_QUARTOS = 10;
    public static final int NUM_HOSPEDES = 50;
    public static final int NUM_CAMAREIRAS = 10;
    public static final int NUM_RECEPCIONISTAS = 5;

    public static void main(String[] args) {
        
        //Inicialização das entidades do hotel
        Quartos[] quartos = new Quartos[NUM_QUARTOS];
        for (int i = 0; i < NUM_QUARTOS; i++) {
            quartos[i] = new Quartos();
        }

        Hospedes[] hospedes = new Hospedes[NUM_HOSPEDES];
        for (int i = 0; i < NUM_HOSPEDES; i++) {
            hospedes[i] = new Hospedes(quartos);
            hospedes[i].start();
        }

        Camareiras[] camareiras = new Camareiras[NUM_CAMAREIRAS];
        for (int i = 0; i < NUM_CAMAREIRAS; i++) {
            camareiras[i] = new Camareiras(quartos);
            camareiras[i].start();
        }

        Recepcionistas[] recepcionistas = new Recepcionistas[NUM_RECEPCIONISTAS];
        for (int i = 0; i < NUM_RECEPCIONISTAS; i++) {
            recepcionistas[i] = new Recepcionistas(quartos);
            recepcionistas[i].start();
        }
    }
}