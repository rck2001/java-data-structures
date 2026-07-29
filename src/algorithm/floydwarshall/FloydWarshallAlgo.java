package algorithm.floydwarshall;

import java.util.HashSet;
import static algorithm.Constants.INF;

/* FLYOD-WARSHALL ALGORITHM
 * All-pairs shortest path algorithm
 * Time complexity : O(V³)
 * Space complexity : O(V²)
 */

// The code assumes INF = Integer.MAX_VALUE
// Integer overflow is prevented during distance relaxation

public class FloydWarshallAlgo {

    private final int V;
    private final int[][] graph;
    private final String[] labels;

    private final int[][] distance;
    private final int[][] parent;

    // flag to check if the algorithm has already been run
    private boolean computed = false;

    public FloydWarshallAlgo(int[][] graph, String[] labels) {
        // validate inputs
        validateInputs(graph, labels);

        // object initialisation
        this.V = graph.length;

        this.graph = new int[V][V];
        this.labels = labels.clone(); // we clone so that any changes in value when the algorithm in running doesn't produce undesired results

        this.distance = new int[V][V];
        this.parent = new int[V][V];

        for(int i = 0; i < V; i++) { // deep clone
            this.graph[i] = graph[i].clone();
            this.distance[i] = graph[i].clone();
        }
    }

    // Floyd-warshall algorithm
    public void run() {
        if(computed) return;

        initialiseParentMatrix();

        // main logic
        for(int k = 0; k < V; k++) {

            for(int i = 0; i < V; i++) {
                for(int j = 0; j < V; j++) {
                    // We are casting one of the int values to long...
                    // So that long addition is performed...
                    // And integer overflow doesn't occur
                    long newDistance = (long) distance[i][k] + distance[k][j];

                    if(distance[i][k] != INF &&
                            distance[k][j] != INF &&
                            newDistance < distance[i][j]) {
                        distance[i][j] = (int) newDistance;
                        parent[i][j] = parent[k][j];
                    }
                }
            }
        }

        detectNegativeCycles();

        computed = true;
    }

    // display methods
    @Override
    public String toString() {
        return String.format("FloydWarshallAlgorithm{Vertices=%d}", V);
    }
    public void display() {
        ensureComputed();

        System.out.println("Shortest paths: ");
        System.out.println("-".repeat(78));
        System.out.printf("| %-8s | %-8s %-12s %-10s %-30s |\n",
                "Sl. no.",
                "Source",
                "Destination",
                "Distance",
                "Path");
        System.out.println("-".repeat(78));

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(j == 0) {
                    System.out.printf("| %-8s | %-8s ",
                            (i + 1 + "."),
                            labels[i]);
                }
                else {
                    System.out.printf("| %-8s | %-8s ",
                            "",
                            "");
                }

                String dist = (distance[i][j] == INF) ? "INF" : String.valueOf(distance[i][j]);
                System.out.printf("%-12s %-10s %-30s |\n",
                        labels[j],
                        dist,
                        getPath(i, j));
            }

            System.out.println("-".repeat(78));
        }

    }
    public void displayDistanceMatrix() {
        ensureComputed();

        System.out.println("Shortest Distance matrix for the graph: ");
        System.out.printf("%-10s| ", "");
        for(int i = 0; i < V; i++) {
            System.out.printf("%-10s", labels[i]);
        }
        System.out.println();
        System.out.println("_".repeat(10 * (V + 1)));

        for(int i = 0; i < V; i++) {
            System.out.printf("%-10s| ", labels[i]);

            for(int j = 0; j < V; j++) {
                String dist = (distance[i][j] == INF) ? "INF" : String.valueOf(distance[i][j]); // or Integer.toString(distance[i][j])
                System.out.printf("%-10s", dist);
            }

            System.out.println();
        }
        System.out.println();
    }
    public void displayParentMatrix() {
        ensureComputed();

        System.out.println("Parent matrix for the graph: ");
        System.out.printf("%-10s| ", "");
        for(int i = 0; i < V; i++) {
            System.out.printf("%-10s", labels[i]);
        }
        System.out.println();
        System.out.println("_".repeat(10 * (V + 1)));

        for(int i = 0; i < V; i++) {
            System.out.printf("%-10s| ", labels[i]);

            for(int j = 0; j < V; j++) {
                if(parent[i][j] == -1 || i == j)
                    System.out.printf("%-10s", "-");
                else
                    System.out.printf("%-10s", labels[parent[i][j]]);
            }

            System.out.println();
        }
        System.out.println();
    }

    // utility methods (public API)
    public String getPath(int source, int destination) {
        if(source < 0 || source >= V || destination < 0 || destination >= V) {
            throw new IllegalArgumentException("Vertex doesn't exist");
        }

        ensureComputed();

        // main logic
        if(distance[source][destination] == INF) {
            return "No path";
        }

        if(destination == source) {
            return labels[source];
        }

        return getPath(source, parent[source][destination]) + " -> " + labels[destination];
    }
    public int getDistance(int source, int destination) {
        if(source < 0 || source >= V || destination < 0 || destination >= V) {
            throw new IllegalArgumentException("Vertex doesn't exist");
        }

        ensureComputed();

        // main logic
        return distance[source][destination];
    }

    public String getPath(String source, String destination) {
        return getPath(getVertexIndex(source), getVertexIndex(destination));
    }
    public int getDistance(String source, String destination) {
        return getDistance(getVertexIndex(source), getVertexIndex(destination));
    }

    // helpers
    private static void validateInputs(int[][] graph, String[] labels) {
        // graph validation
        if(graph == null)
            throw new NullPointerException("Graph cannot be null");
        if(graph.length == 0)
            throw new IllegalArgumentException("Graph cannot be empty");
        for(int i = 0; i < graph.length; i++) {
            if(graph[i].length != graph.length) {
                throw new IllegalArgumentException("Input graph must be a square matrix");
            }

            if(graph[i][i] != 0) {
                throw new IllegalArgumentException("Diagonal Entries must be 0");
            }
        }

        // labels validation
        if(labels == null)
            throw new NullPointerException("Labels cannot be null");
        if(labels.length != graph.length)
            throw new IllegalArgumentException("Labels and graph size must match");

        // no duplicate label verification
        HashSet<String> set = new HashSet<>();

        for(String label : labels) {
            if(label == null)
                throw new NullPointerException("Label cannot be null");

            if(set.add(label) == false) {
                throw new IllegalArgumentException("Duplicate label: " + label);
            }
        }

    }
    private void initialiseParentMatrix() {
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(i == j) {
                    parent[i][j] = i;
                }
                else if(distance[i][j] == INF) {
                    parent[i][j] = -1;
                }
                else {
                    parent[i][j] = i;
                }
            }
        }
    }
    private void detectNegativeCycles() {
        for(int i = 0; i < V; i++) {
            if(distance[i][i] < 0)
                throw new IllegalStateException("Graph contains negative-weight cycle");
        }
    }
    private int getVertexIndex(String vertex) {
        if(vertex == null)
            throw new NullPointerException("Vertex cannot be null");

        for(int i = 0; i < V; i++) {
            if(labels[i].equals(vertex))
                return i;
        }

        throw new IllegalArgumentException("Vertex doesn't exist");
    }
    private void ensureComputed() {
        if(!computed) run();
    }
}
