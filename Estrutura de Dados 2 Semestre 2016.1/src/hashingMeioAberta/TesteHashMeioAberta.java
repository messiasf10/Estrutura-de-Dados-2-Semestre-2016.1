package hashingMeioAberta;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteHashMeioAberta {
	
	public static void main(String[] args) {
	
		/* BUGS: ESTA FAZENDO REHASHING MUITO CEDO. OLHAR O VALOR DA CONST HASH_CHEIO
		 * O VALOR DE LAMBDA NAO ESTA CORRESPONDENDO AO NORMAL. OLHAR SLIDES DO PROF
		 * PARA VERIFICAR ISSO.
		 * NESSE EXEMPLO O LAMBDA EH IGUAL A 2 MAS SE COMPORTA COMO SE FOSSE 1
		 * TALVEZ SEJA UM ERRO OU NAO. ESTUDAR O CODIGO.
		 * JA ALTEREI O FUNCAO REHASHING - AGORA PEGA O PROX PRIMO
		 * 
		 * 																			*/

		HashMeioAberta hash = new HashMeioAberta(5, 2);
		
		//int[] S = {13,15,24,6,23,55};
		int[] S = {16,18,22,29,27,2,18,13,12,28,31,81,01,19,8,14,91,32,1,31};
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

