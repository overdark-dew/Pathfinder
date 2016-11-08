package com.andersenlab.traniee.pathfinder;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testConstruct() {
		
		Graph notnull = new Graph.Builder(5).build();
		
	assertNotNull("Not null", notnull);
	
	}
	
	public void testNotEquals() {
		
		int n = 3;
		
		Graph test = new Graph.Builder(n).edge(1,2,5).build();
		Graph expect = new Graph.Builder(n).edge(2,1,5).build();
		
		
		assertEquals(expect, test);
	}
        
	
	@Test
	public void testOnePointGraph() {
		
		
		Graph onepoint = new Graph.Builder(1).build();
		
	
	int on = onepoint.getGraph()[0][0];

	assertEquals("Нулевое расстояние в одноточечном графе", 0, on);
	}
	
	@Test
	public void testZeroPointGraph() {
		
		
		Graph zeropoint = new Graph.Builder(0).build();
		
	
	//teger ze = zeropoint.getGraph()[0][0];

		assertNotNull("Не null", zeropoint);
	}
	
	@Test
	public void testFindShortWay()  {

		int n = 3;

		Graph begin = new Graph.Builder(n).edge(0, 1, 1).edge(0, 2, 2).edge(1, 2, 5).edge(1, 0, 1).edge(2, 0, 2).edge(2, 1, 5).build();
		Graph test = new Graph.Builder(n).shortWayGraph(begin).build();
		Graph expect = new Graph.Builder(n).edge(0, 1, 1).edge(0, 2, 2).edge(1, 2, 3).edge(1, 0, 1).edge(2, 0, 2).edge(2, 1, 3).build();
		
		for (int i = 0; i < n; ++i) {

			for (int j = 0; j < n; ++j) {

				int ex = expect.getGraph()[i][j];
				int te = test.getGraph()[i][j];

				assertEquals("Элементы должны быть равны", ex, te);
			}

		}
	}
	
	@Test
	public void testEmpty() throws Exception{
		
		
		
	}
}

// class GraphTest extends TestCase {
// @Test
// public void testEmptyGraph() {
// Assert.assertEquals(…);
// …
// }
// }
//
/// **
// * Unit test for simple App.
// */
// public class AppTest extends TestCase {
// /**
// * Create the test case
// *
// * @param testName
// * name of the test case
// */
// public AppTest(String testName) {
// super(testName);
// }
//
// /**
// * @return the suite of tests being tested
// */
// public static Test suite() {
// return new TestSuite(AppTest.class);
// }
//
// /**
// * Rigourous Test :-)
// */
// public void testApp() {
// assertTrue(true);
// }
// }
