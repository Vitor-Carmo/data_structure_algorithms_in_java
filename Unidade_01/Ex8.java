package Unidade_01;

public class Ex8 {
    //Exercício 8: Estruturas Condicionais e Listas
    //Crie um programa que solicite ao usuário que insira uma lista de números inteiros e, em seguida, encontre e exiba o número que mais se repete.

    public static void main(String[] args) {
        
        int[] numbers = new int[10];

        System.out.println("Digite 10 números inteiros: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(System.console().readLine());
        }

        int mostFrequentNumber = numbers[0];
        int maxCount = 1;

        for (int i = 0; i < numbers.length; i++) {
            int count = 1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostFrequentNumber = numbers[i];
            }
        }

        System.out.println("O número que mais se repete é: " + mostFrequentNumber);
    }
}