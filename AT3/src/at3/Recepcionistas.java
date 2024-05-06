package at3;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Recepcionistas extends Thread {
    private final List<Quartos> quartos;
    private final Queue<Hospedes> filaEspera = new LinkedList<>();
    private volatile boolean executando = true;

    private static final int MAX_TENTATIVAS = 2;

    public Recepcionistas(List<Quartos> quartos) {
        this.quartos = quartos;
    }

    public Quartos alocarQuarto(Hospedes hospede) throws InterruptedException {
        synchronized (this) {
            int tentativas = 0;
            while (procurarQuartoDisponivel() == null && !filaEspera.isEmpty()) {
                if (++tentativas >= MAX_TENTATIVAS) {
                    System.out.println("Hóspede " + hospede + " não conseguiu alugar um quarto após " + MAX_TENTATIVAS + " tentativas. Deixando uma reclamação e saindo do hotel.");
                    return null;
                }
                System.out.println("Hóspede " + hospede + " aguardando disponibilidade de quarto.");
                filaEspera.add(hospede);
                this.wait();
            }
            return procurarQuartoDisponivel();
        }
    }
    

    @Override
    public void run() {
        try {
            while (executando) { 
                if (!filaEspera.isEmpty()) {
                    Hospedes hospede = filaEspera.remove();
                    synchronized (this) {
                        Quartos quarto = alocarQuarto(hospede);
                        if (quarto != null) {
                            quarto.setChaveNaRecepcao(false);
                            System.out.println("Hóspede " + hospede + " pegou a chave na recepção e entrou no quarto " + quarto.getNumQuarto());
                            hospede.start();
                        }
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void parar() {
        executando = false;
    }
    
    private synchronized Quartos procurarQuartoDisponivel() {
        for (Quartos quarto : quartos) {
            if (!quarto.isOcupado()) {
                return quarto;
            }
        }
        return null;
    }
}
