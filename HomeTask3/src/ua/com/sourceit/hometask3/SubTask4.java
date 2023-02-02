package ua.com.sourceit.hometask3;

public class SubTask4 
{
	public static void main(String[] args)
	{
		replaceText("У реченні з слів перше слово поставити на місце другого");
	}

	public static void replaceText(String text) 
	{
		String cleanText = text.replaceAll("[^а-яА-ЯіІїЇ\\s]", "").toLowerCase();
		String [] words = cleanText.split("\\s+");
		StringBuilder reversed = new StringBuilder(words[words.length-1]);
	    for (int i = 0; i < words.length -1; i++) 
	    {
	      reversed.append(" ").append(words[i]);
	    }
	    System.out.println(reversed.toString());
	}
}
