package kon.blats.data.structures.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kon on 19/8/2018.
 */
public class Graph {

    private int graphSize;
    private List[] graphArray;

    public Graph(int graphSize) {
        //TODO: validate graph size must be greater than zero
        this.graphSize = graphSize;
        this.graphArray = new ArrayList[graphSize];
    }

    public void addEgde(int currentNode, int nodeToBeAdded) {
        //TODO: validate from and to, if there are in the graph boundaries
        List<Integer> currentNodeNeighbors = graphArray[currentNode];
        if (currentNodeNeighbors == null) {
            graphArray[currentNode] = new ArrayList<>();
            currentNodeNeighbors = graphArray[currentNode];
        }

        currentNodeNeighbors.add(nodeToBeAdded);
    }

    public int size() {
        return graphSize;
    }

    public List neighborsOf(int node) {
        return graphArray[node];
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

        System.out.println();
    }

}
