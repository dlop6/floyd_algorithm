package com.GraphStructure;

public class Edge {

    Node src;
    Node dest;
    int weight;

    public Edge(Node src, Node dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
}
