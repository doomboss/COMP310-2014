import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;




public class RPN {
	
	public static void main(String[] args){
		RPN rpn = new RPN();
		System.out.println("Enter the full Expression: ");
		Scanner keyboard = new Scanner(System.in);
		String expression = keyboard.nextLine();
		try{
			System.out.println("End result: "+rpn.evaluate(expression).peek());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public RPN(){
		super();
	}
	
	protected Stack<Integer> stack = new Stack<Integer>();
	
	public Stack<Integer> evaluate(String expression) {
		int intHolder = 0;
		StringReader sr = new StringReader(expression);
		Scanner scanner = new Scanner(sr);
		while (scanner.hasNext()) {
			String token = scanner.next();
			// Check for +, -, /, *
			if (token.equals("+")) {
					intHolder = stack.peek();
					stack.pop();
					intHolder += stack.peek();
					stack.pop();
					stack.push(intHolder);					
				
				// do the appropriate thing
				// pop 2 items off stack, and place result
				// onto stack
				
			}
			else if (token.equals("-")) {
				intHolder = stack.peek();
				stack.pop();
				intHolder = stack.peek() - intHolder;
				stack.pop();
				stack.push(intHolder);
				
			}
			else if (token.equals("*")) {
				intHolder = stack.peek();
				stack.pop();
				intHolder *= stack.peek();
				stack.pop();
				stack.push(intHolder);

			}
			else if (token.equals("/")) {
				intHolder = stack.peek();
				stack.pop();
				if(stack.peek() != 0 && intHolder !=0){
					intHolder = stack.peek() / intHolder;
					stack.pop();
					stack.push(intHolder);
				}
				else{
					stack.pop();
					stack.push(0);
				}

			}
			else{
				try{
					stack.push(Integer.parseInt(token));
				}
				catch(NumberFormatException nfe){
					System.out.println("Not a numerical input...");
					System.exit(1);
				}
			}
			System.out.println("Current top value on stack: "+stack.peek());
			// catch all case
			// put the integer on the stack
		}
		scanner.close();
		return stack;
	}
	
	
	
	void clear(){
		stack.clear();
	}

}
