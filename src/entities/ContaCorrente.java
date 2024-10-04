package entities;

public class ContaCorrente extends Conta {

	 private double limite;
	 
	public ContaCorrente(String titular, int numeroConta, double saldo) {
		super(titular, numeroConta, saldo);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	  @Override
	    public void sacar(double valor) {
	        if (valor > (saldo + limite)) {
	            System.out.println("Saldo e limite insuficientes.");
	        } else {
	            saldo -= valor;
	            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
	            System.out.println("Novo saldo: R$" + saldo);
	        }
	    }

	    @Override
	    public void transferir(double valor, Conta destino) {
	        if (valor > (saldo + limite)) {
	            System.out.println("Saldo insuficiente para transferência.");
	        } else {
	            this.sacar(valor);
	            destino.depositar(valor);
	            System.out.println("Transferência de R$" + valor + " para " + destino.getTitular() + " realizada com sucesso.");
	        }
	    }
}
