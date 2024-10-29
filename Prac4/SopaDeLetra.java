import java.util.Scanner;

public class SopaDeLetra {
    char grid[][];
    int rows;
    int cols;
    boolean res[][];

    SopaDeLetra()
    {}
    
    SopaDeLetra(int r, int c){
        rows = r;
        cols = c;
        grid = new char[r][c];
        res = new boolean[r][c];
    }

    void setRows(int r){
        rows = r;}
    void setCols(int c){
        cols = c;}

    void readGrid( Scanner in) {
        for (int i=0; i<rows; i++) {
            String buf = in.next (); // next() lê um "token" (uma string s)
            for (int j=0; j<cols; j++)
                grid[i][j] = Character.toUpperCase(buf. charAt (j));
        }
    }

    boolean searchRight(int r, int c, String w){
        boolean found = true;
        int len = w.length();
        int k=0;

        if((cols-c) < len)//not enough space
            return false;

        for (k=0; k < len; k++) {
            found = found && (w.charAt(k)==grid[r][c+k]);
        }

        return found;
    }

    boolean searchLeft(int r, int c, String w){
        boolean found = true;
        int len = w.length();
        int k=0;

        if((c+1) < len)//not enough space
            return false;

        for (k=0; k < len; k++) {
            found = found && (w.charAt(k)==grid[r][c-k]);
        }

        return found;
    }

    boolean searchDown(int r, int c, String w){
        boolean found = true;
        int len = w.length();
        int k=0;

        if(len > (rows-r))//not enough space
            return false;

        for (k=0; k < len; k++) {
            found = found && (w.charAt(k)==grid[r+k][c]);
        }

        return found;
    }

    boolean searchUp(int r, int c, String w){
        boolean found = true;
        int len = w.length();
        int k=0;

        if((r+1) < len)//not enough space
            return false;

        for (k=0; k < len; k++) {
            found = found && (w.charAt(k)==grid[r-k][c]);
        }

        return found;
    }

    //find [nFind*4] = .. x1, y1, x2, y2 where x1,y1 is the position of the first letter in wordFound and x2,y2 is the last letter in wordFound relative to the grid[x][y]
    void newfind(int r, int c, int direction, int wLen){// Directions = {"Up","Right","Down","Left"} -> direction E [0,1,2,3]
        switch (direction) {
            case 0://Up
                for (int i = 0; i < wLen; i++) {
                    res[r-i][c] = true;
                }
                break;
            
            case 1://Right
                for (int i = 0; i < wLen; i++) {
                    res[r][c+i] = true;
                }
            break;

            case 2://Down
                for (int i = 0; i < wLen; i++) {
                    res[r+i][c] = true;
                }
                break;

            case 3://Left
                for (int i = 0; i < wLen; i++) {
                    res[r][c-i] = true;
                }
                break;
        
            default:
                break;
        }//end switch
    }

    void search(String w){
        boolean found = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j]==w.charAt(0)){
                    
                    if(searchUp(i, j, w)){
                        newfind(i, j, 0, w.length());
                    }
                    else if(searchRight(i, j, w)){
                        newfind(i, j, 1, w.length());
                    }
                    else if(searchDown(i, j, w)){
                        newfind(i, j, 2, w.length());
                    }
                    else if(searchLeft(i, j, w)){
                        newfind(i, j, 3, w.length());
                    }
                }
            }
        }
    }

    void print(int n){
        String line = "";
        System.out.println("Input #"+n);

        for (int i = 0; i < rows; i++) {
            line = "";
            for (int j = 0; j < cols; j++) {
                if(res[i][j]){
                    line = line+grid[i][j];
                }else{
                    line = line+'.';
                }
            }
            System.out.println(line);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int n = 0, x;
        String s;

        SopaDeLetra game;
        
        while(r*c != 0){
            n++;
            game = new SopaDeLetra(r,c);
            game.readGrid(in);
            
            x = in.nextInt();

            for (int i = 0; i < x; i++) {
                game.search(in.next());
            }

            game.print(n);

            r = in.nextInt();
            c = in.nextInt();
        }
    }
}
