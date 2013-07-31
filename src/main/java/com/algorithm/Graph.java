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

    Map<Integer, Vertex> vertices;
    List<Vertex> secondDfsVertices;
    List<Integer> sccSizes;
    List< List<Vertex>> sccs;
    List<Vertex> scc = null;

    private Boolean useTransposeAdjacencyList = false;
    private Integer time = 0;

    public Graph() {
        vertices = new HashMap<Integer,Vertex>();
        secondDfsVertices = new ArrayList<Vertex>();
        sccSizes = new ArrayList<Integer>();
        sccs = new LinkedList<List<Vertex>>();
    }

    public void addVertex(Vertex vertex) {
        if(!contains(vertex.lbl)) {
            vertices.put(vertex.lbl, vertex);
        }
    }

    public Boolean contains(Integer lbl) {
        return vertices.containsKey(lbl);
    }

    public int numberOfVertices() {
        return vertices.size();
    }

    public void addEdge(Edge edge) {
        addVertex(edge.head);
        addVertex(edge.tail);

        vertices.get(edge.tail.lbl).addVertex(vertices.get(edge.head.lbl));
    }

    public void transpose() {
        Iterator<Integer> keyIterator = vertices.keySet().iterator();
        while(keyIterator.hasNext()) {
            Integer key = keyIterator.next();
            Vertex tail = vertices.get(key);
            Iterator<Vertex> vertexIterator = tail.getAdjacentList().iterator();
            while(vertexIterator.hasNext()) {
                Vertex head = vertexIterator.next();
                vertices.get(head.lbl).addTransposedVertex(vertices.get(tail.lbl));
            }
        }
    }

    public void firstDfsLoop() {
        for(Vertex vertex : vertices.values()) {
            vertex.color = 0;
            vertex.d = 0;
            vertex.f = 0;
        }
        useTransposeAdjacencyList = true;
        time = 0;


        ArrayList<Vertex> list = new ArrayList<Vertex>(vertices.values());
        ListIterator<Vertex> listIterator = list.listIterator(vertices.size());

        while(listIterator.hasPrevious()) {
            Vertex u = listIterator.previous();
            if(u.color == 0) {
                dfs(u);
            }
        }

/*
        for(Vertex v : vertices.values())
        {
            if(v.color == 0) {
                dfs(v);
            }
        }
*/
    }

    public void secondDfsLoop() {
        for(Vertex vertex : vertices.values()) {
            vertex.color = 0;
        }
        time = 0;
        useTransposeAdjacencyList = false;

        ListIterator<Vertex> listIterator = secondDfsVertices.listIterator(secondDfsVertices.size());
        while(listIterator.hasPrevious()) {
            Vertex u = listIterator.previous();
            if (u.color == 0) {
               scc = new ArrayList<Vertex>();
               dfs(u);
               sccs.add(scc);
            }
        }
    }

    public void dfs(Vertex v) {

        v.color = 1;
        v.d = ++time;

        List<Vertex> list = useTransposeAdjacencyList ? v.getTransposedAdjacentList() : v.getAdjacentList();

        for(Vertex u : list) {
            if(u.color == 0) {
                dfs(u);
            }
        }

        v.color = 2;
        v.f = ++time;
        if(useTransposeAdjacencyList) {
            this.secondDfsVertices.add(v);
        } else {
            scc.add(v);
        }
    }
}
