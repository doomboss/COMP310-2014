import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;


public class RPN {

	Stack<Integer>stack = new Stack<Integer>();
	
	public Stack<Integer> evaluate(String expression){
		StringReader sr = new StringReader(expression);
		Scanner s = new Scanner(sr);
		s.next();
		while(s.hasNext()){
			String token = s.next();
			// check for +, -, /, *
			if(token.equals("*")){
				//do the appropriate thing
				//pop 2 items off stack and place result onto the stack
			}
			//catch all case
			// put the integer on the stack
			Integer.parseInt(token);
			
		}
		return stack;
		
	}
	
	
	//(2+3)*7   infix
	//2 3 + 7 * postfix
 	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
