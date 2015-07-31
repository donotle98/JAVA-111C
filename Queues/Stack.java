//Sirinapha Dube
//Homework 9: Queues

public class Stack<T> implements StackInterface<T>{
	private DequeInterface<T> deque;
		
	public Stack(int maxSize) {
		deque = new LinkedDeque<T>();		
	}

	@Override
	public void push(T newEntry) {
		deque.addToFront(newEntry);
	}

	public T pop() {
		T top = null;		
		if(!isEmpty()) {
			top = deque.removeFront();			
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
		
	}
	
	
	public static void main(String[] args) {
		StackInfinitePush stack = new StackInfinitePush(5);
		
		stack.push("ant");
		stack.push("bear");
		stack.push("cat");
		stack.push("dog");
		stack.push("elephant");
		System.out.println(stack.peek());
		System.out.println();
		
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

