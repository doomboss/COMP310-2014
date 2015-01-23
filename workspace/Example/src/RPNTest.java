import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;


public class RPNTest {

	@Test
	public void testEvaluate() {
		RPN calculator = new RPN();
		Stack<Integer> stack;
		stack = calculator.evaluate("25 7 32 + *");
		assertEquals(975,(int)stack.peek());
		stack = calculator.evaluate("2 3 + 5 /");
		assertEquals(1,(int)stack.peek());
		stack = calculator.evaluate("3 3 - 5 /");
		assertEquals(0,(int)stack.peek());
		stack = calculator.evaluate("5 3 - 4 8 * +");
		assertEquals(34,(int)stack.peek());
		stack = calculator.evaluate("1 2 + 4 * 5 + 3 -");
		assertEquals(14,(int)stack.peek());
		stack = calculator.evaluate("5 1 2 + 4 * + 3 -");
		assertEquals(14,(int)stack.peek());
		
	}

}
