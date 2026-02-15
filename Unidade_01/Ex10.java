package Unidade_01;
import java.util.ArrayList;

class Stock {
    private String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class Ex10 {
    public static void main(String[] args) {
        ArrayList<Stock> stock = new ArrayList<>();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar item ao estoque");
            System.out.println("2 - Remover item do estoque");
            System.out.println("3 - Atualizar quantidade de um item");
            System.out.println("4 - Mostrar estoque");
            System.out.println("5 - Sair");

            System.out.print("Opção: ");
            int option = Integer.parseInt(System.console().readLine());

            switch (option) {
                case 1:
                    System.out.print("Digite o nome do item a ser adicionado: ");
                    String ItemName = System.console().readLine();
                    
                    System.out.print("Digite a quantidade do item a ser adicionado: ");
                    int quantityItem = Integer.parseInt(System.console().readLine());
                    
                    stock.add(new Stock(ItemName, quantityItem));
                    
                    System.out.println("Item adicionado ao estoque.");

                    break;
                case 2:
                    if(stock.isEmpty()){
                        System.out.println("O estoque está vazio.");
                        break;
                    }

                    System.out.print("Digite o nome do item a ser removido: ");
                    String nameItemToRemove = System.console().readLine();
                    
                    stock.removeIf(item -> item.getName().equalsIgnoreCase(nameItemToRemove));
                    System.out.println("Item removido do estoque.");

                    break;
                case 3:
                    if(stock.isEmpty()){
                        System.out.println("O estoque está vazio.");
                        break;
                    }
                    System.out.print("Digite o nome do item a ser atualizado: ");
                    String updatedName = System.console().readLine();
                    System.out.print("Digite a nova quantidade do item: ");
                    int newQuantity = Integer.parseInt(System.console().readLine());
                    boolean itemFound = false;

                    for (Stock item : stock) {
                        if (item.getName().equalsIgnoreCase(updatedName)) {
                            item.setQuantity(newQuantity);
                            System.out.println("Quantidade do item atualizada.");
                            itemFound = true;
                            break;
                        }
                    }

                    if (!itemFound) {
                        System.out.println("Item não encontrado no estoque.");
                    }

                    break;

                case 4:
                    if(stock.isEmpty()){
                        System.out.println("O estoque está vazio.");
                        break;
                    }
                    System.out.println("Estoque:");
                    for (Stock item : stock) {
                        System.out.println("Item: " + item.getName() + ", Quantidade: " + item.getQuantity());
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        }
    }
}