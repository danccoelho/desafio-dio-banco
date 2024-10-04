package entities;

public class ContaPoupanca extends Conta {
	
	 private double taxaJuros;

	public ContaPoupanca(String titular, int numeroConta, double saldo) {
		super(titular, numeroConta, saldo);
		this.taxaJuros = taxaJuros;
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}
	
	public void aplicarRendimento() {
        saldo += saldo * taxaJuros;
        System.out.println("Rendimento aplicado. Novo saldo: R$" + saldo);
    }

    @Override
    public void transferir(double valor, Conta destino) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência.");
        } else {
            this.sacar(valor);
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " para " + destino.getTitular() + " realizada com sucesso.");
        }
	
    }

}
