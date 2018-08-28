package kon.blats.data.structures.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kon on 19/8/2018.
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private Graph graph;

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
        marked = new boolean[graph.size()];
    }

    public void search(int startPoint, Set<Integer> visited) {
        marked[startPoint] = true;
        if (visited == null) {
            visited = new HashSet<>();
        }
        List<Integer> neighbors = graph.neighborsOf(startPoint);
        if (neighbors != null) {
            for (Integer currentNeighbor : neighbors) {
                if (!marked[currentNeighbor]) {
                    marked[currentNeighbor] = true;
                    visited.add(currentNeighbor);
                    System.out.println("now is visited the vertex with ID: " + currentNeighbor);
                    search(currentNeighbor, visited);
                }
            }
        }
    }

    public boolean retrieveVisitedNodes(int source, int dest) {
        List<Integer> neighbors = graph.neighborsOf(source);
        Set<Integer> visited = new HashSet<>();
        for (Integer currentNeighbor : neighbors) {
            if (!marked[currentNeighbor]) {
                marked[currentNeighbor] = true;
                visited.add(currentNeighbor);
                System.out.println("now is visited the vertex with ID: " + currentNeighbor);
                search(currentNeighbor, visited);
            }
        }
        return visited.contains(dest);
    }

    public boolean isThereAnyPath(int source, int dest) {
        return retrieveVisitedNodes(source, dest) || retrieveVisitedNodes(dest, source);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEgde(0, 1);
        graph.addEgde(0, 2);
        graph.addEgde(1, 3);
        graph.addEgde(2, 3);
        graph.addEgde(4, 2);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph);
        System.out.println(depthFirstSearch.isThereAnyPath(0, 4));
        System.out.println();
    }
}