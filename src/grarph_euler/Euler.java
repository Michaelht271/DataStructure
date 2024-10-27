package grarph_euler;

import java.util.*;

public class Euler {
    private final int V;  // Number of vertices
    private final LinkedList<Integer>[] adj;  // Adjacency list for storing edges

    // Constructor to initialize the graph with a given number of vertices
    public Euler(int v) {
        if (v <= 0) {
            throw new IllegalArgumentException("Number of vertices must be positive.");
        }
        this.V = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Method to add edges to the graph
    public void addEdge(int u, int... neighbors) {
        for (int v : neighbors) {
            if (u < 0 || u >= V || v < 0 || v >= V) {
                throw new IllegalArgumentException("Vertex index out of bounds.");
            }
            adj[u].add(v);
            adj[v].add(u);
        }
    }

    // Depth-First Search to check connectivity
    private void DFS(int v, boolean[] visited) {
        visited[v] = true;
        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                DFS(neighbor, visited);
            }
        }
    }

    // Method to check if the graph is connected
    public boolean isConnected() {
        boolean[] visited = new boolean[V];
        int startVertex = -1;

        // Find a vertex with at least one edge
        for (int i = 0; i < V; i++) {
            if (!adj[i].isEmpty()) {
                startVertex = i;
                break;
            }
        }

        
        // If there are no edges, consider the graph as connected
        if (startVertex == -1) {
            return true;
        }

        // Perform DFS from the found vertex
        DFS(startVertex, visited);

        // Check if all vertices with edges are visited
        for (int i = 0; i < V; i++) {
            if (!visited[i] && !adj[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    // Method to check if the graph has an Eulerian path or cycle
    public String findEuler() {
        if (!isConnected()) {
            return "Graph is not Eulerian: The graph is not connected.";
        }

        // Count vertices with odd degree
        List<Integer> oddVertices = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0) {
                oddVertices.add(i);
            }
        }

        // Determine if the graph has an Eulerian path or cycle
        if (oddVertices.isEmpty()) {
            return "Graph has an Eulerian Cycle.";
        } else if (oddVertices.size() == 2) {
            return "Graph has an Eulerian Path with odd vertices at indices: " + oddVertices;
        } else {
            return "Graph is not Eulerian: The graph has " + oddVertices.size() + " odd degree vertices at indices: " + oddVertices;
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Euler graph = new Euler(5);
        graph.addEdge(0, 1, 4,3, 2);
        graph.addEdge(1, 2);
  //      graph.addEdge(2, 3);
    //    graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        System.out.println(graph.findEuler());  // Expected output: Graph has an Eulerian Path
    }
}
