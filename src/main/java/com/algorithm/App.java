package com.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

        System.out.println(g.numberOfVerices() + " " + ((afterLoadGraph-start) / 1000.0) + " seconds");



    }
}
