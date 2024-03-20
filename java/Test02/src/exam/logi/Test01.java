package exam.logi;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 0;
		String name1 = "";
		int age1 = 0;
		String addr1 = "";
		char gender1 = ' ';

		// 키보드로 주소를 입력받는다
		Scanner  in = new Scanner(System.in);
		
		System.out.println("번호를 입력하세요");
		num1      =  in.nextInt();
		in.nextLine();  // 엔터 무시
		System.out.println("이름을 입력하세요");
		name1     =  in.nextLine();
		System.out.println("나이을 입력하세요");
		age1      =  in.nextInt();
		in.nextLine();  // 엔터 무시
		System.out.println("주소를 입력하세요:");
		addr1     =  in.nextLine();
		System.out.println("성별을 입력하세요");
		gender1 = in.next().charAt(0);
		
		System.out.println("번호:" + num1);
		System.out.println("이름:" + name1);
		System.out.println("나이:" + age1);
		System.out.println("주소:" + addr1);
		System.out.println("성별:" + gender1);
		
		
		if (addr1.equals("부산")) {
			System.out.println("부산 사람");
		} else {
			System.out.println(addr1 + " 사람");
		}
		// 20살 이상 여자
		if (gender1 == '여' && age1 >= 20) {
			System.out.println("20세 이상 여자");
		} else {
			System.out.println("20세 이상 여자아님");
		}
		//20대 여자
		if (gender1 == '여' && age1 >= 20 && age1 < 30) {
			System.out.println("20대 여자");
		} else {
			System.out.println("20대 여자 아님");
		}
		//20대 부산 여자
		if (gender1 == '여' && age1 >= 20 && age1 < 30 && addr1.equals("부산") == true) {
			System.out.println("20대 부산 여자");
		} else {
			System.out.println("20대 부산 여자 아님");
		}
		// 20대 부산, 울산 여자
		if (gender1 == '여' && age1 >= 20 && age1 < 30 && (addr1.equals("부산") == true || addr1.equals("울산") == true)) {
			System.out.println("20대 부산 혹은 울산 여자입니다.");
		} else {
			System.out.println("20대 부산 혹은 울산 여자가 아닙니다.");
		}
	}

}
