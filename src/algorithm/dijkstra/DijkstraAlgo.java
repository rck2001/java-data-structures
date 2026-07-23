package algorithm.dijkstra;

public class DijkstraAlgo {

    private final int V;
    private final int INF;
    private final int[][] graph;
    private final int source;
    private final String[] labels;

    private int[] distance;
    private int[] parent;
    private boolean[] visited;

    // flag to check if paths have been computed
    private boolean computed = false;

    public DijkstraAlgo(int[][] graph, int source, String[] labels) {
        this.V = graph.length;
        this.INF = Integer.MAX_VALUE;

        this.graph = graph;
        this.source = source;
        this.labels = labels;

        this.distance = new int[V];
        this.parent = new int[V];
        this.visited = new boolean[V];
    }

    public void run() {
        // initialise
        for(int i = 0; i < V; i++) {
            distance[i] = INF;
            visited[i] = false;
            parent[i] = -1;
        }

        distance[source] = 0;

        for(int count = 0; count < V - 1; count++) {
            int u = getMinimumDistanceVertex(distance, visited);

            if(u == -1) break;

            visited[u] = true;

            for(int v = 0; v < V; v++) {
                if(!visited[v] &&
                        graph[u][v] != 0 &&
                        graph[u][v] + distance[u] < distance[v]) {
                    distance[v] = graph[u][v] + distance[u];
                    parent[v] = u;
                }
            }
        }

        computed = true;
    }

    // display methods
    public void display() {
        if(!computed) {
            run();
        }

        System.out.println("Source = " + labels[source] + "\n");

        System.out.printf("%-8s %-10s %s\n", "Vertex", "Distance", "Path");
        System.out.println("----------------------------------------");
        for(int v = 0; v < V; v++) {
            System.out.printf("%-8s %-10d %s\n", labels[v], distance[v], getPath(v));
        }
    }
    @Override
    public String toString() {
        return "DijkstraAlgorithm{source=" +
                labels[source] +
                ", Vertices=" + V + "}";
    }

    // utilities
    public String getPath(int vertex) {
        if(!computed) {
            run();
        }

        if(parent[vertex] == -1) {
            return labels[vertex];
        }

        return getPath(parent[vertex]) + " -> " + labels[vertex];
    }
    public int getDistance(int vertex) {
        if(!computed) {
            run();
        }

        return distance[vertex];
    }

    // helpers
    private int getMinimumDistanceVertex(int[] distance, boolean[] visited) {
        int minDistance = INF, minIndex = -1;

        for(int i = 0; i < V; i++) {
            if(!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
