//------------------------------------------------------------------------
// 2023 IT-ELAI Introduction to AI
// Topic : Informed Search Algorithms
//------------------------------------------------------------------------
//
// File Name    :   Node.java
// Class Name:  :   Node 
// Stereotype   :   
//
// Node class:
//  Methods:
//      +AddNeighbors                   - adds a neighbor to the current node
//  Utility:
//  Attributes:
//      +name(string)                   - text name of a place
//      +parent(Node)                   - pointer to the parent
//      +isVisited(bool)                - visited status
//      +f                              - f(n) value
//      +g                              - g(n) value
//      +h                              - h(n) value
//      +neighbors(Linkedlist<Neighbor> - list of node's edges/neighbors

//------------------------------------------------------------------------
// Notes:
//   Comment character code - UTF-8.
//------------------------------------------------------------------------
//  Change Activities:
// tag  Reason   Ver  Rev Date       Author      Description.
//------------------------------------------------------------------------
// $000 -------  0.1  001 2023-03-25 cabrillosa  First Release.
// $001 -------  0.5  002 2023-04-29 cabrillosa  Added Greedy BFS and A*

import java.util.Hashtable;
import java.util.LinkedList;

public class Node implements Comparable<Node>{ //<-- implement Comparable interface for PQ
    //---------------------------------------------------------------------
    // Attribute Definition.
    //---------------------------------------------------------------------
    public LinkedList<Neighbor> neighbors;
    public boolean isVisited;
    private Hashtable<String, Double> coordinates;
    private String name;
    private Node parent;
    private double f,h,g;

    //---------------------------------------------------------------------
    // Getters and Setters.
    //---------------------------------------------------------------------
    public double getLatitude() {
        return this.coordinates.get("lat");
    }

    public double getLongitude() {
        return this.coordinates.get("lon");
    }

    public void setCoordinates(double lat, double lon) {
        this.coordinates = new Hashtable<String, Double>();
        this.coordinates.put("lat", lat);
        this.coordinates.put("lon", lon);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node newParent) {
        this.parent = newParent;
    }

    public double getFScore() {
        return this.f;
    }

    public void setFScore(double newFScore) {
        this.f = newFScore;
    }

    public double getHScore() {
        return this.h;
    }

    public void setHScore(double newHScore) {
        this.h = newHScore;
    }

    public double getGScore() {
        return this.g;
    }

    public void setGScore(double newGScore) {
        this.g = newGScore;
    }

    //------------------------------------------------------------------------
    //  Method Name : Node
    //  Description : Constructor. Initialize the need attributes.
    //  Arguments   : Node n
    //                double d
    //  Return      : void.
    //------------------------------------------------------------------------
    public Node(String n) {
        this.name = n;
        this.isVisited = false;
        neighbors = new LinkedList<Neighbor>();
    }

    //------------------------------------------------------------------------
    //  Method Name : AddNeighbor
    //  Description : adds a neighbor to the current node
    //  Arguments   : Node n
    //                double d
    //  Return      : void
    //------------------------------------------------------------------------
    public void addNeighbor(Node n, double d) {
        Neighbor neighbor = new Neighbor(n, d);
        neighbors.add(neighbor);
    }
    
    //------------------------------------------------------------------------
    //  Method Name : compareTo
    //  Description : Overrides Comparable.
    //  Arguments   : Node n
    //  Return      : int
    //------------------------------------------------------------------------
    @Override
    public int compareTo(Node n) {
        return (int)(this.h - n.h);
    }
}