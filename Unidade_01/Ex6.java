package Unidade_01;

public class Ex6 {
    // 
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }


    public static void main(String[] args) {

        System.out.println("Números primos entre 1 e 100:");
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        
    }
}