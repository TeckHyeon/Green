/*
 * 번호,이름,국어,영어,수학 
 * 1,사나,70,80,90 
 * 2,모모,80,70,100 
 * 3,쯔위,70,90,90 
 * 4,정연,80,90,70 
 * 5,원영,90,90,89
 * 6,유진,100,100,100
 */
package ex05;

class Student extends Object {

	// Fields
	int num;
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double avg;
	String grd;

	@Override
	public String toString() {
		// return super.toString();// 부모(super)의 기능
		String fmt = "%d %5s %3d  %3d  %3d  %3d  %6.3f %s"; // 6.3f
		tot = this.kor + this.eng + this.mat;
		avg = (double) tot / 3.0;
		String msg = String.format(fmt, this.num, this.name, this.kor, this.eng, this.mat, this.tot, this.avg,
				this.grd);
		return msg;
	}

	public Student(int num, String name, int kor, int eng, int mat) {
		this();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public Student() {
		System.out.println("---------------------------");
	}

}

public class TestMain {

	public static void main(String[] args) {
//		Student s = new Student();
//		s.display();
		Student s = new Student();
		s.num = 6;
		s.name = "유진";
		s.kor = 100;
		s.eng = 100;
		s.mat = 100;
		System.out.println(s);
		Student s2 = new Student(1, "사나", 70, 80, 90);
		System.out.println(s2);
		Object o = new Object();
		System.out.println(o.toString());
	}

}
