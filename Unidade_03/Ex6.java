package Unidade_03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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

    void addEdge(int from, int to) {
        adj.get(from).add(to);
        adj.get(to).add(from);
    }

    public List<Integer> BFS(int from, int to) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> visited = new ArrayList<>();
        Map<Integer, Integer> parent = new HashMap<>();

        queue.add(from);
        visited.add(from);
        parent.put(from, -1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == to)
                break;

            for (Integer neighbor : adj.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }

        }

        if (!visited.contains(to)) {
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

/*
 * 
 *     0
 *    / \
 *   1   2
 *  / \
 * 3   4
 */
public class Ex6 {

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

        public List<Integer> BFS(int from, int to) {
            Queue<Integer> queue = new ArrayDeque<>();
            List<Integer> visited = new ArrayList<>();
            Map<Integer, Integer> parent = new HashMap<>();

            queue.add(from);
            visited.add(from);
            parent.put(from, -1);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                if (current == to)
                    break;

                for (Integer neighbor : adj.get(current)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        parent.put(neighbor, current);
                        queue.add(neighbor);
                    }
                }

            }

            if (!visited.contains(to)) {
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

        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);

        List<Integer> path = g.BFS(0, 4);

        if (path.isEmpty()) {
            System.out.println("Não há caminho entre os vértices 0 e 4");
        } else {
            System.out.println("Caminho mais curto entre 0 e 4: " + path);
        }
    }

}