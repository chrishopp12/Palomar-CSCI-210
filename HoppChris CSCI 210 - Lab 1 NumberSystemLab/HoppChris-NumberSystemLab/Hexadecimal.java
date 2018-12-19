import java.io.*;
import java.util.*;

/**
 * Class Hexidecimal converts hexadecimal input to binary and decimal output
 * 
 * @author  Chris Hopp - 010809627
 * @version 2.17.17
 */
public class Hexadecimal {
    
    private PrintWriter pw;
    
    int asDec = 0;
    String bin = "";
    String hexd = "";
    String input = "";
    /**
     * Constructor for objects of the class Hexidecimal
     * @param PrintWriter pw
     */
    public Hexadecimal(PrintWriter pw) {
          this.pw = pw;
    }
    
     /**
      * hexToDec method calls necessary methods to convert hexadecimal to decimal
      */
    public void hexToDec() {
        inputHex();
        toDec();
        outDec();
    }

     /**
      * hexToBin method calls necessary methods to convert hexadecimal to binary
      */
    public void hexToBin() {
        inputHex();
        toBin();
        outBin();
    }
    
    /**
     * inputHex method takes user input of a hexidecimal in string format
     */
    private void inputHex() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Hexadecimal Value " );
        hexd = scanner.nextLine();
        
        pw.println("Enter Hexadecimal Value " + hexd);
    }

    /**
    * toDec method creates a decimal value from a hexadecimal input
    * 
    */
    private void toDec() {
        
        long sum = 0;
        StringBuilder n = new StringBuilder(hexd).reverse();
       
        for( int i = 0; i < n.length(); i++) {
            if(n.charAt(i) == 'A' || n.charAt(i) == 'a' )               //converts hex to decimal
                sum += 10*(Math.pow(16, i));
            else if(n.charAt(i) == 'B' || n.charAt(i) == 'b')
                sum += 11*(Math.pow(16, i));
            else if(n.charAt(i) == 'C' || n.charAt(i) == 'c')
                sum += 12*(Math.pow(16, i));
            else if(n.charAt(i) == 'D' || n.charAt(i) == 'd')
                sum += 13*(Math.pow(16, i));
            else if(n.charAt(i) == 'E' || n.charAt(i) == 'e')
                sum += 14*(Math.pow(16, i));
            else if(n.charAt(i) == 'F' || n.charAt(i) == 'f')
                sum += 15*(Math.pow(16, i));
            else 
                sum = sum + Integer.parseInt("" + n.charAt(i)) * (long) Math.pow(16, i);
        }
        asDec = (int) sum;
    }

    /**
    * Outputs the hexadecimal input as a decimal value
    * 
    */
    private void outDec() {
        
        System.out.println();
        System.out.print("Hexadecimal as Decimal is ");
        System.out.println(asDec);
        System.out.println();
        
        pw.println();
        pw.print("Hexadecimal as Decimal is ");
        pw.print(asDec);
        pw.println();
        pw.println();
    }
    /**
    * toBin method creates a binary value from a hexadecimal
    */
        private void toBin() {
       
        StringBuilder n = new StringBuilder(hexd);
       
        for( int i = 0; i < n.length(); i++) {      //maps hex characters as binary nibbles
            if(n.charAt(i) == '0')
                bin += "0000";               
            else if(n.charAt(i) == '1')
                bin += "0001";
            else if(n.charAt(i) == '2')
                bin += "0010";
            else if(n.charAt(i) == '3')
                bin += "0011";
            else if(n.charAt(i) == '4')
                bin += "0100";
            else if(n.charAt(i) == '5')
                bin += "0101";
            else if(n.charAt(i) == '6')
                bin += "0110";
            else if(n.charAt(i) == '7')
                bin += "0111";
            else if(n.charAt(i) == '8')
                bin += "1000";
            else if(n.charAt(i) == '9')
                bin += "1001";
            else if(n.charAt(i) == 'A' || n.charAt(i) == 'a' )
                bin +="1010";
            else if(n.charAt(i) == 'B' || n.charAt(i) == 'b')
                bin +="1011";
            else if(n.charAt(i) == 'C' || n.charAt(i) == 'c')
                bin +="1100";
            else if(n.charAt(i) == 'D' || n.charAt(i) == 'd')
                bin +="1101";
            else if(n.charAt(i) == 'E' || n.charAt(i) == 'e')
                bin += "1110";
            else if(n.charAt(i) == 'F' || n.charAt(i) == 'f')
                bin += "1111";

        }
        bin = new StringBuffer (bin).reverse().toString();
        
        int binStringLength = bin.length(); 
         for (int i=1; i<8; ++i){             //increases length to 32 bits
            if (bin.length() < 32){
                bin += "0000";}
            }
            
        bin = new StringBuffer (bin).reverse().toString();
    }

    /**
    * Outputs the hexadecimal input as a binary number.
    * 
    */
    private void outBin() {
        
        String nibble = "";     //adds whitespace character after nibble
             
        for(int i = 0; i < bin.length(); i++) {
            if(i % 4 == 0){
                nibble += " " + bin.charAt(i);
            }
            else{
                nibble += bin.charAt(i);
            }
       }
        
        bin = nibble;
        
        System.out.println();
        System.out.print("Hexadecimal as Binary is ");
        System.out.println(bin + "\n");
        
        pw.println();
        pw.print("Hexadecimal as Binary is ");
        pw.print(bin + "\n");
        pw.println();
        pw.println();
        
        bin = "";
    }
}


