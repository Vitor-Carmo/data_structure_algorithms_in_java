package Unidade_02;

import java.util.ArrayDeque;
import java.util.Queue;

public class Ex7 {
    public static void main(String[] args) {
        final Queue<String> queue = new ArrayDeque<>();

        // Simulando chegada
        queue.add("João");
        queue.add("Maria");
        queue.add("Carlos");
        queue.add("Ana");

        System.out.println("Ordem de chegada:" + queue);

        System.out.println("\nOrdem de saída:");

        while (!queue.isEmpty()) {
            String pessoa = queue.poll();
            System.out.println(pessoa);
        }
    }
}
