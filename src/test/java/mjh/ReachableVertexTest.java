package mjh;

import org.junit.Assert;
import org.junit.Test;

public class ReachableVertexTest {
	
	@Test
	public void testEquals() {
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		
		ReachableVertex rta = new ReachableVertex(a,1);
		ReachableVertex rtaa = new ReachableVertex(a,1);
		Assert.assertEquals(rta, rtaa);
		
		ReachableVertex rtb = new ReachableVertex(b,1);
		Assert.assertNotEquals(rtb, rta);
	}

}
