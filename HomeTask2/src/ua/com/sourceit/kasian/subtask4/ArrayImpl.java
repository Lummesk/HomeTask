package ua.com.sourceit.kasian.subtask4;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array{
	
	private Object[] container;
	public ArrayImpl()
	{
	    this.container = new Object[0];
	}
	 public static void main(String[] args) {
		 Array arr = new ArrayImpl();
		 arr.add("A");
		 arr.add("B");
		 arr.add("C");
		 System.out.println("Метод add: " + arr);
		 arr.set(1, "D");
		 System.out.println("Метод set: " + arr);
		 System.out.println("Метод get: " + arr.get(2));
		 System.out.println("Метод indexOf: " + arr.indexOf("C"));
		 arr.remove(2);
		 System.out.println("Метод remove: " + arr);
		 System.out.println("Метод size: " + arr.size());
		 System.out.println("Використовуємо ітератор:");
		 Iterator<Object> iterator = arr.iterator();
		    while (iterator.hasNext())
		    {
		        System.out.println(iterator.next());
		    }
		 arr.clear();
		 System.out.println("Метод clear:" + arr); 
	 }
	 
	 private class IteratorImpl implements Iterator<Object>
	    { 
	    	private int index;

			@Override
			public boolean hasNext()
			{
				  return index < container.length;
			}

			@Override
			public Object next() 
			{
				 if (!hasNext()) {
				        throw new NoSuchElementException();
				      }
				      return container[index++]; 
			}
			public void remove() 
			{
			      ArrayImpl.this.remove(--index);
			}
	    }
	@Override 
	public void clear() 
	{
		Object[] a = new Object[0];
		container = a;
		
	}

	@Override
	public int size() 
	{
		return container.length;
	}
	public String toString()
	{
		if (container.length == 0)
		    {
		      return "[]";
		    }
		    StringBuilder builder = new StringBuilder("[");
		    for (int i = 0; i < container.length; i++) 
		    {
		    	if (container[i] == null) 
		    	{
		    		builder.append("");
		    	}
		    	    else
		    	    {
		      builder.append(container[i].toString());
		    	    }
		      if (i != container.length - 1) 
		      {
		        builder.append(", ");
		    }
		    
		    }
		    builder.append("]");
		    return builder.toString();
		   
		  }
	

	@Override
	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	@Override
	public void add(Object element) {
		Object[] a = new Object[container.length +1];
		  for (int i = 0; i < container.length; i++) {
		    a[i] = container[i];
		  }
		  container = a;
		  container[container.length -1] = element;
		  }

	@Override
	public void set(int index, Object element) {
		Object[] a = new Object [container.length +1];
        for (int i = 0; i < container.length;i++)
      	  if (index > i)
      	  {
      		  a[i] = container[i];
      	  }
      	  else
      	  {
      		a[i+1] = container[i];
      	  }
          a[index] = element;
          container = a;
	}

	@Override
	public Object get(int index) {
		if (index <= container.length)
		{
			return container[index];
		}
		else
			{
			throw new NoSuchElementException();
			}
	}

	@Override
	public int indexOf(Object element) {
		
		for (int i = 0; i < container.length; i++) 
			    {
		        if (container[i].equals(element)) 
		        	return i;
			    }
		return -1;
	}

	@Override
	public void remove(int index) {
		Object[] a = new Object [container.length -1];
		for (int i = 0, j = 0; i < container.length; i++)
		    {
			if (i != index) 
			{
			a[j++] = container[i];
			}
			}
			container = a;
			}
          
	}


		
	

	
	
		
	
