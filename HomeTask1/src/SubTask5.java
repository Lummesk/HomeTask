
public class SubTask5 {
	public static void main(String[] value) {
		int a = Integer.parseInt(value[0]);
		System.out.print("Subtask 5:");
		for (int j = 1; j < a; j++) {
	        int k = 0;
	        for (int i = 1; i < j+1; i++) {
	            if (j % i == 0) {
	                k++;
	            }

	        }
	        if (k == 2) {
	        	System.out.print(String.format(" %d", j));
	        }
	    }
		System.out.println();
}
}