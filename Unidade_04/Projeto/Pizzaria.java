package Projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Projeto.Pizza.TamanhoPizza;

public class Pizzaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();

        Map<String, Integer> cidadesEntrega = Map.of(
                "São Paulo", 1,
                "Minas Gerais", 3,
                "Bahia", 10,
                "Amazonas", 17);

        final boolean[] continuar = { true };

        Map<Integer, Runnable> actions = new HashMap<>();

        actions.put(1, () -> fazerPedido(scanner, listaPedidos, listaClientes));

        actions.put(2, () -> alterarPedido(scanner, listaPedidos));

        actions.put(3, () -> {
            finalizarPedido(scanner, listaPedidos, cidadesEntrega);
            continuar[0] = false;
        });

        actions.put(4, () -> {
            listaClientes.add(adicionarCliente(scanner));
            System.out.println("Cliente adicionado com sucesso!");
        });

        actions.put(5, () -> gerarRelatorioVendas(listaPedidos));

        actions.put(6, () -> gerarListaClientes(listaClientes));

        actions.put(9, () -> {
            continuar[0] = false;
            System.out.println("Saindo do sistema. Obrigado por usar a Pizzaria!");
            scanner.close();
        });

        while (continuar[0]) {
            mostrarMenu();

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            Runnable action = actions.get(opcao);

            if (action != null) {
                action.run();
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Fazer pedido");
        System.out.println("2. Alterar pedido");
        System.out.println("3. Finalizar pedido");
        System.out.println("4. Adicionar cliente");
        System.out.println("5. Gerar relatório de vendas");
        System.out.println("6. Gerar lista de clientes");
        System.out.println("9. Sair");
    }

    private static void fazerPedido(Scanner scanner, List<Pedido> listaPedidos, List<Cliente> listaClientes) {

        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Por favor, adicione um cliente antes de fazer um pedido.");
            return;
        }
        
        List<Pizza> pizzas = new ArrayList<>();
        System.out.println("FAZER PEDIDO");

        int x = 1;

        System.out.println("Selecione o cliente:");
        for (Cliente cliente : listaClientes) {
            System.out.println(x + ". " + cliente.getNome());
            x++;
        }
        System.out.print("Opção: ");
        int cliente = scanner.nextInt();
        scanner.nextLine();

        boolean contiuar = true;
        while (contiuar) {
            x = 1;
            System.out.println("Selecione o tamanho da pizza:");
            for (TamanhoPizza tamanhos : Pizza.TamanhoPizza.values()) {
                System.out.println(x + ". " + tamanhos);
                x++;
            }
            System.out.print("Opção: ");
            int tamanho = scanner.nextInt();
            scanner.nextLine();

            int quantiSabores = 0;
            while (quantiSabores < 1 || quantiSabores > 4) {
                System.out.println("Digite a quantidade de sabores (1 a 4): ");
                System.out.print("Opção: ");
                quantiSabores = scanner.nextInt();
                scanner.nextLine();
            }

            Cardapio cardapio = new Cardapio();
            List<String> saboresList = new ArrayList<>();
            List<String> saboresSelecionados = new ArrayList<>();

            for (int i = 0; i < quantiSabores; i++) {
                System.out.println("Selecione o sabor:");

                x = 1;
                for (String sabor : cardapio.getCardapio().keySet()) {
                    saboresList.add(sabor);
                    System.out.println(x + ". " + sabor);
                    x++;
                }
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                saboresSelecionados.add(saboresList.get(opcao - 1));
            }

            Pizza pizza = new Pizza(saboresSelecionados, cardapio.getPrecoJusto(saboresSelecionados),
                    TamanhoPizza.getByIndex(tamanho - 1));
            pizzas.add(pizza);

            System.out.println("Pizza adicionada ao pedido com sucesso!");
            System.out.println();
            System.out.println("Deseja adicionar mais pizzas ao pedido?");
            System.out.print("1. Sim, 2. Não: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao != 1) {
                contiuar = false;
            }
        }
        Pedido pedido = new Pedido(listaPedidos.size() + 1, listaClientes.get(cliente - 1), pizzas,
                somarPizzas(pizzas));
        listaPedidos.add(pedido);
    }

    private static double somarPizzas(List<Pizza> pizzas) {
        double valorTotal = 0.0;
        for (Pizza pizza : pizzas) {
            valorTotal += pizza.getPreco();
        }
        return valorTotal;
    }

    private static void alterarPedido(Scanner scanner, List<Pedido> listaPedidos) {
        System.out.println("Informe o ID ou o Nome do Cliente para buscar o pedido:");
        String busca = scanner.nextLine();

        Pedido pedidoEncontrado = buscarPedido(busca, listaPedidos);

        if (pedidoEncontrado == null) {
            System.out.println("Pedido não localizado.");
            return;
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("EDITANDO PEDIDO");
            System.out.println("1. Adicionar nova pizza");
            System.out.println("2. Remover pizza (por sabor)");
            System.out.println("3. Alterar um sabor específico");
            System.out.println("0. Sair e Salvar");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    int x = 1;
                    System.out.println("Selecione o tamanho da pizza:");
                    for (TamanhoPizza tamanhos : Pizza.TamanhoPizza.values()) {
                        System.out.println(x + ". " + tamanhos);
                        x++;
                    }
                    System.out.print("Opção: ");
                    int tamanho = scanner.nextInt();
                    scanner.nextLine();

                    int quantiSabores = 0;
                    while (quantiSabores < 1 || quantiSabores > 4) {
                        System.out.println("Digite a quantidade de sabores (1 a 4): ");
                        System.out.print("Opção: ");
                        quantiSabores = scanner.nextInt();
                        scanner.nextLine();
                    }

                    Cardapio cardapio = new Cardapio();
                    List<String> saboresList = new ArrayList<>();
                    List<String> saboresSelecionados = new ArrayList<>();

                    for (int i = 0; i < quantiSabores; i++) {
                        System.out.println("Selecione o sabor:");

                        x = 1;
                        for (String sabor : cardapio.getCardapio().keySet()) {
                            saboresList.add(sabor);
                            System.out.println(x + ". " + sabor);
                            x++;
                        }
                        System.out.print("Opção: ");
                        int opcao1 = scanner.nextInt();
                        scanner.nextLine();
                        saboresSelecionados.add(saboresList.get(opcao1 - 1));
                    }
                    Pizza nova = new Pizza(saboresSelecionados, cardapio.getPrecoJusto(saboresSelecionados),
                            TamanhoPizza.getByIndex(tamanho - 1));
                    pedidoEncontrado.getPizzas().add(nova);
                    System.out.println("Pizza adicionada!");
                    break;

                case 2:
                    pedidoEncontrado.listarSaboresDoPedido();
                    System.out.print("Qual sabor da pizza que deseja REMOVER inteira? ");
                    String sabRemover = scanner.nextLine();
                    if (pedidoEncontrado.removerPizzaPorSabor(sabRemover)) {
                        System.out.println("Pizza removida com sucesso!");
                    } else {
                        System.out.println("Sabor não encontrado.");
                    }
                    break;

                case 3:
                    Cardapio cardapioAlt = new Cardapio();
                    List<String> saboresListAlt = new ArrayList<>();
                    int y = 1;

                    pedidoEncontrado.listarSaboresDoPedido();
                    System.out.print("Digite o nome do sabor que deseja trocar: ");
                    String antigo = scanner.nextLine();
                    System.out.print("Digite o novo sabor: ");
                    for (String sabor : cardapioAlt.getCardapio().keySet()) {
                        saboresListAlt.add(sabor);
                        System.out.println(y + ". " + sabor);
                        y++;
                    }
                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    String novoSabor = saboresListAlt.get(escolha - 1);

                    if (pedidoEncontrado.alterarSaborEspecifico(antigo, novoSabor)) {
                        System.out.println("Sabor atualizado!");
                    } else {
                        System.out.println("Sabor antigo não encontrado no pedido.");
                    }
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Alterações salvas com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;

            }
        }

    }

    private static void finalizarPedido(Scanner scanner, List<Pedido> listaPedidos, Map<String, Integer> cidades) {
        int x = 1;
        for (String zona : cidades.keySet()) {
            System.out.println(x + ". " + zona);
            x++;
        }
        System.out.print("Informe a zona de entrega: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        String zonaEntrega = (String) cidades.keySet().toArray()[opcao - 1];

        if (!cidades.containsKey(zonaEntrega)) {
            System.out.println("Zona de entrega inválida.");
            return;
        }

        int km = cidades.get(zonaEntrega);

        for (Pedido pedido : listaPedidos) {
            double frete = pedido.calcularFrete(km);
            double totalPizzas = pedido.getValorTotal();

            System.out.println("\n--- Resumo do Frete ---");
            System.out.printf("Custo por Distância: R$ %.2f\n", (km * 1.50));
            System.out.printf("Custo por Volume (%d pizzas): R$ %.2f\n", pedido.getPizzas().size(),
                    (pedido.getPizzas().size() * 2.00));
            System.out.printf("Total do Frete: R$ %.2f\n", frete);
            System.out.println("-----------------------");
            System.out.printf("TOTAL A PAGAR: R$ %.2f\n", (totalPizzas + frete));
        }
    }

    private static Cliente adicionarCliente(Scanner scanner) {
        System.out.println("ADICIONAR CLIENTE");
        System.out.println();
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println();
        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.println();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.println();
        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();
        System.out.println();

        return new Cliente(nome, endereco, telefone, email);
    }

    private static void gerarRelatorioVendas(List<Pedido> listaPedidos) {
        Relatorio relatorio = new Relatorio();
        relatorio.processarPedidos(listaPedidos);
        relatorio.exibirRelatorio();
    }

    private static void gerarListaClientes(List<Cliente> listaClientes) {
        int x = 1;
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : listaClientes) {
                System.out.println("Cliente " + x);
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Endereço: " + cliente.getEndereco());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("Email: " + cliente.getEmail());
                System.out.println();
                x++;
            }
        }

    }

    public static Pedido buscarPedido(String entrada, List<Pedido> listaDePedidos) {
        for (Pedido p : listaDePedidos) {
            if (String.valueOf(p.getId()).equals(entrada) ||
                    p.getCliente().getNome().equalsIgnoreCase(entrada)) {
                return p;
            }
        }
        return null;
    }

}
