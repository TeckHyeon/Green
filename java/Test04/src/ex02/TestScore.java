package ex02;

public class TestScore {
 /*
번호,이름,국어,영어,수학
1,사나,70,80,90
2,모모,0,70,100   
3,쯔위,70,90,90
4,정연,80,90,70
*/
	//공통변수 영역 - 전역 변수
	
	static String name="미나";
	
	public static void main(String[] args) {
		// 성적처리
		input();
		process();
		output();
	}

private static void input() {
	System.out.println("\ninput");
	String name = "모모";
	System.out.println(name);
}

private static void process() {
	System.out.println("\nprocess");
	System.out.println(name);
	}

private static void output() {
	System.out.println("\noutput");
	System.out.println(name);
}

}
