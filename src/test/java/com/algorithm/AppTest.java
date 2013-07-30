package com.algorithm;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testAddVertices()
    {
        Graph g = new Graph();
        g.addVertex(new Vertex(1));
        g.addVertex(new Vertex(2));

        assertEquals(2, g.numberOfVerices());
    }

    public void testContains()
    {
        Graph g = new Graph();
        Vertex v = new Vertex(1);
        g.addVertex(v);
        Vertex v2 = new Vertex(1);
        assertTrue(g.contains(v2));
    }

    /**
     *
     1 4
     2 8
     3 6
     4 7
     5 2
     6 9
     7 1
     8 5
     8 6
     9 7
     9 3
     */

    public void testClassSccSample()
    {
        Graph g = new Graph();
        g.addEdge( new Edge(new Vertex(1), new Vertex(4)));
        g.addEdge( new Edge(new Vertex(2), new Vertex(8)));
        g.addEdge( new Edge(new Vertex(3), new Vertex(6)));
        g.addEdge( new Edge(new Vertex(4), new Vertex(7)));
        g.addEdge( new Edge(new Vertex(5), new Vertex(2)));
        g.addEdge( new Edge(new Vertex(6), new Vertex(9)));
        g.addEdge( new Edge(new Vertex(7), new Vertex(1)));
        g.addEdge( new Edge(new Vertex(8), new Vertex(5)));
        g.addEdge( new Edge(new Vertex(8), new Vertex(6)));
        g.addEdge( new Edge(new Vertex(9), new Vertex(7)));
        g.addEdge( new Edge(new Vertex(9), new Vertex(3)));



        assertEquals(9, g.numberOfVerices());
    }

    public void testTranspose()
    {
        Graph g = new Graph();
        g.addEdge(new Edge(new Vertex(1), new Vertex(2)));
        g.addEdge(new Edge(new Vertex(1), new Vertex(3)));
        g.addEdge(new Edge(new Vertex(2), new Vertex(3)));

    }
}
