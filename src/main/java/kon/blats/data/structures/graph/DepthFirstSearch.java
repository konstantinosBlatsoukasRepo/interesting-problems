package kon.blats.data.structures.graph;

import java.util.List;

/**
 * Created by kon on 19/8/2018.
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private Graph graph;

    public DepthFirstSearch(Graph graph, int startPoint) {
        this.graph = graph;
        marked = new boolean[graph.size()];
        marked[startPoint] = true;
    }

    public void search(int startPoint) {
        //TODO: check if start point is valid
        List<Integer> neighbors = graph.neighborsOf(startPoint);
        for (Integer currentNeighbor : neighbors) {
            if (!marked[currentNeighbor]) {
                marked[currentNeighbor] = true;
                System.out.println("now is visited the vertex with ID: " + currentNeighbor);
                search(currentNeighbor);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEgde(0, 1);
        graph.addEgde(0, 2);

        graph.addEgde(1, 2);
        graph.addEgde(1, 3);
        graph.addEgde(1, 4);

        graph.addEgde(2, 0);
        graph.addEgde(2, 1);
        graph.addEgde(2, 3);

        graph.addEgde(3, 4);
        graph.addEgde(3, 1);
        graph.addEgde(3, 2);

        graph.addEgde(4, 1);
        graph.addEgde(4, 3);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        depthFirstSearch.search(0);
    }

}
