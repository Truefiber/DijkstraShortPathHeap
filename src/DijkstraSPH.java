import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Gennadiy on 04.06.2014.
 */
public class DijkstraSPH {
    Map<Integer, GraphNode> joinedMap = new HashMap<Integer, GraphNode>();



    Heap heap = new Heap();

    public DijkstraSPH(String sourceFile) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            String[] rowSplit;
            String[] tuples;
            String nextLine;

            while ((nextLine = reader.readLine()) != null) {
                rowSplit = nextLine.split("\t");
                int nodeNumber = Integer.parseInt(rowSplit[0]);
                GraphNode node = new GraphNode(nodeNumber);
                for (int i = 1; i < rowSplit.length; i++) {
                    tuples = rowSplit[i].split(",");
                    int vertex = Integer.parseInt(tuples[0]);
                    int length = Integer.parseInt(tuples[1]);
                    node.addEdge(vertex, length);
                }

                if (nodeNumber == 1) {
                    node.setGreedyScore(0);
                    node.setShortestPath(0);
                } else {
                    node.setShortestPath(100000);
                    node.setGreedyScore(100000);
                }

                heap.addToMap(node);

            }

            heap.heapify();




        } catch (IOException e) {
            System.out.println("Wrong filename");
        }




    }

    public void search() {



        while (!(heap.isEmpty())) {
            GraphNode nextNode = heap.poll();
            nextNode.setShortestPath(nextNode.getGreedyScore());
            Map<Integer, Integer> adjacencyMap = nextNode.getAdjacency();
            Set<Integer> adjacentVertices = adjacencyMap.keySet();
            for (Integer i : adjacentVertices ) {
                GraphNode adjacentNode = heap.getNode(i);
                if (!(joinedMap.containsValue(adjacentNode)))                          //Skip if adjacent vertex already in joinedMap
                {
                    int edgeLength = adjacencyMap.get(i);
                    int currentShortestPath = nextNode.getShortestPath();
                    int adjacentGreedyScore = adjacentNode.getGreedyScore();

                    if ((edgeLength + currentShortestPath) < adjacentGreedyScore) {
                        heap.remove(adjacentNode);
                        adjacentNode.setGreedyScore(edgeLength + currentShortestPath);
                        heap.add(adjacentNode);
                    }

                }
            }

            joinedMap.put(nextNode.getNumberOfNode(), nextNode);
        }

    }

    public void output(int...nodes) {
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("Node " + nodes[i] + ", SP is " + joinedMap.get(nodes[i]).getShortestPath());
        }
    }

}
