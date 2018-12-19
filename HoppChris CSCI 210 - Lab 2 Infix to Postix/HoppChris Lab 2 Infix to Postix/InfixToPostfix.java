import java.io.*;
import java.util.*;

/**
 * Class InfixToPostfix converts infix notation to postfix notation.
 * 
 * @author Chris Hopp -010809627 
 * @version 7.17.2017
 */

public class InfixToPostfix{
    private PrintWriter pw;
    String buf;
    String postfix = "";
    ObjectStack stack;
       
     /**
     * Constructor for objects of class InfixToPostfix
     * @param String buf
     * @param Printwriter pw
     */
    public InfixToPostfix(String buf, PrintWriter pw)
    {
        this.pw = pw;
        this.buf = buf;
        stack = new ObjectStack();
    }
        
     /**
     * Priority method determines priority of operators
     * 
     * @param  char op   Infix input
     * @return int       Representing priority 
     */
    public int priority(char op) {
        switch (op) {
        case '(':return -1;
        case ')': return -1;
        case '^': return 3;
        case '*': return 2;
        case '/': return 2;
        case '+': return 1;
        case '-': return 1;
        default : return 0;
        }
    }   
    
     /**
     * Convert method converts infix to postfix notation
     * @return String
     */
    


    public String convert(){
        postfix = "";
        
        for(int i = 0; i < buf.length() ; i++)
        {
          char ch = buf.charAt(i);
                  
            if(ch >= '0' && ch <= '9') {     //if a number, add to postfix string
               postfix = postfix + ch;
            }
          else if(ch == '(')                //push left parantheses on operator stack
            {
                stack.push(ch); 
            }
           
            
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
            {                           //handles operators
                if(stack.isEmpty())
                    stack.push(ch);
                else
                {
                                     
                    if(priority((char) stack.top()) >= priority(ch))
                    {
                       while(!stack.isEmpty()&& priority((char)stack.top()) >= priority(ch))
                       
                           postfix = postfix + ((char) stack.pop());
                       
                     }  
                    stack.push(ch);
                    
                }
            }   
                        

            
            else if(ch == ')')          //if right parentheses pop stack until left parentheses is reached
            {
            while((!stack.isEmpty())&&((Character) stack.top() != '('))                
                   postfix += stack.pop();                
            if (!stack.isEmpty())
                    stack.pop();                
          }  
          }
        

        while(!stack.isEmpty())         //clears operator stack

               postfix = postfix + ((char) stack.pop());
       
        return postfix;
    }
    
    /**
     * PrintPostfix method prints resulting postfix notation
     * 
     */
    public void printPostfix()
    {
        System.out.println("Postfix: " + postfix);
        pw.println("Postfix: " + postfix);
    }
}
