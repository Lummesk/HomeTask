package ua.com.sourceit.subtask3;

public class SubTask3 
{
	public static void main(String[] args) 
	{
        Runnable task = () ->
        {
        	Counter counter = new Counter();
            int maxIterations = 10;
            int iteration = 0;
            while (iteration < maxIterations) 
            {
                int counter1 = counter.getCounter1();
                int counter2 = counter.getCounter2();
                System.out.println("Counter1: " + counter1 + ", Counter2: " + counter2 + 
                        " (Counter1 == Counter2: " + (counter1 == counter2) + ")");
                counter.setCounter1(counter1 + 1);
                try 
                {
                    Thread.sleep(10);
                } catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
                counter.setCounter2(counter2 + 1);
                
                iteration++;

            }
        };

        
        System.out.println("Synchronized version:");
        synchronized (task) 
        {
            
                new Thread(task).start();
            
            try 
            {
				Thread.sleep(1000);
			} catch (InterruptedException e) 
            {
				e.printStackTrace();
			}
        }
        System.out.println("\nUnsynchronized version:");
        {
            new Thread(task).start();
        }
    }
}
