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
//      +greedyBestFirstSearch           - Traverse the map using greedy best first search alg
//      +aStar                           - Traverse the map using A-star search alg
//  Utility:
//      -getNodeByName                   - search the map using the string name
//      -reconstruct_path                - reconstruct the solution/path
//      -getLowestFScore                 - get the lowest fscore in a given list of nodes
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
// $001 -------  0.5  002 2023-04-29 cabrillosa  Added Greedy BFS and A*

import java.util.*;
import java.lang.Math;

class GraphTraversal {
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
    //  Description : Adds a place in string and float format.
    //  Arguments   : String place
    //                float lat
    //                float lon
    //  Return      : void
    //------------------------------------------------------------------------
    public void addPlace(String name, float lat, float lon) {
        Node newnode = new Node(name.toLowerCase());

        newnode.setCoordinates(lat,lon);

        graph.add(newnode);
    }
    
    //------------------------------------------------------------------------
    //  Method Name : connect
    //  Description : Connect one vertex to another vertex.
    //  Arguments   : string v1
    //                string v2
    //                float h
    //  Return      : 0 (OK)
    //               -1 (NG - place is not in the list)
    //------------------------------------------------------------------------
    public int connect(String place1, String place2) {
        Node p1 = getNodeByName(place1.toLowerCase());
        Node p2 = getNodeByName(place2.toLowerCase());

        if(p1 == null || p2 == null) {
            System.out.println("Error: Could'nt find the places!");
            return -1;
        }
        
        float h = calculateEuclidianDistance(
            p1.getLatitude(),
            p1.getLongitude(),
            p2.getLatitude(),
            p2.getLongitude()
        );

        p1.addNeighbor(p2, h);
        p2.addNeighbor(p1, h);

        return 0;
    }

