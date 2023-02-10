package ua.com.sourceit.subtask2;

public class Second implements Runnable 
{
	@Override
	  public void run() 
	{
	    long start = System.currentTimeMillis();
	    while (System.currentTimeMillis() - start < 2000) 
	    {
	      System.out.println("Runnable");
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
