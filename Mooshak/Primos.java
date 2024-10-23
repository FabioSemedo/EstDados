import java.util.Scanner;

public class Primos{
    //public static final int mx_B = 10000000+2;
    public static int primes(int a, int b){
        boolean arr [] = new boolean[b+1];
        int i = 2;
        int count=0;

        while(i <= b){
            if(arr[i] == false){ // java default bool = false
                if(a<=i){ // a <=i <=b
                    count++;
                }
                
                for(int j = i*2; j <= b; j=j+i){
                    arr[j]=true;
                }
            }
            i++;
        }
        return count;
    }


    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        
        System.out.println(primes(a,b));
    }
}