import java.util.Scanner;

public class ED89 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numEmpr = in.nextInt();
        int flag = in.nextInt();
        in.nextLine();
        
        int nif, actCode, income;
        String name, actEcon;

        int [] actList = new int[101];

        for (int i = 0; i < actList.length; i++) {
            actList[i] = 0;
        }

        for (int i = 0; i < numEmpr; i++) {
            in.nextLine();//nif
            in.nextLine();//name
            in.nextLine();//activity
            
            actCode = in.nextInt();
            in.nextLine();
            
            income = in.nextInt();

            if(in.hasNext())
                in.nextLine();  
            
            actList[actCode] += income;
        }

        switch (flag) {
            case 0:
                int count = 0;
                for (int i = 0; i < actList.length; i++) {
                    if(actList[i]!=0) count++;
                }
                System.out.println(count);
                break;
            case 1:
                for (int i = 0; i < actList.length; i++) {
                    if(actList[i]!=0){
                        System.out.println(i + " "+ actList[i]);
                    }
                }
                break;
            default:
                break;
        }
    }
}
