package com.algorithm;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ryang
 * Date: 2013-07-29
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Graph {

    Map<Vertex, List<Vertex>> vertices;


    public Graph() {
        vertices = new HashMap<Vertex, List<Vertex>>();
    }

    public void addVertex(Vertex vertex) {
        if(!contains(vertex)) {
            vertices.put(vertex, new ArrayList<Vertex>());
        }
    }

    public Boolean contains(Vertex vertex) {
        return vertices.containsKey(vertex);
    }

    public int numberOfVerices() {
        return vertices.size();
    }

    public void addEdge(Edge edge) {
        addVertex(edge.head);
        addVertex(edge.tail);

        vertices.get(edge.tail).add(edge.head);
    }

    public void DFSVist() {

    }
}
