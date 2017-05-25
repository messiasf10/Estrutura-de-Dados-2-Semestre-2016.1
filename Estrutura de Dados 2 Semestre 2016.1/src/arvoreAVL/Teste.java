package arvoreAVL;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class Teste {

	public static void main(String[] args) {
		
		AVL avl = new AVL();
		
		int[] S = {1,2,3,4,5,6,7,8,9,24,1222,51,69,11};
		int[] D= {11,24,69};
		
		for(int i = 0;i < S.length;i++){
			System.out.println("\n"+(i+1)+"º PASSO:");
			System.out.println("INSERIR "+S[i]);
			System.out.println();
			avl.inserir(S[i]);
			avl.printArvoreBinaria();
		}
		
		for(int i = 0;i<D.length;i++){
			System.out.println("\nDeletar "+D[i]);
			avl.remover(2, D[i]);
			avl.printArvoreBinaria();
		}
		
		avl.printArvoreBinaria();
			
		
	}
	
}