    //------------------------------------------------------------------------
    //  Method Name : displayAdjacencyList
    //  Description : Display adjacency list.
    //  Arguments   : None.
    //  Return      : None.
    //------------------------------------------------------------------------
    public void displayAdjacencyList() {
        for(Node i : graph) {
            System.out.print(i.getName() + "::> ");
            for(Neighbor neighbor : i.neighbors) {
                System.out.print(neighbor.node.getName() + "->");
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
        Queue<Node> q = new LinkedList<Node>();
        Node start_node = getNodeByName(s.toLowerCase());
        if(start_node == null) {
            System.out.println("Error: unable to find the string place!");
            return;
        }

        q.add(start_node);
        
        start_node.isVisited = true;
        
        while(q.size() > 0) {
            Node current = q.remove();

            if(current.getName().equals(g.toLowerCase())) {
                reconstruct_path(current);
                unvisit();
                return;
            }

            System.out.print(current.getName() + "->");
            
            for(Neighbor neighbor : current.neighbors) {
                Node neighborNode = neighbor.node;
                if(neighborNode.isVisited != true) {
                    q.add(neighborNode);
                    neighborNode.setParent(current);
                    neighborNode.isVisited = true;
                }
            }
        }
        unvisit();
        System.out.println();
        System.out.println("No solution!");
    }

    //------------------------------------------------------------------------
    //  Method Name : depthFirstSearch
    //  Description : Traverse the map using DFS
    //  Arguments   : String s
    //                String g
    //  Return      : Void
    //------------------------------------------------------------------------
    public void depthFirstSearch(String s, String g) {
        Stack<Node> st = new Stack<Node>();
        Node start_node = getNodeByName(s.toLowerCase());
        if(start_node.equals(null)) {
            System.out.println("Error: unable to find the string place!");
            return;
        }

        st.push(start_node);
        
        start_node.isVisited = true;
        
        while(st.size() > 0) {
            Node current = st.pop();
            System.out.print(current.getName() + "->");

            if(current.getName().equals(g.toLowerCase())) {
                reconstruct_path(current);
                unvisit();
                return;
            }

            for(Neighbor neighbor : current.neighbors) {
                Node neighborNode = neighbor.getNode();
                if(neighborNode.isVisited != true) {
                    st.push(neighborNode);
                    neighborNode.setParent(current);
                    neighborNode.isVisited = true;
                }
            }
        }

        unvisit();
        System.out.println();
        System.out.println("No solution!");
    }

    //------------------------------------------------------------------------
    //  Method Name : depthFirstSearchRecursive
    //  Description : Traverse the map using dfs recursive
    //  Arguments   : String s
    //                String g
    //  Return      : Void
    //------------------------------------------------------------------------
    public void depthFirstSearchRecursive(String s, String g) {
        Node start_node = getNodeByName(s.toLowerCase());
        start_node.isVisited = true;
    
        System.out.print(start_node.getName() + "->");
        
        if(start_node.getName().equals(g)) {
            System.out.println("Found!");
            unvisit();
            return;
        }

        for(Neighbor neighbor : start_node.neighbors) {
            Node neighborNode = neighbor.getNode();
            if(!neighborNode.isVisited) {
                neighborNode.setParent(start_node);
                depthFirstSearchRecursive(neighborNode.getName(), g);
                return;
            }
        }

        unvisit();
        System.out.println();
        System.out.println("No solution!");
        return;
    }

    //------------------------------------------------------------------------
    //  Method Name : greedyBestFirstSearch
    //  Description : Traverse the map using GBFS
    //  Arguments   : String s
    //                String g
    //  Return      : Void
    //------------------------------------------------------------------------
    public void greedyBestFirstSearch(String start_place, String goal_place) {
        Node start = getNodeByName(start_place);
        Node goal = getNodeByName(goal_place);
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        if (start.equals(null)) {
            System.out.println("Enter a valid start node!");
        }

        start.setHScore(
            calculateEuclidianDistance(
                start.getLatitude(),
                start.getLongitude(),
                goal.getLatitude(),
                goal.getLongitude()
            )
        );
        start.setFScore(start.getHScore());
        start.isVisited = true;
        pq.add(start);

        while(pq.size() > 0) {
            Node current = pq.poll();
            current.isVisited = true;
            current.setHScore(
                calculateEuclidianDistance(
                    current.getLatitude(),
                    current.getLongitude(),
                    goal.getLatitude(),
                    goal.getLongitude()
                )
            );
            System.out.print(current.getName() + "->");

            if(current.getName().equals(goal_place.toLowerCase())) {
                reconstruct_path(current);
                unvisit();
                return;
            }

            for(Neighbor neighbor : current.neighbors){
                Node neighborNode = neighbor.node;
                if(neighborNode.isVisited != true) {
                    neighborNode.setParent(current);
                    neighborNode.setFScore(neighborNode.getHScore());
                    pq.add(neighborNode);
                }
            }
        }
        
        unvisit();
        System.out.println("No solution!");
    }

    //------------------------------------------------------------------------
    //  Method Name : aStar
    //  Description : Traverse the map using aStar
    //  Arguments   : String s
    //                String g
    //  Return      : Void
    //------------------------------------------------------------------------
    public void aStar(String start_place, String goal_place) {
        Node start = getNodeByName(start_place);
        Node goal = getNodeByName(goal_place);

        LinkedList<Node> openlist = new LinkedList<Node>();
        LinkedList<Node> closedlist = new LinkedList<Node>();

        start.setHScore(
            calculateEuclidianDistance(
                start.getLatitude(),
                start.getLongitude(),
                goal.getLatitude(),
                goal.getLongitude()
            )
        );
        start.setFScore(start.getGScore() + start.getHScore());
        openlist.add(start);

        while(openlist.size() > 0) {
            Node current = getLowestFScore(openlist);
            start.setHScore(
                calculateEuclidianDistance(
                    current.getLatitude(),
                    current.getLongitude(),
                    goal.getLatitude(),
                    goal.getLongitude()
                )
            );
            System.out.print(current.getName() + "->");

            if(current.getName().equals(goal_place.toLowerCase())) {
                //solution found
                reconstruct_path(current);
                System.out.println("Final fscore = " + current.getFScore());
                return;
            }

            Iterator<Neighbor> neighbor_ite = current.neighbors.iterator();

            while(neighbor_ite.hasNext()) {
                Neighbor m = neighbor_ite.next();
                float gtotal = current.getGScore() + m.distance;

                if(!closedlist.contains(m.node) && !openlist.contains(m.node)) {
                    m.node.setParent(current);
                    m.node.setGScore(gtotal);
                    m.node.setFScore(m.node.getGScore() + m.node.getHScore());
                    openlist.add(m.node);
                } else {
                    if(gtotal < m.node.getGScore()) {
                        m.node.setParent(current);
                        m.node.setGScore(gtotal);
                        m.node.setFScore(m.node.getGScore() + m.node.getHScore());

                        if (closedlist.contains(m.node)){
                            openlist.add(m.node);
                        }
                    }
                }
            }
            openlist.remove(current);
            closedlist.add(current);
        }
        System.out.println("No path to goal!");
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
            if(n.getName().equals(name)) {
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
    private void unvisit() {
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
    private void reconstruct_path(Node lastnode) {
        System.out.println("Reconstructing path...");
        LinkedList<Node> path = new LinkedList<Node>();
        while(lastnode != null) {
            path.addFirst(lastnode);
            lastnode = lastnode.getParent(); // move backward
        }
        
        Iterator<Node> node_ite = path.iterator();
        while(node_ite.hasNext()) {
            Node temp = node_ite.next();
            System.out.print(temp.getName() + "->");
        }

        System.out.print("Found!");
        System.out.println();
    }

    //------------------------------------------------------------------------
    //  Method Name : getLowestFScore
    //  Description : gets the lowest FScore in the open list
    //  Arguments   : String lastnode
    //  Return      : Node, if it has chosen the lowest fscore
    //------------------------------------------------------------------------
    public Node getLowestFScore(LinkedList<Node> list) {
        Node lowest = null;
        
        for(Node node : list) {
            if(lowest == null || node.getFScore() < lowest.getFScore())
                lowest = node;
        }

        return lowest;
    }

    //------------------------------------------------------------------------
    //  Method Name : calculateEuclidianDistance
    //  Description : returns the distance between two points (lat,lon) in km
    //  Arguments   : String lat1
    //                String lon1
    //                String lat2
    //                String lon2
    //  Return      : float, after calculating the distance
    //------------------------------------------------------------------------
    public float calculateEuclidianDistance(float lat1, float lon1, float lat2, float lon2) {
        float R = (float) 6371;
        float dLat = toRad(lat2-lat1);
        float dLon = toRad(lon2-lon1);

        float a = (float) (Math.sin(dLat/2) * Math.sin(dLat/2) +
        Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(toRad(lat1)) * Math.cos(toRad(lat2))); 
        float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a))); 
        float d = R * c;

        return d;
    }
    
    //------------------------------------------------------------------------
    //  Method Name : calculateEuclidianDistance
    //  Description : Converts a given value to radian
    //  Arguments   : float value
    //  Return      : float, after radian conversion
    //------------------------------------------------------------------------
    public float toRad(float value) {
        return (float) (value * Math.PI / 180.0);
    }
}