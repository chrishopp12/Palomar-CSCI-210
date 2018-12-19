
/**
 * Interface ObjectStackInterface is an interface for the ObjectStack class
 * 
 * @author Richard Stegman (Chris Hopp- 010809627) 
 * @version 7.17.2017
 */

public interface ObjectStackInterface 
{    
    public boolean isEmpty(); 
    public boolean isFull();
    public void clear(); 
    public void push(Object o); 
    public Object pop(); 
    public Object top();
}