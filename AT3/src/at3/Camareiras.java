package at3;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Camareiras extends Thread {
    private final List<Quartos> quartos;

    public Camareiras(List<Quartos> quartos) {
        this.quartos = quartos;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (Quartos quarto : quartos) {
                    ReentrantLock lock = quarto.getLock();
                    Condition condition = quarto.getCondition();
                    lock.lock();
                    try {
                        if (quarto.isQuartoEmLimpeza() && !quarto.isLimpo()) {
                            quarto.limpar();
                            quarto.setChaveNaRecepcao(true);
                            quarto.setQuartoEmLimpeza(false);
                            System.out.println("Camareira deixou a chave na recepção após limpar o quarto " + quarto.getNumQuarto());
                        } else {
                            condition.await(); // Aguardar sinalização dos hóspedes ou da recepcionista
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}