import java.io.*;
import java.util.*;

/**
 * Payroll class takes employee data from a file, processes raises, hiring, and firing of employees and outputs results
 * 
 * @author Chris Hopp -010809627 
 * @version 08.05.2017
 */

public class Payroll {
    
    private ObjectList employeeData;
    private ObjectList fireData;
    private PrintWriter pw;
    private Scanner scan;
    private String header;
    private String salaryHeader;
    private int employeeNumber;
    
    
    /**
     * Constructor for objects of class Payroll
     * @param pw PrintWriter
     */ 
    public Payroll(PrintWriter pw)
    {
        employeeData = new ObjectList();
        fireData = new ObjectList();
        this.pw = pw;
        header = ("%-16s%-16s%-16s%-16s%-16s%-16.2f\r\n");
    }

    /**
     * getPayroll method scans employee data in from a file and creates a list of Employees
     * 
     */ 
    public void getPayroll()
    {
        try
        {
            scan = new Scanner(new File("payfile.txt"));
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found");
        }
        
        while(scan.hasNext())
        {
            String line = scan.nextLine();
            String delims = "[ ]+";
            String[] empInfo = line.split(delims);
            
            employeeData.addLast(new Employee((empInfo[0]), empInfo[1], empInfo[2], Integer.parseInt(empInfo[3]),
                    empInfo[4], Double.parseDouble(empInfo[5])));
        }
    }

    /**
     * printHeader method dislays an organized header for employee information
     * 
     */
    public void printHeader()
    {
        String head = ("%-16s%-16s%-16s%-16s%-16s%-16s\r\n");
        System.out.printf(head, "First Name", "Last Name", "Gender", "Tenure", "Rate", "Pay");
        pw.printf(head, "First Name", "Last Name", "Gender", "Tenure", "Rate", "Pay", "\r\n");
    }

    /**
     * printPay method dislays employee information
     * 
     */ 
    public void printPay()
    {
        ObjectListNode p = employeeData.getFirstNode();
        employeeNumber = 0;

        while(p != null)
        {
            Employee worker = ((Employee) p.getInfo());
            System.out.printf(header, worker.getFirstName(), worker.getLastName(), worker.getGender(), worker.getTenure(), worker.getRate(), worker.getSalary());
            pw.printf(header, worker.getFirstName(), worker.getLastName(), worker.getGender(), worker.getTenure(), worker.getRate(), worker.getSalary(),"\r\n");
            employeeNumber++;
            p = p.getNext();
        }
        System.out.println("Number of employees on payroll: " + employeeNumber + "\n");
        pw.println("Number of employees on payroll: " + employeeNumber + "\r\n");
    }

    /**
     * printFemales method dislays the name of female employees
     * 
     */ 
    public void printFemales()
    {
        ObjectListNode p = employeeData.getFirstNode();
        
        System.out.println("The female employees on payroll: ");
        pw.println("The female employees on payroll: ");
        
        while(p != null)
        {
            Employee worker = ((Employee) p.getInfo());
            if(worker.getGender().equals("F"))
            {
                System.out.println(worker.getFirstName()+ " " + worker.getLastName());
                pw.println(worker.getFirstName()+ " " + worker.getLastName());
            }
            p = p.getNext();
        }
        System.out.println();
        pw.println();
    }

    /**
     * fiveYear method dislays information of employees with tenure of 5 years with salary of greater than $35,000 per year
     * 
     */ 
    public void fiveYear()
    {
        ObjectListNode p = employeeData.getFirstNode();
        
        System.out.println("Weekly employeees who make more than $35,000 per year and have been with company for 5 years: ");
        pw.println("Weekly employees who make more than $35,000 per year and have been with the company for 5 years:");
        
        String fiveYearHeader = ("%-16s%-16s%-16s\r\n");
        System.out.printf(fiveYearHeader, "First Name", "Last Name", "Pay");
        pw.printf(fiveYearHeader, "First Name", "Last Name", "Pay", "\r\n");
        
        while(p != null)
        {
            Employee worker = ((Employee) p.getInfo());
            if(worker.getTenure() >= 5 && worker.getRate().equals("W"))
            {
                double salary = worker.getSalary() * 52;
                if(salary >= 35000)
                {
                    System.out.printf(fiveYearHeader, worker.getFirstName(), worker.getLastName(), worker.getSalary());
                    pw.printf(fiveYearHeader, worker.getFirstName(), worker.getLastName(), worker.getSalary());

                }
            }
            p = p.getNext();
        }
        
        pw.println();
    }

