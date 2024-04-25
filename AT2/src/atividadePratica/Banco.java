package atividadePratica;

public class Banco {

	public static void main(String[] args) {
		
		//Criação das contas, divididas em contas de clientes e contas de funcionários
		Contas contaCliente = new Contas(1000, 0);
		Contas contaFuncionario = new Contas(1400, 0);

		//Criação dos clientes e funcionários
		Clientes cliente1 = new Clientes(contaCliente);
		Clientes cliente2 = new Clientes(contaCliente);
		Clientes cliente3 = new Clientes(contaCliente);
		Clientes cliente4 = new Clientes(contaCliente);
		Clientes cliente5 = new Clientes(contaCliente);
		Funcionarios funcionario1 = new Funcionarios(contaFuncionario);
		Funcionarios funcionario2 = new Funcionarios(contaFuncionario);
		Funcionarios funcionario3 = new Funcionarios(contaFuncionario);
		Funcionarios funcionario4 = new Funcionarios(contaFuncionario);

		//Criação das lojas
		Lojas loja1 = new Lojas();
		Lojas loja2 = new Lojas();

		//Divisão dos funcionários em lojas
		loja1.loja1(funcionario1, funcionario2);
		loja2.loja2(funcionario3, funcionario4);
		

	}

}
