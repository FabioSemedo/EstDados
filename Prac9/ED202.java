// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Geracao de permutacoes
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

import java.util.Locale;
import java.util.Scanner;

public class ED202 {
    static double [][] mat;
    static double sum= Double.MAX_VALUE;

    // Escrever todos as permutacoes do array v[]
    static void permutations(int v[]) {
    boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
    int perm[] = new int[v.length];         // permutacao actual
    goPerm(0, v, used, perm); // chamar funcao recursiva
    }
    // Gera todos os subconjuntos a partir da posicao 'cur'
    static void goPerm(int cur, int v[], boolean used[], int perm[]) {
        if (cur == v.length) {  // Caso base: terminamos a permutacao
            double temp = 0.0;
            for (int i=1; i<v.length; i++){             
                temp+= mat[perm[i-1]][perm[i]];     // distance between prev stop and cur stop
            }
            temp += mat[perm[v.length-1]][perm[0]]; // distance between last stop and starting point
            if(temp< sum)
                sum = temp;
            
        } else 
        //if(perm[0]==0)
        { // Se nao terminamos, continuar a gerar
            for (int i=0; i<v.length; i++) // Tentar todos os elementos
                if (!used[i]) { 
                    used[i] = true; perm[cur] = i;
                    goPerm(cur+1, v, used, perm);
                    used[i] = false;
                }
            }
        } 
       

   // -----------------------------------------------------------
   
   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int v[] = new int[n]; // Inicializacao de array
       mat = new double [n][n];

       for (int i = 0; i < n; i++) {
        in.next();
        v[i] = i;
       }
       
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               mat [i][j] = Double.parseDouble(in.next());
            }
        }
        
        permutations(v);
        
        System.out.printf(String.format("%.2f\n", sum).replace(",", "."));

        in.close();
   }
}