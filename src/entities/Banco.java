package entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Banco {

	private List<Conta> contas;

	public Banco() {
		contas = new ArrayList<>();
	}

	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}

	public void listarContas() {
		for (Conta conta : contas) {
			System.out.println(conta);
		}
	}

	public Conta acessarConta(int nC) {
		
		List<Conta> listAcessar = new ArrayList<Conta>();
		for (Conta c : contas) {
				if (c.getNumeroConta() == nC) {
					System.out.println("Olá, " + c.getTitular());	
					return c;
				}
		}
		System.out.println("Conta não encontrada.");
		return null;
		
		
	}
}
