package debruijn.generator;

import structures.Edge;
import structures.Map;
import structures.Sequence;
import structures.Entry;
import structures.InvalidKeyException;
import structures.Position;
import structures.Vertex;

public class DVertex<E> implements Vertex<E> {
	
	private E 					element;
	private Position<Vertex<E>> vertexLoc;
	private Map<Object, Object> attributes;
	private Sequence<Edge> 		incidentEdges;
	
	public DVertex(E element){
		this.attributes =  new DHashMap<Object, Object>(5);
		this.element = element;
		this.vertexLoc = vertexLoc;
		this.incidentEdges = new LinkedNodeSequence<Edge>();
		for(int i=0; i<incidentEdges.size(); i++)
			this.incidentEdges.addLast(incidentEdges.get(i));
	}
	
	@Override
	public E element() {
		return this.element;
	}
	
	public Iterable<Edge> getIncidentEdges() {
		return this.incidentEdges;
	}
	
	public void addIterableEdge(Edge e) {
		this.incidentEdges.addFirst(e);
	}
	
	public Edge removeIterableEdge(Edge e){
		for(int x=0;x<incidentEdges.size();x++) {
			if(((Edge)incidentEdges.get(x).element()) == e) {
				incidentEdges.remove(x);
				return e;
			}
		}
		
		return null;
	}

	public Position<Vertex<E>> getVertexLoc() {
		return vertexLoc;
	}

	public void setVertexLoc(Position<Vertex<E>> vertexLoc) {
		this.vertexLoc = vertexLoc;
	}

	public void setElement(E element) {
		this.element = element;
	}

	@Override
	public Iterable<Entry<Object, Object>> entrySet() {
		return this.attributes.entrySet();
	}

	@Override
	public Object get(Object key) throws InvalidKeyException {
		return this.attributes.get(key);
	}

	@Override
	public boolean isEmpty() {
		return this.attributes.isEmpty();
	}

	@Override
	public Iterable<Object> keySet() {
		return this.attributes.keySet();
	}

	@Override
	public Object put(Object key, Object value) throws InvalidKeyException {
		return this.attributes.put(key, value);
	}

	@Override
	public Object remove(Object key) throws InvalidKeyException {
		return this.attributes.remove(key);
	}

	@Override
	public int size() {
		return this.attributes.size();
	}

	@Override
	public Iterable<Object> values() {
		return this.attributes.values();
	}
	
	public Iterable<Edge> getEdges() {
		return this.incidentEdges;
	}

}
