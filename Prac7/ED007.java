import java.util.Scanner;
import java.util.Stack;

class ED007{

    public static void main(String [] args){
        Stack <Character> list = new Stack <Character>();
        Scanner txt = new Scanner(System.in);
        boolean err = false;
        String in;
        
        int n = txt.nextInt();
        txt.nextLine();
        
        while(txt.hasNext()){
            list = new Stack<Character>();
            in = (txt.nextLine());
            err = false;

            for (n = 0; n < in.length(); n++) {
                switch(in.charAt(n)){
                    case '(': 
                        list.push(')');
                        break;
                    case '[': 
                        list.push(']');
                        break;
                    case '{': 
                        list.push('}');
                        break;
    
                    case ')': 
                    case ']': 
                    case '}': 
                        if(list.isEmpty() || list.pop() != in.charAt(n)) 
                        {
                            System.out.println("Erro na posicao " + (n));
                            err = true;
                        }
                        break;
                    default:
                        //cur is not a bracket
                        break;
                }//end switch
                n++;
                if(err) break;
            }//end for
                
            if(err){
                continue;
            }else if (! list.isEmpty()){
                
                System.out.println("Ficam parenteses por fechar");
            }else{
                System.out.println("Expressao bem formada");
            }
        }//end main.while loop
        txt.close();

    }// end main
}// end class