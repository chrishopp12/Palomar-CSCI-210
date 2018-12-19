

/**
 * class ObjectTreeNode provides methods to build and manipulate a binary search tree comprised of nodes
 * 
 * @author Richard Stegman - Chris Hopp - 010809627
 * @version 08.18.2017
 */

public class ObjectBinaryTree implements ObjectBinaryTreeInterface {
    private ObjectTreeNode root;
    
   /**
    * ObjectBinaryTree constructor makes an empty binary tree with the root set to null
    */
    public ObjectBinaryTree() {
        root = null;
    }
    
    /**
     * getRood method returns the root of the binary tree
     * @return an ObjectTreeNode the root of the binary tree
     */
    public ObjectTreeNode getRoot() {
        return root;
    }
    
    /**
     * setLeftChild method which sets the left child
     * 
     * @param parent the parent node
     * @param r the child node to be set
     */
    public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r) {
        if (parent == null || parent.getLeft() != null) {
            System.out.println("Runtime Error: setLeftChild()");
            System.exit(1);
        }
        parent.setLeft(r);
    }
    
    /**
     * setRightChild method which sets the right child
     * 
     * @param parent the parent node
     * @param r the child node to be set
     */
    public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r){
        if (parent == null || parent.getRight() != null) {
            System.out.println("Runtime Error: setRightChild()");
            System.exit(1);
        }
        parent.setRight(r);
    }
    
    /**
     * insertBST method inserts a new node with an Object in the information field into the binary search tree
     * 
     * @param o the Object to be inserted
     */
    public void insertBST(Object o) {
        ObjectTreeNode p, q;
                
        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null) {
                p = q;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0 )
                    q = p.getLeft();
                else
                    q = p.getRight();
            }
            if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                setLeftChild(p, r);
            else
                setRightChild(p, r);
        }
    }
    
    /**
     * insertBSTDup method inserts a new node with an Object in the information field into the binary search tree.  If a duplicate is encountered performs a user defined operation
     * 
     * @param o the Object to be inserted
     */
    public void insertBSTDup(Object o) {
        ObjectTreeNode p, q;
                
        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null && ((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) != 0) {
                p = q;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                    q = p.getLeft();
                else
                    q = p.getRight();
            }
            if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                setLeftChild(p, r);
            else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
                setRightChild(p, r);
            else ((TreeComparable)(p.getInfo())).operate((TreeComparable)(r.getInfo()));
        }
    }
    
    /**
     * searchBST method searches through the binary search tree and returns a pointer to the node containing the item.  Returns null if the item is not found
     * 
     * @param o  the object that is being searched for
     * @return the pointer to an item that is found
     */
    public ObjectTreeNode searchBST(Object o) {
        ObjectTreeNode p;
                
        ObjectTreeNode r = new ObjectTreeNode(o);
        if(root != null) {
            p = root;
            while (p != null) {
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                    p = p.getLeft();
                else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
                    p = p.getRight();
                else 
                    return p;
            }
        }
        return null;
    }
    
    /**
     * preTrav method which performs a preorder traversal of the binary search tree
     * 
     * @param tree the tree to be traversed
     */
    public void preTrav(ObjectTreeNode tree) {
        if (tree != null) {
            ((TreeComparable)tree.getInfo()).visit();
            preTrav(tree.getLeft());
            preTrav(tree.getRight());
        }
    }
    
    /**
     * inTrav method performs an inorder traversal of the binary search tree
     * 
     * @param tree the tree to be traversed
     */
    public void inTrav(ObjectTreeNode tree) {
        if (tree != null) {
            inTrav(tree.getLeft());
            ((TreeComparable)tree.getInfo()).visit();
            inTrav(tree.getRight());
        }
    }
    
    /**
     * postTrav method performs a postorder traversal of the binary search tree
     * 
     * @param tree the tree to be traversed
     */
    public void postTrav(ObjectTreeNode tree) {
        if (tree != null) {
            postTrav(tree.getLeft());
            postTrav(tree.getRight());
            ((TreeComparable)tree.getInfo()).visit();
        }
    }
}