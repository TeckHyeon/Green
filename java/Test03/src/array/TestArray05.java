package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestArray05 {

	public static void main(String[] args) {
//		int[] nums = { 32, 23, 17, 6, 89 };
		int sum = 0;
		int[] nums = new int[5];
		nums[0] = 32;
		nums[1] = 23;
		nums[2] = 17;
		nums[3] = 6;
		nums[4] = 89;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		System.out.println(sum);
		Scanner in = new Scanner(System.in);
		System.out.println("주민번호입력(123456-7890123);");
		String juminStr = in.nextLine();
		System.out.println(juminStr);
		String[] juminArr = juminStr.split("-");
//	juminArr[0] = "123456";
//	juminArr[1] = "789123";
		
		
		
		int[] jumin = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3 };
		int[] digit = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		int sum1 = 0;
		for (int i = 0; i < digit.length; i++) {
			sum1 += (jumin[i] * digit[i]);
		}
		System.out.println("sum1의 값" + sum1);
		int x = 11 - (sum1 % 11);
		if (x == jumin[12]) {

			System.out.println("주민등록번호의 마지막 번호는 " + x + "입니다.");
		} else {
			System.out.println("틀린 번호입니다" + x);
		}

	}
}
