
public class SubTask4 {
	public static void main(String[] value) {
		int a = Integer.parseInt(value[0]);
		int sum = 0;
		while(a != 0){		        
			sum += (a % 10);
		        a/=10;
		}
	System.out.println(String.format("Subtask 4: %d", sum));
}
}
