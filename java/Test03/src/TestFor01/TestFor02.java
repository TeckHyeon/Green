package TestFor01;

public class TestFor02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1+2+3+4+5+6+7+8+9+10=
		// 2+4+6+8+10+....+20=
		// 1+1+2+1+2+3+1+2+3+4+1+2+3+4+5=
		// 1+2+4+8+16+32+64+128+256=
		// 1+2+3+5+8+13+21
		func1();
		func2();
		func2_2();
		func2_3();
		func3();
		func4();
		func4_2();
		func5();
		func6();
	}

	private static void func1() {
		int sum1 = 0;
		for (int i = 1; i <= 10; i++) {
			sum1 += i;
		}
		System.out.println(sum1);

	}

	private static void func2() {
		int sum2 = 0;
		for (int j = 1; j <= 10; j++) {
			sum2 += j * 2;
		}
		System.out.println(sum2);

	}

	private static void func2_2() {
		int sum = 0;
		for (int i = 2; i <= 20; i = i + 2) {
			sum += i;
		}
		System.out.println(sum);
	}

	// 1+3+5+7+9+11+13+15+17+...+99
	// 1에서 100사이의 수 중 홀수 합
	private static void func2_3() {
		int sum = 0;
//		for (int i = 1; i <= 50; i++) {
//			sum += 2*i-1;
//		}
		for (int i = 1; i <= 100; i += 2) {
			sum += i;
		}
		System.out.println(sum);
	}

	private static void func3() {
		int sum3 = 0;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				sum3 += j;
			}
		}
		System.out.println(sum3);

	}

	private static void func4() {
		int sum4 = 0;
		for (int i = 0; i <= 8; i++) {
			sum4 += Math.pow(2, i);
		}
		System.out.println(sum4);

	}

	private static void func4_2() {
		int sum4 = 0;
		for (int i = 1; i <= 256; i *= 2) {
			sum4 += i;
		}
		System.out.println(sum4);

	}

	private static void func5() {
		int result = 0;
		int num1 = 0;
		int num2 = 1;
		int answer = 0;
		for (int i = 0; i <= 6; i++) {
			result = num1 + num2;
			num1 = num2;
			num2 = result;
			answer += result;
		}
		System.out.println(answer);

	}

// 58+23+17+45+3+7+16+456= 규칙을 모를 때 반복하기 - 배열
	private static void func6() {
		int[] nums = { 58, 23, 17, 45, 3, 7, 16, 456 };
		int sum = 0;
		for (int i = 0; i<nums.length; i++) {
			sum+=nums[i];
		} System.out.println(sum);
	}

}