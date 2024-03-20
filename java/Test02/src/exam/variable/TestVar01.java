package exam.variable;

public class TestVar01 {
	
	public static void main(String[] args) {
		System.out.println(35);
		System.out.println(-4.5);
		System.out.print(0xff + "\n"); // 16진수
		System.out.print(0777 + "\n"); // 8진수
		System.out.print(0b01000001 + "\n"); //2진수
		
		//System.out.println(10000000000); // 에러 21억 최대 (8BYTE)
		System.out.println(1.0e10);
		// 10000000000 : 10의 10승 - 실수(지수) exponent
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
	}
}
