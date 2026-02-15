package Unidade_01;
public class Ex2 {
    public static void main(String[] args) {
        int num;
        
        System.out.print("Escolha um número: ");
        num = Integer.parseInt(System.console().readLine());

        
        System.out.println("O número é " + num + (num % 2 == 0 ? "par" : "ímpar") + ".");
        
    }
}