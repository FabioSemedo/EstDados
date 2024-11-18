import java.util.Scanner;

public class ED006{
    public static String game(int turns, String name, CircularLinkedList<String>list){
        while(list.size()>1){
            for (int i = 0; i < turns-1; i++) {//turn -1 to let us use removeFirst, turn - 1, instead of removeLast, turn.
                list.rotate();
            }

            list.removeFirst();
        }
        
        String temp = list.getLast();
        if(temp.equalsIgnoreCase(name))// Name is last one standing
        {
            return "O "+name+" livrou-se (coitado do "+list.getLast()+"!)";
        }
        
        return "O "+name+" nao se livrou";
    }

    public static void main (String [] args){
        Scanner in  = new Scanner(System.in);
        Scanner line= new Scanner(in.nextLine());

        CircularLinkedList list;
        Node<String> child;
        String carlos =  "Carlos";

        boolean testFlag = true;

        int n_games = line.nextInt();
        int players=0;
        int turns=0;

        System.out.printf("%d, %d, %d, %s\n", n_games, players, turns, "");

        //game loop
        for (int i = 0; i < n_games; i++) {
            line = new Scanner(in.nextLine());
            
            while(line.hasNext()){
                turns++;
                line.next();
            }
            
            if(testFlag){
                System.out.println("Words ="+ turns);
            }
            
            players = in.nextInt();
            list = new CircularLinkedList<String>();

            for (int j = 0; j < players; j++) {
                child = new Node<String>(in.next(), null);
                list.addLast(child);
            }

            System.out.println( game(turns, carlos, list));
        }
    }
}