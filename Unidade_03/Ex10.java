package Unidade_03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Graph {
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

    // Directed graph (required for Topological Sort)
    void addEdge(int from, int to) {
        adj.get(from).add(to);
    }

    public List<Integer> topologicalSort() {
        int[] inDegree = new int[V];

        // Calculate in-degree of each vertex
        for (int i = 0; i < V; i++) {
            for (Integer neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        // Add vertices with in-degree 0
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int visitedCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);
            visitedCount++;

            for (Integer neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If not all vertices are processed, there is a cycle
        if (visitedCount != V) {
            return new ArrayList<>();
        }

        return order;
    }
}

public class Ex10 {

    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        List<Integer> order = g.topologicalSort();

        if (order.isEmpty()) {
            System.out.println("O grafo possui ciclo. Não é possível realizar a ordenação topológica.");
        } else {
            System.out.println("Ordenação topológica dos vértices: " + order);
        }
    }
}