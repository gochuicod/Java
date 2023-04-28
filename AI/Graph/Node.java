import java.util.LinkedList;

public class Node {
    public double cost;
    public double f,h,g;
    public String name;
    public boolean isVisited;
    public Node parent;
    public LinkedList<Neighbor> neighbors;
    
    public Node(String n) {
        this.name = n;
        this.isVisited = false;
        neighbors = new LinkedList<Neighbor>();
    }

    public Node(String n, double cost) {
        this.name = n;
        this.isVisited = false;
        this.cost = cost;
        neighbors = new LinkedList<Neighbor>();
    }

    public Node(String n, double f, double h, double g) {
        this.name = n;
        this.isVisited = false;
        neighbors = new LinkedList<Neighbor>();
        this.f = f;
        this.h = h;
        this.g = g;
    }

    public void addNeighbor(Node n, double cost) {
        Neighbor neighbor = new Neighbor(n,cost);
        neighbors.add(neighbor);
    }
}