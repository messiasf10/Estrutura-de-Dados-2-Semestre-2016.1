package pilhas;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class Teste {

	public static void main(String[] args) {

		Pilha<Peca> pilha = new Pilha<Peca>();
		Peca peca = new Peca();
		pilha.insere(peca);
		Peca pecaRemove = pilha.remove();
		if (pilha.vazia()) {
			System.out.println("A pilha está vazia");
		}
		Pilha<String> pilha2 = new Pilha<String>();
		pilha2.insere("Adalberto");
		pilha2.insere("Maria");
		String maria = pilha2.remove();
		String adalberto = pilha2.remove();
		System.out.println(maria);
		System.out.println(adalberto);

	}

}
