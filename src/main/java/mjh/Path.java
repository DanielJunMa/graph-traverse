package mjh;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Representation of a path through the graph via an ordered list of vertices
 */
public class Path { 
	private List<Vertex> vertices = new ArrayList<Vertex>();
		
	public Path(Vertex... verticies) {
		for(int i=0; i<verticies.length; i++) {
			vertices.add(verticies[i]);
		}
	}
	
	public Path(Path preceding, Vertex next) {
		this.vertices.addAll(preceding.getVertices());
		this.vertices.add(next);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertices == null) ? 0 : vertices.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Path other = (Path) obj;
		if (vertices.size() != other.getVertices().size()) {
			return false;
		} 
		for(int i=0; i < vertices.size(); i++) {
			if(vertices.get(i) != other.getVertices().get(i)) {
				return false;
			}
		}
		
		return true;
	}

	public List<Vertex> getVertices() {
		return vertices;
	}
	
	@Override
	public String toString() {
		String s = vertices.stream().map(Object::toString).collect(Collectors.joining(" -> "));
		return s;
	}
	
	public int getLength() {
		return vertices.size() - 1;  // -1 because origin is excluded from count
	}

}
