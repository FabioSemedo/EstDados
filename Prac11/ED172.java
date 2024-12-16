import java.util.Scanner;

public class ED172 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BSTree<Word> t = new BSTree<Word>();

        while(in.hasNext()){
            Word w = new Word(in.next());
            if(t.contains(w)){
                countWord(t.getRoot(),w);
            }else{
                t.insert(w);
            }
        }

        print(t.getRoot());
    }

    public static boolean countWord(BSTNode<Word> t,Word w){
        if(t==null) return false;
        if(t.getValue().word.equals(w.word)) {
            ++t.getValue().count;
            return true;
        }
        if(t.getValue().word.compareTo(w.word) < 0){
            return countWord(t.getRight(), w);
        } 
        return countWord(t.getLeft(), w);
    }

    public static void print(BSTNode<Word> t){
        if(t==null) {
            return;
        }
        print(t.getLeft());
        System.out.println(t.getValue().word + ": "+t.getValue().count);
        print(t.getRight());
    }
}

class Word implements Comparable<Word>{
    String word;
    int count;
    
    Word(String w){
        word = w;
        count = 1;
    }

    @Override
    public int compareTo(Word w){
        return this.word.compareTo(w.word);
    }
}

class BSTNode<T extends Comparable<? super T>> {
    private T value;          // Valor guardado no no
    private BSTNode<T> left;  // Filho esquerdo
    private BSTNode<T> right; // Filho direito
 
    // Construtor
    BSTNode(T v, BSTNode<T> l, BSTNode<T> r) {
       value = v;
       left = l;
       right = r;
    }
 
    // Getters e Setters
    public T getValue() {return value;}
    public BSTNode<T> getLeft() {return left;}
    public BSTNode<T> getRight() {return right;}
    public void setValue(T v) {value = v;}
    public void setLeft(BSTNode<T> l) {left = l;}
    public void setRight(BSTNode<T> r) {right = r;}   
 }

 // -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Arvore binaria de pequisa
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

// O tipo T tem de implementar o interface Comparable
// (ou te-lo herdado de uma super classe).
class BSTree<T extends Comparable<? super T>> {   
    private BSTNode<T> root; // raiz da arvore
 
    // Construtor
    BSTree() {
       root = null;
    }

   //  BSTree(BTree<T> t){
   //    root = t.getRoot();
   //  }
 
 
    // Getter e Setter para a raiz
    public BSTNode<T> getRoot() {return root;}
    public void setRoot(BSTNode<T> r) {root = r;}
    
    // Verificar se arvore esta vazia
    public boolean isEmpty() {
       return root == null;
    }
 
    // Limpa a arvore (torna-a vazia)
    public void clear() {
       root = null;
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
    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
       return contains(root, value);
    }
 
    private boolean contains(BSTNode<T> n, T value) {
       if (n==null) return false;
       if (value.compareTo(n.getValue()) < 0) // menor? sub-arvore esquerda
          return contains(n.getLeft(), value);
       if (value.compareTo(n.getValue()) > 0) // maior? sub-arvore direita
          return contains(n.getRight(), value);
       return true; // se nao e menor ou maior, e porque e igual
    }
 
    // --------------------------------------------------------
    // Adicionar elemento a uma arvore de pesquisa
    // Devolve true se conseguiu inserir, false caso contrario
    public boolean insert(T value) {
       if (contains(value)) return false;
       root = insert(root, value);
       return true;
    }
 
    private BSTNode<T> insert(BSTNode<T> n, T value) {
       if (n==null)
          return new BSTNode<T>(value, null, null);
       else if (value.compareTo(n.getValue()) < 0) 
          n.setLeft(insert(n.getLeft(), value));
       else if (value.compareTo(n.getValue()) > 0)
          n.setRight(insert(n.getRight(), value));
       return n;
    }
 
    // --------------------------------------------------------
    // Remover elemento de uma arvore de pesquisa
    // Devolve true se conseguiu remover, false caso contrario
    public boolean remove(T value) {
       if (!contains(value)) return false;
       root = remove(root, value);
       return true;
    }
 
