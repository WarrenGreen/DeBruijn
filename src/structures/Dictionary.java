package structures;

/**
 * Interface for a dictionary that uses unique Key-Value entries.
 * 
 * @author WarrenGreen
 *
 * @param <K> - key
 * @param <V> - value
 */
public interface Dictionary<K, V> {
	/**
	 * @return - number of entries in dictionary
	 */
	public int size();
	
	/**
	 * @return whether the Dictionary has any entries
	 */
	public boolean isEmpty();
	
	/**
	 * Finds the entry corresponding to the supplied key
	 * 
	 * @param key - key of desired entry
	 * @return desired entry
	 */
	public Entry<K,V> find(K key);
	
	/**
	 * Inserts new entry into the dictionary composed of supplied key-value pair
	 * 
	 * @param key - key to be inserted
	 * @param value - value to be inserted
	 * @return the entry inserted
	 */
	public Entry<K,V> insert(K key, V value); 
	
	/**
	 * Removes and returns the supplied entry from dictionary.
	 * 
	 * @param e - entry to be removed
	 * @return the removed entry
	 */
	public Entry<K,V> remove(Entry<K,V> e);
	
	public Iterable<Entry<K,V>> entries();
}
