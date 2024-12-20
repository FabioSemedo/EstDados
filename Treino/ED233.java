import java.util.*;

public class ED233 {
    public static void main(String[] args) {
    Scanner in = new Scanner("6 3 2 1 N N N 5 N 7 N N 10 8 N 9 N N 25 N N");
    BTree<Integer> t = LibBTree.readIntTree(in);
    
    // Escrever resultado de chamada a alguns metodos
    System.out.println("numberNodes = " + t.numberNodes());
    System.out.println("depth = " + t.depth());
      System.out.println("contains(2) = " + t.contains(2));
      System.out.println("contains(3) = " + t.contains(3));

      // Escrever nos da arvore seguindo varias ordens possiveis
      //   t.printPreOrder();      
      //   t.printInOrder();
    //   t.printPostOrder();
    t.printBFS();
    t.printDFS();
    
    //   t.cut(3);
    //   t.printBFS();
    //   t.cut(2);
    //   t.printBFS();
    //   t.cut(1);
    //   t.printBFS();
    System.out.println(Arrays.toString(t.maxLevel()));
    t.cut(2);
    System.out.println(Arrays.toString(t.maxLevel()));
    in = new Scanner("6 3 2 1 5 N N N N N N");
    t = LibBTree.readIntTree(in);
    System.out.println(Arrays.toString(t.maxLevel()));

    }
    
}

class LibBTree {
    public static BTree<Integer> readIntTree(Scanner in) {
       BTree<Integer> t = new BTree<Integer>();
       t.setRoot(readIntNode(in));
       return t;
    }
    
    private static BTNode<Integer> readIntNode(Scanner in) {
       String s = in.next();
       if (s.equals("N")) return null;
       Integer value = Integer.parseInt(s);
       BTNode<Integer> left = readIntNode(in);
       BTNode<Integer> right = readIntNode(in);
       return new BTNode<Integer>(value, left, right);
    }
 }

class BTNode<T> {
    private T value;         // Valor guardado no no
    private BTNode<T> left;  // Filho esquerdo
    private BTNode<T> right; // Filho direito
 
    // Construtor
    BTNode(T v, BTNode<T> l, BTNode<T> r) {
       value = v;
       left = l;
       right = r;
    }
 
    // Getters e Setters
    public T getValue() {return value;}
    public BTNode<T> getLeft() {return left;}
    public BTNode<T> getRight() {return right;}
    public void setValue(T v) {value = v;}
    public void setLeft(BTNode<T> l) {left = l;}
    public void setRight(BTNode<T> r) {right = r;}   
 }

 class BTree<T> {   
    private BTNode<T> root; // raiz da arvore
 
    // Construtor
    BTree() {
       root = null;
    }
 
    // Getter e Setter para a raiz
    public BTNode<T> getRoot() {return root;}
    public void setRoot(BTNode<T> r) {root = r;}
 
    // Verificar se arvore esta vazia
    public boolean isEmpty() {
       return root == null;
    }
 
    // --------------------------------------------------------
 
    // Numero de nos da arvore   
    public int numberNodes() {
       return numberNodes(root);
    }
 
    private int numberNodes(BTNode<T> n) {
       if (n == null) return 0;
       return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }
 
    // --------------------------------------------------------
 
    // Altura da arvore
    public int depth() {
       return depth(root);
    }
 
    private int depth(BTNode<T> n) {
       if (n == null) return -1;
       return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }
 
    // --------------------------------------------------------
    
    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
       return contains(root, value);
    }
 
    private boolean contains(BTNode<T> n, T value) {
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
 
    private void printPreOrder(BTNode<T> n) {
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
 
    private void printInOrder(BTNode<T> n) {
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
 
    private void printPostOrder(BTNode<T> n) {
       if (n==null) return;
       printPostOrder(n.getLeft());
       printPostOrder(n.getRight());
       System.out.print(" " + n.getValue());
    }
 
    // --------------------------------------------------------
 
    // Imprimir arvore numa visita em largura (usando TAD Fila)
    public void printBFS() {
       System.out.print("BFS:");
       
       //MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
       LinkedList<BTNode<T>> q = new LinkedList<BTNode<T>>();
       q.add(root);
       while (!q.isEmpty()) {
          BTNode<T> cur = q.removeFirst();
          if (cur != null) {
             System.out.print(" " + cur.getValue());
             q.add(cur.getLeft());
             q.add(cur.getRight());
          }
       }
       System.out.println();
    }
 
    // --------------------------------------------------------
    
    // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
    public void printDFS() {
       System.out.print("DFS:");
       
       //MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
       LinkedList<BTNode<T>> q = new LinkedList<BTNode<T>>();
       q.push(root);
       while (!q.isEmpty()) {
          BTNode<T> cur = q.pop();
          if (cur != null) {
             System.out.print(" " + cur.getValue());
             q.push(cur.getLeft());
             q.push(cur.getRight());
          }
       }
       System.out.println();
    }

    public void cut(int n){
        //size = 
        cut(root, n);
    }
    public int cut(BTNode<T> t,int n){
        if(t==null) return 0;
        if(n<=1){
            t.setLeft(null);
            t.setRight(null);
        }
        return 1 + cut(t.getLeft(), n-1) + cut(t.getRight(), n-1);
    }

    public int height(){
        return height(root);
    }
    public int height(BTNode<T> t){
        if (t==null) return -1 ;
        return 1 + Math.max(height(t.getLeft()), height(t.getRight()));
    }

    int [] auxWidth;

    public int[] maxLevel(){
        int height = this.height();
        int [] res = new int [2];

        auxWidth = new int [height+1];

        levelWidth(root, 0);

        int max = auxWidth[0];
        int maxEq = 1;
        for (int i = 1; i < auxWidth.length; i++) {
            if(auxWidth[i]==max){
                maxEq++;
            }
            if(auxWidth[i]> max){
                max = auxWidth[i];
                maxEq=1;
            }
        }
        res[0] = max;
        res[1] = maxEq;

        return res;
    }
    
    public int levelWidth(BTNode<T> t, int i){
        if(t==null) return 0;
        auxWidth[i]++;
        return levelWidth(t.getLeft(),i+1) + levelWidth(t.getRight(), i +1);
    }
 }