package structures;

/**
 * An interface for a position that can be marked with an arbitrary
 * number of decorations.
 * 
 * @author WarrenGreen
 *
 * @param <E>
 */
public interface DecorablePosition<E> extends Position<E>, Map<Object,Object> {
	//no new methods necessary.
}
