/**
 * 
 * @Override 
	*/
package debruijn.generator;

import java.util.Iterator;

import structures.BoundaryViolationException;
import structures.EmptyTreeException;
import structures.InvalidPositionException;
import structures.Position;
import structures.Tree;

/**
 * Implementation of a Generic Tree 
 * 
 * @author WarrenGreen
 */
public class DTree<E> implements Tree<E> {
	
	private int size;
	private TNode<E> root;
	
	public DTree(){
		size = 0;
		root = new TNode<E>(null,  null);
	}
	
	/**
	 * @return number of Positions in tree structure
	 * @Override 
	 */
	public int size(){
		return this.size;
	}
	
	/**
	 * @return whether the tree contains any valid Positions
	 * @Override 
	*/
	public boolean isEmpty(){
		return size<=0?true:false;
	}
	
	/**
	 * @return iterator
	 * @Override 
	*/
	public Iterator<E> iterator(){
		return null;
	}
	
	/**
	 * @return all Positions in Tree
	 * @Override 
	*/
	public Iterable<Position<E>> positions(){
		LinkedNodeSequence<Position<E>> posList = new LinkedNodeSequence<Position<E>>();
		
		return DFTraversal(posList, root);
	}
	
	/**
	 * Depth First Traversal of Tree
	 * @param posList - List of positions in tree
	 * @param curr - current node
	 * @return List of positions in tree
	 */
	public LinkedNodeSequence<Position<E>> DFTraversal(LinkedNodeSequence<Position<E>> posList, TNode<E> curr) {
		if(this.isExternal(curr)) return posList;
		posList.addLast(curr);
		
		for(TNode<E> child: (Iterable<TNode<E>>)curr.getChildren())
			posList = DFTraversal(posList, child);
		
		return posList;
		
	}
	
	/**
	 * Replaces supplied Position with new Position made from supplied element.
	 * 
	 * @param n - Position to be replaced
	 * @param e - element used to make replacer Position
	 * @return the element of the replaced Position
	 * @throws InvalidPositionException
	 * @Override 
	*/
	public E replace(Position<E> n, E e) throws InvalidPositionException{
		E temp = n.element();
		((TNode<E>)n).setElement(e);
		
		return temp;		
	}
	
	/**
	 * @return root Position of tree
	 * @throws EmptyTreeException
	 * @Override 
	*/
	public Position<E> root() throws EmptyTreeException{
		//if(root.element()==null) throw new EmptyTreeException("Tree is empty");
		return this.root;
	}
	
	/**
	 * Returns parent of supplied Position
	 * 
	 * @param n - Position whose parent is requested
	 * @return parent of supplied position
	 * @throws InvalidPositionException
	 * @throws BoundaryViolationException
	 * @Override 
	*/
	public Position<E> parent(Position<E> n) 
		throws InvalidPositionException, BoundaryViolationException{
		return ((TNode<E>)n).getParent();
	}
	
	/**
	 * Returns child Positions of supplied position
	 * 
	 * @param n - parent position
	 * @return Iterable structure containing children of supplied Position
	 * @throws InvalidPositionException
	 * @Override 
	 */
	public Iterable<Position<E>> children(Position<E> n) throws InvalidPositionException{
		return ((TNode<E>)n).getChildren();
	}
	
	/**
	 * @param n - Position to be tested
	 * @return whether the supplied Position is an internal Position
	 * @throws InvalidPositionException
	 * @Override 
	 */
	public boolean isInternal(Position<E> n) throws InvalidPositionException{
		for(TNode<E> curr: (Iterable<TNode<E>>)((TNode<E>)n).getChildren()){
			if(curr != null) return true;
		}
		return false;
	}
	
	/**
	 * @param n - Position to be tested
	 * @return whether the supplied Position is an external Position
	 * @throws InvalidPositionException
	 * @Override 
	 */
	public boolean isExternal(Position<E> n) throws InvalidPositionException {
		for(TNode<E> curr: (Iterable<TNode<E>>)((TNode<E>)n).getChildren()){
			if(curr != null) return false;
		}
		return true;
	}
	
	/**
	 * @param n - Position to be tested
	 * @return whether the supplied Position is root
	 * @throws InvalidPositionException
	 * @Override 
	 */
	public boolean isRoot(Position<E> n) throws InvalidPositionException {
		return this.root==n?true:false;
	}

}
