package ua.com.sourceit.hometask3;

public class SubTask5 
{
	public static void main(String[] args) 
	{
	    String text = "Здійснити форматування заданого тексту з вирівнюванням ліворуч. Програма повинна розбивати текст на рядки.";
	    int lineLength = 20;
	    
	    String[] words = text.split(" ");
	    StringBuilder line = new StringBuilder();
	    for (String w : words) 
	    {
	      if (line.length() + w.length() <= lineLength) 
	      {
	        line.append(w + " ");
	      } else {
	        System.out.println(line);
	        line = new StringBuilder(w + " ");
	      }
	    }
	    System.out.println(line);
	  }
}
