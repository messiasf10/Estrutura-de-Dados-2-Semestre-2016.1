package hashingMeioAbertaModificada;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteHashMeioAbertaModificada {
	
	public static void main(String[] args) {
	
		HashMeioAbertaModificada hash = new HashMeioAbertaModificada(5, 2);
		
		//int[] S = {13,15,24,6,23,55};
		int[] S = {2,5,9,16,4,3,11,29,33,64,26,29,30,17,14,11,3,5,17,32}; //Ex. de Sala
		//int[] S = {16,18,22,29,27,2,18,13,12,28,31,81,01,19,8,14,91,32,1,31};
		int[] D = {81,71,14,22};

		for(int i = 0; i < S.length; i++){
			System.out.println((i+1)+"º PASSO:");
			hash.inserir(S[i]);
			hash.imprimir();
		}
		
		hash.calculoFC();
		hash.calculoFB();
		System.out.println("FATOR DE CARGA = "+hash.getFC());
		System.out.println("FATOR DE BALANCEAMENTO = "+hash.getFB()+"\n");
		
		for(int i = 0; i < D.length; i++){
			System.out.println((i+1)+"º PASSO:");
			hash.deletar(D[i]);
			hash.imprimir();
		}
		
		hash.calculoFC();
		hash.calculoFB();
		System.out.println("FATOR DE CARGA = "+hash.getFC());
		System.out.println("FATOR DE BALANCEAMENTO = "+hash.getFB()+"\n");
		
		
	}
	
	
	
	

}

