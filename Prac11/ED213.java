import java.util.Scanner;

class MyPair{
    String path;
    int num;
    
    MyPair(String s, int n){
        path = s;
        num = n;
    }
}

public class ED213 {
    static int max =0;
    public static int getHeight( BSTNode<Integer> cur){
        if(cur==null) return -1;
        return 1 + Math.max(getHeight(cur.getLeft()), getHeight(cur.getRight()));
    }

    public static String maxSum(BTree<Integer> t){
        if(t.getRoot()==null) return "";
        max = t.getRoot().getValue();
        return goMaxSum(t.getRoot(),"", new MyPair("", max)).path;
    }
    
    public static MyPair goMaxSum(BSTNode<Integer> t, String c, MyPair p){
        if(t==null) return p;
        p.path = p.path + c;
        p.num += t.getValue();
        if(t.getLeft()==null && t.getRight()==null) return p;
        return max( 
                    goMaxSum(t.getLeft(), "E", new MyPair(p.path, p.num)),
                    goMaxSum(t.getRight(), "D", new MyPair(p.path, p.num)) 
                    );
    }

    static MyPair max(MyPair p1, MyPair p2){
        if(p1.num< p2.num) return p2;
        return p1;
    }

    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);
    //     Scanner line;

    //     for (int i = in.nextInt(); i> 0; i--) {
    //         line = new Scanner(in.nextLine());
    //         BTree<Integer> t = LibBTree.readIntTree(in);
    //         System.out.println(maxSum(t));
    //     }
    // }
}
