package ua.com.sourceit.hometask3;
import java.util.Arrays;
import java.util.Comparator;

public class SubTask3 
{

    public static void main(String[] args) 
    {
        String text = "Java is a high-level class-based object-oriented programming language that is designed to have as few implementation dependencies as possible";
        String letter = "a";
        String[] words = text.split(" ");

        Arrays.sort(words, new Comparator<String>() 
        {
            @Override
            public int compare(String o1, String o2) 
            {
                int count1 = countLetter(o1, letter);
                int count2 = countLetter(o2, letter);
                if (count1 == count2) 
                {
                    return o1.compareTo(o2);
                }
                return Integer.compare(count1, count2);
            }
        });

        for (String word : words) 
        {
            System.out.println(word);
        }
    }

    private static int countLetter(String word, String letter) 
    {
        int count = 0;
        for (int i = 0; i < word.length(); i++) 
        {
            if (word.charAt(i) == letter.charAt(0)) 
            {
                count++;
            }
        }
        return count;
    }
}

