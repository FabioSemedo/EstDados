public class L_System {
    // Prac 1 Extra 4
    /*
    Crie um procedimento que receba um inteiro n e escreva as primeiras n linhas do L-system original de Lindenmayer, que usa as seguintes regras:

    A primeira linha é "A"
    Para se obter uma nova linha pega-se na linha anterior e substitui-se todos os "A" por "AB" e todos os "B" por "A". 

    Por exemplo, se o procedimento for chamado com n=7 o output deverá ser:

    A
    AB  
    ABA
    ABAAB
    ABAABABA
    ABAABABAABAAB
    ABAABABAABAABABAABABA
    */  
    static void l_system(int n, String s){
        System.out.println(s);
        if(n<=1){}
        else{
            String next="";
            for(int i=0; i< s.length(); i++){
                if(s.charAt(i)=='A'){
                    next += ("AB");
                } else if(s.charAt(i)=='B'){
                    next += ("A");
                }
            }
            l_system(--n, next);
        }
    }
    public static void main(String [] args){
        l_system(7,"A");
    }//end of main
}//end of class
//NOTE: javac file_name.java --> compile file_name.java