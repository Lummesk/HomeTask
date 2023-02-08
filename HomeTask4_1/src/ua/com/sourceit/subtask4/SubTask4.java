package ua.com.sourceit.subtask4;

import java.util.Stack;

public class SubTask4 {
	public static void main (String[]args) 
	{
		int num = 1234;
		Stack<Integer> stack = new Stack<>();
		while (num>0) 
		{
			stack.push(num%10);
            num=num/10;
		}
		int reverse = 0;
		int p = 1;
		while(!stack.isEmpty()) 
		{
			int a = stack.pop();
			reverse=reverse + a*p;
            p=p*10;
		}
		System.out.println(reverse);
	}
}
