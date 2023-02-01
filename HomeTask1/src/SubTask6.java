
public class SubTask6 {
	public static final int alphabetLength = 26;
	public static void main(String[] args) {
		
		System.out.println("Subtask 6:");
		System.out.println(charToValue("BCA"));	
		System.out.println(valueToChar (1431));
		System.out.println(rightValue ("BCB"));
	
	}
	
	 public static int charToValue (String args){
		int value = 0;
		char[] pos = new char[args.length()];
		for (int i = 0; i < args.length();i++) 
		{
			pos[i] = (args.charAt(i));
			int a = 0;
				if (i == (args.length() -1))
				{
					a += (pos[i] - 64);
				}
				else
				{
					a += ((pos[i] - 64) * Math.pow(alphabetLength, ((args.length() - 1) - i)));
				}
				value += a;
			
		}
		return value;
		}
	 public static StringBuilder valueToChar (int value){
		 StringBuilder str = new StringBuilder("");
			int dividend = value;
			while (dividend !=0) 
			{ 
				int a = dividend % alphabetLength;
			if (a == 0)
				{
				str.insert(0,"Z");
				dividend = (dividend - 1) / alphabetLength;
			    }
			
			else 
			    {
				str.insert(0,(char)(a+64));
			    dividend = (dividend - a) / alphabetLength;
			    }
			
			}
			return str;
	     }
	 public static int rightValue (String args) {
		 int a = charToValue (args);
		 return a++;
	 }
	
	 }



	

