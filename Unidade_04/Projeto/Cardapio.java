package Projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cardapio {
    private Map<String, Double> cardapio;

    public Cardapio(){
        this.cardapio = new HashMap<>();
        inicializarCardapio();

    }

    private void inicializarCardapio(){
        cardapio.put("Margherita", 25.0);
        cardapio.put("Pepperoni", 30.0);
        cardapio.put("Quatro Queijos", 28.0);
        cardapio.put("Calabresa", 27.5);
        cardapio.put("Frango com Catupiry", 32.0);
        cardapio.put("Vegetariana", 40.0);
        cardapio.put("Portuguesa", 29.4);
        cardapio.put("Atum", 31.0);
        cardapio.put("Aliche", 24.0);
        cardapio.put("Mussarela", 22.0);
    }

    public Map<String, Double> getCardapio() {
        return cardapio;
    }

    public double getPrecoJusto(List<String> sabores){
        List<String> saboresDisponiveis = new ArrayList<>();
        double precoTotal = 0.0;
        int totalSabores = 0;

        for(String sabor : sabores){
            if(cardapio.containsKey(sabor)){
                saboresDisponiveis.add(sabor);
                totalSabores++;
            } else {
                System.out.println("Sabor " + sabor + " não disponível no cardápio.");
            }
        }

        for (String sabor : saboresDisponiveis) {
            precoTotal += cardapio.get(sabor)/totalSabores;
        }

        return precoTotal;
    }
}
