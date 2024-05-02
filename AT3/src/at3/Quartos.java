package at3;

public class Quartos {

    // Criação dos quartos, que são ocupados por hóspedes, limpos por camareiras e gerenciados por recepcionistas
    private int qtd = 0;
    
    // Métodos de entrada e saída de hóspedes nos quartos
    public synchronized void entrar() {
        while(qtd == 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        qtd++;
        System.out.println("Hospede entrou. Qtd de hospedes: " + qtd);
        notifyAll();
    }
    
    public synchronized void sair() {
        while(qtd == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        qtd--;
        System.out.println("Hospede saiu. Qtd de hospedes: " + qtd);
        notifyAll();
    }

    // Métodos de limpeza dos quartos pelas camareiras, os hóspedes são retirados antes da limpeza
    public synchronized void limpar() {
        while(qtd > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Camareira limpou o quarto.");
        notifyAll();
    }

    // Métodos de check-in e check-out dos quartos pelos recepcionistas, que avisam os hóspedes quando um quarto está disponível ou não
    public synchronized void checkIn() {
        while(qtd == 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        qtd++;
        System.out.println("Recepcionista fez check-in. Qtd de hospedes: " + qtd);
        notifyAll();
    }

    public synchronized void checkOut() {
        while(qtd == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        qtd--;
        System.out.println("Recepcionista fez check-out. Qtd de hospedes: " + qtd);
        notifyAll();
    }

}
