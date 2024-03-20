package ex06;

import java.util.Scanner;

/*
번호,이름,국어,영어,수학
1,사나,70,80,90
2,모모,0,70,100
3,쯔위,70,90,90
4,정연,80,90,70
5,원영,90,90,89
6,유진,100,100,100
*/

class Student extends Object {

	// Fields
	int num;
	String name;
	int kor;
	int eng;
	int mat;
	static int classNum;

	// Consturctor
	public Student() {
	}

	public Student(int num, String name, int kor, int eng, int mat) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	// Methods
	int getTot() {
		int tot = kor + eng + mat;
		return tot;
	}

	double getAvg() {
		double avg = getTot() / 3.0;
		return avg;
	}

	String getGrd() {
		String grd = "";
		if (getAvg() >= 90) {
			grd = "A";
		} else {
			if (getAvg() >= 80 && getAvg() < 90) {
				grd = "B";
			} else {
				if (getAvg() >= 70 && getAvg() < 80) {
					grd = "C";
				} else {
					if (getAvg() >= 60 && getAvg() < 70) {
						grd = "D";
					} else {
						grd = "F";
					}
				}
			}
		}
		return grd;
	}

	// toString
	@Override // Override - 기능 재정의
	public String toString() {
		String fmt = "%d %5s %3d  %3d  %3d  %3d  %6.3f %s";
		String msg = String.format(fmt, this.num, this.name, this.kor, this.eng, this.mat, getTot(), getAvg(),
				getGrd());
		return msg;
		// return super.toString(); // 부모(super) 의 기능
	}

}

public class TestMain {

	// Fields
	static Student s;

	// method
	public static void main(String[] args) {

		input();
		process();
		output();

	}

	// input()
	private static void input() {

		Scanner in = new Scanner(System.in);

		s = new Student();
		System.out.println("번호 이름 국어 영어 수학");
		String line = in.nextLine();
		String[] li = line.split(",");
		s.num = Integer.parseInt(li[0]);
		s.name = li[1];
		s.kor = Integer.parseInt(li[2]);
		s.eng = Integer.parseInt(li[3]);
		s.mat = Integer.parseInt(li[4]);
		//Student.classNum = 3;

	}

	// process
	private static void process() {

	}

	// output()
	private static void output() {

		System.out.println("번호 이름 국어 영어 수학 총점 평균 성적");
		System.out.println(s.toString());

	}

}
