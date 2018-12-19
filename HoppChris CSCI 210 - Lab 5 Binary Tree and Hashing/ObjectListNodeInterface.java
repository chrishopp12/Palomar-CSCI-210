
/**
 * ObjectListNodeInterface interfaces with the ObjectListNode class
 * 
 * @author Richard Stegman - Chris Hopp - 010809627
 * @version 08.18.2017
 */

public interface ObjectListNodeInterface {
	public void setInfo(Object o);
	public Object getInfo();
	public void setNext(ObjectListNode p);
	public ObjectListNode getNext();
}

