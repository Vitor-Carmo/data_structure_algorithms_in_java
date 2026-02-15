package Unidade_01;
import java.util.ArrayList;

public class Ex4 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayNumbers = new ArrayList<>();

        int option;


        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar número");
            System.out.println("2 - Remover número");
            System.out.println("3 - Listar números");
            System.out.println("4 - Sair");
            option = Integer.parseInt(System.console().readLine());


            switch (option) {
                case 1:
                    System.out.println("Digite um número para adicionar:");
                    int numberToAdd = Integer.parseInt(System.console().readLine());
                    arrayNumbers.add(numberToAdd);
                    System.out.println("Número adicionado com sucesso!");
                    break;
            
                case 2:
                    if(arrayNumbers.isEmpty()){
                        System.out.println("A lista está vazia! Não há números para remover.");
                        break;
                    }


                    if(arrayNumbers.size() == 1){
                        arrayNumbers.remove(0);
                        System.out.println("Número removido com sucesso!");
                        break;
                    }
                    
                    System.out.println("Digite o índice do número a ser removido:");
                    
                    int indexToRemove = Integer.parseInt(System.console().readLine());
                    
                    if (indexToRemove >= 0 && indexToRemove < arrayNumbers.size()) {
                        arrayNumbers.remove(indexToRemove);
                        System.out.println("Número removido com sucesso!");
                    }else {
                        System.out.println("Índice inválido!");
                    }
                    break;
            
                case 3:
                    System.out.println("Números na lista:");

                    if(arrayNumbers.isEmpty()){
                        System.out.println("A lista está vazia! Não há números para listar.");
                        break;
                    } 

                    
                    for (int i = 0; i < arrayNumbers.size(); i++) {
                        System.out.println(i + " - " + arrayNumbers.get(i));
                    }
                    break;
            
                default:
                    break;
            }

        } while (option != 4);

    }
}