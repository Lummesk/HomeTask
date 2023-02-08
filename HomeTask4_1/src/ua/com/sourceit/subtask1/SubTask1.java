package ua.com.sourceit.subtask1;



public class SubTask1 
{
	public static void main (String[]args)
	{
		Notepad notepad = new Notepad();
		notepad.addRecord("Перший запис");
        notepad.addRecord("Другий запис");
        notepad.getRecords();
	}
}
