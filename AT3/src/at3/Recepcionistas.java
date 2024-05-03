package at3;

class Recepcionistas extends Thread {
    private final Quartos[] quartos;

    public Recepcionistas(Quartos[] quartos) {
        this.quartos = quartos;
    }

    @Override
    public void run() {
        try {
            for (Quartos quarto : quartos) {
                quarto.entrar();  // Faz o check-in do hóspede
                sleep(500);  // Simula o tempo que o recepcionista leva para fazer o check-in
                quarto.sair();  // Faz o check-out do hóspede
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}