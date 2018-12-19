/**
 * interface TreeComparable interfaces with the ObjectBinaryTree class and Objects to compare them, perform a user defined operation in a duplicate search, or visit the root in a traversal
 * 
 * @author Richard Stegman - Chris Hopp 010809627 
 * @version 08.18.2017
 */


public interface TreeComparable {
	public int compareTo(Object o);
	public void operate(Object o);
	public void visit();
}