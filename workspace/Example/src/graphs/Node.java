package graphs;

import java.util.ArrayList;


public class Node<T> {
	
	final public ArrayList<Node<T>> neighbors;
	Node(T data){
		this.data = data;
		neighbors = new ArrayList<Node<T>>();
	}
	final public T data;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

	void accept(Visitor<T> v) {
		v.visit(this);
	}
}
