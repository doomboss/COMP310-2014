package labs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class HashSet<T> implements Set<T> {
	private ArrayList<LinkedList<T>> structure;
	private int size;
	public HashSet() {
		clear();
	}
	@Override
	public void clear() {
		// Let the garbage collector to the actual work for us :-)
		structure = new ArrayList<LinkedList<T>>();
		for (int i = 0; i < 13; i++) {
			structure.add(new LinkedList<T>());
		}
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public boolean add(T arg0) {
		structure.add(arg0.hashCode());
//      Hint: use arg0.hashCode();
//      Hint: do proper bookkeeping on the size
		return false;
	}
	
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int i = 0;
			Iterator<T> iterator = structure.get(0).iterator();
			{
				update();
			}
			private void update() {
				if (i > 12) return;
				while(!iterator.hasNext()) {
					i++;
					iterator = structure.get(i).iterator();
				}
			}
			@Override
			public boolean hasNext() {
				update();
				return iterator.hasNext();
			}
			@Override
			public T next() {
				update();
				return iterator.next();
			}
		};
	}


	// These are all pretty similar in terms of implementation
	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	// Don't bother implementing, unless you want to do reflection.
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	// Don't bother implementing.
	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args){
		System.out.println("hello".hashCode());
		System.out.println("world".hashCode());
		
	}
	
}
