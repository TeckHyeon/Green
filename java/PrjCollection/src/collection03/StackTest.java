package collection03;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String>  stack = new Stack<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		String s1 = stack.pop();
		System.out.println(s1 + stack.size());
		String s2 = stack.pop();
		System.out.println(s2 + stack.size());
		String s3 = stack.pop();
		System.out.println(s3 + stack.size());
		//주소는 순서대로 호출은 역순으로
	}

}
