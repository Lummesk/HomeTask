package ua.com.sourceit.subtask1;
import java.util.ArrayList;
import java.util.Calendar;


public class Notepad 
{
	private ArrayList<ArrayList<Record>> records;

    public Notepad() 
    {
        records = new ArrayList<ArrayList<Record>>();
    }
    public void addRecord(String text) 
    {
        Calendar date = Calendar.getInstance();
        int index = -1;
        for (int i = 0; i < records.size(); i++) 
        {
            Calendar recordDate = records.get(i).get(0).getDate();
            if (recordDate.get(Calendar.YEAR) == date.get(Calendar.YEAR)
                    && recordDate.get(Calendar.MONTH) == date.get(Calendar.MONTH)
                    && recordDate.get(Calendar.DAY_OF_MONTH) == date.get(Calendar.DAY_OF_MONTH)) 
            {
            	index = i;
                break;
            }
        }
        if (index == -1) 
        {
            ArrayList<Record> newDateRecords = new ArrayList<Record>();
            newDateRecords.add(new Record(date, text));
            records.add(newDateRecords);
        } else {
            records.get(index).add(new Record(date, text));
        }
    }

    public void getRecords()
    {
    	 for (ArrayList<Record> dateRecords : records) 
    	 {
             Calendar date = dateRecords.get(0).getDate();
             System.out.println("Date: " + date.get(Calendar.YEAR) + "-"
                     + (date.get(Calendar.MONTH) + 1) + "-" + date.get(Calendar.DAY_OF_MONTH));
             for (Record record : dateRecords) 
             {
                 System.out.println("  " + record.getText());
             }
         
    	 }
     }
}
