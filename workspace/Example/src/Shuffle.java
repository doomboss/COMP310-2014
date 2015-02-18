import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


public class Shuffle {
	<T extends Comparable<T>> void shuffle(List<T> collection){
		Random rand = new Random();
		int other;
		T temp;
		for (int i=0; i<collection.size(); i++){
			// Get anotehr random index
			other = rand.nextInt(collection.size());
			// swap data at index i with data at index other
			temp = collection.get(i);
			collection.set(i, collection.get(other));
			collection.set(other,temp);
		}
			
	}
	
	
	
	
	

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String> ();
		list.add("bar");
		list.add("baz");
		list.add("foo");
		
	}

}
