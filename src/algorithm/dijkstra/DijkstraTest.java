package algorithm.dijkstra;

public class DijkstraTest {
    public static void main(String[] args) {

        int[][] graph = {
            {0, 5, 7, 0, 0, 0, 0, 0},
            {0, 0, 0, 4, 3, 6, 0, 0},
            {0, 0, 0, 2, 0, 4, 0, 3},
            {0, 5, 2, 0, 0, 0, 5, 0},
            {0, 4, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 0, 0, 0, 0, 0},
            {15,0, 0, 0, 0, 0, 0, 0},
            {0, 0, 2, 0, 0, 0, 0, 0}
        };

        String[] labels = {"P", "I1", "I2", "I3", "C1", "C2", "C3", "C4"};

        int source = 3;

        DijkstraAlgo dijkstra = new DijkstraAlgo(graph, source, labels);

        dijkstra.run();
        dijkstra.display();
    }
}
