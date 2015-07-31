/**
	 * Sirinapha Dube
	 * Lab E: Stacks and Queues
	 * 
	 */

public class NoDupsPrioritizeArrayStack<T> implements StackInterface<T>,
		NoDupsPrioritizeStackInterface<T> {

	private T[] stack; // array of stack entries
	private int topIndex; // index of top entry
	private static final int DEFAULT_INITIAL_CAPACITY = 50;

	public NoDupsPrioritizeArrayStack() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	public NoDupsPrioritizeArrayStack(int initialCapacity) {
		stack = (T[]) new Object[initialCapacity];
		topIndex = -1;
	}

	public void push(T newEntry) {
		topIndex++;

		if (topIndex >= stack.length) // if array is full,
			doubleArray(); // expand array

		if (contains(newEntry) == false)
			stack[topIndex] = newEntry;
		else
			topIndex--;

	}

	private boolean contains(T newEntry) {
		boolean found = false;
		for (int i = 0; i < topIndex; i++) {
			if (newEntry.equals(stack[i])) {
				return found = true;
			}
		}
		return found;
	}

	public T peek() {
		T top = null;

		if (!isEmpty())
			top = stack[topIndex];

		return top;
	}

	public T pop() {
		T top = null;

		if (!isEmpty()) {
			top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
		}

		return top;
	}

	public boolean isEmpty() {
		return topIndex < 0;
	}

	public void clear() {
		for (; topIndex > -1; topIndex--)
			stack[topIndex] = null;
	}

	private void doubleArray() {
		T[] oldStack = stack; // get reference to array of stack entries
		int oldSize = oldStack.length; // get max size of original array

		stack = (T[]) new Object[2 * oldSize]; // double size of array

		// copy entries from old array to new, bigger array
		System.arraycopy(oldStack, 0, stack, 0, oldSize);

	}

	@Override
	public void moveToTop(T entry) {

		if (!isEmpty()) {
			T temp = stack[topIndex];
			boolean found = false;
			for (int i = 0; i < topIndex; i++) {
				if (entry.equals(stack[i])) {
					temp = stack[i];
					stack[i] = stack[i + 1];
					stack[i + 1] = temp;
					found = true;
				}
			}
			if (!found) {
				push(entry);
			}
		}
	}

	@Override
	public void display() {

		for (int i = 0; i < topIndex + 1; i++) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}
}