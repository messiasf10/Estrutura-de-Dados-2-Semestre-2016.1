package hashingAbertaAVL;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteHashAbertaAVL {

	public static void main(String[] args) {
		
		HashAbertaAVL hash = new HashAbertaAVL(5);
		
		//int[] S = {0,1,85,6,36,46,89,112,44};
		int[] S = {16,18,22,29,27,2,18,13,12,28,31,81,01,19,8,14,91,32,1,31};
		int[] D = {81,71,14,22};
		
		for(int i = 0; i < S.length; i++){	
			System.out.println((i+1)+"º PASSO:");
			hash.inserir(S[i]);
			hash.imprimir();
		}
		
		System.out.println("FATOR DE CARGA: "+hash.getFC());
		System.out.println("FATOR DE BALANCEAMENTO: "+hash.getFB()+"\n");

		for(int i = 0; i < D.length; i++){
			System.out.println((i+1)+"º PASSO:");
			hash.deletar(D[i]);
			hash.imprimir();
		}		
		
		System.out.println("FATOR DE CARGA: "+hash.getFC());
		System.out.println("FATOR DE BALANCEAMENTO: "+hash.getFB()+"\n");
		
	}

}
