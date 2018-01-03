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
	public void getPathsFromA() {
		Graph graph = GraphTest.createTestGraph();
		
		Vertex a = graph.getVertex("a");
		Collection<Path> paths = graph.getAllPaths(a);
		Assert.assertEquals(10, paths.size());
		
		Vertex b = graph.getVertex("b");
		Vertex c = graph.getVertex("c");
		Vertex d = graph.getVertex("d");
		Vertex e = graph.getVertex("e");
		Vertex f = graph.getVertex("f");
		Vertex g = graph.getVertex("g");
		Vertex h = graph.getVertex("h");
		Vertex i = graph.getVertex("i");
		Vertex j = graph.getVertex("j");
		Vertex k = graph.getVertex("k");
		
		Path p1 = new Path(a,b);
		Path p2 = new Path(a,c,e);
		Path p3 = new Path(a,c,f,h,k);
		Path p4 = new Path(a,c,f,i);
		Path p5 = new Path(a,d,c,e);
		Path p6 = new Path(a,d,c,f,h,k);
		Path p7 = new Path(a,d,c,f,i);
		Path p8 = new Path(a,d,f,h,k);
		Path p9 = new Path(a,d,f,i);
		Path p10 = new Path(a,d,g,j);
		
		Assert.assertThat(paths, containsInAnyOrder(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));
		
		System.out.println("All paths from Vertex a:");
		paths.stream().forEach(System.out::println);
		System.out.println("\n");
	}
	
	@Test
	public void getPathsFromB() {
		Graph graph = GraphTest.createTestGraph();
		
		Vertex b = graph.getVertex("b");
		Collection<Path> paths = graph.getAllPaths(b);
		Assert.assertEquals(1, paths.size());
		Path p1 = new Path(b);
		Assert.assertThat(paths, containsInAnyOrder(p1));
		
		System.out.println("All paths from Vertex b:");
		paths.stream().forEach(System.out::println);
		System.out.println("\n");
	}
	
	@Test
	public void getPathsFromF() {
		Graph graph = GraphTest.createTestGraph();
		
		Vertex f = graph.getVertex("f");
		Collection<Path> paths = graph.getAllPaths(f);
		Assert.assertEquals(2, paths.size());
		
		Vertex h = graph.getVertex("h");
		Vertex i = graph.getVertex("i");
		Vertex k = graph.getVertex("k");
		Path p1 = new Path(f,h,k);
		Path p2 = new Path(f,i);
		
		Assert.assertThat(paths, containsInAnyOrder(p1,p2));
		
		System.out.println("All paths from Vertex f:");
		paths.stream().forEach(System.out::println);
		System.out.println("\n");
	}
	
	@Test
	public void getPathsfromG() {
		Graph graph = GraphTest.createTestGraph();
		
		Vertex g = graph.getVertex("g");
		Collection<Path> paths = graph.getAllPaths(g);
		Assert.assertEquals(1, paths.size());
		
		System.out.println("All paths from Vertex g:");
		paths.stream().forEach(System.out::println);
		System.out.println("\n");
	}
	
	@Test
	public void getLongestPathfromA() {
		Graph graph = GraphTest.createTestGraph();
		
		Vertex a = graph.getVertex("a");
		Path longestPath = graph.getLongestPath(a);
		Assert.assertEquals(5, longestPath.getLength());
		 
		Vertex c = graph.getVertex("c");
		Vertex d = graph.getVertex("d");
		Vertex f = graph.getVertex("f");
		Vertex h = graph.getVertex("h");
		Vertex k = graph.getVertex("k");
		Path expected = new Path(a,d,c,f,h,k);
		
		Assert.assertEquals(expected, longestPath);
	}
	
	@Test
	public void getLongestPathfromB() {
		Graph graph = GraphTest.createTestGraph();
		
		Vertex b = graph.getVertex("b");
		Path longestPath = graph.getLongestPath(b);
		Assert.assertEquals(0, longestPath.getLength());
	}
	
	@Test
	public void getLongestPathfromF() {
		Graph graph = GraphTest.createTestGraph();
		
		Vertex f = graph.getVertex("f");
		Path longestPath = graph.getLongestPath(f);
		Assert.assertEquals(2, longestPath.getLength());
		 
		Vertex h = graph.getVertex("h");
		Vertex k = graph.getVertex("k");
		Path expected = new Path(f,h,k);
		
		Assert.assertEquals(expected, longestPath);
	}
		
	
	/**
	 * Utility method to create test graph
	 * 
	 *               a
	 *             / | \
	 *            b  c<-d
	 *            	/ \/ \
	 *             e   f  g
	 *                /\   \
	 *               h  i   j
	 *               |
	 *               k
	 *            
	 * @return Graph
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
