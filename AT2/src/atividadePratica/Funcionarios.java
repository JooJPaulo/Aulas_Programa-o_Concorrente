package atividadePratica;

public class Funcionarios extends Thread {
    private Contas contaSalario;
    private Contas contaInvestimento;
    private String funcionarioNome;

    public Funcionarios(Contas contaSalario, Contas contaInvestimento, String funcionarioNome) {
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
        this.funcionarioNome = funcionarioNome;
    }

    @Override
    public void run() {
        synchronized (contaSalario) {
            double salario = 1400.00;
            contaSalario.depositar(salario);
            double investimento = salario * 0.2;
            contaInvestimento.depositar(investimento);
            System.out.println("Funcionário " + funcionarioNome + " recebeu salário: +" + salario + " e depositou " + investimento + " em investimento");
        }
    }

    public void setContaSalario(Contas conta) {
        this.contaSalario = conta;
    }
}