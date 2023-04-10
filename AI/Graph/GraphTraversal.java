//------------------------------------------------------------------------
// 2023 IT-ELAI Introduction to AI
// Topic : Informed Search Algorithms
//------------------------------------------------------------------------
//
// File Name    :   GraphTraversal.java
// Class Name:  :   GraphTraversal 
// Stereotype   :   
//
// GraphTraversal class:
//  Methods:
//      +addPlace                        - Add a place in string format.
//      +connect                         - Connect one vertex to another vertex.
//      +displayAdjacencyList            - Display adjacency list.
//      +breadthFirstSearch              - Traverse the map using BFS
//      +depththFirstSearch              - Traverse the map using DFS
//  Utility:
//      -getNodeByName                   - search the map using the string name
//      -reconstruct_path                - reconstruct the solution/path
//  Attributes:
//      -graph(LinkedList<Node>)         - Number of places/vertices in the map.

//------------------------------------------------------------------------
// Notes:
//   Comment character code - UTF-8.
//------------------------------------------------------------------------
//  Change Activities:
// tag  Reason   Ver  Rev Date       Author      Description.
//------------------------------------------------------------------------
// $000 -------  0.1  001 2023-03-25 cabrillosa  First Release.
import java.util.*;

public class GraphTraversal {
    //---------------------------------------------------------------------
    // Attribute Definition.
    //---------------------------------------------------------------------
    private LinkedList<Node> graph;

    //------------------------------------------------------------------------
    //  Method Name : GraphTraversal
    //  Description : Constructor. Initialize the need attributes.
    //  Arguments   : void.
    //  Return      : void.
    //------------------------------------------------------------------------
    public GraphTraversal() {
        graph = new LinkedList<Node>();
    }

    //------------------------------------------------------------------------
    //  Method Name : addPlace
    //  Description : Adds a place in string format.
    //  Arguments   : String place
    //  Return      : void
    //------------------------------------------------------------------------
    public void addPlace(String name) {
        Node newnode = new Node(name.toLowerCase());
        graph.add(newnode);
    }
    
    //------------------------------------------------------------------------
    //  Method Name : connect
    //  Description : Connect one vertex to another vertex.
    //  Arguments   : string v1
    //                string v2
    //                int dist
    //  Return      : 0 (OK)
    //               -1 (NG - place is not in the list)
    //------------------------------------------------------------------------

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

    //------------------------------------------------------------------------
    //  Method Name : displayAdjacencyList
    //  Description : Display adjacency list.
    //  Arguments   : None.
    //  Return      : None.
    //------------------------------------------------------------------------
    public void displayAdjacencyList() {
        for(Node node_ite : graph){
            System.out.print(node_ite.name+"::>");
            for(Neighbor neighbor : node_ite.neighbors){
                System.out.print(neighbor.node.name+"->");
            }
            System.out.println();
        }
    }

    //------------------------------------------------------------------------
    //  Method Name : breadthFirstSearch
    //  Description : Traverse the map using BFS
    //  Arguments   : String s
    //                String g
    //  Return      : Void
    //------------------------------------------------------------------------
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
                System.out.println("Found!");
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

    //------------------------------------------------------------------------
    //  Method Name : depththFirstSearch
    //  Description : Traverse the map using BFS
    //  Arguments   : String s
    //                String g
    //  Return      : Void
    //------------------------------------------------------------------------
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
                System.out.println("Found!");
                unvisit();
                return;
            }
            System.out.print(v.name + "->");

            for(Neighbor neighbor : v.neighbors){
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
    
        if(dfsRecursiveHelper(start_node, goal_node, visited) == false) System.out.println("No Solution!");
    }
    
    private boolean dfsRecursiveHelper(Node start_node, Node goal_node, Set<Node> visited) {
        System.out.print(start_node.name+"->");
    
        if(start_node == goal_node){
            System.out.println("Found!");
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

    //UTILITY FUNCTIONS

    //------------------------------------------------------------------------
    //  Method Name : getNodeByName
    //  Description : get the node by its name
    //  Arguments   : String name
    //  Return      : Node, if name is found
    //                null, if name is not found
    //------------------------------------------------------------------------
    public Node getNodeByName(String name) {
        

        Iterator<Node> node_ite = graph.iterator();

        while(node_ite.hasNext()) { // while(temp != null)
            Node n = node_ite.next(); // temp = temp.next
            
            //found
            if(n.name.equals(name)) {
                return n;
            }
        }

        return null;
    }

    //------------------------------------------------------------------------
    //  Method Name : unvisit
    //  Description : reconstruct the path from goal to start
    //  Arguments   : void
    //  Return      : Node, if name is found
    //                null, if name is not found
    //------------------------------------------------------------------------
    private void unvisit(){
        Iterator<Node> node_ite = graph.iterator();

        while(node_ite.hasNext()) {
            Node n = node_ite.next();
            n.isVisited = false;
        }
    }

    //------------------------------------------------------------------------
    //  Method Name : reconstruct_path
    //  Description : reconstruct the path from goal to start
    //  Arguments   : String lastnode
    //  Return      : Node, if name is found
    //                null, if name is not found
    //------------------------------------------------------------------------
    private void reconstruct_path(Node lastnode)
    {
        System.out.println("Reconstructing path.");
        LinkedList<Node> path = new LinkedList<Node>();
        while(lastnode != null) {
            path.addFirst(lastnode);
            lastnode = lastnode.parent; // move backward
        }
        
        Iterator<Node> node_ite = path.iterator();
        while(node_ite.hasNext()) {
            Node temp = node_ite.next();
            System.out.print(temp.name + "->");
        }
    }
}