public class Primes {
    // Verifica se o número n é primo (apenas divisível por 1 e por si próprio)
    // [função ainda por completar]
    static boolean isPrime(int n) {
        if(n%2== 0) return false;

        for(int i=3; i<= Math.sqrt(n); i+=2){
            if(n % i == 0) return false;
        }
	return true;
    }
    
    public static void main(String[] args) {
	
	int n=1000000; // Limite dos números
	
	for (int i=2; i<=n; i++)
	    if (isPrime(i))
		    System.out.println(i);
    }
}
//NOTE: javac file_name.java --> compile file_name.java