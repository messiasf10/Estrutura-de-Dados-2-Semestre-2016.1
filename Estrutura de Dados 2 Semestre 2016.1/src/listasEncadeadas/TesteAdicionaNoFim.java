package listasEncadeadas;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteAdicionaNoFim {
	public static void main(String[] args) {
		ListaLigada lista = new ListaLigada();
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		System.out.println(lista);
	}
}
