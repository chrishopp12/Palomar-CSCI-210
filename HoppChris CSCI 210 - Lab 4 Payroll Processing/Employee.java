
/**
 * Employee class creates employee Objects containing name, gender, and empmloyment data
 * 
 * @author Chris Hopp -010809627
 * @version 08.05.2017
 */
public class Employee implements Comparable {
    private String firstName;
    private String lastName;
    private String gender;
    private int tenure;
    private String rate;
    private double salary;
    
    /**
    * Constructor for Employee Objects taking arguments for name, gender, tenure, rate, and salary
    * 
    * @param String firstName the employee's first name
    * @param String lastName the employee's last name
    * @param String gender the employee's gender
    * @param int tenure the current tenure of the employee
    * @param String rate the hourly pay rate of the employee
    * @param double salary the weekly salary of the employee
    * 
    */
    
    public Employee(String firstName, String lastName, String gender, int tenure, String rate, double salary)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.tenure = tenure;
        this.rate = rate;
        this.salary = salary;
    }
    
    
    /**
    * Constructor for Employee Objects taking arguments for name only
    * 
    * @param String firstName the employee's first name
    * @param String lastName the employee's last name
    * 
    */
    public Employee(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
    * getFirstName method outputs the first name of the employee
    * 
    * @return String firstName the employee's first name
    * 
    */
    public String getFirstName(){
        return firstName;
    }
    
    /**
    * getLastName method outputs the last name of the employee
    * 
    * @return String lastName the employee's last name
    * 
    */    
    public String getLastName(){
        return lastName;
    }
 
    /**
    * getGender method outputs the gender of the employee
    * 
    * @return String gender the employee's gender
    * 
    */    
    public String getGender(){
        return gender;
    }
    
    /**
    * getTenure method outputs the tenure of the employee
    * 
    * @retur int tenure the employee's tenure
    * 
    */     
    public int getTenure(){
        return tenure;
    }

    /**
    * getRate method outputs the hourly rate of the employee
    * 
    * @return String rate the employee's hourly rate
    * 
    */     
    public String getRate(){
        return rate;
    }
  
    /**
    * getSalary method outputs the weekly salary of the employee
    * 
    * @return double salary the employee's salary
    * 
    */    
    public double getSalary(){
        return salary;
    }

    /**
    * getSalary method outputs the weekly salary of the employee
    * 
    * @param double salary new salary to be set
    * 
    */    
    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    
    /**
    * compareTo method compares the first and last names of two employees
    * 
    * @param Object o the Employee to be compared
    * @return int representing the results of the comparison
    * 
    */ 
    public int compareTo(Object o)
    {
        Employee worker = ((Employee) o);
        if (lastName.compareTo(worker.getLastName()) == 0)
            return firstName.compareTo(worker.getFirstName());
        else
            return lastName.compareTo(worker.getLastName());
    }
    

}
