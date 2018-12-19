


/**
 * class ObjectTreeNode provides methods to build and manipulate nodes in a binary search tree
 * 
 * @author Richard Stegman - Chris Hopp - 010809627
 * @version 08.18.2017
 */

public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    
    /**
     * ObjectTreeNode constructor makes an empty Object Tree node set to null
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }
    
    /**
     * ObjectTreeNode one arg constructor makes an Object Tree node with an Onject in the info field
     * 
     * @param o the Object to be set in the info field
     */
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
    }
    
    /**
     * setInfo method sets the info field of a object binary tree node
     * 
     * @param o the Object that is being inputed into the node info field
     */
    public void setInfo(Object o) {
        info = o;
    }
    
    /**
     * getInfo method returns the info field of the object binary tree node
     * 
     * @return info the Object in the info field
     */
    public Object getInfo() {
        return info;
    }
    
    /**
     * setLeft method sets the reference pointer to the left child
     * 
     * @param p the reference pointer to the left child
     */
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }
    
    /**
     * getLeft method returns the reference pointer to the left child
     * 
     * @return left the reference pointer of the left child
     */
    public ObjectTreeNode getLeft() {
        return left;
    }
    
    /**
     * setRight method sets the reference pointer to the right child
     * 
     * @param p the reference pointer to the right child
     */
    public void setRight(ObjectTreeNode p) {
        right = p;
    }
    
    /**
     * getRight method returns the reference pointer to the right child
     * 
     * @return right the reference pointer to the right child
     */
    public ObjectTreeNode getRight() {
        return right;
    }
}