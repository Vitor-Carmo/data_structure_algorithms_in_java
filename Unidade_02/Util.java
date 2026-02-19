package Unidade_02;

import java.io.Console;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public final class Util {

    private Util() {}

    public static int readInt(String prompt) {
        Console console = System.console();

        while (true) {
            String input = console.readLine(prompt);

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }


    public static int readValidInt(String prompt, IntPredicate validator, String errorMessage) {
        while (true) {
            int value = readInt(prompt);

            if (validator.test(value)) {
                return value;
            }

            System.out.println(errorMessage);
        }
    }

    public static String readString(String prompt) {
        Console console = System.console();

        while (true) {
            String input = console.readLine(prompt);

            if (input != null) {
                return input;
            }

            System.out.println("Entrada inválida.");
        }
    }

    public static String readValidString(String prompt, Predicate<String> validator, String errorMessage) {
        while (true) {
            String value = readString(prompt);

            if (validator.test(value)) {
                return value;
            }

            System.out.println(errorMessage);
        }
    }

    
}
