package Projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Relatorio {
    
    private Map<String, Integer> saborParaIndice = new HashMap<>();
    private List<String> indiceParaSabor = new ArrayList<>();
    private int[][] matrizAdjacencia; 
    private Map<String, Integer> contagemSabores = new HashMap<>();
    private double faturamentoTotal = 0;

    public void processarPedidos(List<Pedido> todosPedidos) {
        
        for (Pedido p : todosPedidos) {
            faturamentoTotal += p.getValorTotal();
            for (Pizza pizza : p.getPizzas()) {
                for (String sabor : pizza.getSabores()) {
                    registrarSabor(sabor);
                    contagemSabores.put(sabor, contagemSabores.getOrDefault(sabor, 0) + 1);
                }
            }
        }

        
        int n = indiceParaSabor.size();
        matrizAdjacencia = new int[n][n];

        
        for (Pedido p : todosPedidos) {
            for (Pizza pizza : p.getPizzas()) {
                List<String> sbs = pizza.getSabores();
                
                for (int i = 0; i < sbs.size(); i++) {
                    for (int j = i + 1; j < sbs.size(); j++) {
                        int idx1 = saborParaIndice.get(sbs.get(i));
                        int idx2 = saborParaIndice.get(sbs.get(j));
                        
                        matrizAdjacencia[idx1][idx2]++;
                        matrizAdjacencia[idx2][idx1]++;
                    }
                }
            }
        }
    }

    private void registrarSabor(String sabor) {
        if (!saborParaIndice.containsKey(sabor)) {
            saborParaIndice.put(sabor, indiceParaSabor.size());
            indiceParaSabor.add(sabor);
        }
    }

    public void exibirRelatorio() {
        System.out.println("\n========== RELATÓRIO DE VENDAS (GRAFOS) ==========");
        System.out.printf("Faturamento Total: R$ %.2f\n", faturamentoTotal);
        
        System.out.println("\n--- Sabores Mais Pedidos ---");
        contagemSabores.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " vezes"));

        System.out.println("\n--- Ligações entre Sabores (Mesma Pizza) ---");
    
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = i + 1; j < matrizAdjacencia[i].length; j++) {
                if (matrizAdjacencia[i][j] > 0) {
                    System.out.println("[ " + indiceParaSabor.get(i) + " ] <---> [ " + 
                                    indiceParaSabor.get(j) + " ] | Ocorrências: " + matrizAdjacencia[i][j]);
                }
            }
        }
        System.out.println("==================================================\n");
    }
}
