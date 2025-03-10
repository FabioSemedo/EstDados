// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Classe utilitaria com metodo para ler uma arvore em preorder
// Ex: 5 1 8 N N 6 N N 7 2 N N N
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

import java.util.Scanner;

public class LibBTree {
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