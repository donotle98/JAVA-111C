import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



public class tester {

	public static void main(String[] args) {
		Random generator = new Random();
		Comparable[] array = new Comparable[10];
		for(int i=0; i<array.length; i++){
			array[i] = generator.nextInt(100);
		}
		System.out.println(Arrays.toString(array));
		
		
	}


public static boolean isSorted(Comparable[] array){
	
	boolean found = false;
	for( int i=0; (i< array.length && !found); i++){
		Comparable unsorted = array[i];
		int position = i;
		
		while(position > 0 && unsorted.compareTo(array[position-1]) < 0){
			array[position] = array[position-1];
			found = true;
			position--;				
		}
		array[position] = unsorted; 
	}
	return found;
}

public static void selectionSort(Comparable[] A) {
	  int j, k, minIndex;
	  Comparable min;
	  int N = A.length;

	  for (k = 0; k < N; k++) {
	     min = A[k];
	     minIndex = k;
	     for (j = k+1; j < N; j++) {
	        if (A[j].compareTo(min) < 0) {
		    min = A[j];
		    minIndex = j;
		}
	     }
	     A[minIndex] = A[k];
	     A[k] = min;
	  }
}


	public int countInRange(SortedListInterface<Integer> sList, int low, int high) {
		int count = 0;

		for (int i = 0; i < sList.getLength(); i++) {
			if (sList.getEntry(i) >= low && sList.getEntry(i) <= high) {
				count++;
			}
		}
		return count;
	}
}

/*
 * public static boolean isDivisibleBy(Node firstNode, int divisor) {

		Node<Integer> currentNode = firstNode;
		boolean found = false;
	
		while (currentNode != null) {
			Integer current = currentNode.getData();
			
			if (current % divisor == 0) {							
				found = true;
				currentNode = currentNode.next;				
			} else {
				return found = false;
			}
		}
		return found;
	}
}

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

