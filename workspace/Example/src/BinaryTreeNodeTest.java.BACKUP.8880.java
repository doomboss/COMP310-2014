import static org.junit.Assert.*;

import org.junit.Test;


public class BinaryTreeNodeTest {

	@Test
	public void testAdd() {
<<<<<<< HEAD
		BinaryTreeNode<String> root = new BinaryTreeNode<String>("dog");
		root.add("cat");
		root.add("fish");
		root.add("turtle");
		root.add("snake");
		assertEquals("cat", root.left.data);
		assertEquals("fish", root.right.data);
		assertEquals("turtle", root.right.right.data);
		assertEquals("snake", root.right.right.left.data);
=======
		BinaryTreeNode<String> tree =
				new BinaryTreeNode<String>("dog");
		tree.add("cat");
		tree.add("fish");
		tree.add("turtle");
		tree.add("snake");
		assertEquals("cat", tree.left.data);
		assertEquals("fish", tree.right.data);
		assertEquals("turtle", tree.right.right.data);
		assertEquals("snake", tree.right.right.left.data);
		assertTrue(tree.contains("snake"));
>>>>>>> bd5b51d569208bd7aade3fb477af01d11abdc207
	}

}
