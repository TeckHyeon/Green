package array;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray03 {

	public static void main(String[] args) {
		// 0 10 20 30 40 50 60 70 80 90 100
		// 
		char[] grade = new char[] {
				'F', 'F', 'F', 'F', 'F','F','D','C','B','A','A'
		};
		int avg = 79;
		System.out.println(grade[avg/10]);
	}

}
