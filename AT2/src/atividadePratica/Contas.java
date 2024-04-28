package atividadePratica;

public class Contas {
    private double saldo;

    public Contas(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public synchronized void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito: +" + valor + ", Saldo: " + saldo);
    }

    public synchronized void compra(double valor, String tipoTransacao) {
        saldo -= valor;
        System.out.println(tipoTransacao + ": -" + valor + ", Saldo: " + saldo);
    }
}