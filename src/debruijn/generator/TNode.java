package debruijn.generator;

import structures.InvalidPositionException;
import structures.Position;
import structures.PositionList;

/**
 * Implementation of Position as a tree node.
 * 
 * @author WarrenGreen
 *
 * @param <E>
 */
public class TNode<E> implements Position<E> {
	
	private E 						element;
	private TNode<E> 				parent;
	private LinkedNodeSequence<TNode<E>> children;
	
	/**
	 * Contructor
	 * @param parent - parent of current node
	 * @param element - element of current node
	 */
	public TNode(TNode<E> parent, E element) {
		this.element = element;
		this.parent = parent;
		this.children = new LinkedNodeSequence<TNode<E>>();
	}
	
	/**
	 * Set current node's parent
	 * 
	 * @param parent - parent of current node
	 */
	public void setParent(TNode<E> parent) {
		this.parent = parent;
	}
	
	/**
	 * @return parent of current node
	 */
	public TNode<E> getParent() {
		return this.parent;
	}
	
	/**
	 * @return children of current node
	 */
	public PositionList getChildren() {
		return this.children;
	}
	
	/**
	 * @param child - node to be added to current node's list of children
	 */
	public void addChild(E e){
		this.children.addLast(new TNode<E>(this, e));
	}
	
	/**
	 * @param child - node to be removed from list of children
	 * @return removed node
	 */
	public TNode<E> removeChild(TNode<E> child){
		Position<TNode<E>> curr = children.first();
		for(int x=0;x<children.size();x++) {
			if(curr == child) return children.remove(curr);
			curr = children.next(curr);
		}
		
		return null;
	}
	
	/**
	 * @return element of Position
	 * @throws InvalidPositionException
	 * @Override
	 */
	public E element() throws InvalidPositionException {
		return this.element;
	}
	
	/**
	 * @param e - element to set
	 */
	public void setElement(E e) {
		this.element = e;
	}

}
