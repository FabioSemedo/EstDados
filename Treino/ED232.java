import java.util.Arrays;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class ED232 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String type;
        int k,n;
        
        for (int i = in.nextInt(); i > 0; i--) {
            type = in.next();
            switch (type) {
                case "char":
                    SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();
                    SinglyLinkedList<Character> remove = new SinglyLinkedList<Character>();
                    
                    n = in.nextInt();
                    for (int j = 0; j < n; j++) {
                        list.addLast(in.next().charAt(0));
                    }

                    k = in.nextInt();
                    for (int j = 0; j < k; j++) {
                        remove.addLast(in.next().charAt(0));
                    }
                    testRemoveChar(list, remove);

                break;
                
                case "int":
                    SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
                    SinglyLinkedList<Integer> remove2 = new SinglyLinkedList<Integer>();
                    
                    n = in.nextInt();
                    for (int j = 0; j < n; j++) {
                        list2.addLast(in.nextInt());
                    }
                    
                    k = in.nextInt();
                    for (int j = 0; j < k; j++) {
                        remove2.addLast(in.nextInt());
                    }
                    testRemoveInt(list2, remove2);
                break;

                case "string":
                    SinglyLinkedList<String> list3 = new SinglyLinkedList<String>();
                    SinglyLinkedList<String> remove3 = new SinglyLinkedList<String>();
                    
                    n = in.nextInt();
                    for (int j = 0; j < n; j++) {
                        list3.addLast(in.next());
                    }
                    
                    k = in.nextInt();
                    for (int j = 0; j < k; j++) {
                        remove3.addLast(in.next());
                    }
                    testRemoveStr(list3, remove3);
                break;
            
                default:
                    break;
            }
        }
    }

    public static void testRemoveInt(SinglyLinkedList<Integer> list2, SinglyLinkedList<Integer> toRemove){
        System.out.printf("%s\t%d\n",list2.toString(), list2.size());
        list2.remove(toRemove);
        System.out.printf("Removing %s\n",toRemove.toString(), list2.size());
        System.out.printf("%s\t%d\n",list2.toString(), list2.size());
        
    }
    public static void testRemoveChar(SinglyLinkedList<Character> list2, SinglyLinkedList<Character> toRemove){
        System.out.printf("%s\t%d\n",list2.toString(), list2.size());
        list2.remove(toRemove);
        System.out.printf("Removing %s\n",toRemove.toString(), list2.size());
        System.out.printf("%s\t%d\n",list2.toString(), list2.size());
        
    }
    public static void testRemoveStr(SinglyLinkedList<String> list2, SinglyLinkedList<String> toRemove){
        System.out.printf("%s\t%d\n",list2.toString(), list2.size());
        list2.remove(toRemove);
        System.out.printf("Removing %s\n",toRemove.toString(), list2.size());
        System.out.printf("%s\t%d\n",list2.toString(), list2.size());
        
    }
}

// class Node<T> {
//     private T value;      // Valor guardado no no
//     private Node<T> next; // Referencia para o proximo no da lista
 
//     // Construtor
//     Node(T v, Node<T> n) {
//        value = v;
//        next = n;
//     }
 
//     // Getters e Setters
//     public T getValue() { return value; }
//     public Node<T> getNext()  { return next; }
//     public void setValue(T v) { value=v; }
//     public void setNext(Node<T> n) { next = n; }
//  }

 class SinglyLinkedList<T> {
    private Node<T> first;    // Primeiro no da lista
    private Node<T> last;
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
       if(last==null) last = newNode;
    }
 
    // Adiciona v ao final da lista
    public void addLast(T v) {
       Node<T> newNode = new Node<T>(v, null); 
       if (isEmpty()) {
          first = newNode;
       }
     //else {
    //       Node<T> cur = first;
    //       while (cur.getNext() != null)
    //          cur = cur.getNext();
    //       cur.setNext(newNode);         
    //    }
    if(last==null) {
        last = newNode;
    }
    else{
        last.setNext(newNode);
    }   
        last = newNode;
       size++;
    }
 
    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
        if (isEmpty()) return null;
        return first.getValue();
     }
     public Node<T> getFirstN() {
        if (isEmpty()) return null;
        return first;
     }
 
    // Retorna o ultimo valor da lista (ou null se a lista for vazia)
    public T getLast() {
       if (isEmpty()) return null;
    //    Node<T> cur = first;
    //    while (cur.getNext() != null)
    //       cur = cur.getNext();
    //    return cur.getValue(); 
        return last.getValue();     
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
          last = cur;
       }
       size--;
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

    public SinglyLinkedList<T> reverse(){
        SinglyLinkedList<T> list = new SinglyLinkedList<T>();
        Node<T> cur = first;

        while (cur!=null) {
            //Node<T> n = new Node(cur.getValue(), null);
            list.addFirst(cur.getValue());
            cur = cur.getNext();
        }
        
        return list;
    }

    public int [] occurrences(T elem){
        Node<T> cur = first;
        // ArrayList<Integer> arr = new ArrayList<Integer>();
        int count = 0;
        int r[] = new int[this.size];
        int a[];

        for (int i = 0; i < this.size; i++) {
            if(cur.getValue().equals(elem)){
                r[count] = i;
                count++;
            }
            cur = cur.getNext();
        }

        if(count==0) return null;

        a = new int[count];
        for (int i = 0; i < a.length; i++) {
            a[i] = r[i];
        }

        return a;        
    }

    public void remove(SinglyLinkedList<T> toRemove){
        if(toRemove.size() == 0 || first == null) return;
        Node<T> cur = toRemove.getFirstN();
        Node<T> aux;

        for (int i = 0; i < toRemove.size(); i++) {
            while(first!=null && first.getValue().equals(cur.getValue())){
                first = first.getNext();
                size--;
            }
            for (aux = first; aux!=null && aux.getNext()!=null; ) {
                if(aux.getNext().getValue().equals(cur.getValue())){
                    aux.setNext(aux.getNext().getNext());
                    size--;
                }else{
                    aux = aux.getNext();
                }
            }
            cur = cur.getNext();
        }
    }
    
    public boolean contains(T elem){
        if(elem==null) return false;

        Node <T> cur = first;
        while(cur != null){
            if(cur.getValue().equals(elem)) return true;
            cur = cur.getNext();
        }

        return false;
    }
 }