package at3;

public class Hospedes extends Thread {
    
    // Criação dos hóspedes, que entram e saem dos quartos
    private Quartos quartos;
    
    public Hospedes(Quartos quartos) {
        this.quartos = quartos;
    }
    
    @Override
    public void run() {
        while(true) {
            quartos.entrar();
            quartos.sair();
        }
    }

}
