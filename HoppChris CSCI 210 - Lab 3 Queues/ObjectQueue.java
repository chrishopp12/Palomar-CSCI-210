
/**
 * Object Queue Class creates queues that can hold Object items
 * 
 * @author Richard Stegman - Chris Hopp - 010809627 
 * @version 07.26.2017
 */
public class ObjectQueue implements ObjectQueueInterface
{
    private Object[] item;
    private int front;
    private int rear;
    private int count;

    /**
     * Constructor for objects of class ObjectQueue.  Creates a new empty queue
     */
    public ObjectQueue()
    {
       item = new Object[1];
       front = 0;
       rear = -1;
       count = 0;
    }

    /**
     * isEmpty method determines if the ObjectQueue contains any objects by looking at the count
     * 
     * @return     true if the queue contains no Objects
     */
    public boolean isEmpty ()
    {
        return count == 0;
    }

    /**
     * isFull method determines if the ObjectQueue contains maximum objects by comparing count to item length
     * 
     * @return     true if the queue is full
     */
    public boolean isFull ()
    {
        return count == item.length;
    }

    /**
     * clear method removes all Objects from the queue and resets pointers and count
     * 
     */
    public void clear ()
    {
       item = new Object[1];
       front = 0;
       rear = -1;
       count = 0;        
    }

    /**
     * insert method adds another Object to the queue and increases the queue length if necessary
     * 
     * @param o, an Object to be inserted
     * 
     */
    public void insert (Object o)
    {
        if (isFull())
            resize(2 * item.length);
        rear = (rear+1) % item.length;
        item[rear] = o;
        ++count;       
    }

    /**
     * remove method first checks for underflow condition, removes an item from the queue, and resizes the queue if necessary taking into account the boundary condition
     * 
     */
    public Object remove() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        Object temp = item[front];
        item[front] = null;
        front = (front+1) % item.length;
        --count;
        if (count == item.length/4 && item.length != 1)
            resize(item.length/2);
        return temp;
    }
    
    /**
     * query method first checks for underflow and then returns the first queue element without removing it
     * 
     */
    public Object query() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        return item[front];
    }
    
    /**
     * resize method resizes the queue to a desired size
     * 
     * @param size
     */
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i < count; ++i) {
            temp[i] = item[front];
            front = (front+1) % item.length;
        }
        front = 0;
        rear = count-1;
        item = temp;
    }
}
