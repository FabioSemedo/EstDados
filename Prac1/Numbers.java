public class Numbers {
    public static void main(String [] args){
        int n = 10;
        int sum = 0;
        int i = 1;
        
        System.out.print("Numbers from 1 to " + n + ": ");
        for(i = 1; i<=n-1; i++){
            System.out.print(i+", ");
            sum+=i;
        }
            
        if (i <= n){

            System.out.println(i);
            sum+=i;
        }

        System.out.println("Sum = " + sum);

    }//end of main
}//end of class
//NOTE: javac file_name.java --> compile file_name.java