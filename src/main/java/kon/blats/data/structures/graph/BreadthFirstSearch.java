package kon.blats.data.structures.graph;

import java.util.*;

/**
 * Created by kon on 28/8/2018.
 */
public class BreadthFirstSearch {
    private Graph graph;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    public void search(int startPoint, Set<Integer> visited) {
        if (visited.isEmpty()) {
            visited.add(startPoint);
        }
        List<Integer> neighbors = graph.neighborsOf(startPoint);
        if (neighbors != null) {
            Queue<Integer> queue = new LinkedList<>();
            queue.addAll(neighbors);
            while (!queue.isEmpty()) {
                Integer removedNode = queue.remove();
                visited.add(removedNode);
                List<Integer> removedAdjs = graph.neighborsOf(removedNode);
                if (removedAdjs != null) {
                    queue.addAll(removedAdjs);
                }
            }
        }
    }

    public boolean isThereAPath(int source, int dest) {
        Set<Integer> sourceToDest = new HashSet<>();
        search(source, sourceToDest);
        if (sourceToDest.contains(dest)) {
            return true;
        }
        Set<Integer> destToSource = new HashSet<>();
        search(dest, destToSource);
        return destToSource.contains(source);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEgde(0, 1);
        graph.addEgde(0, 2);
        graph.addEgde(1, 3);
        graph.addEgde(2, 3);
        graph.addEgde(4, 2);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);
        System.out.println(breadthFirstSearch.isThereAPath(0, 4));
    }

}
