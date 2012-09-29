package structures;

/**
 * Interface for a queue structure following FIFO access. 
 * 
 * @author WarrenGreen
 *
 * @param <E>
 */
public interface Queue<E> {
	
	/**
	 * Add element to the back of the queue.
	 * 
	 * @param element - element to be inserted
	 */
	public void enque(E element);
	
	/**
	 * Removes and returns the element in the front of the queue.
	 * 
	 * @return element removed from front of queue
	 */
	public E deque() throws EmptyQueueException;
	
	/**
	 * Reports the number of elements in the queue.
	 * 
	 * @return number of elements in queue
	 */
	public int size();
	
	/**
	 * @return whether there are elements in the queue
	 */
	public boolean isEmpty();
	
	/**
	 * Reports but does not remove the element in the front of the queue
	 * 
	 * @return element in the front of the queue
	 */
	public E front();
}
