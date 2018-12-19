
import java.io.*;
import java.util.*;
/**
 * Driver class runs all necessary operations to sort, hire, and fire Employees from payroll.
 * 
 * @author Chris Hopp - 010809627
 * @version 08.05.2017
 */
public class Driver {
	public static void main(String[] args) throws IOException
	{
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		Payroll payroll = new Payroll(pw);
		
		payroll.getPayroll();
		payroll.printHeader();
		payroll.printPay();
		payroll.printFemales();
		payroll.fiveYear();
		payroll.giveRaise();
		payroll.alphaList();
		payroll.hire();
		payroll.fire();
		pw.close();
	}

}



