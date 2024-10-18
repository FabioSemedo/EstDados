import java.util.Scanner;

public class Palindromo{
    public static String cleaner(String st){
        st = st.toLowerCase();
        st = st.replaceAll("[^a-zA-Z]", "");

        //System.out.println("«« "+st+" »»");
        return st;
    }

    public static boolean isPalindromo(String st){
        int j = 0;

        st = cleaner(st);
        j = st.length()-1;

        for(int i=0; i<j; i++){
            if(st.charAt(i)!=st.charAt(j)){
                //System.out.print("«« "+i+" »» :"+st.charAt(i)+",«« "+j+" »»: "+st.charAt(j)+" \t" );
                return false;
            }
            j--;
        }

        return true;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        System.out.println(n);

        for(int i=0; i<n; i++){
            if(isPalindromo(input.nextLine())){
                System.out.print("sim\n");
            }else{
                System.out.print("nao\n");
            }
        }
    }
}