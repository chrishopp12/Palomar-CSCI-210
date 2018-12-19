
import java.io.*;

/**
 * Driver class runs all the necessary classese to read in an input file, omit words, and track word position and count 
 * using binary search trees and a hash table for ommitted words.  Includes a search funtion for users to search for word
 * information in the input data.

 * @author Chris Hopp - 010809627
 * version 08.18.2017
 */
public class Driver {
	public static void main(String[] args) throws IOException
	{
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		
		Xref gettysburg = new Xref(pw);
		Hash hash = new Hash(pw);
		

		gettysburg.outputText();
		gettysburg.omitTree();
	
		hash.readOmit();
		hash.printArray();
	
		gettysburg.printTree();
	
		gettysburg.searchIndex();
		pw.close();
	}
}