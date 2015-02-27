package graphs;

import java.util.ArrayList;

public class Graph<T> {
	ArrayList<Node<T>> nodes;
	public Node<T> addNode(T data){
		Node<T> node = new Node<T>(data);
		nodes.add(node);
		return node;
	}
	public Graph(){
		nodes = new ArrayList<Node<T>> ();
	}
	public void link( Node<T> from, Node<T> to ){
		from.neighbors.add(to);
	}
	public void link2way( Node<T> from, Node<T> to ){
		from.neighbors.add(to);
		to.neighbors.add(from);
	}
	void accept(Visitor<T> v) {
		v.visit(this);
	}
}
