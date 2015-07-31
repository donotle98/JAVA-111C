public class QueueList<T> implements QueueInterface<T> {

	private ListInterface<T> list;
	private int maxSize, frontIndex, backIndex;

	public QueueList(int maxSize) {
		list = new AList<T>();
		this.maxSize = maxSize;
		this.frontIndex = 1;
		this.backIndex = maxSize + 1;
	}

	@Override
	public void enqueue(T newEntry) {
		list.add(newEntry);
	}

	@Override
	public T dequeue() {

		T top = null;
		if (!isEmpty()) {
			top = list.remove(frontIndex);
		}
		return top;
	}

	@Override
	public T getFront() {
		T front = null;
		if (!isEmpty())
			front = list.getEntry(frontIndex);
		return front;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();

	}

	@Override
	public void clear() {
		list.clear();

	}

	public static void main(String[] args) {
		QueueList<String> stack = new QueueList<String>(5);

		stack.enqueue("ant");
		stack.enqueue("bear");
		stack.enqueue("cat");
		stack.enqueue("dog");
		stack.enqueue("elephant");
		System.out.println(stack.isEmpty());
		System.out.println(stack.getFront());

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

		while (!stack.isEmpty()) {
			System.out.println(stack.dequeue());
		}
	}
}