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

	public Vertex getVertex() {
		return vertex;
	}

	public int getDistance() {
		return distance;
	}
}
