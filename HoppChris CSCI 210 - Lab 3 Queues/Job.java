
/**
 * Job class creates Job Objects to be used in the multi-level feedback queue simulation
 * 
 * @author Chris Hopp - 010809627
 * @version 07.26.2017
 */
public class Job
{
    private int pid;
    private int arrivalTime;
    private int cpuTimeRequired;
    private Clock cpuTimeRemaining;
    private int currentQueue;

    /**
     * Constructor for objects of class Job
     * 
     * @param arrivalTime to identify the system time the job enters the simulation
     * @param pid the Process Identification number
     * @param cpuTimeRequired the cpu time necessary when the job enters the simulation
     */
    public Job(int arrivalTime, int pid, int cpuTimeRequired)
    {
        this.arrivalTime = arrivalTime;
        this.pid = pid;
        this.cpuTimeRequired = cpuTimeRequired;
        cpuTimeRemaining = new Clock (cpuTimeRequired);
    }

    /**
     * getPID method returns the job ID number
     * 
     * @return pid, an int representing the job ID 
     */
    public int getPID ()
    {
        return pid;
    }
    
    /**
     * getArrival method returns the job arrival time
     * 
     * @return arrivalTime, an int representing the job arrival time 
     */
    public int getArrival ()
    {
        return arrivalTime;
    }

    /**
     * getTimeRequired method returns the cpu tiime required
     * 
     * @return cpuTimeRequired, an int representing the cpu time required to complete the job 
     */
    public int getTimeRequired ()
    {
        return cpuTimeRequired;
    }

    /**
     * getTimeRemaining method returns the cpu tiime remaing
     * 
     * @return an int representing the cpu time remaining required to complete the job 
     */
    public int getTimeRemaining ()
    {
        return cpuTimeRemaining.getTime();
    }

    /**
     * decTimeRemaining method decreases the quantum time remaining to complete a job
     * 
     */
    public void decTimeRemaining ()
    {
        cpuTimeRemaining.decClock();
    }

    /**
     * currentQueue method returns the queue number the job is currently in
     * 
     * @return cpuTimeRequired, an int representing the cpu time required to complete the job 
     */
    public int currentQueue ()
    {
        return currentQueue;
    }

    /**
     * queueJob method sends the job to a queue
     * 
     * @param queue, the specific queue the job will be sent to 
     */
    public void jobQueue (int queue)
    {
        currentQueue = queue;
    }
}
