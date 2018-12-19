import java.io.*;


/**
 * Class EvalPostfix evaluates a postfix expression
 * 
 * @author Chris Hopp -010809627 
 * @version 7.17.2017
 */
public class EvalPostfix
{
   private PrintWriter pw;
    ObjectStack numbers;
   int eval;
       
     /**
     * Constructor for objects of class EvalPostfix
     * @param String postfix
     * @param Printwriter pw
     */
    public EvalPostfix(String postfix, PrintWriter pw)
    {
       this.pw = pw;
       numbers = new ObjectStack();
    }
        
     /**
     * EvalPostfix method evaluates a postfix expression
     * 
     */
    public void evalPostfix(String postfix){
        char ch;

        for(int i = 0; i < postfix.length() ; i++)                  //parses postfix string and performs operations based on operator found
        {
            ch = postfix.charAt(i);
            
            if(ch == '+')
            {
                int y = ((int)numbers.pop());
                int x = ((int)numbers.pop());
                numbers.push(x+y);
                
            }
            
            
            else if(ch == '-')
            {
                int y = ((int)numbers.pop());
                int x = ((int)numbers.pop());
                numbers.push(x-y);
                
            }
            
            else if(ch == '*')
            {
                int y = ((int)numbers.pop());
                int x = ((int)numbers.pop());
                numbers.push(x*y);
                
            }
            
            else if(ch == '/')
            {
                int y = ((int)numbers.pop());
                int x = ((int)numbers.pop());
                numbers.push(x/y);
                
            }
            
            else if(ch == '^')
            {
                int y = ((int)numbers.pop());
                int x = ((int)numbers.pop());
                numbers.push((int)Math.pow(x,y));
                
            } 
    
        else if(ch >= '0' || ch <= '9')
            {
                numbers.push((int)(ch - '0'));
            }
        }
    }
    
    /**
     * PrintPostfix method prints resulting postfix notation
     * 
     */
    public void printEval()
    {
           eval = ((int)numbers.pop());
           System.out.println("Postfix Evaluation: " + eval);
           pw.println("Postfix Evaluation: " + eval);
}}