package Unidade_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Ex9 {
    static class Graph {
        int V;
        Map<Integer, Map<Integer, Integer>> adj;

        Graph(int v) {
            V = v;
            adj = new HashMap<>();
            for (int i = 0; i < v; i++) {
                addVertex(i);
            }
        }

        void addVertex(int v) {
            adj.put(v, new HashMap<>());
        }

        void addEdge(int from, int to, int weight) {
            adj.get(from).put(to, weight);
            adj.get(to).put(from, weight);
        }

        public List<Integer> Dijkstra(int from, int to) {
            Map<Integer, Integer> distance = new HashMap<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distance::get));
            Map<Integer, Integer> parent = new HashMap<>();


            // Inicializa as distâncias e os pais
            for (int v : adj.keySet()) {
                distance.put(v, Integer.MAX_VALUE);
                parent.put(v, -1);
            }

            distance.put(from, 0);
            priorityQueue.add(from);

            while (!priorityQueue.isEmpty()) {
                int current = priorityQueue.poll();
                if (current == to)
                    break;

                for (Integer neighbor : adj.get(current).keySet()) {
                    int newDist = distance.get(current) + adj.get(current).get(neighbor);
                    if (newDist < distance.get(neighbor)) {
                        distance.put(neighbor, newDist);
                        parent.put(neighbor, current);
                        priorityQueue.add(neighbor);
                    }
                }

            }

            if (distance.get(to) == Integer.MAX_VALUE) {
                return new ArrayList<>();
            }

            List<Integer> path = new ArrayList<>();
            int actual = to;

            while (actual != -1) {
                path.add(actual);
                actual = parent.get(actual);
            }

            Collections.reverse(path);
            return path;
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(4);

        
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 1);

        List<Integer> path = g.Dijkstra(0, 3);

        if (path.isEmpty()) {
            System.out.println("Não há caminho entre os vértices 0 e 3");
        } else {
            System.out.println("Caminho mais curto entre 0 e 3: " + path);
        }
    }

}