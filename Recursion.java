// Homework 5: Recursion

import java.util.*;

public class Homework5Driver {

	public static void main(String[] args) {
		
		// printBackwards1 and printBackwards2 driver
		String s = "stressed";
		System.out.print(s + " backwards is ");
		printBackwards1(s);
		System.out.println();
		System.out.print(s + " backwards is still ");
		printBackwards2(s);
		System.out.println();
		
		//isPalindrome driver
		String p = "anna";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "ana";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "a";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "amanaplanacanalpanama";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "ababb";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "ab";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		System.out.println();
		
		//sumArray1 and sumArray2 driver
		int arraySize = 10;
		int[] numsToSum = new int[arraySize];
		for (int i = 0; i < arraySize; i++)
			numsToSum[i] = i * 3;

		int sum1 = sumArray1(numsToSum, 0, arraySize - 1);
		int sum2 = sumArray2(numsToSum, 0, arraySize - 1);
		System.out.println("The sum of the array with all three methods should be the same: ");
		System.out.println(sum1);
		System.out.println(sum2);
		
		// findSmallest driver
		int[] randomNums = new int[arraySize];
		Random generator = new Random();
		for(int i=0; i<randomNums.length; i++) {
			randomNums[i] = generator.nextInt(100);
		}
		System.out.print("Here are the numbers in the array:\t");
		for(int i=0; i<randomNums.length; i++) {
			System.out.print(randomNums[i] + "  ");
		}
		System.out.println();
		int smallest = findSmallest(randomNums);
		System.out.println("The smallest element is " + smallest);

		
		
		System.out.println("ArrayBag");
		ArrayBag<Integer> numbersArrayBag = new ArrayBag<Integer>();
		numbersArrayBag.add(1);
		numbersArrayBag.add(2);
		numbersArrayBag.add(1);
		numbersArrayBag.add(4);
		numbersArrayBag.add(3);
		System.out.println("The bag contains[1, 2, 1, 4, 3] \n\t\t"	+ Arrays.toString(numbersArrayBag.toArray()));
		System.out.println("Should be 2: " + numbersArrayBag.getFrequencyOf(1));
		System.out.println("Should be 1: " + numbersArrayBag.getFrequencyOf(4));
		System.out.println("Should be 0: " + numbersArrayBag.getFrequencyOf(5));
		
		
		System.out.println("LinkedBag");
		LinkedBag<Integer> numbersLinkedBag = new LinkedBag<Integer>();
		numbersLinkedBag.add(1);
		numbersLinkedBag.add(2);
		numbersLinkedBag.add(1);
		numbersLinkedBag.add(4);
		numbersLinkedBag.add(3);
		System.out.println("The bag contains[3, 4, 1, 2, 1] \n\t\t"	+ Arrays.toString(numbersLinkedBag.toArray()));
		System.out.println("Should be 2: " + numbersLinkedBag.getFrequencyOf(1));
		System.out.println("Should be 1: " + numbersLinkedBag.getFrequencyOf(4));
		System.out.println("Should be 0: " + numbersLinkedBag.getFrequencyOf(5));		
		
	
		
		//sumList driver
		ListInterface<Integer> numbersList = new AList<Integer>(); 
		numbersList.add(4);
		numbersList.add(1);
		numbersList.add(3);
		numbersList.add(2);
		numbersList.add(0);
		numbersList.add(9);
		
		System.out.println("Sum is 19: " + sumList(numbersList));
		
		////countPositives driver by use ArrayBag and LinkedBag!
		BagInterface<Integer> numbersBag = new ArrayBag<Integer>(); 
		numbersBag.add(2);
		numbersBag.add(-1);
		numbersBag.add(3);
		numbersBag.add(5);
		numbersBag.add(-2);
		numbersBag.add(-4);
		numbersBag.add(1);
		System.out.println("The bag contains[2, -1, 3, 5, -2, -4, 1] \n\t\t"	+ Arrays.toString(numbersBag.toArray()));
		System.out.println("There are 4 positives: " + countPositives(numbersBag));
		System.out.println("The bag still contains  [2, -1, 3, 5, -2, -4, 1] \n\t\t\t"	+ Arrays.toString(numbersBag.toArray()));
	}
	//printBackwards1 
	public static void printBackwards1(String s) {
		char c = s.charAt(s.length()-1);
        	
        	if(s.length() <= 1) {
        		System.out.print(c);
        	} 
        	else{
        		System.out.print(c);
        		printBackwards1(s.substring(0,s.length()-1));
		}
	}

	//printBackwards2 
	public static void printBackwards2(String s) {
		char c = s.charAt(0);
		if (s.length()<=1){
			System.out.print(c);
		} 
		else {
			printBackwards2(s.substring(1));
			System.out.print(c);
		}
	}

	//isPalindrome
	public static boolean isPalindrome(String s) {
		
		int n = s.length();
		if(n<2) return true;
			if(s.charAt(0)!=s.charAt(n-1)) 
			return false;
		return isPalindrome(s.substring(1, n-1));
	}

	//sumArray1
	public static int sumArray1(int[] array, int first, int last) {
		if(first == last){
			return (array[first]);
		}
		else {
			return array[first] + sumArray1(array,first +1, last);
		}
	}

	//sumArray2
	public static int sumArray2(int[] array, int first, int last) {	
		if(first == last){
			return (array[first]);
		} 
		else {
			int mid = (first + last) / 2;
			return sumArray2(array,first, mid) + sumArray2(array, mid+1, last);
		}
	}

	//findSmallest
	public static int findSmallest(int[] numbers) {
		return findSmallestHelper(numbers, 0, numbers.length);
	}

	private static int findSmallestHelper(int[] numbers, int first, int last){
		if (first == last){
			return first;
		} 
		else {
			 int min = findSmallestHelper(numbers, first+ 1, last);
		        if (numbers[first] > min) {
		            return min;
		        } 
		        else {
		            return numbers[first];
		        }
		    }       
	}
	
	
	//sumList
	public static int sumList(ListInterface<Integer> list) {
		return sumListHelper(list, 1, list.getLength());
	}
	
	private static int  sumListHelper(ListInterface<Integer> list, int start, int end) {
		if(start  == end){
			return list.getEntry(start);			 
		} 
		else {
			return  list.getEntry(start)+ sumListHelper(list, start + 1,end);
		}
	}
	
	//countPositives
	public static int countPositives(BagInterface<Integer> bag) {
		Object[] tempBag = bag.toArray();
		return countPositivesHelper ( (Object[]) tempBag, 0, tempBag.length-1);
	}
	
	private static int countPositivesHelper (Object []tempBag, int start, int end){
		 if (start == end) {   
             		if ((Integer)tempBag [start] > 0) {      
                  		return 1;
        	 	}
        	 	else {
                  		return 0;      
         		} 
		 }
         	else {
           		if ((Integer)tempBag[start] > 0) {         	   
        			 return  1 + countPositivesHelper(tempBag, start +1, end); 
           		}
           		else {      
               			return countPositivesHelper(tempBag, start +1, end);
        		}
    		}
	}





