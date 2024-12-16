// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Arvore binaria "normal"
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class BTree<T> {   
   private BSTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BSTNode<T> getRoot() {return root;}
   public void setRoot(BSTNode<T> r) {root = r;}

   // Verificar se arvore esta vazia
   public boolean isEmpty() {
      return root == null;
   }

   // --------------------------------------------------------

   // Numero de nos da arvore   
   public int numberNodes() {
      return numberNodes(root);
   }

   private int numberNodes(BSTNode<T> n) {
      if (n == null) return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BSTNode<T> n) {
      if (n == null) return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------
   
   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BSTNode<T> n, T value) {
      if (n==null) return false;
      if (n.getValue().equals(value)) return true;
      return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BSTNode<T> n) {
      if (n==null) return;
      System.out.print(" " + n.getValue() );
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
   }

   // --------------------------------------------------------
   
   // Imprimir arvore em InOrder
   public void printInOrder() {
      System.out.print("InOrder:");
      printInOrder(root);
      System.out.println();
   }

   private void printInOrder(BSTNode<T> n) {
      if (n==null) return;
      printInOrder(n.getLeft());
      System.out.print(" " + n.getValue());
      printInOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em PostOrder
   public void printPostOrder() {
      System.out.print("PostOrder:");
      printPostOrder(root);
      System.out.println();
   }

   private void printPostOrder(BSTNode<T> n) {
      if (n==null) return;
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      System.out.print(" " + n.getValue());
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em largura (usando TAD Fila)
   public void printBFS() {
      System.out.print("BFS:");
      
      MyQueue <BSTNode<T>> q = new LinkedListQueue<BSTNode<T>>();
      q.enqueue(root);
      while (!q.isEmpty()) {
         BSTNode<T> cur = q.dequeue();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.enqueue(cur.getLeft());
            q.enqueue(cur.getRight());
         }
      }
      System.out.println();
   }

   // --------------------------------------------------------
   
   // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
   public void printDFS() {
      System.out.print("DFS:");
      
      MyStack <BSTNode<T>> q = new LinkedListStack<BSTNode<T>>();
      q.push(root);
      while (!q.isEmpty()) {
         BSTNode<T> cur = q.pop();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.push(cur.getLeft());
            q.push(cur.getRight());
         }
      }
      System.out.println();
   }

   public int numberLeafs(){
      return numberLeafs(root);
   }

   private int numberLeafs(BSTNode<T> n) {
      if (n == null) return 0;
      if(n.getLeft()==null && n.getRight()==null) return 1;
      return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
   }

   public  boolean strict(){
      return strict(root);
   }

   public boolean strict(BSTNode<T> n){
      if( n.getLeft() == null && n.getRight()== null) return true;
      if( n.getLeft()!= null && n.getRight()!= null)  return strict(n.getLeft()) && strict(n.getRight());
      return false;
   }

   public T path(String s) {
      if(s=="R") return root.getValue();
      BSTNode <T> cur = root;
      for (int i = 0; i < s.length(); i++) {
         switch(s.charAt(i)){
            case 'E':
            case 'e':
               cur = cur.getLeft();
               break;

            case 'D':
            case 'd':
               cur = cur.getRight();
               break;
         }
      }

      return cur.getValue();
   }

   public int nodesLevel(int k){
      return nodesLevel(k, root);
    }
    public int nodesLevel(int k, BSTNode<T> n){
      if(n == null) return 0;
      if(k==0) return 1;
      //System.out.println(n.getValue()+"\tk="+k);
      return nodesLevel(k-1, n.getLeft()) + nodesLevel(k-1, n.getRight());
    }

}