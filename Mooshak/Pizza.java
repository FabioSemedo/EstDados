import java.util.Scanner;

public class Pizza {
    public static boolean arrContains(int [] arr, int size, int x){
        for(int i =0; i< size; i++){
            if(arr[i]==x){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner line;
        
        int no_like[] = new int[100];
        int size = 0;
        int like = 0;
        int pizzas;
        int ingrid_num;
        int flag;

        line = new Scanner(input.nextLine());
        size = line.nextInt();

        for(int i=0; i< size; i++){
            no_like[i] = line.nextInt();
        }

        pizzas = Integer.parseInt(input.nextLine());

        for(int i= 0; i < pizzas; i++){
            line = new Scanner(input.nextLine());
            ingrid_num = line.nextInt();
            flag = 1;

            for(int k = 0; k< ingrid_num; k++){
                if( arrContains( no_like, size, line.nextInt())){
                    flag=0;
                }
            }
            if(flag == 1){
                like++;
            }
        }

        input.close();
        System.out.println(like);
    } 
}
