import java.util.Scanner;

class ED165 {
    public static void main(String[] args) {
        BSTree<Integer> t = new BSTree<Integer>();
        Scanner in = new Scanner(System.in);
        
        //tree
        int n = in.nextInt();
        
        for (int i = 0; i < n; i++) {
            t.insert(in.nextInt());
        }

        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if(somas(t, t.getRoot() ,num)){
                System.out.println(num+": sim");
            }else{
                System.out.println(num+": nao");
            }
        }

        in.close();
    }

    //for every node, check if num - node value is in the tree. if not search children
    public static boolean somas(BSTree<Integer> origin, BSTNode<Integer> t, Integer n){
        if(t==null) return false;
        if(n == 2*t.getValue()) return true;

        //return somas(origin, t.getLeft(), n) || somas(origin, t.getRight(), n);
        if(! origin.contains(n - t.getValue())){
            // n = a + b. tvalue = a. if a 
            return somas(origin, t.getLeft(), n) || somas(origin, t.getRight(), n);
        } 
        return true;
    }
}
