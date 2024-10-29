import java.util.Scanner;

public class Game004 {
    private int n;
    private char m[][];

    Game004(int _size){
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
    
    public static boolean notPoint(char c){
        return !(c=='.');
    }

    void check(){
        boolean game_not_finished = false; // true if char '.' was found
        boolean winner = true;

        for(int i=0; i< n; i++){
            winner = true;

            for(int j=0; j< n; j++){ //horizontal
                winner = winner && (m[i][0] == m[i][j]);
                game_not_finished = game_not_finished || (m[i][j]=='.');
            }
            
            if(notPoint(m[i][0]) && winner){
                System.out.println("Ganhou o " + m[i][0]);
                return;
            }
        }

        for(int i=0; i< n; i++){
            winner = true;

            for(int j=0; j< n; j++){ //vertical
                winner = winner && (m[0][i] == m[j][i]);
            }

            if(notPoint(m[0][i]) && winner){
                System.out.println("Ganhou o " + m[0][i]);
                return;
            }
        }

        winner = true;

        for (int i = 0; i < n; i++) {// diagonal \
            winner = winner && (m[i][i]==m[0][0]);            
        }
        
        if(notPoint(m[0][0]) && winner){
            System.out.println("Ganhou o " + m[0][0]);
            return;
        }

        winner = true;

        for (int i = 0; i < n; i++) {// diagonal /
            winner = winner && (m[i][n-i-1]==m[n-1][0]);            
        }
        
        if(notPoint(m[n-1][0]) && winner){
            System.out.println("Ganhou o " + m[n-1][0]);
            return;
        }

        if(!game_not_finished) 
            System.out.println("Empate");
        else 
            System.out.println("Jogo incompleto");        
    }
}
