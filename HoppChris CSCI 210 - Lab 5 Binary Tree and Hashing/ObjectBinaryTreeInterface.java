
/**
 * ObjectBinaryTreeInterface interfaces with the ObjectBinaryTree class
 * 
 * @author Richard Stegman - Chris Hopp - 010809627
 * @version 08.18.2017
 */


public interface ObjectBinaryTreeInterface {
	public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r);
	public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r);
	public void insertBST(Object o);
	public void insertBSTDup(Object o);
	public void preTrav(ObjectTreeNode tree);
	public void inTrav(ObjectTreeNode tree);
	public void postTrav(ObjectTreeNode tree);

}
