
/**
 * class ObjectList creates and manipulates linked lists composed of nodes.
 * 
 * @author Richard Stegman - Chris Hopp - 010809627 
 * @version 08.05.2017
 */
public class ObjectList implements ObjectListInterface {
    
    private ObjectListNode list;
    private ObjectListNode last;

    /**
     * Constructs an empty Object list
     */
    public ObjectList()
    {
        list = null;
        last = null;
    }

    /**
     * getFirstNode method returns the first node in the list
     * 
     * @return the first node in the list
     */
    public ObjectListNode getFirstNode()
    {
        return list;
    }

    /**
     * getLastNode method returns the last node in the list
     * 
     * @return the last node in the list
     */
    public ObjectListNode getLastNode()
    {
        return last;
    }

    /**
     * getFirst method returns the first Object in the list
     * 
     * @return the first object in the list
     */
    public Object getFirst()
    {
        if (list == null) {
            System.out.println("Runtime Error: getFirst ()");
            System.exit (1);
        }
        
        return list.getInfo();
    }

    /**
     * getLast method returns the last Object in the list
     * 
     * @return the last object in the list
     */
    public Object getLast()
    {
        if (list == null) {
            System.out.println("Runtime Error: getFirst ()");
            System.exit (1);
        }
        
        return last.getInfo();
    }

    /**
     * addFirst method adds an Object to the front of a list
     * 
     * @param o an Object to be added to the front of the list
     */
    public void addFirst(Object o)
    {
        ObjectListNode p = new ObjectListNode (o, list);
        if (list == null)
            last = p;
        list = p;
    }

    /**
     * addFirst method adds a node to the front of a list
     * 
     * @param p an ObjectListNode to be added to the front of the list
     */
    public void addFirst(ObjectListNode p)
    {
        if (p == null) {
            System.out.println("Runtime Error: addfirst()");
            System.exit(1);
        }
        
        p.setNext(list);
        if (list == null)
            last = p;
        list = p;
        
    }    

    /**
     * addLast method adds an Object to the end of a list
     * 
     * @param o an Object to be added to the end of the list
     */
    public void addLast(Object o)
    {
        ObjectListNode p = new ObjectListNode (o);
        if (list == null)
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    /**
     * addLast method adds a node to the end of a list
     * 
     * @param p an ObjectListNode to be added to the end of the list
     */
    public void addLast(ObjectListNode p)
    {
        if (p == null) {
            System.out.println("Runtime Error: addLast()");
            System.exit(1);
        }
        
        p.setNext(null);
        if (list == null)
            list = p;
        else
            last.setNext(p);
        last = p;        
    } 

    /**
     * removeFirst method removes the first Object from the list
     * 
     * @return the first Object in the list
     */
    public Object removeFirst()
    {
        if (list == null) {
            System.out.println ("Runtime Error: removeFirst ()");
            System.exit(1);
        }
        
        ObjectListNode p = list;
        list = p.getNext();
        if (list == null)
            last = null;
        
        return p.getInfo();       
    }

    /**
     * removeLast method removes the last Object from the list
     * 
     * @return the last Object in the list
     */
    public Object removeLast()
    {
        if (list == null) {
            System.out.println ("Runtime Error: removeLast ()");
            System.exit(1);
        }
        
        ObjectListNode p = list;
        ObjectListNode q = null;
        
        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }
        
        if (q == null){
            list = null;
            last = null;
        }
        else{
            q.setNext(null);
            last = q;
        }
        
        return p.getInfo();
      
    }

    /**
     * insertAfter method inserts an Object after a given node
     * 
     * @param p an ObjectListNode where the Object will be inserted after
     * @param o the Object to be added to the list
     */
    public void insertAfter(ObjectListNode p, Object o)
    {
        if (list == null || p == null) {
            System.out.println ("Runtime Error: insertAfter()");
            System.exit(1);
        }
        
        ObjectListNode q = new ObjectListNode(o, p.getNext());
        p.setNext(q);
        if (q.getNext() == null)
            last = q;      

            
    }

    /**
     * insertAfter method inserts a node after a given node
     * 
     * @param p an ObjectListNode where the Object will be inserted after
     * @param q an ObjectListNode to be inserted
     */
    public void insertAfter(ObjectListNode p, ObjectListNode q)
    {
        if (list == null || p == null || q == null) {
            System.out.println ("Runtime Error: insertAfter()");
            System.exit(1);
        }
        
        q.setNext(p.getNext());
        p.setNext(q);
        if (last.getNext()!= null)
            last = q;
            
    }

