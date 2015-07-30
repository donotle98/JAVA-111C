// Sirinapha Dube 
// Homework 3: Linked Bags and Lists

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 */
public final class LinkedBag<T extends Comparable> implements BagInterface<T> {
	private Node firstNode; // Reference to first node	private int numberOfEntries;
	private int numberOfEntries;
	
	public LinkedBag(){
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return True if this bag is empty, or false if not.
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty


	/**
	 * Gets the number of entries currently in this bag.
	 * 
	 * @return The integer number of entries currently in this bag.
	 */
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param newEntry
	 *            The object to be added as a new entry
	 * @return True if the addition is successful, or false if not.
	 */
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
		// Add to beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.next = firstNode; // Make new node reference rest of chain
									// (firstNode is null if chain is empty)
		firstNode = newNode; // New node is at beginning of chain
		numberOfEntries++;

		return true;
	} // end add

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return A newly allocated array of all the entries in this bag.
	 */
	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries]; // Unchecked cast

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		} // end while

		return result;
	} // end toArray

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry
	 *            The entry to be counted.
	 * @return The number of times anEntry appears in this bag.
	 */
	/*public int getFrequencyOf(T anEntry) {
		int frequency = 0;

		int counter = 0;
		Node currentNode = firstNode;
		while ((counter < numberOfEntries) && (currentNode != null)) {
			if (anEntry.equals(currentNode.data)) {
				frequency++;
			} // end if

			counter++;
			currentNode = currentNode.next;
		} // end while

		return frequency;
	} // end getFrequencyOf*/
	
	
	public int getFrequencyOf(T anEntry){
		return getFrequencyOfHelper(firstNode, anEntry);
	}
	
	private int getFrequencyOfHelper (Node currentNode, T anEntry){
		
		int frequency = 0;
		
		if(currentNode == null) { // base case
			return frequency= 0;
		} else { // recursive case
			T currentData = currentNode.data;
			if(currentData.equals(anEntry)) {
				return 1 + getFrequencyOfHelper(currentNode.next, anEntry);
			} else {
				return 0 + getFrequencyOfHelper(currentNode.next, anEntry);
				
			}
			
		}
	}

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry
	 *            The entry to locate.
	 * @return True if the bag contains anEntry, or false otherwise.
	 */
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while

		return found;
	} // end contains

	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	/*private Node getReferenceTo(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while

		return currentNode;
	} // end getReferenceTo 
	*/
	
	private Node getReferenceTo(T anEntry) {
		return getReferenceToHelper(firstNode, anEntry);
	}
	
	private Node getReferenceToHelper (Node currentNode, T anEntry) {
		if(currentNode == null) { // base case
			return currentNode;
		} else { // recursive case
			T currentData = currentNode.data;
			if(currentData.equals(anEntry)) {
				return currentNode;
			} else {
				return getReferenceToHelper (currentNode.next, anEntry);
			}
			
		}
	}


	/** Removes all entries from this bag. */
	public void clear() {
		while (!isEmpty())
			remove();
	} // end clear
	
	

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return Either the removed entry, if the removal was successful, or null.
	 */
	public T remove() {
		T result = null;
		if (firstNode != null) {
			result = firstNode.data;
			firstNode = firstNode.next; // Remove first node from chain
			numberOfEntries--;
		} // end if

		return result;
	} // end remove

	/**
	 * Removes one occurrence of a given entry from this bag, if possible.
	 * 
	 * @param anEntry
	 *            The entry to be removed.
	 * @return True if the removal was successful, or false otherwise.
	 */
	public boolean remove(T anEntry) {
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);

		if (nodeN != null) {
			nodeN.data = firstNode.data;

			firstNode = firstNode.next;
			numberOfEntries--;

			result = true;
		} // end if

		return result;
	} // end remove

	
	// Question 1
	
	public T replace(T newEntry) {
		T replaceEntry = firstNode.data;
		firstNode.data = newEntry;
		return replaceEntry;
	}

	// Question 2
	public T getMax() {
		Node currentNode = firstNode;
		T currentMax = firstNode.data;

		while (currentNode != null) {
			currentNode = currentNode.next;

			if (currentNode != null
					&& currentNode.data.compareTo(currentMax) == 1)
				currentMax = currentNode.data;
		} // end while
		return currentMax;
	} // end getMax

	// Question 3
	public T removeMax() {
		T result = null;
		T nodeN = getMax();

		if (nodeN != null) {
			nodeN = firstNode.data;

			firstNode = firstNode.next;
			numberOfEntries--;
		} // end if
		return result;
	} // end removeMax

	// Question 4
	public BagInterface<T> union(BagInterface<T> secondLinkedBag) {

		BagInterface<T> tempLinkedBag = new LinkedBag<T>();

		T[] currentBagTempArray = this.toArray();
		for (T index : currentBagTempArray) {
			tempLinkedBag.add(index);
		}

		T[] others = secondLinkedBag.toArray();
		for (T index : others) {
			tempLinkedBag.add(index);
		}
		return tempLinkedBag;
	}// end union

	private class Node {
		private T data; // Entry in bag
		private Node next; // Link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor
	} // end Node
} // end LinkedBag



	