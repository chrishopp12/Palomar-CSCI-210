import java.io.*;
import java.util.*;

/**
 * The Menu class provided the interface to allow the user to complete the desired number conversions
 * 
 * @author Chris Hopp - 010809627
 * @version 02.17.2017
 */
public class Menu
{
   private PrintWriter pw;
   Scanner scan = new Scanner(System.in);

   
   /**
     * Constructor for objects of class Menu.
     * @param PrintWriter pw
     */
    
    public Menu(PrintWriter pw)
    {
       this.pw = pw;
    }

    
    /**
     * Display method displays menu options to be selected by the user as well as outputs to the csis.txt file
     */
    public void display()
    {
        System.out.println("Please select one of the following options ");
        System.out.println("Select 1 to convert Decimal to Binary ");
        System.out.println("Select 2 to convert Decimal to Hexadecimal ");
        System.out.println("Select 3 to convert Binary to Decimal ");
        System.out.println("Select 4 to convert Binary to Hexadecimal ");
        System.out.println("Select 5 to convert Hexadecimal to Decimal ");
        System.out.println("Select 6 to convert Hexadecimal to Binary ");
        System.out.println("Select 7 to Exit ");
        
        pw.println("Please select one of the following options ");
        pw.println("Select 1 to convert Decimal to Binary ");
        pw.println("Select 2 to convert Decimal to Hexadecimal ");
        pw.println("Select 3 to convert Binary to Decimal ");
        pw.println("Select 4 to convert Binary to Hexadecimal ");
        pw.println("Select 5 to convert Hexadecimal to Decimal ");
        pw.println("Select 6 to convert Hexadecimal to Binary ");
        pw.println("Select 7 to Exit ");
    }
    
     
    /**
     * getSelection method prompts user for menu selection and returns choice
     * @return choice
     */
    public int getSelection()
    {
        System.out.print("Enter Selection 1-7 ");

        
       try {
            return scan.nextInt(); 
        }
        catch (InputMismatchException e) {              //catches improper data types
            System.out.println("Invalid Selection ");
            System.out.println("Enter Selection 1-7 ");
            
            pw.println("Invalid Selection ");
            pw.println("Enter Selection 1-7 ");
            scan.next();
        }
        
        String entry = scan.next();
        int choice = Integer.parseInt(entry);
        
        pw.print("Enter Selection 1-7 " + choice);      //shows selection made
        System.out.println("\nSelection " + choice + " made ");
        pw.println("\nSelection " + choice + " made ");
        
        if (choice == 7){
            System.out.println("Program Closed");
            pw.println("Program Closed");
        }
   
        return choice;
    }
        
}
