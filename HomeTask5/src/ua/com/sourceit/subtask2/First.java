package ua.com.sourceit.subtask2;

public class First extends Thread
{
	 @Override
	  public void run() 
	 {
	    long start = System.currentTimeMillis();
	    while (System.currentTimeMillis() - start < 2000) 
	    {
	      System.out.println("Thread");
	      try 
	      {
	        Thread.sleep(500);
	      } catch (InterruptedException e) 
	      {
	        e.printStackTrace();
	      }
	    }
	  }
}
