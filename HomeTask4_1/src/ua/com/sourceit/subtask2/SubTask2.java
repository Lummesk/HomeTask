package ua.com.sourceit.subtask2;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SubTask2
{
	public static void main(String[] args)
	{
        try (FileWriter fw = new FileWriter("Випадкові числа.txt"))
        {
            Random rd = new Random();
            for (int i = 0; i < 10; i++)
            {
                fw.write(String.valueOf(rd.nextInt(100)) + "\n");
            }
        } catch (IOException e) 
        {
            System.out.println("Помилка у створюванні файлу");
        }

       
        try (BufferedReader br = new BufferedReader(new FileReader("Випадкові числа.txt")))
        {
            ArrayList<Integer> numbers = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) 
            {
                numbers.add(Integer.parseInt(line));
            }
            Collections.sort(numbers);

            try (FileWriter fw = new FileWriter("Сортованні числа.txt"))
            {
                for (int a : numbers)
                {
                    fw.write(String.valueOf(a) + "\n");
                }
            } catch (IOException e) 
            {
                System.out.println("Помилка запису у файл.");
            }
        } catch (IOException e) 
        {
            System.out.println("Помилка читання з файлу");
        }
    }
}
