import java.io.*;
import java.util.*;
/**
 * Class Decimal converts decimal input to binary or hexadecimal output
 * 
 * @author Chris Hopp - 010809627
 * @version 2.17.17
 */
public class Decimal
{
    private PrintWriter pw;
    
    int asInt = 0;
    int DecToBin;
    int DecToHex;
    String bin = "";
    String hex = "";

    /**
     * Constructor for objects of class Decimal
     * @param PrintWriter pw
     */
    public Decimal(PrintWriter pw)
    {
       this.pw = pw;
    }

    /**
     * decToBin method calls necessary methods to convert decimal to binary
     * 
     */
    public void decToBin ()
    {
        inputDec();
        toBin();
        outBin();
    }
    
    /**
     * decToHex method calls necessary methods to convert decimal to hexadecimal
     * 
     */
    public void decToHex ()
    {
        inputDec();
        toHex();
        outHex();
    }
    
     /**
     * inputDec method takes user input of a decimal in string format and converts to decimal format
     * 
     */
    private void inputDec ()
    {
       Scanner scanner = new Scanner(System.in);  
       
       System.out.print(" Enter Decimal Value ");
       String dec = scanner.nextLine();
       pw.println(" Enter Decimal Value " + dec);
       
       dec = dec.replaceAll(" ", "");
       dec = dec.replaceAll(",","");
       asInt = Integer.parseInt(dec);       //creates an integer from input string
    }
    
     /**
     * toBin method creates a binary value from a decimal
     * 
     */
    private void toBin ()
    {
            while (asInt > 0){           //converts to binary
            DecToBin = asInt % 2;
            asInt = asInt / 2;
            bin += DecToBin;
        }
        
        int binStringLength = bin.length();     //adds leading zeros to individual nibbles
        if( binStringLength % 4 == 1)
            bin += "000";
        else if( binStringLength % 4 == 2)
            bin += "00";
        else if( binStringLength % 4 == 3)
            bin += "0";
        
          
        for (int i=1; i<8; ++i){             //increases length to 32 bits
            if (bin.length() < 32){
                bin += "0000";}
            }
    
    }
    
     /**
     * outBin method outputs a binary value with appropriate whitespace characters
     * 
     */
    private void outBin ()
    {
       String nibble = "";

       for (int i = 0; i< bin.length(); i++){     //adds whitespace character after nibble
           if(i % 4 == 0){
               nibble += " " + bin.charAt(i);
            }
            else {
                nibble += bin.charAt(i);
            }
        }
        bin = nibble;
        
        System.out.println();
        System.out.print(" Decimal as Binary is ");
        System.out.println(new StringBuffer (bin).reverse().toString());
        System.out.println();
        
        pw.println();
        pw.print(" Decimal as Binary is ");
        pw.println(new StringBuffer (bin).reverse().toString());
        pw.println();
        
        bin = "";                   //resets strings
        nibble = "";
     
    }
    
     /**
     * toHex method creates a hexadecimal value from a decimal
     * 
     */
    private void toHex ()
    {
        hex = "";
        if (asInt == 0){
            hex = "0";}
        while (asInt > 0){
        {DecToHex = asInt % 16;
        if (DecToHex == 10){            //accounts for non-numeric values in hex
                hex = 'A' + hex;
            }
            else if (DecToHex == 11){
                hex = 'B' + hex;
            }
            else if (DecToHex == 12){
                hex = 'C' + hex;
            }
            else if (DecToHex == 13){
                hex = 'D' + hex;
            }
            else if (DecToHex == 14){
                hex = 'E' + hex;
            }
            else if (DecToHex == 15){
                hex = 'F' + hex;
            }
            else {
                hex = Integer.toString(asInt % 16) + hex;
            }
        asInt = asInt / 16;
        }
    }   
    }
    
     /**
     * outHex outputs a hexadecimal value
     * 
     */
    private void outHex ()
    {
       System.out.println();
       System.out.print(" Decimal as Hexadecimal is ");
       System.out.println(hex + "\n");
       
       pw.println();
       pw.print(" Decimal as Hexadecimal is ");
       pw.println(hex + "\n");
    }
    }


