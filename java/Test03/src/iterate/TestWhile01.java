package iterate;

import java.util.Scanner;

public class TestWhile01 {
public static void main(String[] args) {
	for(int i=1; i<=5; i++) {
		System.out.println("나나");
	}
	
	int i =1;
	while (i<=5) {
		System.out.println("나나");
		i++;
	}
	//무한 루프 (무한 반복) - 조건이 항상 true 반드시 탈출 조건 필요
	while(true) {
		Scanner  in = new Scanner(System.in);
		System.out.println("a");
		String ans = in.nextLine();
		if (ans.equals("n")) 
		{System.out.println("종료");
			break;
			
		}
	}
}
}
