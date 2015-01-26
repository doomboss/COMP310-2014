import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;


public class RPNTest {

	@Test
	public void testEvaluate() {
		RPN calculator = new RPN();
		Stack<Integer> stack = calculator.evaluate("25 7 32 + *");
		assertEquals((int)975, (int)stack.peek());
	}

}
