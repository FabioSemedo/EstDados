public class Square {// Prac 1 ex 3
    // Desenha uma linha de n caracteres onde:
    // - o primeiro e o último caracteres são o caracter da variável 'a'
    // - todos os outros caracteres são o caracter da variável 'b'
    static void line(char a, char b, int n) {
        System.out.print(a);
        for (int i=1; i<=n-2; i++)
            System.out.print(b);
        System.out.println(a);
    }

    static void square(int n){
	    line('+','-',n);
        for (int i=0; i<n-2; i++)
            line('|','.',n);
        line('+','-',n);	    
    }

    // O procedimento executado inicialmente é sempre o main
    public static void main(String[] args) {	
	    line('*','-',5);	    
        square(3);
    }//end of main
}