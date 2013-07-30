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
    public Integer finish;

    private List<Vertex> transposedAdj;


    public Vertex(int lbl) {
        this.lbl = lbl;
        transposedAdj = new ArrayList<Vertex>();
        finish = 0;
    }

    public void AddTransposedVertex(Vertex vertex) {
        transposedAdj.add(vertex);
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
        return "lbl:" + lbl + "f:" + finish;
    }
}
