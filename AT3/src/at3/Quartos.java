package at3;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Quartos {
	private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final int numQuarto;
    private boolean ocupado = false;
    private boolean chaveNaRecepcao = true;
    private boolean quartoEmLimpeza = false;
    private boolean limpo = true;
    private static final int CAPACIDADE_MAXIMA = 4;

    public Quartos(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public Condition getCondition() {
        return condition;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public boolean isChaveNaRecepcao() {
        return chaveNaRecepcao;
    }

    public void setChaveNaRecepcao(boolean chaveNaRecepcao) {
        this.chaveNaRecepcao = chaveNaRecepcao;
    }

    public boolean isQuartoEmLimpeza() {
        return quartoEmLimpeza;
    }

    public void setQuartoEmLimpeza(boolean quartoEmLimpeza) {
        this.quartoEmLimpeza = quartoEmLimpeza;
    }

    public boolean isLimpo() {
        return limpo;
    }

    public void entrar(List<Hospedes> grupo) throws InterruptedException {
        lock.lock();
        try {
            while (!chaveNaRecepcao || ocupado || grupo.size() > CAPACIDADE_MAXIMA || quartoEmLimpeza) {
                condition.await();
            }
            ocupado = true;
            chaveNaRecepcao = false;
            System.out.println("Grupo de hóspedes alugou o quarto " + numQuarto);
        } finally {
            lock.unlock();
        }
    }

    public void sairGrupo() {
        lock.lock();
        try {
            while (!chaveNaRecepcao) {
                quartoEmLimpeza = true;
                System.out.println("Hóspedes deixaram a chave na porta e saíram do quarto " + numQuarto);
                condition.signalAll(); // Sinalizar camareiras para limpar o quarto
                condition.await();
            }
            chaveNaRecepcao = true;
            condition.signalAll(); // Sinalizar camareiras novamente após os hóspedes saírem
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    
    public void limpar() {
        lock.lock();
        try {
            if (!limpo) {
                chaveNaRecepcao = true;
                System.out.println("Camareira entrou para limpar o quarto " + numQuarto);
                limpo = true;
            } else {
                System.out.println("O quarto " + numQuarto + " já está limpo.");
            }
        } finally {
            lock.unlock();
        }
    }
}
