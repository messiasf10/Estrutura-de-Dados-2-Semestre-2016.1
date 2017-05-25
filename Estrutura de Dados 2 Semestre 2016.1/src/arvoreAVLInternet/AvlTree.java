package arvoreAVLInternet;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class AvlTree {  
       private AvlNode root = null;  
  
       public AvlTree( ) {  
           root = null;  
       }  
         
       public void clear() {  
           root = null;  
       }  
       public boolean isEmpty() {  
           return root == null;  
       }  
         
       public AvlNode getRootNode (){  
           return root;  
       }  
         
       /** Retorna a altura da Arvore */  
       private static int height( AvlNode t ) {  
           return t == null ? -1 : t.height;  
       }  
         
        /** 
        * Retorna o maior valor ente lhs e rhs. 
        */  
       private static int max( int lhs, int rhs ) {  
           return lhs > rhs ? lhs : rhs;  
       }  
         
       /** Retorna o fator de balanceamento da Arvore com raiz t */   
       private int getFactor (AvlNode t) {  
           return height( t.left ) - height( t.right );  
       }  
         
       public boolean insert (int x) {  
           root = insert (x, root);  
           return true;  
       }  
         
       private AvlNode insert (int x, AvlNode t) {  
           if( t == null )  
               t = new AvlNode( x, null, null );  
           else if( x<t.key ) t.left = insert( x, t.left );  
           else if( x>t.key) t.right = insert( x, t.right );  
           t = balance (t);  
           return t;  
       }  
         
       public AvlNode balance (AvlNode t) {  
           if ( getFactor(t) == 2 ) {  
                   if (getFactor (t.left)>0) t = doRightRotation( t );  
                   else t = doDoubleRightRotation( t );  
           }  
           else if ( getFactor(t) == -2 ) {  
                   if ( getFactor(t.right)<0 ) t = doLeftRotation( t );  
                   else t = doDoubleLeftRotation( t );  
           }  
           t.height = max( height( t.left ), height( t.right ) ) + 1;  
           return t;  
       }  
  
       /** Faz Rotacao simples a direita */  
       private static AvlNode doRightRotation( AvlNode k2 ) {  
           AvlNode k1 = k2.left;  
           k2.left = k1.right;  
           k1.right = k2;  
           k2.height = max( height( k2.left ), height( k2.right ) ) + 1;  
           k1.height = max( height( k1.left ), k2.height ) + 1;  
           return k1;  
       }  
  
       /** Rotacao simples a esquerda */  
       private static AvlNode doLeftRotation( AvlNode k1 ) {  
           AvlNode k2 = k1.right;  
           k1.right = k2.left;  
           k2.left = k1;  
           k1.height = max( height( k1.left ), height( k1.right ) ) + 1;  
           k2.height = max( height( k2.right ), k1.height ) + 1;  
           return k2;  
       }  
  
       /** Rotacao dupla a direita */  
       private static AvlNode doDoubleRightRotation( AvlNode k3 ) {  
           k3.left = doLeftRotation( k3.left );  
           return doRightRotation( k3 );  
      }  
  
       /** Rotacao dupla a esquerda */  
       private static AvlNode doDoubleLeftRotation( AvlNode k1 ) {  
           k1.right = doRightRotation( k1.right );  
           return doLeftRotation( k1 );  
       }  
         
       public AvlNode search(int el) {  
           return search(root,el);  
       }  
       protected AvlNode search(AvlNode p, int el) {  
           while (p != null) {  
               /* se valor procuradp == chave do no retorna referencia ao no */   
               if (el==p.key) return p;  
               /* se valor procurado < chave do no, procurar na subarvore esquerda deste no */  
               else if (el<p.key) p = p.left;  
               /* se valor procurado > chave do nó, procurar na subarvore direita deste no */  
               else p = p.right;  
           }  
           // caso chave nao foi achada, retorna null  
           return null;  
       }  
         
       public void inorder() {  
           inorder(root);  
       }  
       protected void inorder(AvlNode p) {  
           if (p != null) {  
                inorder(p.left);  
                System.out.print(p.key+" - ");  
                inorder(p.right);  
           }  
       }  
         
       public void preorder() {  
           preorder(root);  
       }  
       
       protected void preorder(AvlNode p) {  
           if (p != null) {  
                System.out.print(p.key + " ");  
                preorder(p.left);  
                preorder(p.right);  
           }  
       }  
         
       public void postorder() {  
           postorder(root);  
       }  
     
       protected void postorder(AvlNode p) {  
           if (p != null) {  
                postorder(p.left);  
                postorder(p.right);  
                System.out.print(p.key + " ");  
           }  
       }  
         
   protected AvlNode searchFather (int el) {  
       AvlNode p = root;  
       AvlNode prev = null;  
       while (p != null && !(p.key==el)) {  // acha o no p com a chave el  
           prev = p;                             
           if (p.key<el)  
                 p = p.right;  
           else p = p.left;  
       }  
       if (p!=null && p.key==el) return prev;  
       return null;  
   }  
     
   /* Metodo de autoria de Leonardo Zandona - 2006/2 */  
   public void displayTree() {  
    if (isEmpty()){  
        System.out.println("Arvore vazia!");  
        return;  
    }             
    String separator = String.valueOf("  |__");  
    System.out.println(this.root.key+"("+root.height+")");  
    displaySubTree(root.left,  separator);  
    displaySubTree(root.right, separator);  
}  
   
private void displaySubTree(AvlNode node, String separator) {  
      
    if (node != null) {  
          
        AvlNode father = this.searchFather(node.key);  
        if (node.equals(father.left) == true) {  
            System.out.println(separator+node.key+"("+node.height+")"+" (ESQ)");  
        }else{  
            System.out.println(separator+node.key+"("+node.height+")"+" (DIR)");  
        }             
        displaySubTree(node.left,  "     "+separator);  
        displaySubTree(node.right, "     "+separator);  
    }  
}  
         
       public static void main (String args[]){  
           AvlTree t = new AvlTree();  
           t.insert(10);
           t.displayTree();
           t.insert(5);  
           t.displayTree();
           t.insert(15);  
           t.displayTree();
           t.insert(23);  
           t.displayTree();
           t.insert(32);  
           t.displayTree();
           t.insert(1);  
           t.displayTree();
           t.insert(3);   
           t.displayTree();  
       }
}