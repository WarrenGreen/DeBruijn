package structures;


/**
 * An interface for a graph.
 * 
 * @author WarrenGreen
 *
 * @param <V>
 * @param <E>
 */
public interface Graph<V, E> {
	
	/** Returns an iterable collection of all vertices in graph */
	public Iterable<Vertex<V>> vertices();
	
	/** Returns an iterable collection of all edges in graph */
	public Iterable<Edge<E>> edges();
	
	/** Returns an iterable collection of all edges incident upon vertex v */
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v);
	
	/** Returns the endvertex of edge e distinct from vertex v; an error occurs 
	 * if e is not incident on Edge e 
	 * */
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e);
	
	/** Returns an array storing the end vertices of edge e */
	public Vertex<V>[] endVertices(Edge<E> e);
	
	/** Returns whether vertices v and w and adjacent */
	public boolean areAdjacent(Vertex<V> v, Vertex<V> u);
	
	/** Replace element of Vertex v with element x and return the old element */
	public V replace(Vertex<V> v, V x);
	
	/** Replace element of Edge e with element x and return the old element */
	public E replace(Edge<E> e, E x);
	
	/** Insert and return a new vertex storing element x */
	public Vertex<V> insertVertex(V x);
	
	/** Insert and return a new undirected edge with end vertices v and w and 
	 * storing element x
	 */
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E x);
	
	/** Remove vertex v and all its incident edges and return the element stored at v */
	public V removeVertex(Vertex<V> v);
	
	/** Remove edge e and return the element stored at e */
	public E removeEdge(Edge<E> e);
}
