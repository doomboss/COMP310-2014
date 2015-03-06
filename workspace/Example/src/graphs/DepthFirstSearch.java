package graphs;

import java.util.Stack;

public class DepthFirstSearch<T> implements Visitor<T>{

	Set<Node<T>> visitors
	Stack<Node<T>> visited = new Stack<Node<T>> ();
	
	
	
	@Override
	public void visit(Node<T> node) {
		// TODO Auto-generated method stub
		if (!visited.contains(node)){
			System.out.println(node.data);
			for(Node<T> neighbor : node.neighbors){
				neighbor.accept(this);
			}
		}
	}

	@Override
	public void visit(Graph<T> graph) {
		// TODO Auto-generated method stub
		for(Node<T> node : graph.nodes){
			node.accept(this);
		}
	}
	
}
