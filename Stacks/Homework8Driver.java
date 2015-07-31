//Sirinapha Dube
//Homework 8


import java.util.*;

public class Homework8Driver {

    public static void main(String[] args) {   
    	        
        // Q6 print in order
        StackInterface s = new LinkedStack();
        System.out.println("Q6");
        System.out.println("Should print cat, dog, hamster, zebra");
        s.push("cat");
        s.push("dog");
        s.push("hamster");
        s.push("zebra");
        printInAddOrder(s);
        System.out.println();
    	
        // Q7 palindromes     	 
        System.out.println("Q7");
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
		
		// Q8 fibonacci numbers
		System.out.println("Q8");
		int fibNum = 9;
    	System.out.println("Fib recursive should be the same as Fib using stacks (" + fibonacciRecursive(fibNum)  +
    			"): " + fibonacciStack(fibNum));
    	System.out.println();
    	
    	// Q9 display methods
    	System.out.println("Q9");
    	LinkedStack<String> displayLinkedStack = new LinkedStack();
    	System.out.println("Should give a message that the stack is empty.");
    	displayLinkedStack.display();
    	displayLinkedStack.push("Alaska");
    	displayLinkedStack.push("Delaware");
    	displayLinkedStack.push("Iowa");
    	displayLinkedStack.push("New York");
    	System.out.println("Should print New York, Iowa, Delaware, Alaska");
    	displayLinkedStack.display();
    	
    	ArrayStack<String> displayArrayStack = new ArrayStack();
    	System.out.println("Should give a message that the stack is empty.");
    	displayArrayStack.display();
    	displayArrayStack.push("California");
    	displayArrayStack.push("Florida");
    	displayArrayStack.push("Georgia");
    	displayArrayStack.push("Hawaii");
    	System.out.println("Should print Hawaii, Georgia, Florida, California");
    	displayArrayStack.display();
    	System.out.println();
    	
    	
    	// Q10EC peek2 in LinkedStack
    	
    	System.out.println("Q10EC");
    	LinkedStack peekStackLinked = new LinkedStack();
    	System.out.println("Should print null: " + peekStackLinked.peek2());
    	peekStackLinked.push("hello");
    	System.out.println("Should print null: " + peekStackLinked.peek2());
    	peekStackLinked.push("goodbye");
    	System.out.println("Should print hello: " + peekStackLinked.peek2());
    	peekStackLinked.push("and good night");
    	System.out.println("Should print goodbye: " + peekStackLinked.peek2());
    	System.out.println();
    	
    	
    	//Q11EC peek2 in ArrayStack
    	
    	
    	
    	System.out.println("Q11EC");
    	ArrayStack peekStackArray = new ArrayStack();
    	System.out.println("Should print null: " + peekStackArray.peek2());
    	peekStackArray.push("hello");
    	System.out.println("Should print null: " + peekStackArray.peek2());
    	peekStackArray.push("goodbye");
    	System.out.println("Should print hello: " + peekStackArray.peek2());
    	peekStackArray.push("and good night");
    	System.out.println("Should print goodbye: " + peekStackArray.peek2());
    	System.out.println();
    	 	
    	
    	StackInterface stack = new LinkedStack();

		stack.push(6);
		stack.push(5);
		stack.push(4);
		
		
		
		

		System.out.println(howManyMultiples(stack,9));
		
    }       
    
    // Q6 print in order
	public static void printInAddOrder(StackInterface stack) {
		ArrayList<String> myArray = new ArrayList<String>();
		StackInterface stack1 = new LinkedStack();

		while (!stack.isEmpty()) {
			stack1.push(stack.pop());
			myArray.add((String) stack1.pop());
		}
		Collections.reverse(myArray);
		System.out.print(myArray);

	}
	
	public QueueInterface<Integer> mergeQueueStack(QueueInterface<Integer> queue, StackInterface<Integer> stack){
   		
		StackInterface stack1 = new LinkedStack();
		
		while(!stack.isEmpty()){
			stack1.push(stack.pop());
		}
		while(!queue.isEmpty()){
			stack1.push(queue.dequeue());
		}	
		
   		return (QueueInterface<Integer>) stack1;
   	}
	
	
	
	public static int howManyMultiples(StackInterface<Integer> s, Integer multiple) {
		ArrayList<Integer> myArray = new ArrayList<Integer>();

		int count = 0;
		while (!s.isEmpty()) {
			myArray.add((Integer) s.pop());
		}
		for (int i = 0; i < myArray.size(); i++) {
			int j = myArray.get(i);
			if (j % multiple == 0) {
				count++;
			}
		}

		return count;
	}
	
   	public int stackSize(StackInterface stack){
   		StackInterface temp = new LinkedStack();
   		int counter = 0;
   		
   		while(!stack.isEmpty()){
   			temp.push(stack.pop());
   			counter++;
   		}
   		
   		return counter;
   	}
   	
   	
    
 // Q7 palindromes  
	public static boolean isPalindrome(String s) {

		StackInterface stack1 = new LinkedStack();

		for (int i = 0; i < s.length(); ++i) {
			stack1.push(s.charAt(i));

		}
		for (int i = 0; i < s.length(); ++i) {
			char c1 = (Character) stack1.pop();
			if (c1 != s.charAt(i)) {
				return false;
			}
			return true;
		}
		return false;
	}
    
 // Q8 fibonacci numbers
    public static int fibonacciRecursive(int n) {
    	if(n==1 || n ==2) {
    		return 1;
    	} else {
    		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    	}
    }

	public static int fibonacciStack(int n) {
		StackInterface<Integer> stack = new LinkedStack<Integer>();
		int top = 0, buttom = 1, next = 1;
		stack.push(buttom);
		stack.push(top);

		for (int i = 0; i < n; i++) {
			top = stack.pop();
			buttom = stack.pop();
			next = top + buttom;
			stack.push(top);
			stack.push(next);
		}
		return next;
	}
}