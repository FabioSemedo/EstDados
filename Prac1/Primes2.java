public class MorePrime{
    /*  Prac 1 - Extra #2
        Crie um procedimento que, dado um inteiro n, escreva a sua decomposição em factores primos. Por exemplo, se n=20, o output deve ser:
        20 = 2 * 2 * 5
    */

    static void primefact(int num){
        int n = num;

        System.out.print(num+" = ");
        
        for(int i=2; i<= Math.sqrt(num); i++){
            while(n % i == 0){
                System.out.print(i + " * ");
                n = n/i;
            }
        }
        System.out.println(n);

    }// end of primefact method


    public static void main(String [] args){
        int n=20;
        primefact(n);
    }
}