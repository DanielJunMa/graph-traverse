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
	
	
	/**
	 * Get all vertices that are reachable from a given origin
	 * @param origin
	 * @return Collection of ReachableVertex wrapper objects that contains the Vertex and the distance
	 */
	public Collection<ReachableVertex> getReachableVertices(Vertex origin) {
		return  getReachableVertices(origin,0);
	}
		
	/**
	 * Private recursive implementation used with getReachableVertices(). Not intended for public API
	 * @param vertex
	 * @param distance
	 * @return
	 */
	private Collection<ReachableVertex> getReachableVertices(Vertex vertex, int distance) {
		Collection<ReachableVertex> reachable = new HashSet<ReachableVertex>();
		if(distance != 0) {
			// The first time vertex == origin and it must not be added
			reachable.add(new ReachableVertex(vertex,distance));
		}
		
		if(vertex.getVertices().size() > 0) {
			// recursively call getReachableVertices for each child
			List<ReachableVertex> decendents = vertex.getVertices().stream()
					.flatMap(v -> getReachableVertices(v,distance + 1).stream())
					.collect(Collectors.toList());
			reachable.addAll(decendents);
		}
		
		return reachable;
	}
	
	

}
