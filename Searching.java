
import java.util.*;

public class Homework7Driver {

	public static void main(String[] args) {
		Integer[] unsortedNumbers = { 1, 4, 3, 2, 6, 7, 2, 4,};
		Integer[] sortedNumbers = Arrays.copyOf(unsortedNumbers,
				unsortedNumbers.length);
		Arrays.sort(sortedNumbers);

		// Q7: recursive linear search on unsorted data
		System.out.println("Q7");
		System.out.println("contains 2 (true): "
				+ searchRecursiveLinearFromLast(unsortedNumbers, 2));
		System.out.println("contains 4 (true): "
				+ searchRecursiveLinearFromLast(unsortedNumbers, 4));
		System.out.println("contains 8 (false): "
				+ searchRecursiveLinearFromLast(unsortedNumbers, 8));
		System.out.println("");

		// Q8: recursive linear search on sorted data
		// note: you might want to add additional print statements to make sure
		// that your method is not only returning the correct value, but also
		// taking advantage of the list being sorted
		System.out.println("Q8");
		System.out.println("contains 1 (true): "
				+ searchRecursiveLinearSorted(sortedNumbers, 1));
		System.out.println("contains 4 (true): "
				+ searchRecursiveLinearSorted(sortedNumbers, 4));
		System.out.println("contains 7 (true): "
				+ searchRecursiveLinearSorted(sortedNumbers, 7));
		System.out.println("contains 8 (false): "
				+ searchRecursiveLinearSorted(sortedNumbers, 8));
		System.out.println("");

		// Q9: return all indices of the target; recursive
		System.out.println("Q9");		
		ArrayList<Integer> indices;
		indices = findIndicesUnsorted(unsortedNumbers, new Integer(1));
		System.out.println("1 is at [0]: " + indices.toString());
		indices = findIndicesUnsorted(unsortedNumbers, new Integer(2));
		System.out.println("2 is at [3, 6]: " + indices.toString());
		indices = findIndicesUnsorted(unsortedNumbers, new Integer(4));
		System.out.println("4 is at [1, 7]: " + indices.toString());
		indices = findIndicesUnsorted(unsortedNumbers, new Integer(5));
		System.out.println("5 is at []: " + indices.toString());
		System.out.println(""); 
		
		
		// Q10: return all indices of the target; recursive and efficient on sorted data
		// note: the order of the indices does not matter
		System.out.println("Q10");	
		indices = findIndicesRecursiveSorted(sortedNumbers, new Integer(1));
		System.out.println("1 is at [0]: " + indices.toString());
		indices = findIndicesRecursiveSorted(sortedNumbers, new Integer(7));
		System.out.println("7 is at [7]: " + indices.toString());
		indices = findIndicesRecursiveSorted(sortedNumbers, new Integer(2));		
		System.out.println("2 is at [1, 2]: " + indices.toString());
		indices = findIndicesRecursiveSorted(sortedNumbers, new Integer(4));
		System.out.println("4 is at [4, 5]: " + indices.toString());
		indices = findIndicesRecursiveSorted(sortedNumbers, new Integer(5));
		System.out.println("5 is at []: " + indices.toString());
		System.out.println(""); 
		
		// Q11 extra credit: findMax (recursive, efficient) unsorted data
		System.out.println("Q11EC");
		System.out.println("max is 7: " + recursiveFindMax(unsortedNumbers)); 

	}

	// Q7
	public static boolean searchRecursiveLinearFromLast(Object[] array,
			Object desiredItem) {

		return searchRecursiveLinearFromLastHelper(array, 0, array.length - 1,
				desiredItem);
	}

	private static boolean searchRecursiveLinearFromLastHelper(Object[] array,
			int first, int last, Object desiredItem) {
		boolean found;
		if (first > last) {
			found = false;
		} else if (desiredItem.equals(array[last]))
			found = true;
		else
			found = searchRecursiveLinearFromLastHelper(array, first, last - 1,
					desiredItem);
		return found;
	}

	// Q8
	public static boolean searchRecursiveLinearSorted(Comparable[] array,
			Comparable desiredItem) {
		return searchRecursiveLinearSortedHelper(array, 0, array.length - 1,
				desiredItem);
	}

	private static boolean searchRecursiveLinearSortedHelper(
			Comparable[] array, int first, int last, Comparable desiredItem) {
		boolean found = false;

		if (first > last) {
			found = false;
		} else if (array[first].equals(desiredItem)) {
			found = true;
		} else if (array[first].compareTo(desiredItem) > 0) {
			found = false;
		} else {
			return found = searchRecursiveLinearFromLastHelper(array,
					first + 1, last, desiredItem);
		}
		return found;
	}

	// Q9
	public static ArrayList<Integer> findIndicesUnsorted(Object[] array,
			Object desiredItem) {

		return findIndicesUnsortedHelper(array, desiredItem, 0,
				array.length - 1);
	}

	private static ArrayList<Integer> findIndicesUnsortedHelper(Object[] array,
			Object desiredItem, int first, int last) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		if (first == last) {
			if (array[first].equals(desiredItem))
				result.add(first);			
		} else {
			if (array[first].equals(desiredItem)) {
				result.add(first);
				result.addAll(findIndicesUnsortedHelper(array, desiredItem,
						first + 1, last));
			} else {
				result = findIndicesUnsortedHelper(array, desiredItem,
						first + 1, last);
			}
		}
		return result;
	}

	// Q10
	public static ArrayList<Integer> findIndicesRecursiveSorted(
			Comparable[] sortedArray, Comparable desiredItem) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		findIndicesRecursiveSortedHelper(sortedArray, desiredItem, 0,
				sortedArray.length - 1, result);
		
		return result;
	}

	private static void findIndicesRecursiveSortedHelper(
			Comparable[] sortedArray, Comparable desiredItem, int first,
			int last, ArrayList<Integer>result) {

		if (sortedArray[first].equals(desiredItem))
			result.add(first);
		if ((first != last) && (sortedArray[first].compareTo(desiredItem) <= 0)) 
			findIndicesRecursiveSortedHelper(sortedArray,
					desiredItem, first + 1, last, result);

	}	
	
	
	// Q11EC
	public static Comparable recursiveFindMax(Comparable[] array) {
		return recursiveFindMaxHelper(array, 0, array.length-1);
	} 
	
	
	private static Comparable recursiveFindMaxHelper(Comparable[] array,int first, int last) {
				
		Comparable result = null;
		
		if(first >= last)
			return array[first];
		
		else{
			int mid = first + (last-first) / 2;
			Comparable max = null;
			Comparable firstHalf = recursiveFindMaxHelper(array,first, mid);
			Comparable secondHalf =recursiveFindMaxHelper(array, mid +1, last);
			
			if(firstHalf.compareTo(secondHalf) > 0)				
				result = firstHalf;			
			else 
				result = secondHalf;						
		}
			
		return result;
	}
}

