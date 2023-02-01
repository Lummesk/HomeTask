package ua.com.sourceit.subtask2;

public class SubTask2 {

	public static void main(String[] args) {
		System.out.println(substrCount("Good Golly Miss Molly", "ll", 7,
				10));
	}
	public static int substrCount(String input, String needle, int offset, int length) {
	    int count = 0;
	    for (int i = offset; i < offset + length && i < input.length(); i++) {
	        if (input.substring(i, i + needle.length()).equals(needle)) {
	            count++;
	        }
	    }
	    return count;
	}
}
