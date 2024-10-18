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