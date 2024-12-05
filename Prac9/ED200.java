
// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed
// -----------------------------------------------------------
// Exemplo de flood fill
// (Pedro Ribeiro @DCC-FCUP)
// -----------------------------------------------------------

import java.util.Scanner;

public class ED200 {
   static int rows;            // Numero de linhas
   static int cols;            // Numero de colunas   
   static char m[][];          // Matriz de celulas
   static boolean visited[][]; // Saber se uma dada posicao ja foi visitada
    public int max_org_size = 0;

   // Tamanho da mancha que inclui posicao (y,x)
   static int t(int y, int x) {
      if (y<0 || y>=rows || x<0 || x>=cols) return 0; // Caso base: fora dos limites
      if (visited[y][x]) return 0;  // Caso base: celula ja visitada
      if (m[y][x] == '.') return 0; // Caso base: celula vazia
      int count = 1;        // celula nao vazia
      visited[y][x] = true; // marcar como visitada
      count += t(y-1, x);   // Adicionando celulas nao vizinhas
      count += t(y+1, x);
      count += t(y, x+1);
      count += t(y, x-1);

      count += t(y+1,x-1);
      count += t(y+1,x+1);
      
      count += t(y-1,x-1);
      count += t(y-1,x+1);
      return count;
   }
   
   static int maxIt(int v[], int start, int end) {
        int maxSoFar = v[start];                // Maior ate agora
        for (int i=start+1; i<=end; i++)        // Percorrer intervalo
            maxSoFar = Math.max(maxSoFar, v[i]); // Actualizar maximo
        return maxSoFar;
    }
   // -----------------------------------------------------------
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int games;
        int max;

        for (games = in.nextInt(); games>0; games--) {
            max = 0;
            rows = in.nextInt();
            cols = in.nextInt();
            m = new char[rows][cols];
            visited = new boolean[rows][cols];
            for (int i=0; i<rows; i++)
                m[i] = in.next().toCharArray();
                
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    if(visited[y][x]==true) continue;
                    else{
                        int a = t(y,x);
                        //System.out.printf("t(%d,%d) returned %d", y,x,a);
                        if(max < a)
                        {
                            max = a;
                        }
                    }
                }
            }
          System.out.println(max);   
        }
        
        in.close();
        // Leitura de uma matriz de caracterer
   }
   
}