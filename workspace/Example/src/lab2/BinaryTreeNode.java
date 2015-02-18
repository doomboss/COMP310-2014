package lab2;

public class BinaryTreeNode <DataType extends Comparable<DataType>>{
		
		DataType data, tmp;
		BinaryTreeNode<DataType>left,right, holder;
		BinaryTreeNode(DataType data){
			this.data = data;
		}
		
		
		/*
		 *     
		private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = remove( t.element, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

		 */
		public BinaryTreeNode<DataType> remove(DataType item, BinaryTreeNode<DataType> node){
			if(node == null)
				return node;
			int compare = item.compareTo(node.data);
			if(compare<0){ //left
				node.left = remove(item, node.left); //move to the next node recursively
			}else if(compare>0){ //right
				node.right = remove(item, node.right); //move to the next node recursively
			}else if(node.left!=null && node.right!=null){ //has two nodes
				//find the min
				node.data = findMin(node.left).data; //get the data and replace it with the deleted node
				node.right = remove(node.data, node.right); //get the rest of the node
			}else{
				node = (node.left != null) ? node.left : node.right; 
				//if left node not empty use it, else use right node...
			}
			
			
	
			return node;
		}
		
		
		void add(DataType moreData){
			// figure out which side to place it
			if(data.compareTo(moreData) <= 0){
				// goes to right hand side
				if(right == null){
				// create a node with the data and call it a day
					right = new BinaryTreeNode<DataType>(moreData);
			} else {
				// keep looking recursively
					right.add(moreData);

				}
			}
			 else {
					// it goes to the left
				if (left == null) {
					// create a node and call it a day
					left = new BinaryTreeNode<DataType>(moreData);
				} else {
					// keep looking recursively
					left.add(moreData);
				}
			}
					// put it there
		}
			
		
		
		
		boolean contains (DataType moreData) {
			int result = this.data.compareTo(moreData);
			if (result < 0){
				if (right == null){
					return false;
				}
				else{
					return right.contains(moreData);
				}
			}
			else if(result==0){
				return true;
			}
			else{
				if (left == null){
					return false;
				}
				else{
					return left.contains(moreData);
				}
			}
		}
		
	// Can you write this function?
	// Hint: try doing what you do in the add function
		
	    BinaryTreeNode<DataType> findMin( BinaryTreeNode<DataType> data )
	    {
	        if( data == null )
	            return null;
	        else if( data.left == null )
	            return data;
	        return findMin( data.left );
	    }
	    BinaryTreeNode<DataType> findMax( BinaryTreeNode<DataType> data )
	    {
	        if( data != null )
	            while( data.right != null )
	                data = data.right;

	        return data;
	    }

		
	public static void main(String[] args) {
		System.out.println("Hello".compareTo("World"));
		BinaryTreeNode<String> root = new BinaryTreeNode<String>("dog");
		root.add("cat");
		root.add("fish");
		root.add("turtle");
		root.add("snake");
		System.out.println(root.remove("fish", root).data);
		System.out.println(root.contains("fish"));
		System.out.println(root.remove("hibye", root).data);
	}
}
