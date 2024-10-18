import java.util.Scanner;

public class Pizza {
    public static boolean arrContains(int [] arr, int x){
        for(int i =0; i< arr.length(); i++){
            if(arr[i]==x){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner line;
        
        int no_like[] = int[100];
        int size = 0;
        int pizzas;
        int ingrid;
        int like = 0;

        line = new Scanner(input.nextLine());

        while(line.hasNextInt()){
            no_like[size] = line.nextInt();
            size++;
        }

        pizzas = Integer.parseInt(input.nextLine());

        for(int i= 0; i < pizzas; i++){
            line = new Scanner(input.nextLine());
            ingrid = line.nextInt();

            for(int k = 0; k< ingrid; k++){
                if(arrContains(no_like, line.nextInt())){

                }
            }
        }


        System.out.println(n);
    } 
}
