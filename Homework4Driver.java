import java.util.*;

public class Homework4Driver {

	public static void main(String[] args) {
		
		int arraySize = 5;
		int[] numbers = new int[arraySize];
		fillWithUnique(numbers);
		System.out.println("The array is: " + Arrays.toString(numbers));

		Date current = new Date();
		long startTime = current.getTime();
		System.out.println("The missing integer is " + findMissingIntegerN(numbers));
		current = new Date();
		long stopTime = current.getTime();
		long elapsedTime = stopTime - startTime;
		System.out.println("The linear method took " + elapsedTime + " milliseconds.");
		
		startTime = current.getTime();
		System.out.println("The missing integer is " + findMissingIntegerN2(numbers));
		current = new Date();
		stopTime = current.getTime();
		elapsedTime = stopTime - startTime;
		System.out.println("The quadratic method took " + elapsedTime + " milliseconds.");
		
		int[] posNegNumbers = new int[arraySize];
		fillWithPosNeg(posNegNumbers);
		System.out.println(Arrays.toString(posNegNumbers));
		arrangeNegBeforePositive(posNegNumbers);
		System.out.println(Arrays.toString(posNegNumbers));
		
	}
	
	private static int findMissingIntegerN(int[] numbers) {
		int n = numbers.length;
		int i, missingNumber;
		missingNumber  = (n+1)*(n+2)/2;   
		    for ( i = 0; i< n; i++)
		    	missingNumber -= numbers[i];
		    return missingNumber;
	}
	

	private static int findMissingIntegerN2(int[] numbers) {
		int missingNumber = 0;
		
		for(int i=1; i<=numbers.length+1; i++) { // loop is dependent on the size of the array
			
			boolean found = false;
			for(int j=0; j < numbers.length; j++) {
				if (!found && i == numbers[j]){
					found = true;					
				}
			}
			if (!found)
				missingNumber = i;
		}
		return missingNumber;
	}
	
	public static void arrangeNegBeforePositive(int[] array) {
		int i, temp;
		boolean found = true;
		
		while (found){
			found = false;
			for(i=0;  i < array.length -1; i++) {
	             if (array[i] > array[i+1]) {
	                temp = array[i];     
	                array[i] = array[i+1];
	                array[i+1] = temp;

	                found = true;           
	            }
	          }
	        } 
	        System.out.println(Arrays.toString(array));
	   }
		
	
	// fills the array with unique values from 1 to n+1 with one missing value
	private static void fillWithUnique(int[] numbers) {
		
		ArrayList<Integer> possibleValues = new ArrayList<Integer>();
		for(int i=1; i<=(numbers.length+1); i++) {
			possibleValues.add(i); // fill an array list with all values 1 to n+1
		}
		Collections.shuffle(possibleValues); // randomize the order
		
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = possibleValues.get(i); // fill the array with the first n values (will leave one value missing)
		}
	}
	
	private static void fillWithPosNeg(int[] numbers) {
		Random generator = new Random();
		for(int i=0; i<numbers.length; i++) {
			int number = generator.nextInt(101) - 50; // will fill with a random number in the range -50 to 50
			numbers[i] = number;
		}
	}
}
