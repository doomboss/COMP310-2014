
public class BinaryTreeNode
	<DataType extends Comparable<DataType>>{
		DataType data;
		BinaryTreeNode<DataType>left,right;
		BinaryTreeNode(DataType data){
			this.data = data;
		}
		void add(DataType moreData){
			// figure out which side to place it
			if(data.compareTo(moreData) <= 0){
				// goes to right hand side
				if(right == null){
					//create node
					right = new BinaryTreeNode<DataType>(moreData);
				}
				else{
					right.add(moreData);

				}
			}
			else{
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
		
		public boolean contains(DataType moreData){
			
			return false;
		}
		
		public static void main(String[] args){
			System.out.println("Hello".compareTo("World"));
		}
	}
