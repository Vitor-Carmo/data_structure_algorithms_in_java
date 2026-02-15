package Unidade_01;
public class Ex1 {
    public static void main(String[] args) {
        int nInt;
        float nFloat;
        String nString;

        System.out.print("Entre com um inteiro: ");
        nInt = Integer.parseInt(System.console().readLine());
        System.out.print("Entre com um float: ");
        nFloat = Float.parseFloat(System.console().readLine());
        System.out.print("Entre com uma string: ");
        nString = System.console().readLine();



        System.out.println("O inteiro digitado foi: " + nInt);
        System.out.println("O float digitado foi: " + nFloat);
        System.out.println("A string digitada foi: " + nString);
    }
}