package com.GraphStructure;

import java.util.LinkedList;
import java.util.List;

public class Node {

    private int id;
    private String name;
    private List<Edge> edges = new LinkedList<>();

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addEdge(Node dest, int weight) {
        Edge edge = new Edge(this, dest, weight);
        edges.add(edge);
        
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
