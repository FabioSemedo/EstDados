import java.util.Scanner;

public // -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria de pesquisa
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

class TestBSTree {
   public static void main(String[] args) {

      // Criacao da Arvore
      BSTree<Integer> t = new BSTree<Integer>();

      // Inserindo 11 elementos na arvore binaria de pesquisa
      int[] data = {14, 4, 18, 3, 9, 16, 20, 7, 15, 17, 5};
      for (int i=0; i<data.length; i++) t.insert(data[i]);

      // Escrever resultado de chamada a alguns metodos
      System.out.println("numberNodes = " + t.numberNodes());
      t.printInOrder();
      System.out.println("depth = " + t.depth());
      System.out.println("contains(2) = " + t.contains(2));
      System.out.println("contains(3) = " + t.contains(3));
      System.out.println("countBetween(6, 17) = " + t.countBetween(6,17));

      Scanner in = new Scanner(System.in);
      int i = in.nextInt();
      in.nextLine();
      
      // uncomment BSTree.BSTress(BTree<T>) to run the following for loop
      // for (i = i; i > 0; i--) {
      //    Scanner line = new Scanner(in.nextLine());
      //    BTree<Integer> temp = LibBTree.readIntTree(line);
      //    t = new BSTree<Integer>(temp);
      //    t.printInOrder();
      //    System.out.printf("MaxLeft | root | MinRight\n%s | %s | %s\n", t.maxV(t.getRoot().getLeft()), t.getRoot().getValue(), t.minV(t.getRoot().getRight()));
      //    System.out.println("Valid = "+t.valid());
      // }

      in.close();
      
      // // Escrever nos da arvore seguindo varias ordens possiveis
      // t.printPreOrder();
      // t.printPostOrder();
      
      // // Experimentando remocao
      // t.remove(14);
      // t.printInOrder();

   }
}