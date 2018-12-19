import java.io.*;

/**
 * Driver class runs the multi-level feedback queue simulation
 * 
 * @author Richard Stegman - Chris Hopp - 010809627
 * @version 07.26.2017
 */
public class Driver
{

    public static void main(String[] args) throws IOException
    {
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        
        MFQ mfq = new MFQ(pw);
        
        mfq.scanFile();
        mfq.outputHeader();
        mfq.runSimulation();
        mfq.outStats();

        pw.close();  
    }
}