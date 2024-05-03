package at3;
import java.util.concurrent.locks.ReentrantLock;

class Quartos {
    private final ReentrantLock lock = new ReentrantLock();
    private boolean ocupado = false;
    private boolean limpo = true;

    // Métodos de entrada e saída de hóspedes nos quartos
    public void entrar() throws InterruptedException {
        lock.lock();
        try {
            while (!limpo) {
                lock.wait();
            }
            ocupado = true;
        } finally {
            lock.unlock();
        }
    }

    public void sair() {
        lock.lock();
        try {
            ocupado = false;
            limpo = false;
            lock.notifyAll();
        } finally {
            lock.unlock();
        }
    }

    // Métodos de limpeza dos quartos pelas camareiras, os hóspedes são retirados antes da limpeza
    public void limpar() throws InterruptedException {
        lock.lock();
        try {
            while (ocupado) {
                lock.wait();
            }
            limpo = true;
            lock.notifyAll();
        } finally {
            lock.unlock();
        }
    }
}