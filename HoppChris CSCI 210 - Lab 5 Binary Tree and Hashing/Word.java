
import java.io.PrintWriter;

/**
 * Word class creates word Objects to be placed into the binary search tree
 * @author Chris Hopp - 010809627
 * version 08.18.2017
 */
public class Word implements TreeComparable
{
    private PrintWriter pw;
    
    private String term;
    private int count;
    private ObjectList wordList;
    private LinePosition position;
 
    
    /**
     * Word a one arg constructor which takes a word from from the omit.txt file
     *
     * @param term the omitted word
     */
    public Word(String term)
    {
        this.term = term;
    }
    
    /**
     * Word a three arg constructor which takes a word and tracks the position and word count
     * 
     * @param term the word that is being read from the input file
     * @param position the position where the word is located
     * @param pw the print writer object to write to the csis.txt file
     */
    public Word(String term, LinePosition position, PrintWriter pw)
    {
        wordList = new ObjectList();
        count = 1;
        this.term = term;   
        this.position = position;
        this.pw = pw;
        
    }
    
    /**
     * getWord method returns the word as a string
     * 
     * @return a word as a String
     */
    public String getWord()
    {
        return this.term;
    }
    
    /**
     * getLinePosition method which returns the line position of the word
     * 
     * @return the line position of the word
     */
    public Object getLinePosition(){
        return position;
    }
    
    /**
     * compareTo method compares a term being read to an object Word
     * 
     * @param o the Object word to compare to
     * @return an int value representing the results of the comparison 
     */
    public int compareTo(Object o)
    {
        Word phrase = (Word) o;
        return term.compareTo(phrase.getWord());    
    }
    
    /**
     * operate method increments a counter and tracks the position when duplicate words are encountered
     * 
     * @param o the Word Object that is duplicated
     */
    public void operate(Object o)
    {
        Word phrase = (Word) o;
        count++;    
        wordList.addLast(phrase.getLinePosition());
    }
    
    /**
     * visit method prints out each word as a node is visited in a traversal
     */
    public void visit()
    {
        System.out.printf("Word: " + "%-12s" + "%-12d", term, count);
        pw.printf(String.format("Word: " + "%-12s" + "%-12d", term, count));
        position.printLinePosition();
        
        if(count > 0)
        {
            ObjectListNode p = wordList.getFirstNode();
            
            while(p != null)
            {
                LinePosition temp = (LinePosition) p.getInfo();
                temp.printLinePosition();
                p = p.getNext();
            }
        }
        System.out.println();
        pw.println();
    }
    
}
