import java.util.Scanner;

public class ED231 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int k;

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        k = in.nextInt();
        in.close();

        switch (k) {
            case 1:
                minMax(arr);
                break;
            case 2:
                lowRise(arr);
                break;
            case 3:
                printGraph(arr);
                break;
            default:
                break;
        }
    }

    public static void printGraph(int arr[]){
        int [] columns = new int [arr.length];
        int max = arr[0]/100;
        for (int i = 0; i < arr.length; i++) {
            columns[i] = arr[i]/100;

            if(max < columns[i]) max = columns[i];
        }
        for (int i = max; i > 0; i--) {
            for (int j = 0; j < arr.length; j++) {
                String c = ".";
                if(columns[j]>= i) c = "#";
                System.out.print(c);
            }
            // if(i!= 1)
                System.out.println();
        }
    }

    public static void lowRise(int arr[]){
        int count = 0;

        int maxStreak=0;
        int streak = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            double num = (arr[i+1] - arr[i])/(double)arr[i];
            if(num <= 0.05){
                if(streak==0) count++;
                streak++;
                if(maxStreak < streak) maxStreak = streak;
            }
            else{
                //System.out.printf("Streak: %d\tStreaks: %d\tMaxStreak: %d\n", streak, count, maxStreak);
                streak = 0;
            }
            //System.out.printf("%.2f%% ",num*100);
        }
        
        // System.out.println();
        System.out.println(count + " "+ maxStreak);
    }

    public static void minMax(int arr[]){
        int max = arr[1] - arr[0];
        int min = arr[1] - arr[0];

        for (int i = 1; i < arr.length; i++) {
            int num = (arr[i] - arr[i-1]);
            if(max < num){
                max = num;
            }
            if(min > num){
                min = num;
            }
        }
        System.out.println(min + " "+max);
    }
}
