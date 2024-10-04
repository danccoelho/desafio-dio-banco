package entities;

import operacoesConta.IConta;

public class Conta implements IConta {

	protected String titular;
	protected int numeroConta;
	protected double saldo;

	public Conta(String titular, int numeroConta, double saldo) {
		this.titular = titular;
		this.numeroConta = numeroConta;
		this.saldo = saldo;

	}

	public String getTitular() {
		return titular;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		if (valor > saldo) {
			System.out.println("Saldo insuficiente para saque.");
		} else {
			saldo -= valor;
			System.out.println("Saque de R$" + valor + " realizado com sucesso.");
			System.out.println("Novo saldo: R$" + saldo);
		}
	}

	@Override
	public void depositar(double valor) {
		if (valor <= 0) {
			System.out.println("Saldo insuficiente para depósito.");
		} else {
			saldo += valor;
			System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
			System.out.println("Novo saldo: R$" + saldo);
		}
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if (valor <= 0) {
			System.out.println("Saldo insuficiente para depósito.");
		} else {
			this.sacar(valor);
			contaDestino.depositar(valor);
		}

	}

	@Override
	public void consultarSaldo() {
		System.out.println("Saldo atual: R$" + saldo);
	}

}
