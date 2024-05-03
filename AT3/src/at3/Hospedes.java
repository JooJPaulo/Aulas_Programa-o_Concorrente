package at3;

class Hospedes extends Thread {
    private final Quartos[] quartos;

    public Hospedes(Quartos[] quartos) {
        this.quartos = quartos;
    }

    @Override
    public void run() {
        try {
            for (Quartos quarto : quartos) {
                quarto.entrar();
                sleep(1000);  // Simula o tempo que o hóspede passa no quarto
                quarto.sair();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}