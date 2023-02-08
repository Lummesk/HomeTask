package ua.com.sourceit.subtask3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SubTask3 
{
  public static void main(String[] args)
  {
    ArrayList<String> lines = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("Текст для завдання 3.txt"))) 
    {
      String line;
      while ((line = reader.readLine()) != null) 
      {
        lines.add(line);
      }
    } catch (FileNotFoundException e) 
    {
    	System.out.println("Файл не знайдено");
    } catch (IOException e) 
    {
    	System.out.println("Помилка читання з файлу");
    }

    try (FileWriter writer = new FileWriter("Текст для завдання 3.txt")) 
    {
      for (int i = lines.size() - 1; i >= 0; i--) 
      {
        writer.write(lines.get(i) + System.lineSeparator());
      }
    } catch (IOException e)
    {
    	System.out.println("Помилка запису у файл");
    }
  }
}
