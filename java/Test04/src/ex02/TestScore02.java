package ex02;

import java.util.Scanner;

public class TestScore02 {
	/*
	 * 번호,이름,국어,영어,수학 
	 * 1,사나,70,80,90 
	 * 2,모모,80,70,100 
	 * 3,쯔위,70,90,90 
	 * 4,정연,80,90,70 
	 * 5,원영,90,90,89
	 * 6,유진,100,100,100
	 */
	// 공통변수 영역 - 전역 변수

	static int num;
	static String name;
	static int kor;
	static int eng;
	static int mat;
	static int tot;
	static double avg;
	static String grd;

	public static void main(String[] args) {
		// 성적처리
		input();
		process();
		output();
	}

//입력 : 번호 이름 국어 영어 수학
	private static void input() {
		System.out.println("\ninput");
		Scanner in = new Scanner(System.in);
		System.out.println("입력 : 번호, 이름, 국어, 영어, 수학");
		String line = in.nextLine(); // 0 1 2 3 4
		String[] li = line.split(","); // "1","사나","70","80","90"
		num = Integer.parseInt(li[0]);
		name = li[1];
		kor = Integer.parseInt(li[2]);
		eng = Integer.parseInt(li[3]);
		mat = Integer.parseInt(li[4]);
		// 학점

	}

	private static void process() {
		System.out.println("\nprocess");
		tot = kor + eng + mat;
		avg = (double) tot / 3.0;
		getGrade();

	}

	private static void getGrade() {
		// 학점
		if (avg >= 90) {
			grd = "A";
		} else {
			if (avg >= 80 && avg < 90) {
				grd = "B";
			} else {
				if (avg >= 70 && avg < 80) {
					grd = "C";
				} else {
					if (avg >= 60 && avg < 70) {
						grd = "D";
					} else {
						grd = "F";
					}
				}
			}
		}

	}

// 석차
//학점, 실수, 석차 추가
//학점 : 90~ A, 80~ B, 70~ C, 60~ D , 나머지 F

	private static void output() {
		System.out.println("\noutput");
		String title = "번호 이름 국어 영어 수학 총점  평균  성적";
		String fmt = "%d %5s %3d  %3d  %3d  %3d  %6.3f %s"; // 6.3f
		String msg = String.format(fmt, num, name, kor, eng, mat, tot, avg, grd);
		System.out.println(title);
		System.out.println(msg);
	}

}
