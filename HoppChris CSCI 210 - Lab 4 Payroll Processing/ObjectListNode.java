
/**
 * class ObjectListNode provides methods to build and manipulate nodes in a linear linked list
 * 
 * @author Richard Stegman - Chris Hopp - 010809627
 * @version 08.05.2017
 */
public class ObjectListNode
{
    private Object info;
    private ObjectListNode next;

    /**
     * Constructor for objects of class ObjectListNode with no arguments
     */
    public ObjectListNode()
    {
        info = null;
        next = null;
    }

    /**
     * Constructor for objects of class ObjectListNode with one argument for the info field
     * 
     * @param o an Object to be given to the info field
     */
    public ObjectListNode(Object o)
    {
        info = o;
        next = null;
    }
    
    /**
     * Constructor for objects of class ObjectListNode with two arguments one each for the info and next fields
     * 
     * @param o an Object to be given to the info field
     * @param p an ObjectListNode to be given to the next field
     */
    public ObjectListNode(Object o, ObjectListNode p)
    {
        info = o;
        next = p;
    }
    
    /**
     * setInfo method sets the info field
     * 
     * @param  o an Object to be given to the info field
     */
    public void setInfo (Object o)
    {
       info = o;
    }

    /**
     * getInfo method returns the contents of the info field
     * 
     * @return an Object from the info field
     */
    public Object getInfo ()
    {
       return info;
    }

    /**
     * setNext method sets the next field
     * 
     * @param  p an ObjectListNode to be given to the info field
     */
    public void setNext (ObjectListNode p)
    {
       next = p;
    }

    /**
     * getNext method returns the contents of the next field
     * 
     * @return an ObjectListNode from the next field
     */
    public ObjectListNode getNext ()
    {
       return next;
    }
}
