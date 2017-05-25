package hashingMeioAbertaModificadaDefinitiva;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteHashMeioAbertaModificadaDefinitiva {
	
	public static void main(String[] args) {
	
		HashMeioAbertaModificadaDefinitiva hash = new HashMeioAbertaModificadaDefinitiva(5, 2);
		
		//int[] S = {13,15,24,6,23,55};
		//int[] S = {2,5,9,16,4,3,11,29,33,64,26,29,30,17,14,11,3,5,17,32}; //Ex. de Sala
		//int[] S = {27,13,12,92,11,21,18,3,16,19,37,44,18,9,91,17,25,16,42,39,38,22,61,54,
			//	33,53}; //PROVA DO SEMESTRE PASSADO
		
		int[] S = {16,18,22,29,27,2,18,13,12,28,31,81,01,19,8,14,91,32,1,31};
		int[] D = {81,71,14,22};

		//int[] D = {18,11,91,22}; 
		
		System.out.println("O HASHING MEIO ABERTO FUNCIONA DA SEGUINTE MANEIRA: O ELEMENTO VAI TENTAR SER INSERIDO NORMALMENTE\n"
				+ "NA HASHING. CASO ELE POSSA SER INSERIDO, A INSERCAO ACONTECE E O PROXIMO ELEMENTO VEM PARA SER INSERIDO.\n"
				+ "ANTES DO ELEMENTO SER INSERIDO EH VERIFICADO SE A CELULA QUE ELE VAI SER INSERIDO ESTA FECHADA, OU SEJA,\n"
				+ "SE A ARVORE AVL QUE ESTA NAQUELA CELULA JA ATINGIU O FATOR DE CARGA MAXIMO. CASO TENHA ATINGIDO, UTILIZA-SE A\n"
				+ "TENTATIVA QUADRATICA PARA TENTAR INSERIR O ELEMENTO EM OUTRA CELULA. CASO A TENTATIVA QUADRATICA FALHE, EH NECESSARIO\n"
				+ "FAZER REHASHING. OUTRO CASO EM QUE NECESSITA-SE FAZER REHASHING EH QUANDO MAIS DA METADE DAS CELULAS ESTAO FECHADAS,\n"
				+ "DESSA FORMA PRECISA-SE FAZER REHASHING.\n\n");
		
		for(int i = 0; i < S.length; i++){
			System.out.println((i+1)+"º PASSO:");
			hash.inserir(S[i]);
			System.out.println();
			hash.imprimir();
		}
		
		hash.calculoFC();
		hash.calculoFB();
		System.out.println("FATOR DE CARGA = "+hash.getFC());
		System.out.println("FATOR DE BALANCEAMENTO = "+hash.getFB()+"\n");
		
		System.out.println("--------------------------------------------------------------------\n");
		
		for(int i = 0; i < D.length; i++){
			System.out.println((i+1)+"º PASSO:");
			hash.deletar(D[i]);
			System.out.println();
			hash.imprimir();
		}
		
		hash.calculoFC();
		hash.calculoFB();
		System.out.println("FATOR DE CARGA = "+hash.getFC());
		System.out.println("FATOR DE BALANCEAMENTO = "+hash.getFB()+"\n");
		
		
	}
	
	
	
	

}

