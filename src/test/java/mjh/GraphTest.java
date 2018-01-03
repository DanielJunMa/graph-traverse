package mjh;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

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
	public void getReachableVerticesfromA() {
		Graph graph = GraphTest.createTestGraph();
		
		Vertex a = graph.getVertex("a");
		Collection<ReachableVertex> reachable = graph.getReachableVertices(a);
		Assert.assertEquals(16, reachable.size());
		
		Assert.assertThat(reachable, containsInAnyOrder(
				new ReachableVertex(graph.getVertex("b"),1),
				new ReachableVertex(graph.getVertex("c"),1),
				new ReachableVertex(graph.getVertex("c"),2),
				new ReachableVertex(graph.getVertex("d"),1),
				new ReachableVertex(graph.getVertex("e"),2),
				new ReachableVertex(graph.getVertex("e"),3),
				new ReachableVertex(graph.getVertex("f"),2),
				new ReachableVertex(graph.getVertex("f"),3),
				new ReachableVertex(graph.getVertex("g"),2),
				new ReachableVertex(graph.getVertex("h"),3),
				new ReachableVertex(graph.getVertex("h"),4),
				new ReachableVertex(graph.getVertex("i"),3),
				new ReachableVertex(graph.getVertex("i"),4),
				new ReachableVertex(graph.getVertex("j"),3),
				new ReachableVertex(graph.getVertex("k"),4),
				new ReachableVertex(graph.getVertex("k"),5)
				));
	}
	
	@Test
	public void getReachableVerticesfromF() {
		Graph graph = GraphTest.createTestGraph();
		
		Vertex f = graph.getVertex("f");
		Collection<ReachableVertex> reachable = graph.getReachableVertices(f);
		Assert.assertEquals(3, reachable.size());
		
		Assert.assertThat(reachable, containsInAnyOrder(
				new ReachableVertex(graph.getVertex("h"),1),
				new ReachableVertex(graph.getVertex("i"),1),
				new ReachableVertex(graph.getVertex("k"),2)
				));
	}
	
	@Test
	public void getReachableVerticesfromB() {
		Graph graph = GraphTest.createTestGraph();
		
		Vertex b = graph.getVertex("b");
		Collection<ReachableVertex> reachable = graph.getReachableVertices(b);
		Assert.assertEquals(0, reachable.size());
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
		graph.addEdge(d,c);
		graph.addEdge(d,f);
		graph.addEdge(d,g);
		graph.addEdge(f,h);
		graph.addEdge(f,i);
		graph.addEdge(g,j);
		graph.addEdge(h,k);
		
		return graph;
	}

}
