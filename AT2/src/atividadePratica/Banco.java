package atividadePratica;

public class Banco {
    public static void main(String[] args) {
        // Inicialização das contas dos clientes
        Contas[] contasClientes = new Contas[5];
        for (int i = 0; i < contasClientes.length; i++) {
            contasClientes[i] = new Contas(1000);
        }

        // Inicialização das contas dos funcionários
        Contas[] contasFuncionarios = new Contas[4];
        for (int i = 0; i < contasFuncionarios.length; i++) {
            contasFuncionarios[i] = new Contas(0); // As contas dos funcionários serão atualizadas pelas lojas
        }

        // Inicialização das contas das lojas
        Contas[] contasLojas = new Contas[2];
        for (int i = 0; i < contasLojas.length; i++) {
            contasLojas[i] = new Contas(0); // As contas das lojas serão atualizadas pelos clientes
        }

        // Criação das threads para os clientes
        Clientes[] clientes = new Clientes[5];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Clientes(contasClientes[i], "cliente" + (i + 1));
            clientes[i].start();
        }

        // Criação das lojas e threads para os funcionários
        Funcionarios[] funcionariosLoja1 = new Funcionarios[2];
        Funcionarios[] funcionariosLoja2 = new Funcionarios[2];
        for (int i = 0; i < 2; i++) {
            funcionariosLoja1[i] = new Funcionarios(contasLojas[0], contasFuncionarios[i], "funcionário loja 1 " + (i + 1)); // Conta de investimento inicializada com 0
            funcionariosLoja2[i] = new Funcionarios(contasLojas[1], contasFuncionarios[i + 2], "funcionário loja 2 " + (i + 1)); // Conta de investimento inicializada com 0
        }

        Lojas loja1 = new Lojas(contasLojas[0], funcionariosLoja1, "loja 1");
        Lojas loja2 = new Lojas(contasLojas[1], funcionariosLoja2, "loja 2");

        // Laço para pagar os salários das lojas
        boolean algumFuncionarioRecebeuSalario = true;
        while (algumFuncionarioRecebeuSalario) {
            algumFuncionarioRecebeuSalario = false;
            loja1.pagarSalarios();
            loja2.pagarSalarios();
            algumFuncionarioRecebeuSalario = loja1.algumFuncionarioRecebeuSalario() || loja2.algumFuncionarioRecebeuSalario();
        }

        // Verificação dos saldos finais
        System.out.println("Saldos finais:");
        for (int i = 0; i < contasClientes.length; i++) {
            System.out.println("Cliente " + (i + 1 ) + ": " + contasClientes[i].getSaldo());
		}
		for (int i = 0; i < contasFuncionarios.length; i++) {
			System.out.println("Funcionário " + (i + 1) + ": " + contasFuncionarios[i].getSaldo());
		}
		for (int i = 0; i < contasLojas.length; i++) {
			System.out.println("Loja " + (i + 1) + ": " + contasLojas[i].getSaldo());
		}
	}
}