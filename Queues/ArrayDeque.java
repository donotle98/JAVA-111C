
public class ArrayDeque<T> implements DequeInterface<T> {

		private T[] deque; // circular array of queue entries and one unused location
		private int frontIndex;
		private int backIndex;

		private static final int DEFAULT_INITIAL_CAPACITY = 50;

		public ArrayDeque() {
			this(DEFAULT_INITIAL_CAPACITY);
		}

		public ArrayDeque(int initialCapacity) {
			deque = (T[]) new Object[initialCapacity + 1];
			frontIndex = 0;
			backIndex = initialCapacity;
		} 

		public void addToBack(T newEntry) { // same code as enqueue method
			if (isArrayFull()) 
				doubleArray(); 

			backIndex = (backIndex + 1) % deque.length;
			deque[backIndex] = newEntry;
		}
		public void addToFront(T newEntry) {
			if (isArrayFull()) 
				doubleArray();
			
			frontIndex = Math.abs(frontIndex - 1) % deque.length;
			
			deque[backIndex] = newEntry;
			
		}
		public T getFront() { // same as in ArrayQueue
			T front = null;

			if (!isEmpty())
				front = deque[frontIndex];

			return front;
		}
		public T getBack() {
			T back = null;
			
			if(!isEmpty()) {
				back = deque[backIndex];
			}
			return back;
		}
		
		public T removeFront() { // same as dequeue
			T front = null;

			if (!isEmpty()) {
				front = deque[frontIndex];
				deque[frontIndex] = null;
				frontIndex = (frontIndex + 1) % deque.length;
			} 

			return front;
		} 
		public T removeBack() {
			T back = null;
			if(!isEmpty()) {
				back = deque[backIndex];
				deque[backIndex] = null;
				backIndex = Math.abs(backIndex - 1) % deque.length;
			}
			return back;
		}
		public boolean isEmpty() {
			return frontIndex == ((backIndex + 1) % deque.length);
		} 

		public void clear() {
			if (!isEmpty()) { // deallocates only the used portion
				for (int index = frontIndex; index != backIndex; index = (index + 1) % deque.length) {
					deque[index] = null;
				} 
				deque[backIndex] = null;
			} 
			frontIndex = 0;
			backIndex = deque.length - 1;
		} 

		private boolean isArrayFull() {
			return frontIndex == ((backIndex + 2) % deque.length);
		} 

		private void doubleArray() {
			T[] oldQueue = deque;
			int oldSize = oldQueue.length;

			deque = (T[]) new Object[2 * oldSize];

			for (int index = 0; index < oldSize - 1; index++) {
				deque[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			} 

			frontIndex = 0;
			backIndex = oldSize - 2;
		} 
		public static void main(String[] args) {
			System.out.println("Create a deque: ");
			DequeInterface<String> dq1 = new LinkedDeque<String>();
			DequeInterface<String> dq2 = new LinkedDeque<String>();;
			//System.out.println("\n\nisEmpty() returns " + myDeque.isEmpty() + "\n");

			
			
			
			dq1.addToBack("b");

			dq1.addToFront("d");

			dq1.addToFront("a");

			dq2.addToBack("e");

			dq2.addToFront("c");

			dq1.addToBack(dq2.removeBack());

			dq1.addToFront(dq2.getBack());

			dq2.addToBack(dq1.getFront());

			dq1.removeFront();
			
			System.out.println(dq1.getFront());
			System.out.println(dq1.getBack());
			
			System.out.println(dq2.getFront());
			System.out.println(dq2.getBack());
			
			
			/*System.out.println("Add to front and back of deque to get\n"
					+ "Joe Jess Jim Jill Jane Jerry\n");
			myDeque.addToFront("Jim");
			myDeque.addToFront("Jess");

			myDeque.addToBack("Jill");
			myDeque.addToBack("Jane");

			myDeque.addToFront("Joe");
			myDeque.addToBack("Jerry");

			System.out.println("\nisEmpty() returns " + myDeque.isEmpty() + "\n");

			System.out
					.println("\n\nTesting getFront, getBack, removeFront, removeBack:\n");
			String front, back;
			front = myDeque.getFront();
			System.out.println(front + " is at the front of the deque.");

			back = myDeque.getBack();
			System.out.println(back + " is at the back of the deque.");

			front = myDeque.removeFront();
			System.out.println(front + " is removed from the front of the deque.");

			back = myDeque.removeBack();
			System.out.println(back + " is removed from the back of the deque.");

			front = myDeque.getFront();
			System.out.println(front + " is at the front of the deque.");

			back = myDeque.getBack();
			System.out.println(back + " is at the back of the deque.");

			System.out.println("\n\nTesting clear:\n");
			myDeque.clear();
			System.out.println("\nisEmpty() returns " + myDeque.isEmpty() + "\n\n");

			front = myDeque.removeFront();
			if (front == null)
				System.out.println("removeFront correctly finds deque empty");
			else
				System.out.println("removeFront incorrectly finds queue not empty");

			front = myDeque.removeBack();
			if (front == null)
				System.out.println("removeBack correctly finds deque empty");
			else
				System.out.println("removeBack incorrectly finds queue not empty");
		} // end main */
		}
}
