
/**
 * class CPU handles all aspects of processing a Job Object once in has been handed to the CPU in the multi-level feedback queue simulation
 * 
 * @author Chris Hopp - 010809627
 * @version 07.26.2017
 */
public class CPU
{
    private Job currentJob;
    public boolean busyFlag;
    public Clock quantumTime;
    private int waitTime = 0;

    /**
     * CPU constructor sets initial busy flag to false to prepare CPU for a Job
     */
    public CPU()
    {
          busyFlag = false;
          quantumTime = new Clock ();
    }

    /**
     * startJob method brings a Job from the input queue or a job queue to the CPU to be processed.  Job is set to the job being handled by the CPU and the busy flag is set.
     * 
     * @param  job, the Job being brought to the CPU
     */
    public void startJob(Job job)
    {
        currentJob = job;
        busyFlag = true;
    }

    /**
     * setQuantumClock method sets the quantum clock to the proper level for CPU operation at the given queue level
     * 
     * @param  exitQueue, the queue a job exits as it is passed to the CPU
     */
    public void setQuantumClock(int exitQueue)
    {   int quantum = (int) (Math.pow(2, exitQueue));
        quantumTime.setTime(quantum);
    }

    /**
     * decQuantumClock method decrements the quantum clock for each cycle
     * 
     */
    public void decQuantumClock()
    {
        quantumTime.decClock();
    }

    /**
     * getJob method returns the current job on the CPU
     * 
     * @return currentJob a Job Object 
     */
    public Job getJob()
    {
        return currentJob;
    }

    /**
     * getQuantumTime method returns the current status of the quantum time
     * 
     * @return the quantum time for the Job
     */
    public int getQuantumTime()
    {
        return quantumTime.getTime();
    }

     /**
     * getWaitTime method returns amount of time the CPU has sat without a job
     * 
     * @return the counter for wait time
     */
    public int getWaitTime()
    {
        return waitTime++;
    }
    
    /**
     * getBusyFlag method returns the current status of the busy flag
     * 
     * @return true if the CPU is busy processing a job, false if the CPU is free
     */
    public boolean getBusyFlag()
    {
        return busyFlag;
    }    
    
    /**
     * jobComplete method returns the completion status of the Job
     * 
     * @return true if the Job has completed and false if not
     */
    public boolean jobComplete()
    {
        return currentJob.getTimeRemaining() == 0;
    }

    /**
     * timeExpired method determines if the CPU time available to a Job in a queue has expired
     * 
     * @return true if the CPU time has expired
     */
    public boolean timeExpired()
    {
        return quantumTime.getTime() == 0;
    }

    /**
     * dismissJob method dismisses the current Job on the CPU, resets the busy flag, and returns the Job
     * 
     * @return the Job previously held by the CPU
     */
    public Job dismissJob()
    {
       busyFlag = false;
       return currentJob;
    }    


}
