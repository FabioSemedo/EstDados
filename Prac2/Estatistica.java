import java.util.Scanner;

public class Estatistica{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        
        int n = Integer.parseInt(input.nextLine());
        int max, min, sum, cur;

        sum = max = min = input.nextInt();

        for(int i=1; i<n; i++){
            cur = input.nextInt();
            sum+= cur;

            if(cur > max){ max = cur;}
            else if(cur < min){ min = cur;}
        }

        System.out.printf("%.2f\n",(float)sum/n);
        System.out.println(max-min);

    }
}