    // Assume-se que elemento existe (foi verificado antes)
    private BSTNode<T> remove(BSTNode<T> n, T value) {
       if (value.compareTo(n.getValue()) < 0)
          n.setLeft(remove(n.getLeft(), value));
       else if (value.compareTo(n.getValue()) > 0)
          n.setRight(remove(n.getRight(), value));
       else if (n.getLeft() == null) // Nao tem filho esquerdo
          n = n.getRight();
       else if (n.getRight() == null) // Nao tem filho direito
          n = n.getLeft();
       else { // Dois fihos: ir buscar maximo do lado esquerdo
          BSTNode<T> max = n.getLeft();
          while (max.getRight() != null) max = max.getRight();
          n.setValue(max.getValue()); // Substituir valor removido
          // Apagar valor que foi para lugar do removido
          n.setLeft(remove(n.getLeft(), max.getValue()));
       }
       return n;
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
   //  public void printBFS() {
   //     System.out.print("BFS:");
       
   //     MyQueue<BSTNode<T>> q = new LinkedListQueue<BSTNode<T>>();
   //     q.enqueue(root);
   //     while (!q.isEmpty()) {
   //        BSTNode<T> cur = q.dequeue();
   //        if (cur != null) {
   //           System.out.print(" " + cur.getValue());
   //           q.enqueue(cur.getLeft());
   //           q.enqueue(cur.getRight());
   //        }
   //     }
   //     System.out.println();
   //  }
 
   //  // --------------------------------------------------------
    
   //  // Imprimir arvore numa visita em largura (usando TAD Pilha)
   //  public void printDFS() {
   //     System.out.print("DFS:");
       
   //     MyStack<BSTNode<T>> q = new LinkedListStack<BSTNode<T>>();
   //     q.push(root);
   //     while (!q.isEmpty()) {
   //        BSTNode<T> cur = q.pop();
   //        if (cur != null) {
   //           System.out.print(" " + cur.getValue());
   //           q.push(cur.getLeft());
   //           q.push(cur.getRight());
   //        }
   //     }
   //     System.out.println();
   //  }

   public T minValue(){
      if(root==null) return null;
      BSTNode<T> cur = root;
      while(cur.getLeft()!=null){
         cur = cur.getLeft();
      }
      return cur.getValue();
   }

   public T maxValue(){
      if(root==null) return null;
      BSTNode<T> cur = root;
      while(cur.getRight()!=null){
         cur = cur.getRight();
      }
      return cur.getValue();
   }

   public int countBetween(T a, T b){
      if(root==null) return 0;
      return goCountBetween(root, a, b);
   }

   public int goCountBetween(BSTNode<T> t, T a, T b){
      if(t==null) return 0;
      // t-a < 0 => goRight
      if(t.getValue().compareTo(a) < 0) return goCountBetween(t.getRight(), a, b);
      // t-b > 0 => goLeft
      if(t.getValue().compareTo(b) > 0) return goCountBetween(t.getLeft(), a, b);
      
      return 1 + goCountBetween(t.getLeft(), a, b) 
               + goCountBetween(t.getRight(), a, b);
   }
    
   public boolean valid(){
      if(root==null) return true;
      return valid(root);
    }

    public boolean valid(BSTNode<T> t){
      if(t==null) return true;
      if(t.getRight()!=null){
         T minR = minV(t.getRight());
         if(t.getValue().compareTo(minR) > 0) return false;
      }
      if(t.getLeft()!=null){
         T maxL = maxV(t.getLeft());
         if(t.getValue().compareTo(maxL) < 0) return false;
      }
      return true && valid(t.getLeft()) && valid(t.getRight());
    }

    public T maxV(BSTNode<T> t){
      //fail
      if(t==null) return null;
      // return leaf
      if(t.getLeft()==null && t.getRight()==null) return t.getValue();
      if(t.getLeft()==null && t.getRight()!=null) {
         T right = maxV(t.getRight());
         if(right.compareTo(t.getValue()) > 0) return right;
         return t.getValue();
      }
      if(t.getLeft()!=null && t.getRight()==null) {
         T left = maxV(t.getLeft());
         if(left.compareTo(t.getValue()) > 0) return left;
         return t.getValue();
      }
      T right = maxV(t.getRight());
      T left = maxV(t.getLeft());

      // left = max(left, right)
      if(right.compareTo(left) > 0) left = right;

      if(left.compareTo(t.getValue()) > 0) return left;
      return t.getValue();
    }

    public T minV(BSTNode<T> t){
      //fail
      if(t==null) return null;
      // return leaf
      if(t.getLeft()==null && t.getRight()==null) return t.getValue();
      // parent of right
      if(t.getLeft()==null && t.getRight()!=null) {
         T right = minV(t.getRight());
         if(right.compareTo(t.getValue()) > 0) return t.getValue();
         return right;
      }
      //parent of left
      if(t.getLeft()!=null && t.getRight()==null) {
         T left = minV(t.getLeft());
         if(left.compareTo(t.getValue()) > 0) return t.getValue();
         return left;
      }
      //parent of left and right
      T right = minV(t.getRight());
      T left = minV(t.getLeft());

      // left = min(left, right)
      if(right.compareTo(left) < 0) left = right;
      
      if(left.compareTo(t.getValue()) < 0) return left;
      return t.getValue();
    }
 }