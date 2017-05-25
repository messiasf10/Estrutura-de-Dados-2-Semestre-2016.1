package arvoreBinaria;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteArvoreBinaria {

	public static void main(String[] args) {
		
		ArvoreBinaria ab1 = new ArvoreBinaria();
		
		ab1.inserir(5);
		ab1.inserir(4);
		ab1.inserir(6);
		ab1.inserir(3);
		ab1.inserir(1);
		ab1.inserir(2);
		
		try {
			ab1.remover(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ab1.imprimirArvore();
		

	}

}
