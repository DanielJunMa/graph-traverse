package mjh;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * A collection of Vertices that make up a graph.
 */
public class Graph {
	Collection<Vertex> vertices = new HashSet<Vertex>();
	
	/**
	 * Add vertex to graph
	 * @param v
	 * @return v to enable method chaining
	 */
	public Vertex addVertex(Vertex v) {
		vertices.add(v);
		return v;
	}
	
	/**
	 * Get collection of all vertices in the graph
	 * @return Collection of Vertices
	 */
	public Collection<Vertex> getVertices() {
		return vertices;
	}
	
	/**
	 * Add edge relationship between two vertices
	 * @param from
	 * @param to
	 */
	public void addEdge(Vertex from, Vertex to) {
		from.addVertex(to);
	}
	
	/**
	 * Find a specific Vertex by its id. 
	 * @param id
	 * @return Vertex
	 * @throws NoSuchElementException if not found
	 */
	public Vertex getVertex(String id) throws NoSuchElementException {
		return vertices.stream()
				.filter(v -> v.getId().equals(id))
				.findFirst()
				.get();
	}
	
	public Collection<ReachableVertex> getReachableVertices(Vertex origin) {
		return  getReachableVertices(origin,0);
	}
	
	private Collection<ReachableVertex> getReachableVertices(Vertex vertex, int distanceTraveled) {
		int distance = distanceTraveled + 1;
		List<ReachableVertex> reachable = vertex.getVertices()
				.stream()
				.map(v -> new ReachableVertex(v,distance))
				.collect(Collectors.toList());
		
		// recursively call getReachableVertices for each child
		List<ReachableVertex> decendents = reachable.stream()
				.flatMap(rv -> getReachableVertices(rv.getVertex(),distance).stream())
				.collect(Collectors.toList());
		

		reachable.addAll(decendents);
		return reachable;
	}
	
	

}
