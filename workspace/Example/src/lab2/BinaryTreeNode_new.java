package lab2;


public class BinaryTreeNode_new
	<DataType extends Comparable<DataType>>
{
	DataType data;
	BinaryTreeNode<DataType> left, right, parent;
	BinaryTreeNode_new(DataType data) {
		this.data = data;
	}
	BinaryTreeNode_new(DataType data, BinaryTreeNode<DataType> parent) {
		this.data = data;
		this.parent = null;
	}
	
	void add(DataType moreData) {
		BinaryTreeNode<DataType> node  = findNode(moreData);
		if(node.data.compareTo(moreData) < 0) {
			node.right  = new BinaryTreeNode<DataType>(moreData);
		}else{
			node.left  = new BinaryTreeNode<DataType>(moreData);
		}
	}
	
	boolean remove(DataType item){
		BinaryTreeNode<DataType> node = findNode(item);
		//if we didnt find the item
		if (node.data.equals(data)){
			return false;
			
		}
		/*
		 * if we got here, we got work to do
		 * if the node has no left and no right child
		 * 
		 */
		if(node.left == null && node.right == null){
			if(node.parent!=null){
				if(node.parent.left==node){
					node.parent.left= null;
				}else{
					node.parent.right = null;
				}
			}
		}
		/*
		 * if the node has one child figure out what to do 
		 * if the node has twokids it gets messy
		 */
		BinaryTreeNode<DataType> pointer;
		for(pointer = node.left; pointer.right != null; pointer = pointer.right)
		return false;
	}
	
	BinaryTreeNode<DataType> findNode (DataType data){
		int result = this.data.compareTo(data);
			
		
	}
	
	// Can you write this function?
	// Hint: try doing what you do in the add function
	boolean contains (DataType moreData) {
		BinaryTreeNode<DataType> node = findNode(data);
		return node.data.equals(data);
	}
	public static void main(String[] args) {
		System.out.println("Hello".compareTo("World"));
	}
}