    /**
     * deleteAfter method deletes the node after a given node
     * 
     * @param p an ObjectListNode where the node will be deleted after
     * @return the Object deleted
     */
    public Object deleteAfter(ObjectListNode p)
    {
        if (list == null || p == null || p.getNext() == null) {
            System.out.println ("Runtime Error: insertAfter()");
            System.exit(1);
        }
        
        ObjectListNode q = p.getNext();
        p.setNext(q.getNext());
      
        if (p.getNext()== null)
            last = p;
        return q.getInfo();    
    }

    /**
     * insert method inserts an Object into a desired location in an ordered list
     * 
     * @param o an Object to be inserted
     */
    public void insert(Object o)
    {
        ObjectListNode p = list;
        ObjectListNode q = null;
        
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) > 0){
            q = p;
            p = p.getNext();
        }
        
        if (q == null)
            addFirst(o);
        else
        insertAfter(q,o);
    }

    /**
     * insert method inserts a node into a desired location in an ordered list
     * 
     * @param r an ObjectListNode to be inserted
     */
    public void insert(ObjectListNode r)
    {
        ObjectListNode p = list;
        ObjectListNode q = null;
        
        while (p != null && ((Comparable)r.getInfo()).compareTo(p.getInfo()) > 0){
            q = p;
            p = p.getNext();
        }
        
        if (q == null)
            addFirst(r);
        else
        insertAfter(q,r);
    }

    /**
     * remove method removes the first occurance of an Object in a list
     * 
     * @param o an Object to be removed
     * @return the Object removed
     */
    public Object remove(Object o)
    {
        ObjectListNode p = list;
        ObjectListNode q = null;
        
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) > 0){
            q = p;
            p = p.getNext();
        }
        
        if (p == null)
            return null;
        else return q == null ? removeFirst () : deleteAfter(q);
    }

    /**
     * contains method determines if an Object is contained within a list
     * 
     * @param o an Object to be located
     * @return true if the Object is contained in the list
     */
    public boolean contains(Object o)
    {
        ObjectListNode p = list;
        
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) != 0)
            p = p.getNext();
        
        return p != null;        
    }

    /**
     * select method points to the node containing a desired Object
     * 
     * @param o an Object to be located
     * @return a ObjectListNode containing the desired Object else returns null
     */
    public ObjectListNode select(Object o)
    {
        ObjectListNode p = list;
        
        while (p != null)
            if (((Comparable)o).compareTo(p.getInfo()) == 0)
                return p;
            else
                p = p.getNext();
        return null;           
    }

    /**
     * isEmpty method determines if a list is empty or not
     * 
     * @return true if the list is empty
     */
    public boolean isEmpty()
    {
        return list == null;        
    }

    /**
     * clear method removes all elements from a list
     * 
     */
    public void clear()
    {
        list = null;
        last = null;
    }
    
    /**
     * size method determines the size of a list
     * 
     * @return int representing the size of the list
     */
    public int size()
    {
        int count = 0;
        ObjectListNode p = list;
        while (p != null) {
            ++count;
            p = p.getNext();
        }
        return count;
    }

    /**
     * copyList method makes a copy of a list
     * 
     * @return ObjectList a copy of the original list
     */
    public ObjectList copyList()
    {
        ObjectListNode p = null;
        ObjectListNode q = null;    //to satisfy compiler;
        ObjectListNode r = list;
        
        if (isEmpty())
            return null;
        ObjectList newList = new ObjectList();
        while (r != null) {
            p = new ObjectListNode (r.getInfo());
            if (newList.isEmpty())
                newList.addFirst(p);
            else
                q.setNext(p);
            q = p;
            r = r.getNext();
        }
        
        newList.last = p;
        return newList;
    }

    /**
     * reverse method reverses a list
     * 
     */
    public void reverse()
    {
        ObjectListNode p = null;
        ObjectListNode q = null;
        ObjectListNode r;
        
        while (p != null){
            r = q;
            q = p;
            p = p.getNext();
            q.setNext(r);
        }
        last = list;
        list = q;
    }
           
}
