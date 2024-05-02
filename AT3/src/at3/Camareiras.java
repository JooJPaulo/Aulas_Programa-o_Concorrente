package at3;

public class Camareiras extends Thread{
    
    // Criação das camareiras, que limpam os quartos
    private Quartos quartos;
    
    public Camareiras(Quartos quartos) {
        this.quartos = quartos;
    }
    
    @Override
    public void run() {
        while(true) {
            quartos.limpar();
        }
    }
}
