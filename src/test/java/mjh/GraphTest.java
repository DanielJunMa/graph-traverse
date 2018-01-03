package mjh;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

	@Test
	public void constructGraph() {
		Graph graph = GraphTest.createTestGraph();
		
		// Verify can get a given vertex
		Vertex found = graph.getVertex("c");
		Assert.assertEquals(found.getId(), "c");
		
		// verify node c is connected to e and f
		Assert.assertEquals(2, found.getVertices().size());
		
		// Verify that trying to get an invalid vertex throws exception
		try {
			graph.getVertex("invalid");
			Assert.fail("Did not receive expected exception");
		} catch(NoSuchElementException nse) {
			// this is expected
		}
	}
	
	@Test
	public void getReachableVertices() {
		Graph graph = GraphTest.createTestGraph();
		
		// Verify can get a given vertex
		Vertex c = graph.getVertex("c");
		Collection<ReachableVertex> reachable = graph.getReachableVertices(c);
		System.out.println("Reachable:"+reachable);
	}
	
	
	
	/**
	 * Utility method to create test data
	 * @return
	 */
	private static Graph createTestGraph() {
		Graph graph = new Graph();
		Vertex a = graph.addVertex(new Vertex("a"));
		Vertex b = graph.addVertex(new Vertex("b"));
		Vertex c = graph.addVertex(new Vertex("c"));
		Vertex d = graph.addVertex(new Vertex("d"));
		Vertex e = graph.addVertex(new Vertex("e"));
		Vertex f = graph.addVertex(new Vertex("f"));
		Vertex g = graph.addVertex(new Vertex("g"));
		Vertex h = graph.addVertex(new Vertex("h"));
		Vertex i = graph.addVertex(new Vertex("i"));
		Vertex j = graph.addVertex(new Vertex("j"));
		Vertex k = graph.addVertex(new Vertex("k"));
	
		graph.addEdge(a,b);
		graph.addEdge(a,c);
		graph.addEdge(a,d);
		graph.addEdge(c,e);
		graph.addEdge(c,f);
		graph.addEdge(d,f);
		graph.addEdge(f,h);
		graph.addEdge(f,i);
		graph.addEdge(g,j);
		graph.addEdge(h,k);
		
		return graph;
	}

}
