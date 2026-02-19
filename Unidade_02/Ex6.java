package Unidade_02;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class WaitingQueue {
    private final Queue<Person> queueWaiting = new ArrayDeque<>();

    public void add() {
        String name = Util.readValidString(
                "Digite o nome da pessoa: ",
                s -> !s.trim().isEmpty(),
                "O nome não pode estar vazio.");

        queueWaiting.add(new Person(name));

        System.out.println("Pessoa adicionada à fila de espera.");
    }

    public void callNext() {
        if (queueWaiting.isEmpty()) {
            System.out.println("Fila de espera está vazia.");
            return;
        }

        Person nextPerson = queueWaiting.poll();
        System.out.println("Próxima pessoa chamada da fila de espera: " + nextPerson.getName());
    }

    public void showQueue() {
        if (queueWaiting.isEmpty()) {
            System.out.println("Fila de espera está vazia.");
            return;
        }

        System.out.println("\nFila de espera:");
        for (Person person : queueWaiting) {
            System.out.println("* " + person.getName());
        }

    }

}

public class Ex6 {
    public static void main(String[] args) {
        Map<Integer, Runnable> actions = new HashMap<>();
        WaitingQueue queueWaiting = new WaitingQueue();

        actions.put(1, () -> queueWaiting.add());
        actions.put(2, () -> queueWaiting.callNext());
        actions.put(3, () -> queueWaiting.showQueue());
        actions.put(4, () -> System.out.println("Saindo..."));

        int option;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar pessoa à fila de espera");
            System.out.println("2 - Chamar próxima pessoa da fila de espera");
            System.out.println("3 - Exibir fila de espera");
            System.out.println("4 - Sair");

            option = Util.readValidInt(
                    "Opção: ",
                    value -> value >= 1 && value <= 4,
                    "Digite apenas números entre 1 e 4.");
            System.out.println("");

            actions.get(option).run();

        } while (option != 4);
    }
}
