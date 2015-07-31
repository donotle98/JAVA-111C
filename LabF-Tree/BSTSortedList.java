//Sirinapha Dube
//Lab F: Trees
//


import java.util.Iterator;

public class BSTSortedList<T extends Comparable<? super T>> implements
		SortedListInterface<T> {

	private BinarySearchTree<T> tree;

	public BSTSortedList() {

		tree = new BinarySearchTree<T>();
	}

	public boolean add(T newEntry) {
		if (!isFull()) {
			tree.add(newEntry);
			return true;
		} else
			return false;
	}

	public boolean remove(T anEntry) {

		boolean result = false;
		int position = getPosition(anEntry);

		if (position > 0) {
			tree.remove(anEntry);
			result = true;
		}
		return result;
	}

	public int getPosition(T anEntry) {

		Iterator<T> positionIterator = tree.getInorderIterator();
		int position = 1;

		while (positionIterator.hasNext()) {
			T currentEntry = positionIterator.next();
			if (currentEntry.equals(anEntry)) {
				return position;
			} else if (currentEntry.compareTo(anEntry) > 0)
				return -position;
			position++;
		}
		return -position;
	} // end getPosition

	public T getEntry(int givenPosition) {

		Iterator<T> positionIterator = tree.getInorderIterator();
		T result = null;
		int counter = 1;
		boolean found = false;

		if (givenPosition < 1)
			return null;

		while (positionIterator.hasNext()) {
			result = positionIterator.next();
			if (counter == givenPosition)
				return result;
			counter++;
		}
		return null;
	}

	public boolean contains(T anEntry) {

		return tree.contains(anEntry);
	}

	public T remove(int givenPosition) {

		T anEntry = getEntry(givenPosition);

		if (givenPosition > 0 && givenPosition < tree.getNumberOfNodes()) {
			tree.remove(anEntry);
			return anEntry;
		} else
			return null;
	}

	public void clear() {
		
		tree.clear();
	}

	public int getLength() {

		int length = 0;
		
		if (!isEmpty()) {
			length = tree.getNumberOfNodes();
		}
		return length;
	}

	public boolean isEmpty() {
		return tree.isEmpty();
	}

	public boolean isFull() {

		try {

		} catch (OutOfMemoryError E) {

		}
		return false;
	}

	public void display() {

		tree.inorderTraverse();
	}
}
