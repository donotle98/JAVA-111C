//Sirinapha Dube
//Homework 9: Queues

public class Queue<T> implements QueueInterface<T> {
	
	private DequeInterface<T> deque;
	private int maxSize, currentSize;

	public Queue(int maxSize) {
		deque = new LinkedDeque<T>();
		this.maxSize = maxSize;
		this.currentSize = 0;
	}

	@Override
	public void enqueue(T newEntry) {
		if (currentSize != maxSize) {
			deque.addToBack(newEntry);
			currentSize++;
		} else {
			deque.removeFront();
			deque.addToBack(newEntry);
		}
	}

	@Override
	public T dequeue() {
		T top = null;
		if (!isEmpty()) {
			top = deque.removeFront();
			currentSize--;
		}
		return top;
	}

	@Override
	public T getFront() {
		T top = null;
		if (!isEmpty()) {
			top = deque.getFront();
		}
		return top;
	}

	@Override
	public boolean isEmpty() {
		return deque.isEmpty();
	}
	

	@Override
	public void clear() {
		deque.clear();
		currentSize = 0;

	}
	
	//Q6
	public Queue<T> splice(Queue<T> otherQueue){
				
		Queue<T> tempQueue = new Queue<T>(maxSize*2);
		
		while(!deque.isEmpty()){
			tempQueue.enqueue(deque.removeFront());
		}
		while(!otherQueue.isEmpty()){
			tempQueue.enqueue(otherQueue.dequeue());
		}
		return tempQueue;
	}
	

	public static void main(String[] args) {
		Queue<String> stack = new Queue<String>(5);
		Queue<String> stack2 = new Queue<String>(5);

		stack.enqueue("ant");
		stack.enqueue("bear");
		stack.enqueue("cat");
		stack.enqueue("dog");
		stack.enqueue("elephant");

		while (!stack.isEmpty()) {
			System.out.println(stack.dequeue());
		}
		System.out.println();

		stack.enqueue("ant");
		stack.enqueue("bear");
		stack.enqueue("cat");
		stack.enqueue("dog");
		stack.enqueue("elephant");
		stack.enqueue("frog");
		stack.enqueue("giraffe");
		

		System.out.println();
		stack2.enqueue("bird");
		stack2.enqueue("fox");
		stack2.enqueue("duck");
		
		
		
		System.out.println(stack.splice(stack2).getFront());
		
		
	}

}
