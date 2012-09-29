package structures;

/**
 * Thrown when an entry is proven to be invalid.
 * 
 * @author WarrenGreen
 *
 */
public class InvalidEntryException  extends RuntimeException {
	  public InvalidEntryException (String message) {
	    super (message);
  }
}
