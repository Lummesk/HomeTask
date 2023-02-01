package ua.com.sourceit.subtask1;

import java.util.Stack;

public class SubTask1 {

	public static void main(String[] args) {

		System.out.println(testString("isu([syvstc]ts(crs))cs"));

	}
	public static boolean testString(String str) {
	    Stack<Character> stack = new Stack<>();
	    for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if (c == '(' || c == '[') {
	            stack.push(c);
	        } else if (c == ')' || c == ']') {
	            if (stack.isEmpty()) {
	                return false;
	            }
	            char closeChar = stack.pop();
	            if (c == ')' && closeChar != '(' || c == ']' && closeChar != '[') {
	                return false;
	            }
	        }
	    }
	    return stack.isEmpty();
	}

}
