import java.util.Arrays;

public class ED232 {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        int [] elems = {2,5,1,1,2,1};

        for (int i = 0; i < elems.length; i++) {
            list.addLast(elems[i]);     
        }
        System.out.println(list.toString());
        System.out.println();
        
        System.out.println(Arrays.toString(list.occurrences(1)));
        System.out.println(Arrays.toString(list.occurrences(2)));
        System.out.println(Arrays.toString(list.occurrences(3)));
        
        SinglyLinkedList<Character> list2 = new SinglyLinkedList<Character>();
        SinglyLinkedList<Character> toRemove = new SinglyLinkedList<Character>();
        char [] cs = {'a','b','d','a','c'};
        
        for (int i = 0; i < cs.length; i++) {
            list2.addLast(cs[i]);     
        }

        toRemove.addLast('a');
        toRemove.addLast('b');
        toRemove.addLast('c');
        toRemove.addLast('d');

        System.out.println(list2.toString());
        System.out.println(list2.size());
        list2.remove(toRemove);
        System.out.println(list2.toString());
        System.out.println(list2.size());
    }
}

class Node<T> {
    private T value;      // Valor guardado no no
    private Node<T> next; // Referencia para o proximo no da lista
 
    // Construtor
    Node(T v, Node<T> n) {
       value = v;
       next = n;
    }
 
    // Getters e Setters
    public T getValue() { return value; }
    public Node<T> getNext()  { return next; }
    public void setValue(T v) { value=v; }
    public void setNext(Node<T> n) { next = n; }
 }

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
        Node <T> cur = first;
        
        while (toRemove.contains(this.getFirst())) {
            this.removeFirst();
        }
        if(first==null) return;

        while(cur.getNext()!=null){
            if(toRemove.contains(cur.getNext().getValue())){
                cur.setNext(cur.getNext().getNext());
                size--;
            }else{
                cur = cur.getNext();
            }
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