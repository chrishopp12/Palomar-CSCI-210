import java.io.*;
import java.util.*;
/**
 * Class Binary converts binary input to decimal or hexadecimal output
 * 
 * @author Chris Hopp - 010809627
 * @version 2.17.17
 */
public class Binary
{
    private PrintWriter pw;
    
    int binToDec;
    int binToHex;
    String hex = " ";
    String bin = " ";

    /**
     * Constructor for objects of class Binary
     * @param PrintWriter pw
     */
    public Binary(PrintWriter pw)
    {
       this.pw = pw;
    }

    /**
     * binToDec method calls necessary methods to convert decimal to binary
     * 
     */
    public void binToDec ()
    {
        inputBin();
        toDec();
        outDec();
    }
    
    /**
     * binToHex method calls necessary methods to convert decimal to hexadecimal
     * 
     */
    public void binToHex ()
    {
        inputBin();
        toHex();
        outHex();
    }
    
     /**
     * inputBin method takes user input of a binary number in string format and converts to binary format
     * 
     */
    private void inputBin ()
    {
   
       Scanner scanner = new Scanner(System.in);
       
       System.out.print("Enter Binary Value ");
       String b = scanner.nextLine();
       pw.println("Enter Binary Value" + bin);
       
       b = b.replaceAll(" ", "");       //removes commas and whitespace characters
       b = b.replaceAll(",","");
       bin = b;
    }
    
     /**
     * toDec method creates a decimal value from a binary
     * 
     */
    public void toDec ()
    {
        double k = 0;
    
        for(int i = 0; i < bin.length(); i++){          //converts to decimal
            if(bin.charAt(i) == '1')
             k = k + Math.pow(2, bin.length() - 1 - i);
        }
        binToDec = (int) k;
    }
    
     /**
     * outDec method outputs a decimal value
     * 
     */
    private void outDec ()
    {
        System.out.println();
        System.out.println("Binary as Decimal is " + binToDec);

        pw.print("Binary as Decimal is " + binToDec);
        pw.println();
    }
    
     /**
     * toHex method creates a hexadecimal value from a decimal
     * 
     */
    private void toHex ()
    {
       String sum = "";
        
        for(int i = 0; i < 32; i+=4) {
            String nibble = bin.substring(i, i+4);
            int j = 0;
            int sum1 = 0;
            
            while(j < 4) {
                int thisDigit = Integer.parseInt(nibble.charAt(4-j-1) + "");        //creates sum from binary nibble
                sum1 += thisDigit * Math.pow(2.0, j);
                j++;
            }
            if(sum1 == 10) {                                                        //maps sum to hex
                sum+="A";
            } else if(sum1 == 11) {
                sum+="B";
            } else if(sum1 == 12) {
                sum+="C";
            } else if(sum1 == 13) {
                sum+="D";
            } else if(sum1 == 14) {
                sum+="E";
            } else if(sum1 == 15) {
                sum+="F";
            } else {
                sum+=sum1;
            }
        }
        hex = sum;
    } 
   
     /**
     * outHex outputs a hexadecimal value
     * 
     */
    private void outHex ()
    {
       System.out.println();
       System.out.print("Binary as Hexadecimal is ");
       System.out.println(hex + "\n");
       
       pw.println();
       pw.print("Binary as Hexadecimal is ");
       pw.println(hex + "\n");
    }
    }

