import java.util.ArrayList;

public class graph {
    static class Edge {
        int src;
        int dist;
        int wt;

        public Edge(int src, int dist, int wt) {
            this.src = src;
            this.dist = dist;
            this.wt = wt;
        }
    }

    // 1. Create a graph 
    public static void createGraph() {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // // Add 0 vertex:-
        graph[0].add(new Edge(0, 1, 5));

        // Add 1 vertex:-
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // Add 2 vertex:-
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // Add 3 vertex:-
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // Add 4 vertex:-
        graph[4].add(new Edge(4, 2, 2));

        // Print 2nd graph
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            
            // System.out.print(e.dist + " ");  // 1 3 4
            System.out.print(e.wt + " ");
        }
    }
    public static void main(String[] args) {
        createGraph();
    }
}