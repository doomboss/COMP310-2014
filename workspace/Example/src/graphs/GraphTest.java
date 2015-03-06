package graphs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Graph<Integer> g = new Graph<Integer> ();
		for(int i = 1; i <= 7; i++){
			g.addNode(this);
		}
	}

}
