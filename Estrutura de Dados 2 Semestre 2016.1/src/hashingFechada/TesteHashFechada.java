package hashingFechada;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteHashFechada {

	public static void main(String[] args) {
		
		HashFechada hash = new HashFechada(11, 3);

		//int[] S = {89,18,49,60,69};
		
		int[] S = {16,18,22,29,27,2,18,13,12,28,31,81,01,19,8,14,91,32,1,31};
		int[] D = {81,71,14,22};
		
		for(int i = 0; i < S.length; i++){
			System.out.println((i+1)+"º PASSO:");
			hash.inserir(S[i]);
			System.out.println();
			hash.imprimir();
		}
		
		System.out.println("--------------------------------------------------------------------\n");
		
		for(int i = 0; i < D.length; i++){
			System.out.println((i+1)+"º PASSO:");
			hash.deletar(D[i]);
			System.out.println();
			hash.imprimir();
		}
		
	}

}
