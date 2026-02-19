package Unidade_02;

import java.util.HashMap;

public class Ex8 {
    public static void main(String[] args) {
        String phrase = "Ser, ou não ser, eis a questão.";
        HashMap<String, Integer> wordFrequency = new HashMap<>();

        phrase = phrase.replaceAll("[^\\p{L}\\p{Nd}\\s]", "").toLowerCase();

        for (String word : phrase.split("\\s+")) {
            wordFrequency.merge(word, 1, Integer::sum);
        }

        System.out.println("\nFrequência das Palavras");
        for (var entry : wordFrequency.entrySet()) {
            System.out.printf("Palavra: %-10s | Quantidade: %d%n",
                    entry.getKey(),
                    entry.getValue());
        }
    }
}
