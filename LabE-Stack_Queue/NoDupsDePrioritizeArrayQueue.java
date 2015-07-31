

	/**
	 * Sirinapha Dube
	 * Lab E: Stacks and Queues
	 * 
	 */
	public class NoDupsDePrioritizeArrayQueue<T> implements QueueInterface<T>,NoDupsDePrioritizeQueueInterface <T> {

		
		private T[] queue; // circular array of queue entries and one unused location
		private int frontIndex;
		private int backIndex;
		private static final int DEFAULT_INITIAL_CAPACITY = 5;

		public NoDupsDePrioritizeArrayQueue() {
			this(DEFAULT_INITIAL_CAPACITY);
		} 

		public NoDupsDePrioritizeArrayQueue(int initialCapacity) {
			queue = (T[]) new Object[initialCapacity + 1];
			frontIndex = 0;
			backIndex = initialCapacity;
		} 


	public void enqueue(T newEntry) {
		if (isArrayFull())
			doubleArray();

		if (contains(newEntry) == false) {
			backIndex = (backIndex + 1) % queue.length;
			queue[backIndex] = newEntry;
		} 

	}
	
		private boolean contains(T newEntry){
			boolean found = false;
			
			for(int i =frontIndex; i< queue.length; i++){
				if(newEntry.equals(queue[i])){
				return found = true;
				}
			}return found;
		}
		
		public T getFront() {
			T front = null;

			if (!isEmpty())
				front = queue[frontIndex];

			return front;
		} 

		public T dequeue() {
			T front = null;

			if (!isEmpty()) {
				front = queue[frontIndex];
				queue[frontIndex] = null;
				frontIndex = (frontIndex + 1) % queue.length;
			} 

			return front;
		} 


		public boolean isEmpty() {
			return frontIndex == ((backIndex + 1) % queue.length);
		} 


		public void clear() {
			if (!isEmpty()) { // deallocates only the used portion
				for (int index = frontIndex; index != backIndex; index = (index + 1)
						% queue.length) {
					queue[index] = null;
				} 

				queue[backIndex] = null;
			} 

			frontIndex = 0;
			backIndex = queue.length - 1;
		} 



		private boolean isArrayFull() {
			return frontIndex == ((backIndex + 2) % queue.length);
		} 


		private void doubleArray() {
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;

			queue = (T[]) new Object[2 * oldSize];

			for (int index = 0; index < oldSize - 1; index++) {
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			} 

			frontIndex = 0;
			backIndex = oldSize - 2;
		}

	@Override
	public void moveToBack(T entry) {

		if (!isEmpty()) {
			T temp = queue[backIndex];
			boolean found = false;
			for (int i = 0; i < backIndex; i++) {
				if (entry.equals(queue[i])){
					temp = queue[i];
					queue[i] = queue[i + 1];
					queue[i + 1] = temp;			
				}
			}
			if(!found);
			enqueue(entry);
		}
	}

		@Override
		public void display() {
			
			int top = backIndex+1;
	
			for(int i = frontIndex; i< top; i++){
				System.out.print(queue[i] + " ");
				
			}System.out.println();
			
		} 
	}