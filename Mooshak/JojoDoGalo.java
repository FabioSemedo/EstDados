import java.util.Scanner;

public class ED004(){
    public static void main(String[]args){
        Scanner in = new Scanner ( System .in );
        int n = in.nextInt ();

        Game g = new Game(n);
        g.read(in);
        g.check();
    }
}

public class Game(){
    private int n;
    private char m[][];

    Game(int _size){
        n= _size;
        m = new char [n][n];
    }

    void read( Scanner in) {
        for (int i=0; i<n; i++) {
            String buf = in.next (); // next() lê um "token" (uma string s)
            for (int j=0; j<n; j++)
                m[i][j] = buf. charAt (j);
        }
    }

    String out_check[] = {"Ganhou o X", "Ganhou o O", "Empate", "Jogo incompleto"}; 
    
    void check(){
    }

    char straight(){
        for(int rows=0; rows< n; rows++){
            for(int cols=0; cols< n; cols++){
                while 
            }
        }
    }
}
