import java.util.Stack;


public class StackDemo {

	public static void main(String[] args) {
		Stack<String>names = new Stack<String>();
		names.push("here is a string");
		names.push("helloworld");
		System.out.println(names.peek());
		names.pop();
		System.out.println(names.peek());
		names.pop();
	}

}
