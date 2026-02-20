package Projeto;

import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Pizza> pizzas;
    private double valorTotal;

    public Pedido(int id, Cliente cliente, List<Pizza> pizzas, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas;
        this.valorTotal = valorTotal;
    }

    public boolean removerPizzaPorSabor(String sabor) {
        for (int i = 0; i < pizzas.size(); i++) {
            for (String pizzaSabor : pizzas.get(i).getSabores()) {
                if (pizzaSabor.equalsIgnoreCase(sabor)) {
                    pizzas.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean alterarSaborEspecifico(String saborAntigo, String saborNovo) {
        for (Pizza pizza : pizzas) {
            List<String> listaSabores = pizza.getSabores();
            for (int i = 0; i < listaSabores.size(); i++) {
                if (listaSabores.get(i).equalsIgnoreCase(saborAntigo)) {
                    listaSabores.set(i, saborNovo);
                    return true;
                }
            }
        }
        return false;
    }

    public double calcularFrete(double distanciaKm) {
        double taxaPorKm = 1.50;
        double taxaPorVolume = 2.00;
        
        
        double custoDistancia = distanciaKm * taxaPorKm;
        
        int quantidadePizzas = this.pizzas.size();
        double custoPeso = quantidadePizzas * taxaPorVolume;
        
        double freteTotal = custoDistancia + custoPeso;
        return freteTotal;
    }

    public void listarSaboresDoPedido() {
        for (Pizza pizza : pizzas) {
            System.out.println("Sabores da pizza: " + pizza.getSabores());
        }
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
