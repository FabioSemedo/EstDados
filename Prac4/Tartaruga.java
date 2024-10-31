import java.util.Scanner;
// import java.util.Set;
// import java.util.HashSet;

public class Tartaruga {
    final int ESTE = 0;
    final int SUL = 1;
    final int OESTE = 2;
    final int NORTE = 3;
    final char X = '*';
    
    private char grid[][];
    private int rows;
    private int cols;

    private int y;
    private int x; 
    private boolean pen;// False = Up, True = down
    private int dir;

    Tartaruga(int r, int c){
        grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j]='.';
            }
        }
        rows = r;
        cols = c;

        y = 0;
        x = 0;
        dir = ESTE;
        pen = false;
    }

    public void up(){
        pen = false;
    }
    public void down(){
        pen = true;
        grid[y][x] = X;
    }

    public void left(){// 0,1,2,3 == E,S,W,N
        dir--;
        if(dir<0) dir = NORTE;
    }
    public void right(){// 0,1,2,3 == E,S,W,N
        dir = (dir + 1) % 4;
    }

    public void markRate(){
        int marks = 0;
        // Set<Integer> colMarked = new HashSet<>();
        // Set<Integer> rowMarked = new HashSet<>();
        boolean [] rowsMarked = new boolean[rows];
        boolean [] colsMarked = new boolean[cols];
        int r=0, c=0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j]==X){
                    marks++;
                    rowsMarked[i]=true;
                    colsMarked[j]=true;
                }
            }
        }

        for (int i = 0; i < cols; i++) {
            if(colsMarked[i]) c++;
        }
        for (int i = 0; i < rows; i++) {
            if(rowsMarked[i]) r++;
        }

        System.out.printf("%d %d %d\n", (marks*100)/(rows*cols), rows-r, cols-c);
    }

    public void forward(){
        switch (dir) {
            case ESTE:
                x++;
                if(x >= cols) x--;
                break;

            case OESTE:
                x--;
                if(x < 0) x++;
                break;

            case SUL:
                y++;
                if(y >= rows) y--;
                break;

            case NORTE:
                y--;
                if(y < 0) y++;
                break;
        
            default:
                System.out.println("Tartaruga.dir is out of bounds: "+dir);
                System.exit(1);
                break;
        }

        if(pen) grid[y][x]=X;
    }

    public void forward(int n){
        for (int i = 0; i < n; i++) {
            forward();
        }
    }

    public void print(){
        String line = "";
        for (int i = 0; i < rows; i++) {
            if(grid[i][0]==X)   
                line = ""+X;
            else 
                line =".";

            for (int j = 1; j < cols; j++) { 
                if(grid[i][j]==X)   
                    line = line + " "+X;
                else 
                    line = line + " .";
            }

            System.out.println(line);
        }
    }

    public void readMoves(Scanner in){
        String s = in.next();
        while(! s.equals("end")){
            switch (s) {
                case "U":
                    this.up();                    
                    break;
                case "D":
                    this.down();                    
                    break;
                case "R":
                    this.right();                    
                    break;
                case "L":
                    this.left();                    
                    break;
                case "F":
                    this.forward(in.nextInt());                    
                    break;
            
                default:
                    System.out.println("Unexpected input: s = \'"+s+"\'");
                    System.exit(1);
                    break;
            }//end switch
            s = in.next();
        }//end while
    }

    public void checkPattern(Scanner in){
        int r = in.nextInt();
        int c = in.nextInt();
        boolean match = false;
        char m[][] = new char[r][c];

        for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            m[i][j]=in.next().charAt(0);
        }}

        for (int i = 0; i <= rows-r; i++) {
        for (int j = 0; j <= cols-c; j++) {

            if(m[0][0]==grid[i][j]){//possible top left corner found
                match=true;
                //System.out.printf("match grid[%d][%d]\n",i,j);
                
                for (int i2 = 0; i2 < r && match; i2++) {
                    for (int j2 = 0; j2 < c && match; j2++) {
                        if (m[i2][j2] != grid[i + i2][j + j2]) {
                            match = false;
                        }
                    }
                }
                if(match){
                    System.out.println("Sim");
                    return;
                }  
            }
        }
        }

        System.out.println("Nao");
    }

    public void flagListener(int flag, Scanner in){
        switch (flag) {
            case 0:
                this.print();                
                break;
            case 1:
                this.markRate();
                break;
            case 2:
                this.checkPattern(in);
                break;
            default:
                System.out.println("flag is out of bounds: "+flag);
                System.exit(2);
                break;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int flag = in.nextInt();
        int rows = in.nextInt();
        int cols = in.nextInt();

        Tartaruga tart = new Tartaruga(rows, cols);
        
        tart.readMoves(in);
        tart.flagListener(flag, in);
    }
}
