package structures;

/**
 * Exception thrown when an aspect of a tree is requested while the tree is empty.
 * 
 * @author WarrenGreen
 *
 */
public class EmptyTreeException extends RuntimeException {
	public EmptyTreeException(String msg){
		super(msg);
	}
}
