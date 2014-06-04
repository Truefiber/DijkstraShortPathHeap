import java.util.*;

/**
 * Created by Gennadiy on 04.06.2014.
 */
public class Heap extends PriorityQueue<GraphNode> {
    Map<Integer, GraphNode> supportMap = new HashMap<Integer, GraphNode>();

    public Heap() {
        super(new Comparator<GraphNode>() {
            @Override
            public int compare(GraphNode g1, GraphNode g2) {
                if (g1.getGreedyScore() < g2.getGreedyScore()) {
                    return -1;
                } else if (g1.getGreedyScore() > g2.getGreedyScore()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }




    public void addToMap(GraphNode n) {
        supportMap.put(n.getNumberOfNode(), n);


    }

    public GraphNode getNode(int i) {
        return supportMap.get(i);
    }

    public void heapify() {
        for (Map.Entry<Integer, GraphNode> entry : supportMap.entrySet()) {
            this.offer(entry.getValue());
        }
    }



}
