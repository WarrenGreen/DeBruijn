package structures;

import java.util.Iterator;

/**
 * Interface for a generic tree using Posititions.
 * 
 * @author WarrenGreen
 *
 * @param <E>
 */
public interface Tree<E> {

	/**
	 * @return number of Positions in tree structure
	 */
	public int size();
	
	/**
	 * @return whether the tree contains any valid Positions
	 */
	public boolean isEmpty();
	
	/**
	 * @return iterator
	 */
	public Iterator<E> iterator();
	
	/**
	 * @return all Positions in Tree
	 */
	public Iterable<Position<E>> positions();
	
	/**
	 * Replaces supplied Position with new Position made from supplied element.
	 * 
	 * @param n - Position to be replaced
	 * @param e - element used to make replacer Position
	 * @return the element of the replaced Position
	 * @throws InvalidPositionException
	 */
	public E replace(Position<E> n, E e) throws InvalidPositionException;
	
	/**
	 * @return root Position of tree
	 * @throws EmptyTreeException
	 */
	public Position<E> root() throws EmptyTreeException;
	
	/**
	 * Returns parent of supplied Position
	 * 
	 * @param n - Position whose parent is requested
	 * @return parent of supplied position
	 * @throws InvalidPositionException
	 * @throws BoundaryViolationException
	 */
	public Position<E> parent(Position<E> n) 
		throws InvalidPositionException, BoundaryViolationException;
	
	/**
	 * Returns child Positions of supplied position
	 * 
	 * @param n - parent position
	 * @return Iterable structure containing children of supplied Position
	 * @throws InvalidPositionException
	 */
	public Iterable<Position<E>> children(Position<E> n) throws InvalidPositionException;
	
	/**
	 * @param n - Position to be tested
	 * @return whether the supplied Position is an internal Position
	 * @throws InvalidPositionException
	 */
	public boolean isInternal(Position<E> n) throws InvalidPositionException;
	
	/**
	 * @param n - Position to be tested
	 * @return whether the supplied Position is an external Position
	 * @throws InvalidPositionException
	 */
	public boolean isExternal(Position<E> n) throws InvalidPositionException;
	
	/**
	 * @param n - Position to be tested
	 * @return whether the supplied Position is root
	 * @throws InvalidPositionException
	 */
	public boolean isRoot(Position<E> n) throws InvalidPositionException;
}
