package debruijn.generator;

import structures.*;

/**
 * A sequence implemented using a linked list.
 * 
 * @author WarrenGreen
 *
 * @param <E>
 */

public class LinkedNodeSequence<E> extends DPositionList<E> implements Sequence<E> {
	
	/**
	 * Returns the first element in the sequence
	 * 
	 * @return the first element in the sequence
	 * @throws EmptyDequeException
	 */
	@Override
	public E getFirst() throws EmptyDequeException {
		if(size() <= 0)
			throw new EmptyDequeException("Sequence is empty");
		
		return first().element();
	}

	/**
	 * Returns the last element in the sequence.
	 * 
	 * @return the last element in the sequence
	 * @throws EmptyDequeException
	 */
	@Override
	public E getLast() throws EmptyDequeException {
		if(this.size() <= 0)
			throw new EmptyDequeException("Sequence is empty");
		
		return this.last().element();
	}

	/**
	 * Removes the first node in the sequence and returns its element.
	 * 
	 * @return the first element in the sequence
	 * @throws EmptyDequeException
	 */
	@Override
	public E removeFirst() throws EmptyDequeException {
		if(this.size() <= 0)
			throw new EmptyDequeException("Sequence is empty");
		
		return this.remove(this.last());
	}
	
	/**
	 * Removes the last node in the sequence and returns its element.
	 * 
	 * @return the last element in the sequence
	 * @throws EmptyDequeException
	 */
	@Override
	public E removeLast() throws EmptyDequeException {
		if(this.size() <= 0)
			throw new EmptyDequeException("Sequence is empty");
		
		return this.remove(this.last());
	}

	/**
	 * Returns the element in the sequence at the provided index.
	 * 
	 * @param i - the index of the desired element
	 * @return the element at the provided index
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		if(( i < 0 ) || ( i >= this.size() ))
				throw new IndexOutOfBoundsException("Index is invalid");
		
		return this.atIndex(i).element();
	}

	/**
	 * Sets the element at the node of the provided index and returns the old element.
	 * 
	 * @param i - index of desired node
	 * @param e - element desired node is to be set to
	 * @return the replaced element
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if(( i < 0 ) || ( i >= this.size() ))
			throw new IndexOutOfBoundsException("Index is invalid");
		
		return this.set( i , e );
	}

	/**
	 * Adds a node with the provided index at the provided element.
	 * 
	 * @param i - index that node is to be inserted
	 * @param e - element to be inserted at index
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if( (i < 0) || (i >= this.size()))
			throw new IndexOutOfBoundsException("Index is invalid");
		
		if( i == 0 )
			this.addFirst(e);
		else if( i == this.size() -1 )
			this.addLast(e);
		else
			this.addBefore( this.atIndex(i) , e );
		
	}

	/**
	 * Removes a node at the provided index and returns the removed node's element.
	 * 
	 * @param i - index of node to be removed
	 * @return element of removed node
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		if(( i < 0 ) || ( i >= this.size() ))
			throw new IndexOutOfBoundsException("Index is invalid");
		
		return this.remove( i );
	}

	/**
	 * Returns the node at the provided index.
	 * 
	 * @param i - index of desired node
	 * @return node at provided index
	 * @throws BoundaryViolationException
	 */
	@Override
	public Position<E> atIndex(int i) throws BoundaryViolationException {
		if(( i < 0 ) || ( i >= this.size() ))
			throw new BoundaryViolationException("Index is invalid");
		
		LNode<E> currentNode = this.head.getNext();
		
		for( int x=0; x < i; x++)
			currentNode = currentNode.getNext();
		
		return currentNode;
	}

	/**
	 * Returns the index of the provided node in the sequence.
	 * 
	 * @param p - node whose index is desired
	 * @return index of provided node
	 * @return InvalidPositionException
	 */
	@Override
	public int indexOf(Position<E> p) throws InvalidPositionException {
		
		int returnIndex = 0;
		LNode<E> currentNode = this.head.getNext();
		
		//find location of node in sequence
		while(( currentNode != p ) && ( currentNode != this.tail ))
		{
			currentNode = currentNode.getNext();
			returnIndex++;
		}
		
		if( currentNode == this.tail )
			throw new InvalidPositionException("Position is not in this sequence");
		
		return returnIndex;
	}

}
