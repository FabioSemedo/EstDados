import java.util.Scanner;

class ED164 {
    public static void main(String[] args) {
        BSTree<String> t = new BSTree<String>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String word = in.next();
            if(!t.contains(word)){
                t.insert(word);
            }
        }
        // t.printInOrder();
        System.out.println(t.numberNodes());
    }
}