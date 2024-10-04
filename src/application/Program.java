package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Banco;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Banco bb = new Banco();

		Conta cc = new ContaCorrente("Pelé", 1111, 400.0);
		Conta cc2 = new ContaCorrente("Roberto Carlos", 2222, 700.0);
		Conta cP = new ContaPoupanca("Ronaldo", 3333, 536.0);
		Conta cP2 = new ContaPoupanca("Kaká", 4444, 658.0);

		bb.adicionarConta(cc);
		bb.adicionarConta(cc2);

		System.out.println("---BANCO---");

		try {

			int x = 0;
			while (x != 5) {
				System.out.print("Deseja qual opção:\n " + "1 - sacar.\n " + "2 - depositar.\n " + "3 - transferir.\n "
						+ "4 - consultar saldo.\n" + "5 - para finalizar!\n" + " Digite a opção:  ");
				x = sc.nextInt();
				if (x == 1) {
					System.out.print("Número da conta: ");
					int numeroConta = sc.nextInt();
					Conta contaSaque = bb.acessarConta(numeroConta);
					System.out.print("Quantia para o saque: ");
					double sa = sc.nextDouble();
					cc.sacar(sa);
				}
				if (x == 2) {
					System.out.print("Número da conta: ");
					int numeroConta = sc.nextInt();
					Conta contaDeposito = bb.acessarConta(numeroConta);
					System.out.print("Quantia para o deposito: ");
					double de = sc.nextDouble();
					cc.depositar(de);
				}
				if (x == 3) {
					System.out.print("Número da conta de origem: ");
					int numeroContaOrigem = sc.nextInt();
					Conta contaOrigem = bb.acessarConta(numeroContaOrigem);
					if (contaOrigem != null) {
						System.out.print("Número da conta de destino: ");
						int numeroContaDestino = sc.nextInt();
						Conta contaDestino = bb.acessarConta(numeroContaDestino);
						if (contaDestino != null) {
							System.out.print("Valor da transferência: ");
							double valorTransferencia = sc.nextDouble();
							contaOrigem.transferir(valorTransferencia, contaDestino);
						}
					}
				}
				if (x == 4) {
					 System.out.print("Número da conta: ");
	                    int numeroContaSaldo = sc.nextInt();
	                    Conta contaSaldo = bb.acessarConta(numeroContaSaldo);
	                    if (contaSaldo != null) {
	                        contaSaldo.consultarSaldo();
	                    }
				}

			}
			System.out.println("---Operação finalizada---");
		}

		catch (InputMismatchException e) {
			System.out.println("Error");
		} finally {
			sc.close();
		}
	}
}
