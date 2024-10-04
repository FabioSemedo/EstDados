import java.util.Scanner;

public class Palindromo{
    public void palindromo(String str){
        boolean ispalindromo = true;
        int i=0;
        int j=s.length();

        while(i<j){
            if(s.charAt(i).isAlpha())

            ++i;
            --j;
        }
        
        
        if(ispalindromo) System.out.println("sim");
        else System.out.println("nao");
    }
    public static void main(String [] args){
        int n = Integer.parseInt(new Scanner.in)
        palindromo(n);
    }
}

import java.util.Scanner;

public class Losango2{
    static void losango(int n){
        for(int i = 1; i<=n; i+=2){
            System.out.println(".".repeat((n-i)/2) + "#".repeat(i) + ".".repeat((n-i)/2));
        }
        for(int i = n-2; i>0; i-=2){
            System.out.println(".".repeat((n-i)/2) + "#".repeat(i) + ".".repeat((n-i)/2));
        }
    }
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        losango(n);
    }
}