public class TestPerm {
    // Escrever todos as permutacoes do array v[]
    static void permutations(int v[]) {
    boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
    int perm[] = new int[v.length];         // permutacao actual
    for (int i = 0; i < v.length; i++) {
        perm[i] = i;
    }
    goPerm(0, v, used, perm); // chamar funcao recursiva
    }
    // Gera todos os subconjuntos a partir da posicao 'cur'
    static void goPerm(int cur, int v[], boolean used[], int perm[]) {
    if (cur == v.length) {  // Caso base: terminamos a permutacao
        for (int i = 0; i < perm.length; i++) {
            System.out.print(perm[i]+" ");
        }
        System.out.print("----");
        for (int i=0; i<v.length; i++) // Escrever a permutacao
	System.out.print(v[perm[i]] + " ");
	    System.out.println();
	} else { // Se nao terminamos, continuar a gerar
	    for (int i=0; i < v.length; i++) // Tentar todos os elementos
            if (!used[i]) { 
	        used[i] = true; perm[cur] = i;
	        goPerm(cur+1, v, used, perm);
	        used[i] = false;
            }
	    }
    }   

   // -----------------------------------------------------------
   
   public static void main(String[] args) {
       int v[] = {0,1,2,3,4}; // Inicializacao de array

      permutations(v);
   }
}