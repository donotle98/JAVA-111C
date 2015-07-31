/**
	 * Sirinapha Dube
	 * Lab E: Stacks and Queues
	 * 
	 */

public class LabEPartADriver {

	public static void main(String args[]) {
		NoDupsPrioritizeStackInterface<String> testStack = new NoDupsPrioritizeArrayStack<String>();
		
		/* first test that it still functions like a normal stack */
		System.out.println("Testing basic stack behavior:");
		System.out.println("Stack is currently empty: " + testStack.isEmpty());
		testStack.push("ants");
		testStack.push("baboons");
		testStack.push("dogs");
		testStack.push("cockroaches");
		testStack.push("elephants");
		System.out.println("Stack is currently empty: " + testStack.isEmpty());
		System.out.println("The stack should be: \nBottom ants baboons dogs cockroaches elephants Top");
		testStack.display();

		System.out.println("Should be popping elephants: " + testStack.pop());
		System.out.println("Should be popping cockroaches: " + testStack.pop());
		System.out.println("Should be popping dogs: " + testStack.pop());
		System.out.println("Should be popping baboons: " + testStack.pop());
		System.out.println("Should be popping ants: " + testStack.pop());
		System.out.println("Stack is currently empty: " + testStack.isEmpty());
		
		/* next test that it won't add duplicates */
		System.out.println("\nTesting no duplicate functionality:");
		testStack.push("ants");
		testStack.push("baboons");
		testStack.push("dogs");
		testStack.push("cockroaches");
		testStack.push("elephants");
		System.out.println("The stack should be: \nBottom ants baboons dogs cockroaches elephants Top");
		testStack.display();
		System.out.println();
		testStack.push("dogs");
		System.out.println("The stack should be: \nBottom ants baboons dogs cockroaches elephants Top");
		testStack.display();
		System.out.println();
		
		/* finally test the moveToTop method */
		System.out.println("\nTesting prioritization:");
		testStack.moveToTop("dogs"); // middle element
		System.out.println("The stack should be: \nBottom ants baboons cockroaches elephants dogs Top");
		System.out.println();
		testStack.display();
		testStack.moveToTop("ants"); // bottom element
		System.out.println("The stack should be: \nBottom baboons cockroaches elephants dogs ants Top");
		testStack.display();
		System.out.println();
		testStack.moveToTop("ants"); // top element
		System.out.println("The stack should be: \nBottom baboons cockroaches elephants dogs ants Top");
		testStack.display();
		testStack.moveToTop("ants"); // top element
		System.out.println("The stack should be: \nBottom baboons cockroaches elephants dogs ants Top");
		testStack.display();
		System.out.println();
		testStack.moveToTop("frogs"); // element not currently in stack
		System.out.println("The stack should be: \nBottom baboons cockroaches elephants dogs ants frogs Top");
		testStack.display();
		
		
		

	}

}