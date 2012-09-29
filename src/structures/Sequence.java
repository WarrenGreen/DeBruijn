package structures;

/**
 * An interface for a sequence, a combination of deque, array list and position list.
 * 
 * @author WarrenGreen
 *
 * @param <E>
 */

public interface Sequence<E> extends Deque<E>, ArrayList<E>, PositionList<E> {

	/** Returns the position with index i */
	public Position<E>  atIndex(int i) throws BoundaryViolationException;
	
	/** returns the index of the provided position */
	public int indexOf(Position<E> p) throws InvalidPositionException;
}
