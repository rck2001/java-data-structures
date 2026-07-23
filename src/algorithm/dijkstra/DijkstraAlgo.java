package algorithm.dijkstra;

public class DijkstraAlgo {

    private final int V;
    private static final int INF = Integer.MAX_VALUE;

    // user input fields
    private final int[][] graph;
    private final int source;
    private final String[] labels;

    // why final arrays? array references are final, but the data in the structure itself can be changed
    private final int[] distance;
    private final int[] parent;
    private final boolean[] visited;

    // flag to check if paths have been computed
    private boolean computed = false;

    public DijkstraAlgo(int[][] graph, int source, String[] labels) {
        // validate user inputs
        validateInputs(graph, source, labels);

        // object initialisation
        this.V = graph.length;

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
            int u = getMinimumDistanceVertex();

            if(u == -1) break;

            visited[u] = true;

            for(int v = 0; v < V; v++) {
                if(!visited[v] &&
                        graph[u][v] != 0 &&
                        distance[u] != INF &&
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
            String dist = distance[v] == INF ? "Unreachable" : String.valueOf(distance[v]);

            System.out.printf("%-8s %-10s %s\n",
                    labels[v],
                    dist,
                    getPath(v));
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
        // check if vertex is valid
        if(vertex < 0 || vertex >= V) {
            throw new IllegalArgumentException("Vertex doesn't exist for the graph");
        }

        if(!computed) {
            run();
        }

        // main logic
        if(distance[vertex] == INF) { // for disconnected graphs
            return "Unreachable";
        }

        if(parent[vertex] == -1) {
            return labels[vertex];
        }

        return getPath(parent[vertex]) + " -> " + labels[vertex];
    }
    public int getDistance(int vertex) {
        // check if vertex is valid
        if(vertex < 0 || vertex >= V) {
            throw new IllegalArgumentException("Vertex doesn't exist for the graph");
        }

        if(!computed) {
            run();
        }

        return distance[vertex];
    }

    public String getPath(String vertex) {
        return getPath(getVertexIndex(vertex));
    }
    public int getDistance(String vertex) {
        return getDistance(getVertexIndex(vertex));
    }

    // helpers
    private int getMinimumDistanceVertex() {
        int minDistance = INF, minIndex = -1;

        for(int i = 0; i < V; i++) {
            if(!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
    private int getVertexIndex(String vertex) {
        for(int i = 0; i < V; i++) {
            if(labels[i].equals(vertex))
                return i;
        }

        throw new IllegalArgumentException("Vertex doesn't exist");
    }
    private static void validateInputs(int[][] graph, int source, String[] labels) {
        // graph validation
        if(graph == null)
            throw new NullPointerException("Graph cannot be null");
        if(graph.length == 0)
            throw new IllegalArgumentException("Graph cannot be empty");
        for(int[] row : graph) {
            if(row.length != graph.length)
                throw new IllegalArgumentException("Input graph must be a square matrix");

            for(int weight : row) {
                if(weight < 0)
                    throw new IllegalArgumentException("Negative edge weights are not supported");
            }
        }

        // source validation
        if(source < 0 || source >= graph.length)
            throw new IllegalArgumentException("Source vertex is invalid");

        // labels validation
        if(labels == null)
            throw new NullPointerException("Labels cannot be null");
        if(labels.length == 0)
            throw new IllegalArgumentException("Labels cannot be empty");
        if(labels.length != graph.length)
            throw new IllegalArgumentException("Labels and graph size must match");
    }
}
