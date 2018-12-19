import java.io.PrintWriter;

/**
 * LinePosition class tracks the line position and line number for a word in the input file
 * 
 * @author Chris Hopp - 010809627
 * version 08.17.2017
 */
public class LinePosition 
{
	private int lineNumber;
	private int position;
	private PrintWriter pw;
	
	/**
	 * LinePosition three arg constructor creates an Object that tracks the line number and position of a word in the input   
	 * 
	 * @param lineNumber the line number where the word appears
	 * @param position the line position number where the word appears in the line
	 * @param pw the print writer object that is used to write to the csis.txt file
	 */
	public LinePosition(int lineNumber, int position, PrintWriter pw)
	{
		this.lineNumber = lineNumber;
		this.position = position;
		this.pw = pw;
	}
	
	/**
	 * getLineNumber method returns the line number for a word
	 * 
	 * @return an int representing the line number
	 */
	public int getLineNumber(){
		return this.lineNumber;
	}
	
	/**
	 * getPosition method returns the line position number for a word
	 * 
	 * @return an int representing the position of the word within a line
	 */
	public int getPosition(){
		return this.position;
	}
	
	/**
	 * printLinePosition method outputs the line number and position
	 * 
	 */
	public void printLinePosition()
	{
		String lineFormat = "%d%s%d\t";
		System.out.printf(lineFormat, lineNumber , "-", position, " ");
		pw.printf(String.format(lineFormat, lineNumber , "-", position, " "));
	}
}
