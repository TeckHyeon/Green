package ex01;

import java.util.Scanner;

public class StringEquals {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name1 = "안유진";
		String name2 = "안유진";
		String name3 = "";
		System.out.println("이름:");
		name3 = in.nextLine();
		System.out.println(name3);

		if (name1 == name2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		if (name1 == name3) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		System.out.println("==================================================");
		if (name1.equals(name2))
			System.out.println("같다");
		else
			System.out.println("다르다");

		if (name1.equals(name3))
			System.out.println("같다");
		else
			System.out.println("다르다");
		String name4 = "이순신";
		String name5 = "이이";
		System.out.println(name4.hashCode());
		System.out.println(name5.hashCode());
		// if(name4 > name5) // 의미없다 - 주소비교라서
		// 문자열 > , < 의 비교 : 순서를 따진다.
		System.out.println("abb".compareTo("aba"));
		System.out.println(name4.compareTo(name5));
			if(name4.compareTo(name5) < 0)
				System.out.println("name4 가 name5 보다 작은 순서");
			
			else {
				if(name4.compareTo(name5) == 0)
				System.out.println("name4 가 name5 와 같다");
				else
					System.out.println("name4가 name5 보다 큰 순서");
			}
			System.out.println(name4.length());
			System.out.println(name5.length());
			System.out.println(name4.getBytes().length+" 바이트");
	}
}
