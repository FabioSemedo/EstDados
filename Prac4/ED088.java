import java.util.Scanner;
// Classe principal com o main()
public class ED088 {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	// Ler linhas, colunas e numero de iteracoes
	int rows = in.nextInt();
	int cols = in.nextInt();
	int n    = in.nextInt();

	// Criar objecto para conter o jogo e ler estado inicial
	Game088 g = new Game088(rows, cols);
	g.read(in);
    for (int i = 0; i < n; i++) {
		g.iterate();
	}
	g.write();
	
	//... por completar
    }
}