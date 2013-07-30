package com.algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: ryang
 * Date: 2013-07-29
 * Time: 10:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Edge {
    public Vertex head;
    public Vertex tail;

    public Edge(Vertex tail, Vertex head) {
        this.head = head;
        this.tail = tail;
    }
}
