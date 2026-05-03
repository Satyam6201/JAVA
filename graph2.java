import java.util.ArrayList;

public class graph2 {
    static class Edge {
        int src;
        int dist;

        public Edge(int src, int dist) {
            this.src = src;
            this.dist = dist;
        }
    }

    // Create a graph
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*

        // UnDirected Graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

        */
       
    }

    // 1. Find a graph is cycle or not (Undirected Graph)
    public static Boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisited[i]) {
                if (detectCycleUtil(graph, isVisited, i, -1)) {
                    return true;
                }
            }
        }               
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean isVisited[], int curr, int parents) {
        isVisited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!isVisited[e.dist]) {
                if (detectCycleUtil(graph, isVisited, e.dist, curr)) {
                    return true;
                }
            }
            else if (isVisited[e.dist] && e.dist != parents) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        
        System.out.println(detectCycle(graph));  // true
    }
}
