package atividadePratica;

public class Contas {

    //Definição do tipo de conta
    private int tipoConta;
    //Saldo da conta
    private double saldo;

    //Construtor da classe
    public Contas(int tipoConta, double saldo) {
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    //Método para obter o saldo da conta
    public double getSaldo() {
        return saldo;
    }

    //Método para alterar o saldo da conta
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Método para obter o tipo da conta
    public int getTipoConta() {
        return tipoConta;
    }

    //Método para alterar o tipo da conta
    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    //Método para depositar dinheiro na conta
    public void depositar(double valor) {
        saldo += valor;
    }

}
