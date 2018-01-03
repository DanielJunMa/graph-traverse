package mjh;

import java.util.Collection;
import java.util.HashSet;

public class Vertex {
	private String id;
	private Collection<Vertex> vertices = new HashSet<Vertex>();
	
	public Vertex(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String toString() {
		return id;
	}
	
	/**
	 * Add edge relationship to the provided Vertex 
	 * @param to
	 */
	public void addVertex(Vertex to) {
		vertices.add(to);
	}
	
	/**
	 * Get collection of vertices directly connected to this one
	 * @return Collection of Vertices
	 */
	public Collection<Vertex> getVertices(){
		return vertices;
	}
	

}
