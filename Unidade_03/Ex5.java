package Unidade_03;

import java.util.LinkedList;

public class Ex5 {
    static class Graph {
        int V;
        LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);

        System.out.println("Grafo criado com sucesso!");

        for (int i = 0; i < g.V; i++) {
            System.out.print(i + ": ");
            for (Integer neighbor : g.adj[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

    }

}