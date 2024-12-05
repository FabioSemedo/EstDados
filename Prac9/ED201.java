// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Geracao de subconjuntos
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------
import java.util.Scanner;

public class ED201 {
    static int sum;
    static int limit;
   //  static CircularLinkedList<Integer> arr;
   
    // Escrever todos os subconjuntos do array v[]
    static int sets(int v[], int limit) {
       boolean used[] = new boolean[v.length];
       return goSets2(0, v, used, limit); // chamar funcao recursiva
    }

    // Gera todos os subconjuntos a partir da posicao 'cur'
    static int goSets2(int cur, int v[], boolean used[], int limit) {
        if (cur == v.length) {  // Caso base: terminamos o conjunto
           // Escrever conjunto
           //System.out.print("Set:");
           int sum = 0;
           for (int i=0; i<v.length; i++) 
              if (used[i]) {
                //System.out.print(" " + v[i]);
                sum+= v[i];
                }
            return sum;
        } else {                  // Se nao terminamos, continuar a gerar
           used[cur] = true;      // Subconjuntos que incluem o elemento actual
           int a = goSets2(cur+1, v, used, limit);// Chamada recursiva
           used[cur] = false;     // Subconjuntos que nao incluem o el. actual
           int b = goSets2(cur+1, v, used, limit);// Chamada recursiva

           if( (a<= limit) && (b<=limit)){
            if(a>b) return a;
            else return b;
           }else if((a> limit) && (b<= limit)){
               return b;
           }else if((a<= limit)){
               return a;
           }
        }
        return 0;
    }  
 
    // -----------------------------------------------------------

    /*
    public static int max(int limit, CircularLinkedList<Integer> list){
      if(list.isEmpty()) 
         return -1;
   
      Node<Integer> cur = list.accessLast().getNext();
      int max = list.getLast();
   
     for (int i = 0; i < list.size(); i++) {
         if((max < cur.getValue()) && (cur.getValue() <= limit))
         {
            max = cur.getValue();
         }
         cur= cur.getNext();
      }
   
      return max;
      }   */
    
    public static void main(String[] args) {
       int v[] = {2,4,6,8}; // Inicializacao de array
       Scanner in = new Scanner(System.in);
       
       int limit = in.nextInt();
       int songs = in.nextInt();
       v= new int [songs];

       for (; songs>0; songs--) {
         v[songs-1] = in.nextInt();
       }

       System.out.println( sets(v, limit));

    }
 }

 /*
 class Node<T> {
   private T value;
   private Node<T> next;

   Node(T v, Node <T> n){
      value = v;
      next = n;
   }

   public T getValue(){return value;}
   public Node<T> getNext(){return next;}
   public void setValue(T v){value = v;}
   public void setNext(Node <T> n){next = n;}
}

class CircularLinkedList<T>{
   private Node<T> last;
   private int size;

   CircularLinkedList(){
      last = null;
      size =0;
   }

   public int size(){
      return size;
   }
   public boolean isEmpty(){
      return (size==0);
   }

   public Node <T> accessLast(){
      return last;
   }
   
   public void addFirst(T f){
      Node <T> tmp;

      if(last == null){
         tmp = new Node<T>(f, null);
         tmp.setNext(tmp);
         last = tmp;
      }else {
         tmp = new Node<T>(f, last.getNext());
      }

      last.setNext(tmp);
      size++;
   }
   public void addLast(T l){
      addFirst(l);
      last = last.getNext();
   }

   public T getFirst(){
      if(isEmpty()) return null;
      return last.getNext().getValue();
   }

   public T getLast(){
      if(isEmpty()) return null;
      return last.getValue();
   }

   @Override
   public String toString(){
      String str = "{";     
      Node<T> cur = last;

      if(size!=0){
         cur = cur.getNext();
         while (cur != last) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != last) str += ",";                     
         }      
      }
      str += "}";
      return str;
   }   
}
*/