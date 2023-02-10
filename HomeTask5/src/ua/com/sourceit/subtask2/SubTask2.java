package ua.com.sourceit.subtask2;

public class SubTask2 
{
	public static void main(String[] args) 
	{
		  First childThread = new First();
		  childThread.start();
		  try 
		  {
		    childThread.join();
		  } catch (InterruptedException e) 
		  {
		    e.printStackTrace();
		  }

		  Second childRunnable = new Second();
		  Thread thread = new Thread(childRunnable);
		  thread.start();
		  try 
		  {
		    thread.join();
		  } catch (InterruptedException e) 
		  {
		    e.printStackTrace();
		  }
		}

}
