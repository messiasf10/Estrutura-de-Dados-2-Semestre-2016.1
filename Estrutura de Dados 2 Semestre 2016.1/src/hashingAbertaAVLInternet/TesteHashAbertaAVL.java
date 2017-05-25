package hashingAbertaAVLInternet;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteHashAbertaAVL {

	public static void main(String[] args) {
		
		HashAbertaAVL hash = new HashAbertaAVL(7);
		
		hash.inserir(0);
		hash.inserir(1);
		hash.inserir(85);
		hash.inserir(6);
		hash.inserir(36);
		hash.inserir(46);
		hash.inserir(89);
		hash.inserir(112);
		hash.inserir(44);
		
		hash.imprimir();

	}

}
