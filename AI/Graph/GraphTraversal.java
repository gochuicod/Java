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
    
    public int connect(String place1, String place2, double cost) {
        Node p1 = getNodeByName(place1.toLowerCase());
        Node p2 = getNodeByName(place2.toLowerCase());

        if(p1 == null || p2 == null) {
            System.out.println("Error: Could'nt find the places!");
            return -1;
        }

        p1.addNeighbor(p2,cost);
        p2.addNeighbor(p1,cost);

        return 0;
    }

    public void displayAdjacencyList() {
        for(Node node_ite : graph){
            System.out.print(node_ite.name+"::>");
            for(Neighbor neighbor : node_ite.neighbors){
                System.out.print(neighbor.node.name+"->");
            }
            System.out.println();
        }
    }

    public void breadthFirstSearch(String s, String g) {
        Queue<Node> queue = new LinkedList<Node>();
        Node start_node = getNodeByName(s.toLowerCase());
        if(start_node == null) {
            System.out.println("Error: unable to find the string place!");
            return;
        }

        queue.add(start_node);
        
        start_node.isVisited = true;
        
        while(!queue.isEmpty()) {
            Node v = queue.remove();

            if(v.name.equals(g.toLowerCase())) {
                reconstruct_path(v);
                unvisit();
                return;
            }

            System.out.print(v.name + "->");

            for(Neighbor neighbor : v.neighbors){
                if(!neighbor.node.isVisited){
                    queue.add(neighbor.node);
                    neighbor.node.parent = v;
                    neighbor.node.isVisited = true;
                }
            }
        }
        unvisit();
        System.out.println("No solution!");
    }

    public void depthFirstSearch(String s, String g) {
        Stack<Node> stack = new Stack<Node>();
        Node start_node = getNodeByName(s.toLowerCase());
        if(start_node == null) {
            System.out.println("Error: unable to find the string place!");
            return;
        }

        stack.push(start_node);
        
        start_node.isVisited = true;
        
        while(!stack.isEmpty()) {
            Node v = stack.pop();

            if(v.name.equals(g.toLowerCase())) {
                reconstruct_path(v);
                unvisit();
                return;
            }
            System.out.print(v.name + "->");

            for(Neighbor neighbor : v.neighbors) {
                if(!neighbor.node.isVisited){
                    stack.push(neighbor.node);
                    neighbor.node.parent = v;
                    neighbor.node.isVisited = true;
                }
            }
        }
        unvisit();
        System.out.println("No solution!");

    }

    public void depthFirstSearchRecursive(String s, String g) {
        Node start_node = getNodeByName(s.toLowerCase());
        Node goal_node = getNodeByName(g.toLowerCase());
    
        Set<Node> visited = new HashSet<Node>();
        visited.add(start_node);
    
        if(dfsRecursiveHelper(start_node, goal_node, visited) == false)
            System.out.println("No Solution!");
    }
    
    private boolean dfsRecursiveHelper(Node start_node, Node goal_node, Set<Node> visited) {
        System.out.print(start_node.name+"->");
    
        if(start_node == goal_node){
            System.out.println("Found!");
            reconstruct_path(start_node);
            return true;
        }

        for(Neighbor neighbor_ite : start_node.neighbors){
            if(!visited.contains(neighbor_ite.node)){
                visited.add(neighbor_ite.node);
                if(dfsRecursiveHelper(neighbor_ite.node, goal_node, visited))
                    return true;
            }
        }

        return false;
    }

    public void greedyBestFirstSearch(String start_place, String goal_place) {
        Node start_node = getNodeByName(start_place.toLowerCase());
        Node goal_node = getNodeByName(goal_place.toLowerCase());
        
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node node1, Node node2) {
                if (node1.cost < node2.cost) return -1;
                else if (node1.cost > node2.cost) return 1;
                else return 0;
            }
        });
        queue.add(start_node);
        start_node.isVisited = true;

        while(!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.name + "->");

            if (current == goal_node) {
                reconstruct_path(current);
                unvisit();
                return;
            }

            for (Neighbor neighbor : current.neighbors) {
                Node neighborNode = neighbor.node;
                if (!neighborNode.isVisited) {
                    neighborNode.isVisited = true;
                    neighborNode.parent = current;
                    queue.add(neighborNode);
                }
            }
        }

        unvisit();
        System.out.print("No Solution!");
    }

    public void aStarSearch(String start_place, String goal_place) {
        Node start_node = getNodeByName(start_place.toLowerCase());
        Node goal_node = getNodeByName(goal_place.toLowerCase());

        PriorityQueue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return Double.compare(node1.f, node2.f);
            }
        });
        HashSet<Node> visited = new HashSet<>();
    
        start_node.g = 0;
        start_node.f = start_node.h;
    
        frontier.add(start_node);
    
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            System.out.print(current.name + "->");
    
            if (current == goal_node) {
                reconstruct_path(current);
                unvisit();
                return;
            }
    
            visited.add(current);
    
            for (Neighbor neighbor : current.neighbors) {
                Node neighborNode = neighbor.node;
    
                if (!visited.contains(neighborNode)) {
                    double newGCost = current.g + neighbor.cost;
                    double newFCost = newGCost + neighborNode.h;
    
                    if (frontier.contains(neighborNode) && newFCost >= neighborNode.f) {
                        continue;
                    }
    
                    neighborNode.g = newGCost;
                    neighborNode.f = newFCost;
                    neighborNode.parent = current;
    
                    if (!frontier.contains(neighborNode)) {
                        frontier.add(neighborNode);
                    }
                }
            }
        }

        unvisit();
        System.out.println("No Solution!");
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
        System.out.println("Reconstructing path...");
        LinkedList<Node> path = new LinkedList<Node>();
        double totalCost = 0.0;
        while(lastnode != null) {
            if(lastnode.parent != null) {
                for(Neighbor neighbor : lastnode.parent.neighbors) {
                    if(neighbor.node.equals(lastnode)) {
                        totalCost += neighbor.cost;
                    }
                }
            }
            path.addFirst(lastnode);
            lastnode = lastnode.parent;
        }
        
        Iterator<Node> node_ite = path.iterator();
        while(node_ite.hasNext()) {
            Node temp = node_ite.next();
            System.out.print(temp.name + "->");
        }
        System.out.println("Found!");
        System.out.printf("Distance covered: %.2f km\n", totalCost);
    }
}