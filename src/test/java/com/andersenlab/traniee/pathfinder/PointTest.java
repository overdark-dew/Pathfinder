package com.andersenlab.traniee.pathfinder;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

    @Test
    public void testConstruct() {

        Graph notnull = new Graph.Builder(5).build();

        //assertNotNull("Not null", notnull);

        Path notn = new Path(notnull, 1, 1);
        
        assertNotNull("Not null", notn);
    }
    
    @Test
    public void testLenght() {
        
        Graph line =  new Graph.Builder(5).edge(0, 1, 5).edge(1, 2, 5).edge(2, 3, 5).edge(3, 4, 5).build();
        
        Path path = new Path(line, 0, 4);
        
        assertEquals(path.getAllPath(), 20);
        
        
    }
    
}
