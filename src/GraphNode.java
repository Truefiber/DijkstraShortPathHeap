import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gennadiy on 04.06.2014.
 */
public class GraphNode {
    private Map<Integer, Integer> adjacency = new HashMap<Integer, Integer>();                  //key - number of node, value - distance
    private int shortestPath;
    private int greedyScore;                                                                    //store current score of this node
    private int numberOfNode;

    public GraphNode(int num) {
        numberOfNode = num;
    }

    public int getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(int shortestPath) {
        this.shortestPath = shortestPath;
    }

    public int getGreedyScore() {
        return greedyScore;
    }

    public void setGreedyScore(int greedyScore) {
        this.greedyScore = greedyScore;
    }



    public void addEdge(int vertex, int length) {
        adjacency.put(vertex, length);
    }

    public Map<Integer, Integer> getAdjacency () {
        return adjacency;
    }

    public int getNumberOfNode() {
        return numberOfNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphNode graphNode = (GraphNode) o;

        if (numberOfNode != graphNode.numberOfNode) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return numberOfNode;
    }
}
