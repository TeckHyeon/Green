package array;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray02 {

	public static void main(String[] args) {
		// Array : 배열
		// 배열 : 같은 type과 같은 이름을 가진 변수 여러개의 모음
		String name1 = "카리나";
		String name2 = "윈터";
		String name3 = "마동석";
		String name4 = "미나";
		String name5 = "쯔위";
		String[] names = new String[5]; // String 변수 5개를 만든다 - 배열로
										// names[0], names[1], names[2], names[3], names[4] : 0 ~ 4
		names[0] = name1;
		names[1] = name2;
		names[2] = name3;
		names[3] = name4;
		names[4] = name5;

		for (int i = 0; i < names.length; ++i) {
			System.out.println(names[i] + " ");
		}
//		ArrayList<String> name = new ArrayList<>(Arrays.asList(name1, name2, name3, name4, name5));
//		for (int i = 0; i < name.size(); ++i) {
//			System.out.println(name.get(i) + " ");
//		}
	}

}
