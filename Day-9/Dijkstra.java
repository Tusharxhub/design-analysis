//! wap in java to implement Dijkstra's algorithm

import java.util.*;

class Edge {
    int src, dest, weight;
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {
    int vertex, weight;
    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
    public int compareTo(Node node) {
        return this.weight - node.weight;
    }
}

class Graph {
    int vertices;
    List<List<Edge>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) adjList.add(new ArrayList<>());
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(src, dest, weight));
        adjList.get(dest).add(new Edge(dest, src, weight));
    }

    public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int vertex = node.vertex;

            for (Edge edge : adjList.get(vertex)) {
                int newDist = dist[vertex] + edge.weight;
                if (newDist < dist[edge.dest]) {
                    dist[edge.dest] = newDist;
                    pq.add(new Node(edge.dest, newDist));
                }
            }
        }

        printDijkstra(dist, start);
    }

    public void printDijkstra(int[] dist, int start) {
        System.out.println("Dijkstra's Algorithm: (Start Vertex: " + start + ")");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Vertex " + i + " is at distance " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.dijkstra(0);
    }
}
