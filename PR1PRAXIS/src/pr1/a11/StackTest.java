package pr1.a11;

import java.io.PrintWriter;

public class StackTest {
	
	public static void main(String[] args){
		ListStack teststack = new ListStack(3);
		PrintWriter out = new PrintWriter(System.out,true);
		teststack.push("Test 1");
		teststack.push("Test 2");
		teststack.push("Test 3");
		out.println(teststack.peek());
		teststack.push("Test 4");
		out.println(teststack.peek());
		out.println(teststack.pop());
		out.println(teststack.pop());
		out.println(teststack.pop());
		out.println(teststack.peek());
	}
}
