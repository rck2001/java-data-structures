package algorithm.floydwarshall;

import static algorithm.Constants.INF;

public class FloydWarshallTest {
    public static void main(String[] args) {

        int[][] graph = {
                {0,   5,   7,   INF, INF, INF, INF, INF},
                {INF, 0,   INF, 4,   3,   6,   INF, INF},
                {INF, INF, 0,   2,   INF, 4,   INF, 3},
                {INF, 5,   2,   0,   INF, INF, 5,   INF},
                {INF, 4,   INF, INF, 0,   INF, INF, INF},
                {INF, INF, 3,   INF, INF, 0,   INF, INF},
                {15,  INF, INF, INF, INF, INF, 0,   INF},
                {INF, INF, 2,   INF, INF, INF, INF, 0}
        };

        String[] labels = {"P", "I1", "I2", "I3", "C1", "C2", "C3", "C4"};

        FloydWarshallAlgo algo = new FloydWarshallAlgo(graph, labels);

        algo.run(); // optional, since this is a lazy implementation
        algo.displayAdjacencyMatrix();
        // algo.displayDistanceMatrix();
        // algo.displayParentMatrix();
        // System.out.println(algo.getPath("P", "C3"));
        // System.out.println(algo.getPath(0, 6));
        // System.out.println(algo.getDistance("P", "C3"));
        // System.out.println(algo.getDistance(0, 6));
        algo.display();
    }
}
