
/**
 * ObjectStack class handles all operations of stack utilitization
 * 
 * @author Richard Stegman (Chris Hopp -010809627) 
 * @version 7.17.2017
 */

public class ObjectStack {
    private Object[] item;
    private int top;
    
     /**
     * Constructor for objects of class ObjectStack
     */
    public ObjectStack() {
        item = new Object[1];
        top = -1;
    }

     /**
     * isEmpty method checks if stack is empty
     * 
     * @return boolean true if stack is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }

     /**
     * isFull method checks if stack is full
     * 
     * @return boolean true if stack is full
     */
    public boolean isFull() {
        return top == item.length-1;
    }
    
     /**
     * Clear method clears stack
     * 
     */
    public void clear() {
        item = new Object[1];
        top = -1;
    }
    
    public void push(Object o) {
        if (isFull())
            resize(2 * item.length);
        item[++top] = o;
    }
    
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i <= top; i++)
            temp[i] = item[i];
        item = temp;
    }
    
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow.");
            System.exit(1);
        }
        Object temp = item[top];
        item[top--] = null;
        if (top == item.length/4)
            resize(item.length/2);
        return temp;
    }
    
    public Object top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow.");
            System.exit(1);
        }    
        return item[top];
    }
}



