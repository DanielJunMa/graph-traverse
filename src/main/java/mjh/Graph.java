package mjh;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * A collection of Vertices that make up a graph. 
 * As well as operations to find all paths from given starting point,
 * or just the longest path from a given starting point.
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
	 * Find the longest path from a given starting Vertex.
	 * @param origin
	 * @return
	 */
	public Path getLongestPath(Vertex origin) {
		Collection<Path> allPaths = getAllPaths(origin);
		
		// reverse sort the list of paths by path length, and return the first one.
		return allPaths.stream()
				.sorted(Comparator.comparing(Path::getLength).reversed())
				.findFirst()
				.get();
	}
	
		
	/**
	 * Get all terminal paths from any given origin in the graph
	 * @param origin
	 * @return
	 */
	public Collection<Path> getAllPaths(Vertex origin){
		return getPaths(origin, new Path(origin));
	}
	
	/**
	 * Private recursive implementation used with getAllPaths(). Not intended for public API.
	 * This does a depth first traverse to find all paths from the starting vertex.
	 * @param vertex
	 * @param currentPath
	 * @return
	 */
	private Collection<Path> getPaths(Vertex vertex, Path currentPath){
		Collection<Path> paths = new HashSet<Path>();
		if(vertex.getVertices().size() == 0) {
			// if no children then this is the end of this path
			paths.add(currentPath);
		}else {
			// there are children, so recursively explore each.
			List<Path> additionalPaths = vertex.getVertices().stream()
					.flatMap(v -> getPaths(v, new Path(currentPath,v)).stream())
					.collect(Collectors.toList());
			paths.addAll(additionalPaths);
		}
		return paths;
	}
	
	
	
	

}
