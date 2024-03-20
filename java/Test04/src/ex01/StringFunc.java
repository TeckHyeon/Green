package ex01;

import java.util.Arrays;

public class StringFunc {

	public static void main(String[] args) {

		// int num = (int) 0.0; // casting : 강제로 형변환
		// int num = null;
		// null은 준소이므로 reference type에만 저장
		// reference type : String, class, 배열 -> null 가능
		
		String str1 = null; 		// null 주소 : 주소가 0 heap 영역 데이터 사용 X
		System.out.println(str1);
		// System.out.println(str1.toUpperCase()); // null.함수 : 무조건 NullPointer Exception

		String str2 = ""; // 빈문자열(empty string
		System.out.println(str2);
		System.out.println(str2.toUpperCase()); // 정상 출력

		String s1 = "Hello";
		System.out.println(s1);
		System.out.println(s1.toUpperCase()); // 대문자로
		System.out.println(s1.toLowerCase()); // 소문자로

		// 문자열 추출
		String tel = "010-7561-1447";
		System.out.println(tel);
		String tel1 = tel.substring(0, 2 + 1); // "010";
		System.out.println(tel1);
		String tel2 = tel.substring(4, 7 + 1);
		System.out.println(tel2);
		String tel3 = tel.substring(9, 12 + 1);
		System.out.println(tel3);

		String jumin = "961225-1201204";
		String year = jumin.substring(0, 2); // 96
		String month = jumin.substring(2, 4); // 12
		String date = jumin.substring(4, 6); // 25
		String gender = jumin.substring(7, 8);
// int <- String : Integer.parseInt("");		
		int age = 2024 - (1900 + Integer.parseInt(year));
		System.out.println(age);
		// 20대
		if (20 <= age && age < 30) {
			System.out.println("20대");
		} else {
			System.out.println("20대 아님");
		}
		System.out.println("==========================================================");
		// 구분자(-)를 기준으로 문자를 자라서 배열에 저장
		String[] juminArr = "961225-1201204".split("-");
// 		juminArr[0] = "961225";
// 		juminArr[1] = "1201204";
		String[] j = juminArr[0].split("");
		System.out.println(Arrays.toString(j));

		// 문자검색
		// 01234567890
		String s2 = "Hello World";
		int pos1 = -1;
		int pos2 = -1;
		if ((pos1 = s2.indexOf("Hello")) > -1) {
			System.out.println("찾았다 " + pos1);
		} else {
			System.out.println("못 찾았다");
		}
		if ((pos2 = s2.indexOf('o', pos1 + 1)) > -1) {
			System.out.println("찾았다 " + pos2);
		} else {
			System.out.println("못 찾았다");
		}

		String names = "민지 하니 다니엘 해린 혜인";
		System.out.println(names.indexOf("다니엘"));
		System.out.println("===============");
		String names2 = "John Doe, Jane Doe, Tom Brown";
		System.out.println(names2.indexOf("John Doe"));  
		System.out.println(names2.toLowerCase().indexOf("John doe"));  
	}
}
