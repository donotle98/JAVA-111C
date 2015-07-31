public class LinkedSortedList<T extends Comparable<? super T>>
	             implements SortedListInterface<T>
	{
	   private Node firstNode;       // Reference to first node of chain
	   private int  numberOfEntries;

	   public LinkedSortedList()
	   {
	      firstNode = null;
	      numberOfEntries = 0;
	   } // end default constructor

	/* < Implementations of the sorted list operations go here.>
	   . . . */
	   
	   private class Node
	   {
	      private T     data;  // Entry in list
	      private Node	next; // Link to next node

	      private Node(T dataPortion) 
	      {
	         data = dataPortion;
	         next = null;	
	      } // end constructor

	      private Node(T dataPortion, Node nextNode) 
	      {
	         data = dataPortion;
	         next = nextNode;	
	      } // end constructor

	      private T getData()
	      {
	         return data;
	      } // end getData

	      private void setData(T newData)
	      {
	         data = newData;
	      } // end setData

	      private Node getNextNode()
	      {
	         return next;
	      } // end getNextNode

	      private void setNextNode(Node nextNode)
	      {
	         next = nextNode;
	      } // end setNextNode
	   } // end Node
	 // end LinkedSortedList

	
public boolean contains(T anEntry){
		
		boolean result = false;
		
		Node currentNode = firstNode;
		// for each node in the linked list
		while (currentNode != null)
		{
			if (anEntry.compareTo(currentNode.data) == 0)
				return true;
			currentNode  = currentNode.next;
		}
		
		return false;
	
	}

	/*public boolean isSorted(Node<Comparable> node) {
		Node currentNode = node;

		if (currentNode == null)
			return true;

		while (currentNode.next != null) {
			if (currentNode.data.compareTo(currentNode.next.data) > 0)
				return false;
			currentNode = currentNode.next;
		}
		return true;
		;

	}*/

@Override
public void add(T newEntry) {
	// TODO Auto-generated method stub
	
}


@Override
public boolean remove(T anEntry) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public int getPosition(T anEntry) {
	// TODO Auto-generated method stub
	return 0;
}


@Override
public T getEntry(int givenPosition) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public T remove(int givenPosition) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void clear() {
	// TODO Auto-generated method stub
	
}


@Override
public int getLength() {
	// TODO Auto-generated method stub
	return 0;
}


@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public T[] toArray() {
	// TODO Auto-generated method stub
	return null;
}
}
