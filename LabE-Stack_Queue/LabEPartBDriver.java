/**
	 * Sirinapha Dube
	 * Lab E: Stacks and Queues
	 * 
	 */

public class LabEPartBDriver {

	public static void main(String args[]) {
		NoDupsDePrioritizeQueueInterface<String> testQueue = new NoDupsDePrioritizeArrayQueue<String>();
		
		/* first test that it still functions like a normal stack */
		System.out.println("Testing basic queue behavior:");
		System.out.println("Queue is currently empty: " + testQueue.isEmpty());
		testQueue.enqueue("ants");
		testQueue.enqueue("baboons");
		testQueue.enqueue("dogs");
		testQueue.enqueue("cockroaches");
		testQueue.enqueue("elephants");
		System.out.println("Queue is currently empty: " + testQueue.isEmpty());
		System.out.println("The queue should be: \nFront ants baboons dogs cockroaches elephants Back");
		testQueue.display();

		System.out.println("Should be dequeuing ants: " + testQueue.dequeue());
		System.out.println("Should be dequeuing baboons: " + testQueue.dequeue());
		System.out.println("Should be dequeuing dogs: " + testQueue.dequeue());
		System.out.println("Should be dequeuing cockroaches: " + testQueue.dequeue());
		System.out.println("Should be dequeuing elephants: " + testQueue.dequeue());
		System.out.println("Queue is currently empty: " + testQueue.isEmpty());
		
		/* next test that it won't add duplicates */
		System.out.println("\nTesting no duplicate functionality:");
		testQueue.enqueue("ants");
		testQueue.enqueue("baboons");
		testQueue.enqueue("dogs");
		testQueue.enqueue("cockroaches");
		testQueue.enqueue("elephants");
		System.out.println("The queue should be: \nFront ants baboons dogs cockroaches elephants Back");
		testQueue.display();
		testQueue.enqueue("dogs");
		System.out.println("The queue should be: \nFront ants baboons dogs cockroaches elephants Back");
		testQueue.display();
		
		/* finally test the moveToTop method */
		System.out.println("\nTesting de-prioritization:");
		testQueue.moveToBack("dogs"); // middle element
		System.out.println("The queue should be: \nFront ants baboons cockroaches elephants dogs Back");
		testQueue.display();
		testQueue.moveToBack("ants"); // bottom element
		System.out.println("The queue should be: \nFront baboons cockroaches elephants dogs ants Back");
		testQueue.display();
		testQueue.moveToBack("ants"); // top element
		System.out.println("The queue should be: \nFront baboons cockroaches elephants dogs ants Back");
		testQueue.display();
		testQueue.moveToBack("frogs"); // element not currently in stack
		System.out.println("The queue should be: \nFront baboons cockroaches elephants dogs ants frogs Back");
		testQueue.display();
		
		
		

	}

}