/**
 * ObjectQueueInterface interface which lets the user use methods from the Object Queue class
 * 
 * @author Richard Stegman - Chris Hopp - 010809627
 * @version 07.26.2017
 */
public interface ObjectQueueInterface {
	public boolean isEmpty();
	public boolean isFull();
	public void clear();
	public void insert(Object o);
	public Object remove();
	public Object query();
}