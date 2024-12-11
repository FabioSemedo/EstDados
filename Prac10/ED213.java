class myPair{
    String s;
    int sum;
    
    myPair(){
        s = "";
        sum = 0;
    }

    int compareTo(myPair p){
        return this.sum - p.sum;
    }
}

public class ED213 {

    public static int getHeight( BTNode<Integer> cur){
        if(cur==null) return -1;
        return 1 + Math.max(getHeight(cur.getLeft()), getHeight(cur.getRight()));
    }

    public static String maxSum(BTree<Integer> t){
        return goMaxSum(t.getRoot(), new myPair());
    }

    public static String goMaxSum(BTNode<Integer> t, myPair p){
        if(t==null) return p;
        if()
    }

    public static int maxNode(BTNode<Integer> t){
        if(t==null) return 0;
        return t.getValue() + Math.max(maxNode(t), maxNode(t.getRight())) 
    }
}
