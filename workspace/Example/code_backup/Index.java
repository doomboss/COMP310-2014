import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Index is just like the index in the back of a book.
 * 
 * Given some collection of things, we want to know
 * where something occurs in that collection.
 * 
 * Because we use a HashMap, this'll be O(1) lookup.
 * 
 * @param <Something>
 */
public class Index<Something> {
	HashMap<Something,HashSet<Integer>> index =
			new HashMap<Something,HashSet<Integer>>();
	
	/**
	 * Build up the index with entries at locations.
	 * 
	 * @param entry
	 * @param location
	 */
	public void addItem(Something entry, int location) {
		// no matter what, we need to add to an entry 
		// the location 
		
		
		
		if(!index.containsKey(entry)){
			index.put(entry, new HashSet<Integer>());
		}
		index.get(entry).add(location);

//		HashSet<Integer> hashset = new HashSet<Integer>();
//		hashset.add(location);
//		index.put(entry, hashset);
	}
	
	/**
	 * Given some entry, return where it occurs
	 * 
	 * @param entry
	 * @return
	 */
	public Set<Integer> getIndices(Something entry) {
		return index.get(entry);
	}
}
