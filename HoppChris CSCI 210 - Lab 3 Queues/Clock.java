
/**
 * Clock Class keeps track of time on an incremental basis
 * 
 * @author Chris Hopp - 010809627
 * @version 07.26.2017
 */
public class Clock
{
    private int time;

    /**
     * Constructor for objects of class Clock with no initial value
     */
    public Clock()
    {
        time = 0;
    }
    
    /**
     * Constructor for objects of class Clock with an initial value
     * 
     * @param an int representing the initial time
     */
    public Clock(int x)
    {
        time = x;
    }

    /**
     * setTime method sets the time to a designated point
     * 
     * @param an int representing a designated time
     * 
     */
    public void setTime(int x)
    {
       time = x;
    }    
    
    /**
     * tickClock method advances time one tick
     * 
     */
    public void tickClock()
    {
        ++time;
    }
    
     /**
     * decClock method decrements time one tick
     * 
     */
    public void decClock()
    {
        --time;
    }
    
     /**
     * getTime method returns the value of time
     * 
     * @return    time 
     */
    public int getTime()
    {
        return time;
    }
    
    public void printTime()
    {
        System.out.println(time);
    }
}
