package array;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray04 {

	public static void main(String[] args) {
		// 0 10 20 30 40 50 60 70 80 90 100
		//
//		String names[] = new String[] { "카리나", "윈터", "마동석", "미나", "쯔위" };
		String [] names = {
				"카리나", "윈터", "마동석", "미나", "쯔위"
		};
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " ");
		}
		System.out.println();
		for (String name : names) {
			System.out.print(name + " ");
		}
		System.out.println();
		System.out.println(names);
		System.out.println(Arrays.toString(names));
	}
}
