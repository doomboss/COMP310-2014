import static org.junit.Assert.*;

import org.junit.Test;


public class NodeTest {

	@Test
	public void test() {
//		Node<String> stringNode = new Node<String>();
//		Node<Integer> intNode = new Node<Integer>();
		Node<Integer> thing1 = new Node<Integer>();
		Node<Integer> thing2 = new Node<Integer>();
		thing1.setData(3);
		thing2.setData(10);
		thing1.setNext(thing2);
		assertEquals(thing2, thing1.getNext());
		assertEquals(thing1,thing2.getPrev());
		
		
		
	}

}
