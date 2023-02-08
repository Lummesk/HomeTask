package ua.com.sourceit.subtask1;
import java.util.Calendar;

public class Record 
{
	private Calendar date;
    private String text;

    public Record(Calendar date, String text) 
    {
        this.date = date;
        this.text = text;
    }

    public Calendar getDate()
{
        return date;
    }

    public String getText() 
    {
        return text;
    }
}
