import java.util.Scanner;
import java.util.Stack;

public class ED005{    
    public static boolean comp(Stack<Integer> list, char c){
        int a,b;

        if(list.size()<2){
            return false;
        }

        b = list.pop();
        a = list.pop();

        switch (c) {
            case '+':
                list.push(a+b);
                break;
            case '-':
                list.push(a-b);
                break;
            case '/':
                if(b==0){
                    return false;
                }else{
                    list.push(a/b);
                }
                break;
            case '*':
                list.push(a*b);
                break;
        
            default:
                return false;
        }//end switch

        return true;
    }
    public static void main(String [] args){
        final String ERROR = "Expressao Incorrecta";

        Stack<Integer> list;
        Stack<Integer> list2;
        Scanner in = new Scanner(System.in);
        Scanner line;
        boolean flag = false;
        
        int loop = in.nextInt();
        in.nextLine();

        for (int i = 0; i < loop; i++) {
            line = new Scanner(in.nextLine());
            flag = false;
            list = new Stack<Integer>();
            list2 = new Stack<Integer>();
            
            while(line.hasNext()){
                String cur = line.next();
                switch (cur.charAt(0)) {
                    case '+':
                    case '-':
                    case '/':
                    case '*':
                        if(! comp(list, cur.charAt(0))){
                            flag = true;
                        } 
                        break;
                        
                        default:
                        list.push(Integer.parseInt(cur));
                        break;
                    }//end switch
                    
                //System.out.println(list);
                if (flag) {
                    break;
                }

            }//end while
            //System.out.println(list);
            if (flag || list.size()!=1) {
                System.out.println(ERROR);
            }else{
                System.out.println(list.pop());
            }
        }
    }
}