package mjh;

/**
 * Simple wrapper to associate a given Vertex with the distance to reach it.
 *
 */
public class ReachableVertex {
	private Vertex vertex;
	private int distance;
	
	public ReachableVertex(Vertex destination, int distance) {
		this.vertex = destination;
		this.distance = distance;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + distance;
		result = prime * result + ((vertex == null) ? 0 : vertex.hashCode());
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
		ReachableVertex other = (ReachableVertex) obj;
		if (distance != other.distance)
			return false;
		if (vertex == null) {
			if (other.vertex != null)
				return false;
		} else if (!vertex.equals(other.vertex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertex:" + vertex.getId() + " Distance:" + distance;
	}

	public Vertex getVertex() {
		return vertex;
	}

	public int getDistance() {
		return distance;
	}
	
}
