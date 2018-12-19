import java.io.*;
import java.util.*;

/**
 * MFQ class utilizes a set of queues to run a CPU simulation of job processing
 * 
 * @author Chris Hopp - 010809627
 * @version 07.26.2017
 */

public class MFQ {
	
	public Clock systemTime;
	private Scanner scan;
	private PrintWriter pw;
	private ObjectQueueInterface[] queues;
	private Job job;
	private CPU cpu;
	private int totalJob;
	private int jobTimeTotal;
	private int waitTime = 0;
	private int totalCPUNeeded = 0;
	private int responseTime = 0;
	
	/**
	 * MFQ constructor creates an Multi-Level Feedback queue object out of a number of Object Queues and a CPU Object to run a simulation of job processing
	 * 
	 * @param pw the print writer
	 */
	public MFQ(PrintWriter pw)
	{
		systemTime = new Clock(1);
	    cpu = new CPU();
		this.pw = pw;
		
		queues = new ObjectQueue[5];
		queues[0] = new ObjectQueue();
		queues[1] = new ObjectQueue();
		queues[2] = new ObjectQueue();
		queues[3] = new ObjectQueue();
		queues[4] = new ObjectQueue();
		
		totalJob = 0;
		jobTimeTotal = 0;
		
	}
	
	/**
	 * scanFile method which reads information from a data file, splits that information, and creates Job objects from the data.
	 * 
	 */
	public void scanFile()
    {
        try
        {
            scan = new Scanner(new File("mfq.txt"));
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
        
        while(scan.hasNext())
        {
            String line = scan.nextLine();
            String delims = "[ ]+";
            String[] jobInfo = line.split(delims);
            
            queues[0].insert(new Job(Integer.parseInt(jobInfo[0]), Integer.parseInt(jobInfo[1]), Integer.parseInt(jobInfo[2])));
            totalJob++;
        }
    }
	
	/**
	 * outputHeader creates a header formatted to the data output
	 */
	 public void outputHeader()
	 {
	        System.out.println("Event\t" + "Time\t" + "PID  " + "Required\t" + "Total\t" + "Lowest Level");
	        pw.println("Event\t" + "Time\t" + "PID  " + "Required\t" + "Total\t" + "Lowest Level");
	  }
	 
	 /**
	  * runSimulation method runs the simulation of the CPU processing of Jobs through a Multi-Level Feedback queue
	  */
	 public void runSimulation()
	 {      
	        while(!checkQueues())
	        {
	        	systemTime.tickClock();
	        	
	            if(checkArrival())
	            {
	                processArrival();
	            }

	            if(cpu.getBusyFlag())
	            {
	            	cpu.decQuantumClock();
	       	     	cpu.getJob().decTimeRemaining();
	                
	                if(cpu.jobComplete())
	                {
	                    complete(cpu.dismissJob());
	                }
	                else
	                {
	                	if(cpu.timeExpired() || higherPriority())
	                    {
	                        nextQueue(cpu.dismissJob());
	                    }   
	                }     
	            }
	            
	            if(!cpu.getBusyFlag())
	            {
	                if(nextQueue() != 0)
	                {
	                    insertJob(nextQueue());
	                }
	            }

	            if(cpu.getBusyFlag() == false)
	            	waitTime += cpu.getWaitTime();
	        }
	    }
	 
	 /**
	  * insertJob method sends a job to the CPU and sets the quantum clock for the appropriate queue level
	  * 
	  * @param queue the queue that a job is being removed from
	  */
	 public void insertJob(int queue)
	 {
		 cpu.startJob((Job) queues[queue].remove());
	     cpu.setQuantumClock(queue);
	 }
	 
	 /**
	  * higherPriority method determines if a job has entered queue level one, thus preempting lower levels
	  * 
	  * @return returns true if queue 1 has a Job
	  */
	 public boolean higherPriority()
	 {
	     if(!queues[1].isEmpty())
	     {
	          return true;
	     }
	     else
	     {
	    	 return false;   
	     }
	 }	
	 
	 /**
	  * checkQueues loops through the queues to see if they are occupied and checks to see if the CPU is busy in order to determine if the simulation is complete
	  * 
	  * @return returns true if all queues and CPU are emtpy and false if not
	  */
	 private boolean checkQueues()
	 {
	     for(int i = 0; i < 5; i++)
	     {
	    	 if(queues[i].isEmpty() != true)
	    		 return false;
	         if(i == 4 && cpu.getBusyFlag())
	        	 return false;
	     }    
	     return true;
	  }
	

	 /**
	  * checkArrival method determines if there is a job in the input queue that needs to be submitted into the multi-level feedback queue
	  * 
	  * @return returns true if a new job needs to enter the sytem and false if there are no jobs to be entered
	  */
	 public boolean checkArrival()
	 {
		 if(queues[0].isEmpty())
			 return false;
		 if(((Job) queues[0].query()).getArrival() == systemTime.getTime())
			 return true;
		 else
			 return false;
	  }
	 
	 /**
	  * nextQueue method sends a Job to the next queue if the job is pre-empted or the quantum time has expired
	  * 
	  * @param queue the queue the Job is exiting from
	  */
	 public void nextQueue(Job queue)
	 {
	        switch(queue.currentQueue())
	        {
	            case 0:
	                queue.jobQueue(1);
	                queues[1].insert(queue);
	                break;
	            case 1:
	                queue.jobQueue(2);
	                queues[2].insert(queue);
	                break;
	            case 2:
	                queue.jobQueue(3);
	                queues[3].insert(queue);
	                break;
	            case 3:
	            	queue.jobQueue(4);
	                queues[4].insert(queue);
	                break;  
	            case 4:
	                queue.jobQueue(4);
	                queues[4].insert(queue);
	                break;    
	        }
	 }
	 
	 /**
	  * nextQueue method determines the highest level queue that is occupied
	  * 
	  * @return gives the queue that needs to be processed next by priority
	  */
	 private int nextQueue()
	 {
	     for(int i = 1; i < 5; i++)
	     {
	        if(!queues[i].isEmpty())
	            return i;
	     }
	     return 0;  
	 }
	 
	 /**
	  * processArrival method takes a job from the input queue to be entered into the simulation and outputs the arrival event 
	  */
	 private void processArrival()
	 {
		job = (Job) queues[0].remove();
		int sysTime = systemTime.getTime();
		
		System.out.print("Arrival" + "\t" + sysTime + "\t" + job.getPID() + "\t" + job.getTimeRequired());
		System.out.println("\t" + "-" + "\t" + "-");
		
		pw.print("Arrival" + "\t" + sysTime + "\t" + job.getPID() + "\t" + job.getTimeRequired());
		pw.println("\t" + "-" + "\t" + "-");
	 	
		totalCPUNeeded += job.getTimeRemaining();
		nextQueue(job);
	 }
	 
	 /**
	  * complete method which outputs the exit event information and tracks the total job processing time
	  * 
	  * @param job the job that is leaving the system when it finished processing
	  */
	 private void complete(Job job)
	 {   int sysTime = systemTime.getTime();
		 int totalTime = (sysTime - job.getArrival());
		 
	     System.out.print("Depart" + "\t" + sysTime + "\t" + job.getPID()); 
	     System.out.println("\t" + "-" + "\t" + totalTime + "\t" + job.currentQueue());
	        
	     pw.print("Depart" + "\t" + sysTime + "\t" + job.getPID());
	     pw.println("\t" + "-" + "\t" + totalTime + "\t" + job.currentQueue());
	        
	     jobTimeTotal += totalTime;
	 }
	 
	 /**
	  * outStats method outputs all the stats for job number, total time, response time, turnaround time, wait time, and throughput
	  * 
	  */
	 public void outStats()
	 {
		 System.out.println("Total number of jobs: " + totalJob);
		 System.out.println("Total time of all jobs in system: " + jobTimeTotal);
		 System.out.println("Average response time: " + responseTime);
		 System.out.printf("Average turnaround time: " + "%.2f" + "\n", ((double) ((double) jobTimeTotal / (double) totalJob)));
		 System.out.printf("Average waiting time: " + "%.2f" + "\n", ((double) ((double) jobTimeTotal - (double)totalCPUNeeded)/ (double)totalJob));
		 System.out.printf("Average throughput for system:" + "%.2f" + "\n",((double) ((double)totalJob / (double)jobTimeTotal)));
	   	 System.out.println("Total CPU idle Time: " + waitTime);
	   	 
	   	 pw.println("Total number of jobs: " + totalJob);
	   	 pw.println("Total time of all jobs in system: " + jobTimeTotal);
		 pw.println("Average response time: " + responseTime);
		 pw.printf("Average turnaround time: " + "%.2f" + "\r\n", ((double) ((double) jobTimeTotal / (double) totalJob)));
		 pw.printf("Average waiting time: " + "%.2f" + "\r\n", ((double) ((double) jobTimeTotal - (double)totalCPUNeeded)/ (double)totalJob));
		 pw.printf("Average throughput for system:" + "%.2f" + "\r\n",((double) ((double)totalJob / (double)jobTimeTotal)));
	   	 pw.println("Total CPU idle Time: " + waitTime);
	 }
	  
}
