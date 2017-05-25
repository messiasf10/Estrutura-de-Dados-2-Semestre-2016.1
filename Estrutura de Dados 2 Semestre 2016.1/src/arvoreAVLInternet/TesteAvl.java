package arvoreAVLInternet;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class TesteAvl {

	public static void main(String[] args) {
		
		AvlTree avl = new AvlTree();
		
		avl.insert(5);
		avl.insert(4);
		avl.insert(3);
		
		avl.displayTree();
		
		
	}
	
}
