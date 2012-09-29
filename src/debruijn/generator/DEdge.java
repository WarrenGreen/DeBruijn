package debruijn.generator;

import structures.Map;
import structures.Position;
import structures.Edge;
import structures.Entry;
import structures.Vertex;
import structures.InvalidKeyException;

public class DEdge<E> implements Edge<E> {
	private E 					element;
	private Vertex[] 			endpoints;
	private Position<Edge<E>> 	edgeLoc;
	private Map<Object, Object> attributes;
	
	public DEdge(Vertex u, Vertex v, E element){
		this.element 		= element;
		this.endpoints		= new DVertex[2];
		this.endpoints[0]	= u;
		this.endpoints[1] 	= v;
		attributes			= new DHashMap<Object, Object>(5);
		attributes.put("visited", "false");
		
	}
	
	public Vertex[] endpoints() {
		return this.endpoints;
	}
	
	public Position<Edge<E>> getEdgeLoc(){
		return this.edgeLoc;
	}
	
	@Override
	public E element() {
		return this.element;
	}
	
	public void setElement(E e) {
		this.element = e;
	}

	@Override
	public Iterable<Entry<Object, Object>> entrySet() {
		return attributes.entrySet();
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
		return this.size();
	}

	@Override
	public Iterable<Object> values() {
		return this.attributes.values();
	}

}
