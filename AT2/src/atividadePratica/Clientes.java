package atividadePratica;

public class Clientes extends Thread {
    private Contas conta;
    private String clienteNome;

    public Clientes(Contas conta, String clienteNome) {
        this.conta = conta;
        this.clienteNome = clienteNome;
    }

    @Override
    public void run() {
        while (conta.getSaldo() > 0) {
            conta.compra(100, "compra na loja 1 pelo cliente " + clienteNome);
            conta.compra(200, "compra na loja 1 pelo cliente " + clienteNome);
        }
    }
}