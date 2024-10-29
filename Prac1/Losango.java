public class Losango{
    static void losango(int n){
        int i = 1;
        for(i = 1; i<=n; i+=2){
            System.out.print(" ".repeat((n-i)/2));
            System.out.print("#".repeat(i));
            System.out.println(" ".repeat((n-i)/2));
        }
        for(i = n-2; i>0; i-=2){
            System.out.print(" ".repeat((n-i)/2));
            System.out.print("#".repeat(i));
            System.out.println(" ".repeat((n-i)/2));
        }
    }
    public static void main(String [] args){
        losango(5);
    }
}