package atividadePratica;

public class Lojas {

    private Funcionarios funcionario1;
    private Funcionarios funcionario2;
    private Funcionarios funcionario3;
    private Funcionarios funcionario4;

    //Divisão dos funcionários em lojas
    public void loja1(Funcionarios funcionario1, Funcionarios funcionario2) {
        this.funcionario1 = funcionario1;
        this.funcionario2 = funcionario2;
    }

    public void loja2(Funcionarios funcionario3, Funcionarios funcionario4) {
        this.funcionario3 = funcionario3;
        this.funcionario4 = funcionario4;
    }

    public Funcionarios getFuncionario1() {
        return funcionario1;
    }

    public Funcionarios getFuncionario2() {
        return funcionario2;
    }

    public Funcionarios getFuncionario3() {
        return funcionario3;
    }

    public Funcionarios getFuncionario4() {
        return funcionario4;
    }

}
