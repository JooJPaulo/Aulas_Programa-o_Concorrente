package at3;

class Camareiras extends Thread {
    private final Quartos[] quartos;

    public Camareiras(Quartos[] quartos) {
        this.quartos = quartos;
    }

    @Override
    public void run() {
        try {
            for (Quartos quarto : quartos) {
                quarto.limpar();
                sleep(500);  // Simula o tempo que a camareira leva para limpar o quarto
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}