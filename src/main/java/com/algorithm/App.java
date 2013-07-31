package com.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        if(args.length < 1) {
            System.out.println( "pleaes provide the file contains the edges." );
            return;
        }

        Long start = System.currentTimeMillis();

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Graph g = new Graph();

        try {
                String line = reader.readLine();

                while (null != line) {
                    String[] splits = line.split(" ");

                    Integer tail = Integer.parseInt(splits[0]);
                    Integer head = Integer.parseInt(splits[1]);
                    line = reader.readLine();

                    g.addEdge( new Edge( new Vertex(tail), new Vertex(head)));
            }
        }
        finally {
            reader.close();
        }

        Long afterLoadGraph = System.currentTimeMillis();

        System.out.println(g.numberOfVertices() + " " + ((afterLoadGraph-start) / 1000.0) + " seconds");

        g.transpose();

        Long afterTranspose = System.currentTimeMillis();
        System.out.println("Transposition took " + ((afterTranspose - afterLoadGraph) / 1000.0) + " seconds");

        g.firstDfsLoop();

        Long afterFirstLoop = System.currentTimeMillis();
        System.out.println("First dfs loop took" + ((afterFirstLoop - afterTranspose ) / 1000.0) + " seconds");

        g.secondDfsLoop();
        Long afterSecondLoop = System.currentTimeMillis();
        System.out.println("Second dfs loop took" + ((afterSecondLoop - afterFirstLoop) / 1000.0) + " seconds");

        System.out.println("total sccs are: " + g.sccs.size());

        List<Integer> sccSizes = new ArrayList<Integer>();
        for(List<Vertex> scc : g.sccs)
        {
            sccSizes.add(scc.size());
        }

        Collections.sort(sccSizes);
        ListIterator<Integer> integerListIterator = sccSizes.listIterator(sccSizes.size());

        int i= 5;
        String out = "";
        while(integerListIterator.hasPrevious() && i>0) {
            out += integerListIterator.previous() + ",";
            i--;
        }
        System.out.println(out);
    }
}
