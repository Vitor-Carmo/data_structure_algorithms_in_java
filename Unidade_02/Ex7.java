package Unidade_02;

import java.util.ArrayDeque;
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
