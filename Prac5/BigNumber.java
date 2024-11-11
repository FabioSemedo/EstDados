public class BigNumber{
    private int num[];

    BigNumber(String n){
        int num[] = new int[ n.length()];

        for(i=0; i< n.length();i++){
            num[i]=n.charAt(i);
        }
    }

    public BigInteger getLen() {
        return num.length;
    }

    public int[] getNum() {
        return num;
    }

    public boolean equals(BigNumber n){
        int i=0; 
        int len = this.getLen();

        if(n.getLen()!= len) 
            return false;
        
        num2 = n.getNum();

        while(i<len){
            if(this.num[i] != num2[i]) 
                return false;
            i++;
        }

        return true;
    }

    public String toString(){
        String s = "";
        for (int i : this.num) {
            s += i;
        }
        return s;
    }

    public BigNumber add(BigNumber n){
        
        BigNumber res = new
    }

}