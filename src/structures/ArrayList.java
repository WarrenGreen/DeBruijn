package structures;

/**
 * An interface for an ArrayList.
 * 
 * @author WarrenGreen
 *
 * @param <E>
 */

public interface ArrayList<E> {

	/** Returns the number of elements in the list */
	public int size();
	
	/** Return whether the list is empty */
	public boolean isEmpty();
	
	/** Returns the element in the list at the given index */
	public E get(int i) throws IndexOutOfBoundsException;
	
	/** Sets the the element in the list at the given index and return the replaced element */
	public E set(int i, E e) throws IndexOutOfBoundsException;
	
	/** Inserts the provided element at the given index */
	public void add(int i, E e) throws IndexOutOfBoundsException;
	
	/** Removes the element at the given index from the list and returns it. */
	public E remove(int i) throws IndexOutOfBoundsException;
	
}
