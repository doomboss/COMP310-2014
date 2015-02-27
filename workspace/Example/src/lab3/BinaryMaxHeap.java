package lab3;

// http://en.wikipedia.org/wiki/Binary_heap
//in this case, the binary heap is the max heap
public class BinaryMaxHeap<T extends Comparable<T>> {
	BinaryTree<T> tree = new BinaryTree<T>();
	// Insert an element into the binary heap
	// Not a one-liner
	public void insert (T item) {
//		System.out.println("adding: "+item);
		tree.add(item); //add it to the list first without sorting the order
		insertOrganizer(item, tree.search(item));
		
	}
	public void insertOrganizer (T item, int index){
		int parentIndex = tree.parent( index );
		int compareParent = item.compareTo(tree.get( tree.parent( index ) ) );
		if( compareParent > 0){ //the item is larger than its parent node
			T tmp = tree.get(parentIndex);
			tree.set(parentIndex, item);
			tree.set(index, tmp);
			int compareParent2 = item.compareTo( tree.get( tree.parent( parentIndex ) ) );
			if(compareParent2 > 0){ //searching the index for the parentInt
//				System.out.println("recursive organizer method starts now ");
				insertOrganizer(item, parentIndex);
			}
		}else{
			
		}
//		for(int i=0; i<tree.size(); i++){
//			System.out.print(tree.get(i)+" ");
//		}
		
	}
	// Only remove the root (not a one-liner)
	//in this case, the root should be the top element, which should be at index 0
	public T remove () {
		//the get(0) should be the root...
		
		//replace the root with the last item on the list
		T lastItem = tree.get(tree.size()-1);
		T firstItem = tree.get(0);
//		System.out.println("last item before deleting:"+lastItem);
		tree.set(0, lastItem);
		tree.removeLast();
//		System.out.println("After removeLast()");
//		printAll();
//		System.out.println("Last item: "+lastItem);
		removeOrganizer(lastItem, 0);
//		removeHelper(0);
		
		
		return firstItem;
	}
	
	public void removeOrganizer(T item, int index){
		System.out.println("item: "+item+" index: "+index);
		printAll();
		T left = tree.get(tree.left(index)), right = tree.get(tree.right(index));
		if(right != null && left != null){
			if(left.compareTo(right)>0){ //left is larger than right
				tree.set(index, left);
				tree.set(tree.left(index), item);
				removeOrganizer(item, tree.left(index));
			
			}
			else{ //left is smaller than right...
				tree.set(index, right);
				tree.set(tree.right(index), item);
				removeOrganizer(item, tree.right(index));
		}
		}
		else if(right == null && left != null){ //right side is null
			tree.set(index, left);
			tree.set(tree.left(index), item);
		}
		else{ //no left or right 

		}
		
	}
	
	
	// Does the heap have the item?
	public boolean contains (T item) {
		if(tree.search(item)==-1)//does not exist
		{
			return false;
		}
		else{
			return true;
		}
	}
	
	
	public void printAll(){
		for(int i=0; i<tree.size(); i++){
			System.out.print(tree.get(i)+" ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args){
		BinaryMaxHeap bh = new BinaryMaxHeap<>();
//		bh.tree.add("one");
//		bh.tree.add("two");
//		bh.tree.add("three");
//		bh.tree.add("four");
//		bh.tree.add("five");
//		bh.tree.add("six");
		bh.insert("H");
		bh.insert("D");
		bh.insert("I");
		bh.insert("A");
		bh.insert("B");
		bh.insert("C");
		bh.insert("E");
		bh.insert("F");
		bh.insert("G");
		bh.insert("J");
		bh.insert("K");
		bh.insert("L");
		bh.insert("M");
		bh.insert("6");
		bh.insert("2");
		bh.insert("Z");
		bh.insert("V");
		bh.insert("U");
		
//		System.out.println(bh.tree.search("seven"));
//		System.out.println(bh.tree.search("C"));
//		System.out.println(bh.tree.search("F"));
//		System.out.println(bh.contains("seven"));
//		System.out.println(bh.contains("G"));
		
		System.out.println("before remove");
		for(int i=0; i<bh.tree.size(); i++){
			System.out.print(bh.tree.get(i)+" ");
		}
		try{
		bh.remove();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("after remove");
		
		for(int i=0; i<bh.tree.size(); i++){
			System.out.print(bh.tree.get(i)+" ");
		}
	}
}
