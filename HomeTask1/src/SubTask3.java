
public class SubTask3 {
	public static void main(String[] value) {
		int FirstValue = Integer.parseInt(value[0]);
	    int SecondValue = Integer.parseInt(value[1]);
	    int divide = 1; 
	        for (int i = 1; i <= FirstValue && i <= SecondValue; i++) {
	            if (FirstValue / i > 1 && SecondValue / i > 1) {
	            	divide = i; 
	            }
	        }
	    System.out.println(String.format("Subtask 3: %d", divide));

	}
}
