package array;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray01 {

	public static void main(String[] args) {
		// Array : 배열
		// 5명 이름 입력받고 출력한다
		String name1 = "카리나";
		String name2 = "윈터";
		String name3 = "마동석";
		String name4 = "미나";
		String name5 = "쯔위";
//		System.out.println(name1);
//		System.out.println(name2);
//		System.out.println(name3);
//		System.out.println(name4);
//		System.out.println(name5);
		ArrayList<String> name = new ArrayList<>(Arrays.asList(name1, name2, name3, name4, name5));
        for (int i = 0; i < name.size(); ++i) {
            System.out.println(name.get(i) + " ");
        }
	}

}
