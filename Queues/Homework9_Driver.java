import java.util.ArrayList;

//Sirinapha Dube
//Homework 9: Queues

public class Homework9_Driver {

    public static void main(String[] args) {   
    	        
       
        DequeInterface s = new LinkedDeque();
       
    	
            	 
        System.out.println("Q5");
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
		
		QueueList<Integer> stack = new QueueList<Integer>(5);

		stack.enqueue(10);
		stack.enqueue(5);
		stack.enqueue(9);
		stack.enqueue(22);
		stack.enqueue(11);
		System.out.println(stack.isEmpty());
		System.out.println(stack.getFront());

		System.out.println(minQ(stack));
		
    }
    
    // Q5 palindromes  
   	public static boolean isPalindrome(String s) {

   		DequeInterface dq1 = new LinkedDeque();

   		for (int i = 0; i < s.length(); ++i) {
   			dq1.addToBack(s.charAt(i));
   		}
   		for (int i = 0; i < s.length(); ++i) {
   			char c1 = (Character) dq1.removeBack();
   			if (c1 != s.charAt(i)) {
   				return false;
   			}
   			return true;
   		}
   		return false;
   	}
   	
   	
	public static Integer minQ(QueueInterface<Integer> q) {

		ArrayList<Integer> myArray = new ArrayList<Integer>();

		while (!q.isEmpty()) {
			myArray.add((Integer) q.dequeue());
		}

		int min = myArray.size();
		for (int i = 0; i < myArray.size(); i++) {
			int j = myArray.get(i);
			if (j < min) {
				min = j;
			}
		}

		return min;
	}
   	
   	
   	
   	
   
   	
   	
   	public <T> void splice(ArrayQueue<T> otherQueue) {

		QueueInterface<T> temp = new LinkedQueue<T>();
		while (!otherQueue.isEmpty()) {
			//enqueue(otherQueue.getFront());
			temp.enqueue(otherQueue.dequeue());
		}
		while(!temp.isEmpty()){
			otherQueue.enqueue(temp.dequeue());
		}
	}
}

