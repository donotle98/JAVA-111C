
public class StackInfinitePush<T> implements StackInterface<T> {
	
	private DequeInterface<T> deque; // front of the deque is the top of the stack
	private int maxSize, currentSize;
	
	public StackInfinitePush(int maxSize) {
		deque = new LinkedDeque<T>();
		this.maxSize = maxSize;
		this.currentSize = 0;
	}

	public void push(T newEntry) {
		if(currentSize == maxSize) { // stack has reached the number of elements it can store
			deque.removeBack(); // drop an element from the bottom of the stack
			deque.addToFront(newEntry);
		} else {
			deque.addToFront(newEntry);
			currentSize++;
		}
	}

	public T pop() {
		T top = null;
		
		if(!isEmpty()) {
			top = deque.removeFront();
			currentSize--;
		}
		return top;
	}

	public T peek() {
		T top = null;
		
		if(!isEmpty()) {
			top = deque.getFront();
		}
		return top;
	}
	
	public boolean isEmpty() {
		return deque.isEmpty();
	}

	
	public void clear() {
		deque.clear();
		currentSize = 0;
	}

	public static void main(String[] args) {
		StackInfinitePush stack = new StackInfinitePush(5);
		
		stack.push("ant");
		stack.push("bear");
		stack.push("cat");
		stack.push("dog");
		stack.push("elephant");
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		System.out.println();
		
		stack.push("ant");
		stack.push("bear");
		stack.push("cat");
		stack.push("dog");
		stack.push("elephant");
		stack.push("frog");
		stack.push("giraffe");
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
}
