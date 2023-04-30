//------------------------------------------------------------------------
// 2023 IT-ELAI Introduction to AI
// Topic : Informed Search Algorithms
//------------------------------------------------------------------------
//
// File Name    :   Neighbor.java
// Class Name:  :   Edge 
// Stereotype   :   
//
// Edge class:
//  Methods:
//  Utility:w
//  Attributes:
//      +node(Node)          - Node connected to the parent

//------------------------------------------------------------------------
// Notes:
//   Comment character code - UTF-8.
//------------------------------------------------------------------------
//  Change Activities:
// tag  Reason   Ver  Rev Date       Author      Description.
//------------------------------------------------------------------------
// $000 -------  0.1  001 2023-03-25 cabrillosa  First Release.
// $001 -------  0.5  002 2023-04-29 cabrillosa  Added Greedy BFS and A*

public class Neighbor {
    //---------------------------------------------------------------------
    // Attribute Definition.
    //---------------------------------------------------------------------
    Node node;
    double distance;

    //---------------------------------------------------------------------
    // Getters and Setters.
    //---------------------------------------------------------------------
    public Node getNode() {
        return node;
    }

    public void setNode(Node n) {
        this.node = n;
    }
    
    public double getDistance() {
        return distance;
    }

    public void setDistance(double d) {
        this.distance = d;
    }
    
    //------------------------------------------------------------------------
    //  Method Name : Neighbor
    //  Description : Constructor. Initialize the need attributes.
    //  Arguments   : Node n
    //                double d
    //  Return      : void.
    //------------------------------------------------------------------------
    public Neighbor(Node n, double d) {
        this.node = n;
        this.distance = d;
    }
}