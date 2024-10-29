import java.util.Scanner;

// Classe para representar um jogo
public class Game088 {
    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char m[][];      // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game088(int r, int c) {
        rows = r;
        cols = c;
        m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
	for (int i=0; i<rows; i++)
	    m[i] = in.next().toCharArray();
    }
    
    // Metodo para escrever a matriz m[][]
    public void write() {
	// ... por completar
        String line;
        for (int i = 0; i < rows; i++) {
            line = "";
            for (int j = 0; j < cols; j++) {
                line = line+m[i][j];
            }
            System.out.println(line);
        }
    }

    public int countAlive(int y, int x) {
        int count = 0;
    
        // Iterate over the 8 possible neighboring positions
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Skip the cell itself
                if (i == 0 && j == 0) continue;
    
                int newY = y + i;
                int newX = x + j;
    
                // Check if the neighboring position is within bounds
                if ((newY >= 0) && (newY < rows) && (newX >= 0) && (newX < cols)) {
                    if (m[newY][newX] == ALIVE) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate() {
	// ... por completar
    char m2[][] = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int n_alive = this.countAlive(i, j);

                if(n_alive==2 && m[i][j]==ALIVE){
                    m2[i][j] = ALIVE;
                }else if(n_alive==3){
                    m2[i][j] = ALIVE;
                }else {
                    m2[i][j] = DEAD;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = m2[i][j];
            }
        }

    }//end iterate method
    
}