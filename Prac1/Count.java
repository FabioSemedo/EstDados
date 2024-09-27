public class Numbers {
    // Prac 1 Extra 3
    static int count(String s, char c){
        int counter=0;
        for(int i=0; i< s.length(); i++){
            if(Character.toLowerCase(s.charAt(i)) == c){
                counter ++;
            } 
        }
        return counter;
    }

    public static void main(String [] args){
        System.out.println(count("Fabio Elmiro ramos Semedo", 'e'));

    }//end of main
}//end of class
//NOTE: javac file_name.java --> compile file_name.java