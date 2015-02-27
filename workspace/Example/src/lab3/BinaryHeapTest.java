package lab3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinaryHeapTest {
	BinaryMaxHeap<Integer> heap;

	@Before
	public void setUp() throws Exception {
		heap = new BinaryMaxHeap<Integer>();
		heap.insert(10);
		heap.insert(5);
		heap.insert(6);
		heap.insert(4);
	}

	@Test
	public void testInsert() {
		heap.insert(1000000);
		heap.printAll();
		assertEquals(1000000, (int)heap.remove());
		heap.printAll();
		assertEquals(10, (int)heap.remove());
		assertEquals(6, (int)heap.remove());
	}
	
	@Test
	public void testContains(){
		assertTrue(heap.contains(4));
		assertFalse(heap.contains(42));
	}

}
