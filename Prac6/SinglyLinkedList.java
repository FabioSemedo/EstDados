// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Lista ligada simples (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class SinglyLinkedList<T> {
   private Node<T> first;    // Primeiro no da lista
   private int size;         // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }
   
   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first); 
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null); 
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);         
      }
      size++;
   }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();      
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }

   public T get(int pos){
      Node<T> cur = first;
      for (int i = 0; i < pos && cur!=null; i++) {
         cur = cur.getNext();
      }
      
      if(cur!=null)
         return cur.getValue();

      return null;
   }

   public T remove(int pos){
      if(pos < 0 || this.size-1 < pos || this.isEmpty()) 
       return null;
      
       Node<T> cur,prev;
       
       cur = this.first;
       
      if(pos==0){
         first = first.getNext();
         size--;
         return cur.getValue();
      }
         
      prev = first;
      while(prev.getNext()!=null && pos>1){
         prev = prev.getNext();
         pos--;
      }
      cur = prev.getNext();

      if(cur !=null && pos==1)
      {
         prev.setNext(prev.getNext().getNext());
         size--;
         return cur.getValue();
      }

      return null;
   }

   public SinglyLinkedList<T> copy(){
      SinglyLinkedList<T> temp = new SinglyLinkedList<T>();
      if(first ==null){
         temp.first = null;
         temp.size = 0;
         return temp;
      }
      
      Node <T> cur, nxt;
      
      nxt = first;
      cur = new Node <T> (nxt.getValue(), null);
      
      temp.first= cur;
      temp.size = this.size();
      nxt = nxt.getNext();

      while(nxt!=null){
         cur.setNext(new Node <T> (nxt.getValue(),null));
         cur = cur.getNext();
         nxt = nxt.getNext();
      }
      
      cur.setNext(null);
      return temp;
   }

   public void duplicate(){
      Node <T> cur = first;
      this.size = this.size()*2;
      while(cur!=null){
         cur.setNext(new Node <T> (cur.getValue(), cur.getNext()));
         cur = cur.getNext().getNext();
      }
   }

   public int count(T v){
      int count = 0;

      Node <T> cur = first;

      while(cur!=null){
         if(cur.getValue().equals(v)){
            count++;
         }
         cur = cur.getNext();
      }
      
      return count;
   }

   public void removeAll(T v){
      if(this.isEmpty()) return;

      while(first!=null && first.getValue().equals(v)){
         removeFirst();
      }

      Node <T> cur = first;

      if(cur==null) return;

      while(cur!= null && cur.getNext()!=null){// cur -- target -- nxtNxt
         if(cur.getNext().getValue().equals(v)){//remove next
            cur.setNext(cur.getNext().getNext());
            this.size--;
         }else{
            cur = cur.getNext();                //go to next
         }
      }
   }
   
   // Converte a lista para uma String
   public String toString() {
      String str = "{";      
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";                     
      }      
      str += "}";
      return str;
   }
}
