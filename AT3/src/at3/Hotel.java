package at3;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    public static final int NUM_QUARTOS = 10;
    public static final int NUM_HOSPEDES = 50;
    public static final int NUM_CAMAREIRAS = 10;
    public static final int NUM_RECEPCIONISTAS = 5;

    public static void main(String[] args) {
        List<Quartos> quartos = new ArrayList<>();
        for (int i = 0; i < NUM_QUARTOS; i++) {
            quartos.add(new Quartos(i + 1));
        }

        Recepcionistas recepcionista = new Recepcionistas(quartos);
        recepcionista.start();

        Camareiras camareiras = new Camareiras(quartos);
        camareiras.start();

        List<Hospedes> hospedes = new ArrayList<>();
        for (int i = 0; i < NUM_HOSPEDES; i++) {
            hospedes.add(new Hospedes(quartos, recepcionista));
        }

        for (Hospedes hospede : hospedes) {
            hospede.start();
        }
    }
}
