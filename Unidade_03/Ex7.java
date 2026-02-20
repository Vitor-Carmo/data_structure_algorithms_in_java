package Unidade_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 
 *     0
 *    / \
 *   1   2
 *  / \
 * 3   4
 */
public class Ex7 {
    static class Graph {
        int V;
        Map<Integer, List<Integer>> adj;

        Graph(int v) {
            V = v;
            adj = new HashMap<>();
            for (int i = 0; i < v; i++) {
                addVertex(i);
            }
        }

        void addVertex(int v) {
            adj.put(v, new ArrayList<>());
        }

        void addEdge(int from, int to) {
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        public void DFS(int v) {
            Set<Integer> visited = new HashSet<>();
            DFS(v, visited);
        }

        private void DFS(int v, Set<Integer> visited) {
            visited.add(v);
            System.out.print(v + " ");
            for (Integer neighbor : adj.get(v)) {
                if (!visited.contains(neighbor)) {
                    DFS(neighbor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);


        System.out.println("Vértices visitados em Busca em Profundidade (DFS):");
        g.DFS(4);

    }

}