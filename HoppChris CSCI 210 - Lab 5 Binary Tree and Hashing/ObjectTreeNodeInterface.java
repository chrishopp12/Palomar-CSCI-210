

/**
 * ObjectTreeNodeInterface interfaces with the ObjectTreeNode class
 * 
 * @author Richard Stegman - Chris Hopp - 010809627
 * @version 08.18.2017
 */

public interface ObjectTreeNodeInterface {
	public void setInfo(Object o);
	public Object getInfo();
	public void setLeft(ObjectTreeNode p);
	public ObjectTreeNode getLeft();
	public void setRight(ObjectTreeNode p);
	public ObjectTreeNode getRight();
}