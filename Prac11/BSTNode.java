// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// No de uma arvore binaria "normal"
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class BSTNode<T> {
   private T value;         // Valor guardado no no
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