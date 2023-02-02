package ua.com.sourceit.hometask3;

public class SubTask2
{
	    public static void main(String[] args) 
	    {
	    String originalText = "Java (вимовляється Джава) — об'єктно-орієнтована мова програмування";
        StringBuilder encryptedText = new StringBuilder();
        int index = 1;
        while (index <= 3) 
        {
            for (int i = index - 1; i < originalText.length(); i += 3)
            {
                encryptedText.append(originalText.charAt(i));
            }
            index++;
        }
        System.out.println("Original text: " + originalText);
        System.out.println("Encrypted text: " + encryptedText);
	    }
	}

