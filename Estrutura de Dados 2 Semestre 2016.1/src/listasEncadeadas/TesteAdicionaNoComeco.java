package listasEncadeadas;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteAdicionaNoComeco {
	public static void main(String[] args) {
		ListaLigada lista = new ListaLigada();
		lista.adicionaNoComeco("Rafael");
		lista.adicionaNoComeco("Paulo");
		System.out.println(lista);
	}
}
