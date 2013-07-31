package com.algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: ryang
 * Date: 2013-07-29
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    public Integer lbl;
    public Integer d;
    public Integer f;
    public Integer leader;
    public Integer color; // 0 - white , 1 - grey , 2 - black

    private List<Vertex> transposedAdj;
    private List<Vertex> adj;


    public Vertex(int lbl) {
        this.lbl = lbl;
        transposedAdj = new ArrayList<Vertex>();
        adj = new ArrayList<Vertex>();
        d = 0;
        f = 0;
        leader = 0;
        color = 0;
    }

    public void addTransposedVertex(Vertex vertex) {
        transposedAdj.add(vertex);
    }

    public void addVertex(Vertex vertex) {
        adj.add(vertex);
    }

    public List<Vertex> getAdjacentList()  {
        return adj;
    }

    public List<Vertex> getTransposedAdjacentList() {
       return transposedAdj;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        return this.lbl.equals(((Vertex) o).lbl);
    }

    @Override
    public int hashCode() {
        return this.lbl.hashCode();
    }

    @Override
    public String toString() {
        return "lbl:" + lbl + "d:" + d  + "f:" + this.f;
    }
}
