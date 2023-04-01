package Graph;
import java.util.*;

public class GraphTraversal {
    private LinkedList<Node> graph;

    public GraphTraversal() {
        graph = new LinkedList<Node>();
    }

    public void addPlace(String name) {
        Node newnode = new Node(name.toLowerCase());
        graph.add(newnode);
    }
    
    public int connect(String place1, String place2) {
        Node p1 = getNodeByName(place1.toLowerCase());
        Node p2 = getNodeByName(place2.toLowerCase());

        if(p1 == null || p2 == null) {
            System.out.println("Error: Could'nt find the places!");
            return -1;
        } else { /* nothing todo */ }

        p1.addNeighbor(p2);
        p2.addNeighbor(p1);

        return 0;
    }

    public void displayAdjacencyList() {
        Iterator<Node> node_ite = graph.iterator();

        while(node_ite.hasNext()) {
            Node n = node_ite.next(); //temp = temp.next
            Iterator<Neighbor> neighbor_ite = n.neighbors.iterator();

            System.out.print(n.name +"::>");
            while(neighbor_ite.hasNext()) {
                Neighbor neighbor = neighbor_ite.next();
                System.out.print(neighbor.node.name + "->");
            }
            System.out.println();//print newline
        }
    }

    public void breadthFirstSearch(String s, String g) {
        Queue<Node> q = new LinkedList<Node>();
        Node start_node = getNodeByName(s.toLowerCase());
        if(start_node == null || g == null) {
            System.out.println("Error: unable to find the string place!");
            return;
        } else {/*nothing todo */}

        q.add(start_node);
        
        start_node.isVisited = true;
        
        while(q.size() > 0) 
        {
            Node v = q.remove();

            if(v.name.equals(g.toLowerCase())) {
                reconstruct_path(v);
                System.out.println("Found!");
                unvisit();
                return;
            }

            System.out.print(v.name + "->");
            Iterator<Neighbor> neighbor_ite = v.neighbors.iterator();

            while(neighbor_ite.hasNext()){
                Neighbor neighbor = neighbor_ite.next();
                if( neighbor.node.isVisited != true)
                {
                    q.add(neighbor.node);
                    neighbor.node.parent = v;
                    neighbor.node.isVisited = true;
                }
            }
        }
        unvisit();
        System.out.println();
        System.out.println("No solution!");
    }

    public void depthFirstSearch(String s, String g) {
        Stack<Node> st = new Stack<Node>();
        Node start_node = getNodeByName(s.toLowerCase());
        if(start_node == null || g == null) {
            System.out.println("Error: unable to find the string place!");
            return;
        } else {/*nothing todo */}

        st.push(start_node);
        
        start_node.isVisited = true;
        
        while(st.size() > 0){
            Node v = st.pop();

            if(v.name.equals(g.toLowerCase())){
                reconstruct_path(v);
                System.out.println("Found!");
                unvisit();
                return;
            }
            System.out.print(v.name + "->");
            Iterator<Neighbor> neighbor_ite = v.neighbors.iterator();

            while(neighbor_ite.hasNext()){
                Neighbor neighbor = neighbor_ite.next();
                if( neighbor.node.isVisited != true)
                {
                    st.push(neighbor.node);
                    neighbor.node.parent = v;
                    neighbor.node.isVisited = true;
                }
            }
        }
        unvisit();
        System.out.println();
        System.out.println("No solution!");
    }

    public void depthFirstSearchRecursive(String s, String g) {
        Node start_node = getNodeByName(s.toLowerCase());
        Node goal_node = getNodeByName(g.toLowerCase());

        if (start_node == null || goal_node == null) {
            System.out.println("Error: start node or goal node is null!");
            return;
        }

        start_node.isVisited = true;
        System.out.print(start_node.name + "->");
    
        if (start_node.name.equals(goal_node.name)) {
            System.out.println("Found!");
            return;
        }
    
        Iterator<Neighbor> neighbor_ite = start_node.neighbors.iterator();
        while (neighbor_ite.hasNext()) {
            Node neighbor = neighbor_ite.next().node;
            if (!neighbor.isVisited) {
                if(goal_node.isVisited) return;
                neighbor.parent = start_node;
                depthFirstSearchRecursive(neighbor.name, goal_node.name);
            }
        }
    }

    public Node getNodeByName(String name) {
        Iterator<Node> node_ite = graph.iterator();

        while(node_ite.hasNext()) {
            Node n = node_ite.next();
            if(n.name.equals(name)) return n;
        }

        return null;
    }

    private void unvisit() {
        Iterator<Node> node_ite = graph.iterator();

        while(node_ite.hasNext()) {
            Node n = node_ite.next();
            n.isVisited = false;
        }
    }

    private void reconstruct_path(Node lastnode) {
        System.out.println("Reconstructing path.");
        LinkedList<Node> path = new LinkedList<Node>();
        while(lastnode != null) {
            path.addFirst(lastnode);
            lastnode = lastnode.parent;
        }

        Iterator<Node> node_ite = path.iterator();
        while(node_ite.hasNext()) {
            Node temp = node_ite.next();
            System.out.print(temp.name + "->");
        }
    }
}