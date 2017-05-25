package hashingReHash;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteReHash {

	public static void main(String[] args) {
		
		Rehash hash = new Rehash(5);
		
		//int[] S = {13,15,24,6,23,25,15,19};
		//int[] S = {2,2,2}; //FAZER PARA TAMNHO DA TABELA IGUAL A 4 - NUMERO NA VAI SER INSERIDO DPS DA REHASHING
		//int[] S = {27,13,12,92,11,21,18,3,16,19,37,44,18,9,91,17,25,16,42,39,38,22,61,54,
			//	33,53};
		//int[] D = {18,11,91,22};
		
		System.out.println(
				  "REHASHING FUNCIONA DA SEGUINTE MANEIRA: O ELEMENTO VAI TENTAR SER INSERIDO NORMALMENTE\n"
				+ "NA HASHING. CASO ELE POSSA SER INSERIDO, A INSERCAO ACONTECE E O PROXIMO ELEMENTO VEM PARA\n"
				+ "SER INSERIDO. NO CASO DE OCORRER UMA COLISAO, FAZ-SE A TENTATIVA QUADRATICA PARA TENTAR \n"
				+ "INSERIR O ELEMENTO EM OUTRA CELULA. SE APOS A TENTATIVA QUADRATICA O ELEMENTO NAO CONSEGUIR \n"
				+ "SER INSERIDO, FAZ-SE REHASHING, QUE FUNCIONA DA SEGUINTE MANEIRA: MULTIPLICA-SE O TAMANHO DA \n"
				+ "HASHING (TH) POR 2 E PEGA-SE O PROXIMO NUMERO NATURAL PRIMO DA SEQUENCIA, E ESSE NUMERO SERA \n"
				+ "O NOVO TAMANHO DA HASHING. DAI, MAPEIA-SE TODOS OS VALORES NA NOVA TABELA HASHING. REPETE-SE\n"
				+ "ESSE PROCESSO ATE QUE TODOS OS ELEMENTOS TENHAM SIDO INSERIDOS.\n\n");
		
		int[] S = {16,18,22,29,27,2,18,13,12,28,31,81,01,19,8,14,91,32,1,31};
		int[] D = {0,71,14,22};
		
		for (int i = 0; i < S.length; i++){
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
