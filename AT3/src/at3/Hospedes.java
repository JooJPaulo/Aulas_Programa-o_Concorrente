package at3;

import java.util.List;

public class Hospedes extends Thread {
    private final List<Quartos> quartos;
    private final Recepcionistas recepcionista;
    private Quartos quarto;
    private int tentativas = 0;
    private static final int MAX_TENTATIVAS_POR_HOSPEDE = 2;

    public Hospedes(List<Quartos> quartos, Recepcionistas recepcionista) {
        this.quartos = quartos;
        this.recepcionista = recepcionista;
    }

    public void sairDoQuarto() {
        quarto.sairGrupo();
        quarto.getCondition().signalAll();
    }
    

    @Override
    public void run() {
        try {
            while (true) {
                quarto = recepcionista.alocarQuarto(this);
                if (quarto != null) {
                    quarto.entrar(List.of(this));
                    Thread.sleep(1000);
                    sairDoQuarto();
                    Thread.sleep(2000);
                    quarto.limpar();
                    tentativas = 0; // Resetando o número de tentativas ao alugar com sucesso
                } else {
                    if (++tentativas >= MAX_TENTATIVAS_POR_HOSPEDE) {
                        System.out.println("Hóspede não conseguiu alugar um quarto após " + MAX_TENTATIVAS_POR_HOSPEDE + " tentativas. Deixando uma reclamação e saindo do hotel.");
                        break;
                    }
                    System.out.println("Hóspede aguardando disponibilidade de quarto.");
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
