package ua.com.sourceit.hometask3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SubTask1 
{
	   private HashMap<Character, List<String>> firstCharMap;
	   String[] words;
	   
	   public SubTask1() 
	   {
		   firstCharMap = new HashMap<>();
	   }
	public static void main(String[] args)
	{
		SubTask1 task = new SubTask1();
		task.findChain("У тексті немає слів, що починаються з однакових літер. Надрукувати слова тексту так, щоб остання літера кожного слова збігалася з першою літерою наступного слова.");
		
	}
	
	 public void addWords(String text) 
	 {
		 String cleanText = text.replaceAll("[^а-яА-ЯіІїЇ\\s]", "").toLowerCase();
			words = cleanText.split("\\s+");

	      for (String word : words) 
	      {
	         char lastLetter = word.charAt(0);
	         if (!firstCharMap.containsKey(lastLetter))
	         {
	        	 firstCharMap.put(lastLetter, new ArrayList<>());
	         }
	         firstCharMap.get(lastLetter).add(word);
	      }
	   }

	 public void findChain(String text)
	 { 
		 addWords(text);
		 List<String> longestChain = new ArrayList<>();
		 	    for (String word : words) 
		 	    {
	            List<String> currentChain = new ArrayList<>();
	            currentChain.add(word);
	            char lastLetter = word.charAt(word.length() - 1);
	            if (firstCharMap.containsKey(lastLetter)) 
	            {
	               List<String> nextWords = firstCharMap.get(lastLetter);
	               buildChain(currentChain, nextWords);
	            }
	            if (currentChain.size() > longestChain.size())
	            {
	               longestChain = currentChain;
	            }
	         
	      }
	      System.out.println(longestChain);
	   }
	 

	private void buildChain(List<String> currentChain, List<String> nextWords)
	{
		for (String w : nextWords) 
		{
	         if (!currentChain.contains(w))
	         {
	        	 currentChain.add(w);
	            char lastLetter = w.charAt(w.length() - 1);
	            if (firstCharMap.containsKey(lastLetter))
	            {
	               buildChain(currentChain, firstCharMap.get(lastLetter));
	            }
	            break;
	         }
	      }
	}
}
