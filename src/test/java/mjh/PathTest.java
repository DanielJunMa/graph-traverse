package mjh;

import org.junit.Assert;
import org.junit.Test;

public class PathTest {
	
	@Test
	public void testEquals() {
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		
		Path p1 = new Path(a,b,c);
		
		Path p2 = new Path(a,b);
		Assert.assertNotEquals(p1, p2);
		
		Path p3 = new Path(a,b,c);
		Assert.assertEquals(p1, p3);
	}

}
