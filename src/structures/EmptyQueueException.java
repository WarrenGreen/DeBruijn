package structures;

/**
 * Exception thrown when a dequeue is requested of an empty queue.
 * 
 * @author WarrenGreen
 */
public class EmptyQueueException extends RuntimeException {
	public EmptyQueueException(String msg){
		super(msg);
	}
}
