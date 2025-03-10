// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

import java.util.Scanner;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      BTree<Integer> t = LibBTree.readIntTree(in);

      // Escrever resultado de chamada a alguns metodos
      System.out.println("numberNodes = " + t.numberNodes());
      System.out.println("depth = " + t.depth());
      System.out.println("contains(2) = " + t.contains(2));
      System.out.println("contains(3) = " + t.contains(3));
      System.out.println("nodesLevel(3) = " + t.nodesLevel(3));


      // Escrever nos da arvore seguindo varias ordens possiveis
      // t.printPreOrder();      
      // t.printInOrder();
      // t.printPostOrder();
      // t.printBFS();
      // t.printDFS();
   }
}