

public class SubTask2 {

	public static void main(String[] args) {
		
		
			StringBuilder strBuilder = new StringBuilder("Subtask 2:");
			strBuilder.append(args[0]);
			String space= " ";
			for (int i = 1; i < args.length; i++)
			{
				strBuilder.append(space);
			strBuilder.append(args[i]);}
		    System.out.println(strBuilder.toString());
		  }
}


