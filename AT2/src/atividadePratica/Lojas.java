package atividadePratica;

import java.util.Arrays;

public class Lojas {
    private Contas conta;
    private Funcionarios[] funcionarios;
    private String nomeLoja;

    public Lojas(Contas conta, Funcionarios[] funcionarios, String nomeLoja) {
        this.conta = conta;
        this.funcionarios = funcionarios;
        this.nomeLoja = nomeLoja;
        for (Funcionarios funcionario : funcionarios) {
            funcionario.setContaSalario(conta);
        }
    }

    public void pagarSalarios() {
        double totalSalarios = Arrays.stream(funcionarios).mapToDouble(funcionario -> 1400.00).sum();
        synchronized (conta) {
            if (conta.getSaldo() >= totalSalarios) {
                for (Funcionarios funcionario : funcionarios) {
                    funcionario.start();
                }
                conta.compra((int) totalSalarios, "pagamento de salários na loja " + nomeLoja);
                System.out.println("Pagamento de salários realizado na loja " + nomeLoja + ". Total: -" + totalSalarios + ", Saldo final: " + conta.getSaldo());
            }
        }
    }

    public boolean algumFuncionarioRecebeuSalario() {
        for (Funcionarios funcionario : funcionarios) {
            if (funcionario.isAlive()) {
                return true;
            }
        }
        return false;
    }
}
