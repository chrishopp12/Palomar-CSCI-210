import java.io.*;
import java.util.*;

/**
 * Hash class creates the hash table for the omitted words to be compared to the input text
 * 
 * @author Chris Hopp
 * version 08.18.2017
 */
public class Hash 
{
	private static final int SIZE = 37;
	
	private Scanner scan;
	private String hashTable[];
	private int collision = 0;
	private PrintWriter pw;
	
	/**
	 * Hash constructor creates a new array for the hash table and allows the user to input the omitted words
	 * 
	 * @param pw , print writer object that is responsible for writing to the csis.txt file
	 */
	public Hash(PrintWriter pw)
	{
		hashTable = new String[SIZE];
		this.pw = pw;
	}
	
	/**
	 * readOmit method reads the omitted words from the omit.txt file and inputs it into the hash table.  Calls the linearProbe method to 
	 * resolve collisions and tracks the number of collisions
	 * 
	 * 
	 */
	public void readOmit() throws FileNotFoundException
	 {
		scan = new Scanner(new File("omit.txt"));
		
		
		while(scan.hasNext())
		{
			String line = scan.next();
			String temp = line.toLowerCase();
			
			int index = hashKey(temp);
			
			while(hashTable[index] instanceof String)
			{
				index = linearProbe(index);
				collision++;
			}
			hashTable[index] = temp;	
		}
	}
	
	/**
	 * hashKey method generates a hash key for each word
	 * 
	 * @param s the word that is being hashed to generate a index value into the hash table
	 * @return the index value that is generated to be put into the hash table
	 */
	public int hashKey(String s)
	{	
		int sum = 0;
		for(int i = 0; i < s.length(); i++)
		{
			sum += 3 + (int)s.charAt(i) * 1579 ;
		}
		return sum % SIZE; 
	}
	
	/**
	 * linearProbe method resolves collisions using linear probing
	 * 
	 * @param key the key that is being rehashed to generate a new index value into the hash table
	 * @return the index value that is being genreated to be put into the hash table
	 */
	public int linearProbe(int key)
	{
		return (key+ 1) % SIZE;
	}
	
	/**
	 * printArray method prints the hash table and the number of collisions
	 * 
	 */
	public void printArray()
	{
		System.out.println("-------------------------Hash Table------------------------");
		pw.println("-------------------------Hash Table------------------------");
		
		System.out.println("Description of Hash Function: Takes 3 plus the ASCII value of the"
				+ "\n" + "word times 1579 and is then modded by the table size");
		
		pw.println("Description of Hash Function: Takes 3 plus the ASCII value of the");
		pw.println("word times 1579 and is then modded by the table size");
			
		System.out.println();
		pw.println();
		
		for(int i = 0; i < 37; i++)
		{
			if(hashTable[i] != null)
			{
				System.out.println("Index: " + i + "\t" + " Word: " + hashTable[i]);
				pw.println("Index: " + i + "\t" + " Word: " + hashTable[i]);
			}
			else
			{
				System.out.println("Index: " + i + "\t" + " Word: " + " " );
				pw.println("Index: " + i + "\t" + " Word: " + " " );
			}
			
		}
			System.out.println("Collisions: " + collision);
			pw.println("Collisions: " + collision);
			System.out.println();
			pw.println();
	}
	
	/**
	 * omit method compares the input text to the omitted words to determine if a word should be omitted
	 * 
	 * @param term the term that is being read from the input to be compared to the hash table
	 * @return true if the term is to be omitted
	 */
	public boolean omit(String term)
	{
		int index = hashKey(term);
		if(hashTable[index] == null)
		{
			return false;
		}
		else if(hashTable[index].equalsIgnoreCase(term))
		{
			return true;
		}
		else if(hashTable[index] instanceof String)
		{
			for(int i = 0; i < 4; i++)
			{
				index = linearProbe(index);
				if(hashTable[index] == null)
					break;	
				if(hashTable[index].equalsIgnoreCase(term) && hashTable[index] != null)
				{
					return true;
				}
			}
		}	
		return false;	
	}
}
