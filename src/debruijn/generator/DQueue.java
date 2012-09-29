package debruijn.generator;

import structures.EmptyQueueException;
import structures.Queue;

/**
 * Queue implemented using LNodes implementing Position.
 * 
 * @author WarrenGreen
 *
 * @param <E>
 */
public class DQueue<E> implements Queue<E> {

	private int 		size;
	private LNode<E>	head;
	private LNode<E>	tail;
	
	/**
	 * constructor
	 */
	public DQueue() {
		this.size = 0;
		head = new LNode<E>(null, null, null);
		tail = new LNode<E>(null, null, null);
	}
	
	
	/**
	 * Removes and returns the first node in the queue.
	 * 
	 * @return element removed from front of queue.
	 * @Override
	 * @throws EmptyQueueException
	 */
	public E deque() throws EmptyQueueException {
		if(size<=0) throw new EmptyQueueException("Queue is Empty");
		
		LNode<E> rmv = head.getNext();
		head.setNext(rmv.getNext());
		rmv.getNext().setPrev(head);
		
		return rmv.element();
	}

	/**
	 * Adds the supplied element to the beginning of the queue.
	 * 
	 * @param element - element to be inserted
	 * @Override
	 */
	public void enque(E element) {
		LNode<E> ins = new LNode<E>(tail.getPrev(), tail, element);
		tail.getPrev().setNext(ins);
		tail.setPrev(ins);
	}
	
	/**
	 * Returns the element in the front of the queue.
	 * 
	 * @return element in the front of the queue.
	 * @Override
	 */
	public E front() {
		return head.getNext().element();
	}

	/**
	 * @return whether the queue has elements
	 * @Override
	 */
	public boolean isEmpty() {
		return size<=0?true:false;
	}

	/**
	 * @return number of elements in queue.
	 * @Override
	 */
	public int size() {
		return this.size;
	}

}
