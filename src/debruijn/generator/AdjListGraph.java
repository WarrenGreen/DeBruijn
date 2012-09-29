package debruijn.generator;

import structures.*;

/**
 * Adjacency List Graph implementation using hash maps 
 * to store the vertices and edges. 
 * 
 * @author WarrenGreen
 *
 * @param <V> Element for Vertices
 * @param <E> Element for Edges
 */
public class AdjListGraph<V, E> implements Graph<V, E> {
	
	protected DPositionList<Vertex<V>> 	vertices;
	protected DPositionList<Edge<E>> 		edges;
	
	/**
	 * constructor
	 */
	public AdjListGraph(int cap) {
		vertices = new DPositionList<Vertex<V>>();
		edges 	 = new DPositionList<Edge<E>>();
	}
	
	/**
	 * @return Iterable structure containing the graph's vertices.
	 * @Override
	 */
	public Iterable<Vertex<V>> vertices() {
		return this.vertices;
	}

	/**
	 * @return Iterable structure containing the graph's edges.
	 * @Override
	 */
	public Iterable<Edge<E>> edges() {
		return this.edges;
	}

	/**
	 * @param v - vertex associated with desired edges
	 * @return Iterable structure containing edges connected to supplied Vertex v.
	 * @throws IllegalArgumentException
	 * @Override
	 */
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws IllegalArgumentException {
		DVertex vv = checkVertex(v);
		return vv.getIncidentEdges();
	}

	/**
	 * Returns the vertex opposite to the supplied vertex over the supplied edge.
	 * 
	 * @param v - Vertex connected to desired vertex with supplied edge
	 * @param e - Edge connecting desired vertex and supplied vertex
	 * @return Vertex connected to supplied vertex: v through supplied edge: e
	 * @throws IllegalArgumentException
	 * @Override
	 */
	public Vertex opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException {
		DEdge<E> ee = checkEdge(e);
		Vertex<Object>[] endpoints = ee.endpoints();
		
		if(endpoints[0] == v)
			return endpoints[1];
		else if(endpoints[1] == v)
			return endpoints[0];
		
		return null;
	}

	/**
	 * Returns the vertices connected to the supplied edge
	 * @param e - edge connected to desired vertices
	 * @return array of vertices connected to supplied edge: e
	 * @Override
	 */
	public Vertex<V>[] endVertices(Edge<E> e) {
		DEdge ee = checkEdge(e);
		return ee.endpoints();
	}

	/**
	 * Query whether supplied vertices are connected with any edge
	 * 
	 * @param v - vertex
	 * @param u - vertex
	 * @return whether u and v are connected via an edge
	 * @Override
	 */
	public boolean areAdjacent(Vertex<V> v, Vertex<V> u) {
		for(Edge curr: ((Sequence<Edge>)checkVertex(v).getIncidentEdges())) {
			if(checkEdge(curr).endpoints()[0]==u || checkEdge(curr).endpoints()[1]==u)
				return true;
		}
		
		return false;
	}

	/**
	 * Replace the supplied vertex with a new vertex of the supplied element.
	 * 
	 * @param v - Vertex to be replaced
	 * @param x - Element of node to be created
	 * @return element of replaced vector
	 * @Override
	 */
	public V replace(Vertex<V> v, V x) {
		V temp = v.element();
		checkVertex(v).setElement(x);
		return temp;
	}

	/**
	 * Replace the supplied Edge with a new edge of the supplied element.
	 * 
	 * @param e - the edge to replace
	 * @param x - the element to create a new edge
	 * @return the replace element
	 * @Override
	 */
	public E replace(Edge<E> e, E x) {
		E temp = e.element();
		checkEdge(e).setElement(x);
		return temp;
	}

	/**
	 * Inserts a vertex into the graph
	 * 
	 * @param x - vertex to insert
	 * @return the vertex inserted
	 * @Override
	 */
	public Vertex<V> insertVertex(V v) {
		Vertex<V> vertIn = new DVertex<V>(v);
		vertIn.put("visited", "false");
		vertices.addLast(vertIn);
		return vertIn;
	}
	
	/**
	 * Inserts an edge into the graph
	 * 
	 * @param v - vertex to be connected to edge 
	 * @param w - vertex to be connected to edge
	 * @param x - element of inserted edge
	 * @return inserted edge
	 * @Override
	 */
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E x) {
		Edge<E> e = new DEdge<E>(v, w, x);
		edges.addLast(e);
		checkVertex(v).addIterableEdge(e);
		checkVertex(w).addIterableEdge(e);
		return e;
	}
	
	/**
	 * Inserts an edge into the graph
	 * 
	 * @param v - vertex to be connected to edge 
	 * @param w - vertex to be connected to edge
	 * @param x - element of inserted edge
	 * @return inserted edge
	 * @Override
	 */
	public Edge<E> insertDirectedEdge(Vertex<V> v, Vertex<V> w, E x) {
		Edge<E> e = new DEdge<E>(v, w, x);
		edges.addLast(e);
		checkVertex(v).addIterableEdge(e);
		e.put("directed" , "true");
		return e;
	}

	/**
	 * Removes supplied vertex
	 * 
	 * @param v - vertex to be removed
	 * @return element of removed vertex
	 * @Override
	 */
	public V removeVertex(Vertex<V> v) {
		for(Vertex curr: vertices)
			if(curr.element()==v) vertices.remove(curr);
		for(Edge curr: (Iterable<Edge<E>>) checkVertex(v).getIncidentEdges())
			removeEdge(curr);
		return v.element();
	}
	
	/**
	 * Removes supplied edge
	 * 
	 * @param e - edge to remove
	 * @return element of removed edge
	 * @Override
	 */
	public E removeEdge(Edge<E> e) {
		for(Edge curr: edges)
			if(curr.element()==e) vertices.remove(curr);
		checkVertex(checkEdge(e).endpoints()[0]).removeIterableEdge(e);
		checkVertex(checkEdge(e).endpoints()[1]).removeIterableEdge(e);
		return e.element();
	}

	/**
	 * Safely convert vertex
	 * 
	 * @param v - vertex to convert
	 * @return converted DVertex
	 * @throws InvalidPositionException
	 */
	public DVertex checkVertex(Object v) throws InvalidPositionException {
		if(v instanceof DVertex) return (DVertex)v;
		
		throw new IllegalArgumentException("Not an Vertex");
	}
	
	/**
	 * Safely convert Edge
	 * 
	 * @param e - edge to convert
	 * @return converted DEdge
	 * @throws InvalidPositionException
	 */
	public DEdge checkEdge(Edge<E> e) throws InvalidPositionException {
		if(e instanceof DEdge) return (DEdge)e;
		
		throw new IllegalArgumentException("Not an Edge");
	}
	
}