    /**
     * giveRaise method gives a raise to employees based on current salary or wage
     * 
     */ 
    public void giveRaise()
    {
        ObjectListNode p = employeeData.getFirstNode();
        salaryHeader = ("%-16s%-16s%-16.2f%-16.2f\r\n");
        System.out.println("\nEmployees who recived a raise: ");
        pw.println("\nEmployees who recived a raise: ");
        System.out.printf("%-16s%-16s%-16s%-16s\n", "First Name", "Last Name", "Old Pay", "New Pay");
        pw.printf("%-16s%-16s%-16s%-16s\r\n", "First Name", "Last Name", "Old Pay", "New Pay");
        while(p != null)
        {
            Employee worker = ((Employee) p.getInfo());
            if(worker.getRate().equals("W") && worker.getSalary() <= 350)
            {
                double old = worker.getSalary();
                worker.setSalary(worker.getSalary() + 50.00); 
                System.out.printf(salaryHeader, worker.getFirstName(), worker.getLastName(),old, worker.getSalary());
                pw.printf(salaryHeader, worker.getFirstName(), worker.getLastName(),old,worker.getSalary());
            }
            else if(worker.getRate().equals("H") && worker.getSalary() <= 10)
            {
                double oldRate = worker.getSalary();
                worker.setSalary(worker.getSalary() + .75);
                System.out.printf(salaryHeader, worker.getFirstName(), worker.getLastName(),oldRate,worker.getSalary());
                pw.printf(salaryHeader, worker.getFirstName(), worker.getLastName(),oldRate,worker.getSalary());
            }
            p = p.getNext();
        }
        System.out.println();
        pw.println();
    }

    /**
     * sort method sorts Employees alphabetically by last name and then first
     * 
     */ 
    public void sort()
    {
        ObjectListNode p = employeeData.getFirstNode();
        ObjectList sort = new ObjectList();
        while(p != null)
        {
            Employee worker = ((Employee) employeeData.removeFirst());
            sort.insert(worker);
            p = employeeData.getFirstNode();
        }
        
        employeeData = sort.copyList();
    }

    /**
     * alphaList method sorts Employees alphabetically and displays the alpha list
     * 
     */ 
    public void alphaList()
    {
        System.out.println("Alpha List: ");
        pw.println("Alpha List: ");
        sort();
        printHeader();
        printPay();
    }   
    /**
     * hire adds newly hired employees to the employee list from a file and increses the employee number counter
     * 
     */     
    public void hire()
    {
        try
        {
            scan = new Scanner(new File("hirefile.txt"));
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found");
        }
        
        while(scan.hasNext())
        {
            String line = scan.nextLine();
            String delims = "[ ]+";
            String[] empInfo = line.split(delims);
            
            employeeData.addLast(new Employee((empInfo[0]), empInfo[1], empInfo[2], Integer.parseInt(empInfo[3]),
                    empInfo[4], Double.parseDouble(empInfo[5])));
            employeeNumber++;
        }
        System.out.println("Updated Payroll with hired employees: ");
        pw.println("Updated Payroll with hired employees: ");
        sort();
        printHeader();
        printPay(); 
    }

    /**
     * fire removes fired employees from the employee list from a file and decreases the employee number counter
     * 
     */ 
     public void fire()
     {
        try
        {
            scan = new Scanner(new File("firefile.txt"));
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found");
        }
            
        while(scan.hasNext())
        {
            String line = scan.nextLine();
            String delims = "[ ]+";
            String[] empInfo = line.split(delims);
                
            fireData.addLast(new Employee((empInfo[0]), empInfo[1]));
        }
        
        ObjectListNode q = fireData.getFirstNode();
        ObjectListNode p = employeeData.getFirstNode();
        while(p != null && q != null)
        {
            Employee fire = ((Employee) q.getInfo());
            Employee worker = ((Employee) p.getInfo());
            if(worker.getLastName().equalsIgnoreCase(fire.getLastName()) && q != null)
            {
                employeeData.remove(worker);
                q = q.getNext();
            }
            p = p.getNext();
        }
        System.out.println("Updated Payroll with fired employees: ");
        pw.println("Updated Payroll with fired employees: ");
        printHeader();
        printPay();
     }
}