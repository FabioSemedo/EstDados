import java.util.Scanner;

public class ED006{
    public static String game(int turns, String name, CircularLinkedList<String>list){
        while(list.size()>1){
            for (int i = 0; i < (turns % list.size())-1; i++) {//If turns = 1, rotations should be 0; turns 2 => rot 1; ...
                list.rotate();
            }

            list.removeFirst();
        }

        if(list.getFirst().equalsIgnoreCase(name))// Name is last one left, Name has lost.
        {
            return "O "+name+" nao se livrou";
        }
        
        return "O "+name+" livrou-se (coitado do "+list.getFirst()+"!)";
    }

    public static void main (String [] args){
        Scanner in  = new Scanner(System.in);
        Scanner line= new Scanner(in.nextLine());

        CircularLinkedList<String> list;
        String carlos =  "Carlos";

        int n_games = line.nextInt();
        int players=0;
        int turns=0;
            
            //game loop
        for (int i = 0; i < n_games; i++) {
            line = new Scanner(in.nextLine());
            turns = 0;
            while(line.hasNext()){
                turns++;
                line.next();
            }
            
            line = new Scanner(in.nextLine());
            list = new CircularLinkedList<String>();
            players = line.nextInt();
            
            // System.out.printf("52: Games, players, turns:  %d, %d, %d\n\n", n_games, players, turns);
            for (int j = 0; j < players; j++) {
                list.addLast(line.next());
            }

            System.out.println( game(turns, carlos, list));
            line.close();
        }
        in.close();
    }
}