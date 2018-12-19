
import java.io.*;
import java.util.*;
/**
 * Xref class reads the input file and creates binary search tree to make the word index and track the word count and position
 *
 * @author Chris Hopp - 010809627
 * version  08.18.2017
 */
public class Xref 
{
    private PrintWriter pw;
    
    private ObjectBinaryTree tree;
    private ObjectBinaryTree omitTree;
    
    private Hash hashTable;
    private Scanner fileScan;

    
    /**
     * Xref constructor creates a new binary trees and hash table to reference for omitted words
     * 
     * @param pw the print writer object that is used to write to the csis.txt file
     */
    public Xref(PrintWriter pw)
    {
        this.pw = pw;
        tree = new ObjectBinaryTree();
        omitTree = new ObjectBinaryTree();
        hashTable = new Hash(pw);
    }
    
    /**
     * outputText method which reads the getty.txt file and outputs the text with accompanying line numbers
     * 
     */
    public void outputText() throws FileNotFoundException
    {
        fileScan = new Scanner(new File("getty.txt"));
        int number = 1;
        
        System.out.println("--------------------------Gettysburg Address------------------------------");
        pw.println("--------------------------Gettysburg Address------------------------------");
        while(fileScan.hasNextLine())
        {
            String line = fileScan.nextLine();
            System.out.println(String.format("/* %d */ %s", number, line));
            pw.println(String.format("/* %d */ %s", number, line));
            number++;   
        }
        System.out.println("-----------------------------------------------------------------------------------");
        pw.println("-----------------------------------------------------------------------------------");
        System.out.println();
        pw.println();
    }

     /**
     * omitTree method reads the getty.txt file and puts the words into the binary search tree and linear linked list and omits words using the hash table of ommitted words
     * 
     */
    public void omitTree() throws FileNotFoundException
    {
        fileScan = new Scanner(new File("getty.txt"));
        hashTable.readOmit();
        int lineNum = 1;
        while(fileScan.hasNext())
        {
            String line = fileScan.nextLine();
            String delims = "[ ,.;-]+";
            
            String[] words = line.split(delims);
            
            int i = 0;
            
            while(i < words.length)
            {
                if(hashTable.omit(words[i].toLowerCase()) == false)
                {
                    omitTree.insertBSTDup(new Word(words[i].toLowerCase(), new LinePosition(lineNum, i+1, pw), pw));
                }
                i++;
            }
            
            lineNum++;
        }
    }   
    
    /**
     * printTree method traverses the tree to output the words in alphabetical order including the word count and line position  in-order
     * 
     */
    public void printTree()
    {
        ObjectTreeNode p = omitTree.getRoot();
        System.out.println("------------------------ Word Index ---------------------------");
        pw.println("------------------------ Word Index ---------------------------");
        omitTree.inTrav(p);
    }
    
    /**
     * searchIndex method which allows the user to search through the binary search tree and outputs the desired word with the position and word count
     * 
     */
    public void searchIndex()
    {
        Scanner scan = new Scanner(System.in);
        
        String word = " ";
        
        boolean search = true;
        
        while(search == true)
        {
            System.out.println("Insert a word to search or 'exit' to exit: ");
            pw.println("Insert a word to search or 'exit' to exit: ");
            word = scan.next();
            pw.println(word);
            
            
            if(!word.equalsIgnoreCase("exit"))
            {
                Word temp = new Word(word);
                
                ObjectTreeNode p = omitTree.searchBST(temp);
                
                if(p != null)
                {
                    Word wordSearch = (Word) p.getInfo();
                    wordSearch.visit();
                }
                else
                {
                    System.out.println("Word not found in index.");
                    pw.println("Word not found in index.");
                }   
            }
            else
                search = false;     
        }
        scan.close();
    }
 }
