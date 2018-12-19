import java.io.*;
import java.util.Scanner;

/**
 * Driver Class runs all necessary classes to convert infix to postfix and evaluate
 * 
 * @author Chris Hopp - 010809627
 * @version 7.15.2017
 */
public class Driver
{
    public static void main(String[] args) throws IOException 
    {
        Scanner fileScan = new Scanner(new File("infix.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        
        while(fileScan.hasNext()) 
        {
            String buf = fileScan.nextLine();
            buf = buf.replaceAll(" ", "");
            System.out.println("Infix: " + buf);
            InfixToPostfix infix = new InfixToPostfix(buf, pw);
            infix.convert();
            infix.printPostfix();
            String postfix = infix.convert();
            EvalPostfix eval = new EvalPostfix (postfix, pw);
            eval.evalPostfix(postfix);
            eval.printEval();
            
        }
        pw.close();
    }
}
