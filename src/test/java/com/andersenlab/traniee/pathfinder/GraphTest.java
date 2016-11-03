package com.andersenlab.traniee.pathfinder;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testConstruct() {
		
		Graph notnull = new Graph();
		
	assertNotNull("Not null", notnull);
	
	}
	
	public void testNotEquals() {
		
		int n = 2;
		
		Graph test = new Graph(n);
		Graph expect = new Graph(n);
		
		test.getGraph()[0][1] = 1;
		expect.getGraph()[0][1] = 2;
		
		int ex = expect.getGraph()[0][1];
		int te = test.getGraph()[0][1];
		
		assertFalse(ex == te);
	}
        
	
	@Test
	public void testOnePointGraph() {
		
		
		Graph onepoint = new Graph(1);
		
	
	int on = onepoint.getGraph()[0][0];

	assertEquals("Нулевое расстояние в одноточечном графе", 0, on);
	}
	
	@Test
	public void testZeroPointGraph() {
		
		int n = 0;
		Graph zeropoint = new Graph(n);
		
	
	//teger ze = zeropoint.getGraph()[0][0];

		assertNotNull("Не null", zeropoint);
	}
	
	@Test
	public void testFindShortWay()  {

		int n = 3;

		Graph test = new Graph(n);
		Graph expect = new Graph(n);

		test.getGraph()[0][1] = 1;
		test.getGraph()[0][2] = 2;
		test.getGraph()[1][2] = 5;
		test.getGraph()[1][0] = 1;
		test.getGraph()[2][0] = 2;
		test.getGraph()[2][1] = 5;

		expect.getGraph()[0][1] = 1;
		expect.getGraph()[0][2] = 2;
		expect.getGraph()[1][2] = 3;
		expect.getGraph()[1][0] = 1;
		expect.getGraph()[2][0] = 2;
		expect.getGraph()[2][1] = 3;

		Graph.findShortWay(test);
		

		for (int i = 0; i < 3; ++i) {

			for (int j = 0; j < 3; ++j) {

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
