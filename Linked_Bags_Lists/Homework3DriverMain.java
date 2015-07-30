import java.util.Arrays;



public class Homework3DriverMain {

	public static void main(String[] args) {

		// setting up an LinkedBag to test
		System.out.println("TESTING BAG");
		LinkedBag<Integer> numbersBag = new LinkedBag<Integer>();
		numbersBag.add(1);
		numbersBag.add(2);
		numbersBag.add(1);
		numbersBag.add(4);
		numbersBag.add(3);
		System.out.println("The bag contains[3, 4, 1, 2, 1]  (any order)\n\t\t" + Arrays.toString(numbersBag.toArray()));
		
		// Q1 replace method
		// NOTE: The description does not specify which element to replace, 
		// so your output might be different- that's okay
		numbersBag.replace(6);
		System.out.println("The bag contains[6, 4, 1, 2, 1]  (any order)\n\t\t" + Arrays.toString(numbersBag.toArray()));
		numbersBag.replace(8);
		System.out.println("The bag contains[8, 4, 1, 2, 1]  (any order)\n\t\t" + Arrays.toString(numbersBag.toArray()));
	
		// Q2 getMax and removeMax methods
		System.out.println("The max in the bag is 8: " + numbersBag.getMax());
		numbersBag.removeMax();
		System.out.println("The bag contains[4, 1, 2, 1]  (any order)\n\t\t" + Arrays.toString(numbersBag.toArray()));
		numbersBag.add(4);
		System.out.println("The bag contains[4, 4, 1, 2, 1]  (any order)\n\t\t" + Arrays.toString(numbersBag.toArray()));
		System.out.println("The max in the bag is 4: " + numbersBag.getMax());
		numbersBag.removeMax();
		System.out.println("The bag contains[4, 1, 2, 1]  (any order)\n\t\t" + Arrays.toString(numbersBag.toArray()));
		
		// Q3 union
		LinkedBag<Integer> firstBag = new LinkedBag<Integer>();
		firstBag.add(8);
		firstBag.add(2);
		firstBag.add(4);
		firstBag.add(5);
		firstBag.add(6);
		firstBag.add(2);
		LinkedBag<Integer> secondBag = new LinkedBag<Integer>();
		secondBag.add(3);
		secondBag.add(1);
		secondBag.add(2);
		BagInterface<Integer> unionBag = firstBag.union(secondBag);
		System.out.println("Bag1 contains   [2, 6, 5, 4, 2, 8]  (any order)\n\t\t" + Arrays.toString(firstBag.toArray()));
		System.out.println("Bag2 contains   [2, 1, 3]  (any order)\n\t\t" + Arrays.toString(secondBag.toArray()));
		System.out.println("Union Bag contains [3, 1, 2, 8, 2, 4, 5, 6, 2] (any order) \n\t\t   " + Arrays.toString(unionBag.toArray()));
		
		
		// setting up LList to test
		System.out.println("\nTESTING LIST");
		LList <String> produceList = new LList <String>();
		String[] stringArray = {"banana", "date", "grape", "eggplant", "jicama", "grape"};

		// Q4 addAll method
		produceList.addAll(stringArray);
		System.out.println("The list contains[banana, date, grape, eggplant, jicama, grape] \n\t\t " + Arrays.toString(produceList.toArray()));
		
		// Q5 getPosition method
		System.out.println("Position is 1: " + produceList.getPosition("banana"));
		System.out.println("Position is 3: " + produceList.getPosition("grape"));
		System.out.println("Position is -1: " + produceList.getPosition("mango"));

		// Q6 remove(T) method
		System.out.println("Result is false: " + produceList.remove("pear"));
		System.out.println("Result is true: " + produceList.remove("date"));
		System.out.println("The list contains[banana, grape, eggplant, jicama, grape] \n\t\t " + Arrays.toString(produceList.toArray()));
		System.out.println("Result is true: " + produceList.remove("grape"));
		System.out.println("The list contains[banana, eggplant, jicama, grape] \n\t\t " + Arrays.toString(produceList.toArray()));
		produceList.remove("banana");
		produceList.remove("eggplant");
		produceList.remove("jicama");
		produceList.remove("grape");
		produceList.remove("something");
		System.out.println("The list is empty \n\t\t " + Arrays.toString(produceList.toArray()));
		
		// Q7 removeAll method
		produceList.add("banana");
		produceList.add("eggplant");
		produceList.add("jicama");
		produceList.add("eggplant");
		produceList.add("grape");
		produceList.add("eggplant");		
		System.out.println("Result is false: " + produceList.removeAll("pear"));
		System.out.println("Result is true: " + produceList.removeAll("eggplant"));
		System.out.println("The list contains[banana, jicama, grape] \n\t\t " + Arrays.toString(produceList.toArray()));
		

		// setting up Nodes to test
		/*System.out.println("\nTESTING NODES");
		
		Node<Integer> node5 = new Node<Integer>(new Integer(6));
		Node<Integer> node4 = new Node<Integer>(new Integer(4), node5);
		Node<Integer> node3 = new Node<Integer>(new Integer(2), node4);
		Node<Integer> node2 = new Node<Integer>(new Integer(8), node3);
		Node<Integer> node1 = new Node<Integer>(new Integer(3), node2);
		// sets up the chain 3 -> 8 -> 2 -> 4 -> 6
		
		// Q8 print every other
		System.out.println("Should print 3, 2, 6");
		printEveryOther(node1);
		node5.next = new Node<Integer>(new Integer(11));
		// sets up the chain 3 -> 8 -> 2 -> 4 -> 6 -> 11
		System.out.println("Should still print 3, 2, 6");
		printEveryOther(node1);
		
		// Q9 determine if divisible 
		System.out.println("Are all divisible by 2? false: " + isDivisibleBy(node1, 2));
		node1.data = 4;
		// sets up the chain 4 -> 8 -> 2 -> 4 -> 6 -> 11		
		System.out.println("Are all divisible by 2? false: " + isDivisibleBy(node1, 2));
		node5.next.data = 6;
		// sets up the chain 3 -> 8 -> 2 -> 4 -> 6 -> 6		
		System.out.println("Are all divisible by 2? true: " + isDivisibleBy(node1, 2));

	}
	public static void printEveryOther(Node firstNode) {
		Node temp = (Node) firstNode.data;
		while(temp != null){
			System.out.println(firstNode.data);
			temp = temp.next;
		}
	}
	public static boolean isDivisibleBy(Node<Integer> firstNode, int divisor) {
		// YOUR CODE HERE
		return true;
	}
	private class Node<T> {
		private T data; // Entry in bag
		private Node next; // Link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor
	} // end Node*/
}
}