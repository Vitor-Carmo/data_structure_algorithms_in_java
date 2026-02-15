package Unidade_01;
import java.util.ArrayList;



class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}

public class Ex9 {
    public static void main(String[] args) {
        ArrayList<Person> peopleList = new ArrayList<>();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar pessoa");
            System.out.println("2 - Mostrar lista de pessoas");
            System.out.println("3 - Sair");



            System.out.print("Opção: ");
            int option = Integer.parseInt(System.console().readLine());

            switch (option) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String name = System.console().readLine();
                    System.out.print("Digite a idade: ");
                    int age = Integer.parseInt(System.console().readLine());
                    System.out.print("Digite o Endereço: ");
                    String address = System.console().readLine();

                    Person person = new Person(name, age, address);

                    peopleList.add(person);
                    break;
                case 2:
                    if (peopleList.isEmpty()) {
                        System.out.println("A lista de pessoas está vazia.");
                        break;
                    }
                    System.out.println("Lista de pessoas:");
                    for (Person p : peopleList) {
                        System.out.println("Nome: " + p.getName() + ", Idade: " + p.getAge() + ", Endereço: " + p.getAddress());
                    }
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }

        }
    }
}