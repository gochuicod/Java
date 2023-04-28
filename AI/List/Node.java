import java.util.LinkedList;

public class Node {
    public String name;
    public boolean isVisited;
    public Node parent;
    public LinkedList<Neighbor> neighbors;
    
    public Node(String n) {
        this.name = n;
        this.isVisited = false;
        neighbors = new LinkedList<Neighbor>();
    }

    public void addNeighbor(Node n) {
        Neighbor neighbor = new Neighbor(n);
        neighbors.add(neighbor);
    }
}