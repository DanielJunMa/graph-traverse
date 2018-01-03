package mjh;

import java.util.Collection;
import java.util.HashSet;

public class Vertex {
	private String id;
	private Collection<Vertex> vertices = new HashSet<Vertex>();
	
	public Vertex(String id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj;
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
