package exam.condition;

public class Test01 {

	public static void main(String[] args) {
		// 0 ~ 10 : 아침시간입니다
		// 11 ~ 15 : 점심시간입니다
		// 16 ~ 23 : 저녁시간입니다
		int time = 9;
		if(0<=time && time<=10) {
			System.out.println("아침시간입니다.");
		}else if(10<time && time<=15) {
			System.out.println("점심시간입니다.");
		} else if(15<time && time<=23) {
			System.out.println("저녁시간입니다.");
		} else {
			System.out.println("잘못된 입력값입니다.");
		}

	}

}
