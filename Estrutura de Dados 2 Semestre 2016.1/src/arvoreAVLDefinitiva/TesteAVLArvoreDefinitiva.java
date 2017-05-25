package arvoreAVLDefinitiva;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteAVLArvoreDefinitiva {

	public static void main(String[] args) {
		
		//int[] S = {1,2,3,4,5,6,7,8,9,24,1222,51,69,11};
    	//int[] S = {8,9,91,17,25,27,8,13,12,92,11,13,21,18,3,8,16,9,19,17,37,44,
    		//	33,27,53};
    	//int[] S = {4,2,6,1,3,5,7,15,14,13};
    	//int[] S = {1,2,3,4,5,6,7};  ROTACOES SIMPELS A ESQUERDA
    	//int[] S = {1,2,3,4,5,6,7};
		//int[] S = {21,12,31,15,91,9,8,4,51,3,19,27,2,47,17,54,49}; //DA ERRO NA DELECAO
		//int[] S = {19,9,33,7,15,23,40,5,14,17,25,38,70,36,13}; //EXEMPLO DO PROFESSOR EM SALA
		//int S[] = {61,91,9,92,74,69,51,44,80,88,91,71,57,32,35,97,59,80,14,7,39,73,99,30,41}; //EXEMPLO DO LEO
		//int S[] = {1,2,3,4,5,6,7,8,9,24,1222,51,69,11};
				
		int[] S = {91,15,55,12,16,21,10,16,28,2,52,19,3,7,14,19};
		int[] B = {19,7,21,3,21,7,19,3};
		int[] D = {7,8,23,21,15};
		
    	//int[] D = {19,9,27,12,8,21}; //DA ERRO NA DELECAO DO 8		    			
		
        AVLArvore avl = new AVLArvore();
        
        for(int i = 0;i < S.length;i++){
        	System.out.println("\n"+(i+1)+"º PASSO:");
			System.out.println("INSERIR ELEMENTO "+S[i]);
			avl.inserir(S[i]);
			System.out.println();
			avl.printArvoreBinaria();
			System.out.println("\nALTURA = "+avl.getAlturaArvore());
		}
        
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("\nARVORE FINAL APOS AS INSERCOES\n");
        avl.printArvoreBinaria();
        
        System.out.println("\nALTURA FINAL DA ARVORE = "+avl.getAlturaArvore());
        System.out.println("\n-------------------------------------------------------------------------");
        
        
        for(int i = 0;i < B.length;i++){
			System.out.println("\n"+(i+1)+"º PASSO:");
        	System.out.println("BUSCAR ELEMENTO "+B[i]);
			avl.buscar(B[i]);
			System.out.println();
			avl.printArvoreBinaria();
			System.out.println("\nALTURA = "+avl.getAlturaArvore());
		}
        
        System.out.println("\n-------------------------------------------------------------------------");
        
        for(int i = 0;i<D.length;i++){
        	System.out.println("\n"+(i+1)+"º PASSO:");
        	System.out.println("DELETAR ELEMENTO "+D[i]);
			avl.deletar(D[i]);		
			System.out.println();
			avl.printArvoreBinaria();
			System.out.println("\nALTURA = "+avl.getAlturaArvore());
		}
        
        System.out.println("\n------------------------------------------------------");
        System.out.println("\nARVORE FINAL\n");
        avl.printArvoreBinaria();
        
        System.out.println("\nALTURA FINAL DA ARVORE = "+avl.getAlturaArvore());

	}

}
