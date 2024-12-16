class ED212 {
    static int arr[];

    public static int getHeight( BSTNode<Integer> cur){
        if(cur==null) return -1;
        return 1 + Math.max(getHeight(cur.getLeft()), getHeight(cur.getRight()));
    }

    public static int[] sumLevels(BTree<Integer> t){
        arr = new int [getHeight(t.getRoot())+1];
        
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i]=0;
        // }

        goSumLevels(t.getRoot(), 0);

        return arr;
    }

    public static void goSumLevels(BSTNode<Integer> t, int i){
        if(t==null) return;
        arr[i]+= t.getValue();
        goSumLevels(t.getLeft(), i+1);
        goSumLevels(t.getRight(), i+1);
    }
    
}
