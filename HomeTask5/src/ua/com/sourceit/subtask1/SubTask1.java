package ua.com.sourceit.subtask1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SubTask1 
{
	private static final int NUM_VALUES = 20;
    private static final int MAX_VALUE = 50;

    private int[] data;

    public SubTask1() 
    {
        this.data = new int[NUM_VALUES];
        Random random = new Random();
        for (int i = 0; i < NUM_VALUES; i++)
        {
            this.data[i] = random.nextInt(MAX_VALUE + 1);
        }
    }

    public void writeDataToFile(String filename) throws IOException 
    {
        try (FileWriter writer = new FileWriter(filename))
        {
            for (int i = 0; i < NUM_VALUES; i++) 
            {
                writer.write(String.valueOf(data[i]));
                if (i < NUM_VALUES - 1) 
                {
                    writer.write(" ");
                }
            }
        }
    }

    public void readDataFromFile(String filename) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            String line = reader.readLine();
            String[] values = line.split(" ");
            for (int i = 0; i < NUM_VALUES; i++) 
            {
                this.data[i] = Integer.parseInt(values[i]);
            }
        }
    }

    public void sortData() {
        for (int i = 0; i < NUM_VALUES - 1; i++) 
        {
            for (int j = 0; j < NUM_VALUES - i - 1; j++) 
            {
                if (data[j] > data[j + 1]) 
                {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public void printData(String filename) throws IOException 
    {
        System.out.println(filename + " ==>");
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) throws IOException 
    {
        SubTask1 sorter = new SubTask1();
        sorter.writeDataToFile("data.txt");
        sorter.readDataFromFile("data.txt");
        sorter.sortData();
        sorter.writeDataToFile("data_sorted.txt");
        sorter.readDataFromFile("data.txt");
        sorter.printData("input");
        sorter.readDataFromFile("data_sorted.txt");
        sorter.printData("output");
    }

}
