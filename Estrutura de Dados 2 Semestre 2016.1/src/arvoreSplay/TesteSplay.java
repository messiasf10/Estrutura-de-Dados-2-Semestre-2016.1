package arvoreSplay;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteSplay {

	public static void main(String[] args) {
		
		ArvoreSplay splay = new ArvoreSplay();
		
		//int[] S = {13,11,21,4,9,2,17,14,32,6,19,27};
		//int[] S = {8,9,91,17,25,27,8,13,12,92,11,13,21,18,3,8,16,9,19,17,37,44,
    		//	33,27,53};
		
		int[] S = {4,1,81,21,4,9,81,16,7,3,58,32,1};
		int[] B = {4,9,81,1,14,4,11,1};
		int[] D = {32,1,3,16};
		
		//int[] B = {91,18,37,44,18,19,91,18};
		//int[] B = {11,4,6,11,7,32,4};
				
		for(int i = 0;i < S.length;i++){
			System.out.println("\n"+(i+1)+"º PASSO:");
			System.out.println("INSERIR ELEMENTO "+S[i]);
			splay.inserir(S[i]);
			System.out.println();
			splay.printArvoreBinaria();
			System.out.println("\nALTURA = "+splay.altura());
		}
		
		System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("\nARVORE FINAL APOS AS INSERCOES\n");
        splay.printArvoreBinaria();
        
        System.out.println("\nALTURA FINAL DA ARVORE = "+splay.altura());
        System.out.println("\n-------------------------------------------------------------------------");
		
		for(int i = 0;i < B.length;i++){
			System.out.println("\n"+(i+1)+"º PASSO:");
        	System.out.println("BUSCAR ELEMENTO "+B[i]);
			splay.buscar(B[i]);
			System.out.println();
			splay.printArvoreBinaria();
			System.out.println("\nALTURA = "+splay.altura());
		}
		
		System.out.println("\n-------------------------------------------------------------------------");
		
		for(int i = 0;i < D.length;i++){
			System.out.println("\n"+(i+1)+"º PASSO:");
        	System.out.println("DELETAR ELEMENTO "+D[i]);
        	splay.deletar(D[i]);
        	System.out.println();
			splay.printArvoreBinaria();
			System.out.println("\nALTURA = "+splay.altura());
		}
		
		System.out.println("\n------------------------------------------------------");
        System.out.println("\nARVORE FINAL\n");
        splay.printArvoreBinaria();
        
        System.out.println("\nALTURA FINAL DA ARVORE = "+splay.altura());
		
	}
	
}
