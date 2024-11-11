public class BigNumber{
    private int num[];

    BigNumber(String n){
        int len = n.length();
        int num[] = new int[len];

        for(int i=0; i< len;i++){
            num[i]=n.charAt(i);
        }
    }

    public int getLen() {
        return num.length;
    }

    public int[] getNum() {
        return num;
    }

    public boolean equals(BigNumber n){
        int i=0; 
        int len = this.getLen();
        int []num2 = n.getNum();

        if(n.getLen()!= len) 
            return false;
        
        while(i<len){
            if(this.num[i] != num2[i]) 
                return false;
            i++;
        }

        return true;
    }

    public String toString(){
        String s = "";
        int len = this.getLen();

        for (int i=0; i< len; i++) {
            s += i;
        }

        return s;
    }

    public BigNumber add(BigNumber n){
        int []num2 = n.getNum();
        String res = "";

        int i = this.getLen()-1;
        int j = n.getLen()-1;
        
        int carry = 0;
        int digit = 0;

        while((i > -1) && (j > -1)){
            digit = this.num[i] + num2[j] + carry;
            carry= digit/10; // integer devision
            res = (digit % 10) + res;

            i--;
            j--;
        }
        
        while(i>-1){//this.num is bigger
            res = this.num[i] + res;
            i--;
        }
        while(j > -1){//num2 is bigger
            res = num2[j] + res;
        }

        return new BigNumber(res);
    }

    public static void main(String[]args){
        BigNumber n1 = new BigNumber("123000456");
        BigNumber n2 = new BigNumber("987000321");

        System.out.println("N1 = " + n1.toString());
        System.out.println("Sum n1 + n2 = "+ n1.add(n2).toString());
        System.out.println();
        System.out.println();
    }

}