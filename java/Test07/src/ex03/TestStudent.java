package ex03;

import java.util.Scanner;

class Student {

	private int num;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	private String  grade;
	private int     rank;

	// Constructor
	public Student(int num, String name, int kor, int eng, int mat) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
	}

	public Student() {

	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public void setTot(int tot) {
		tot = kor + eng + mat;
		this.tot = tot;
	}

	public void setAvg(double avg) {
		avg = tot / 3.0;
		this.avg = avg;
	}

	public int getTot() {
		return tot;
	}

	public double getAvg() {
		return avg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		if (avg >= 90) {
			grade = "A";
		} else {
			if (avg >= 80 && avg < 90) {
				grade = "B";
			} else {
				if (avg >= 70 && avg < 80) {
					grade = "C";
				} else {
					if (avg >= 60 && avg < 70) {
						grade = "D";
					} else {
						grade = "F";
					}
				}
			}
		}
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public  void  display() {
		
		String fmt = "%3d %5s %3d %3d %3d %3d %7.3f %2s %3d ";
		String msg = String.format(fmt, 
			num, name, kor, eng, mat, 
			getTot(), getAvg(), getGrade(), getRank());
		System.out.println(msg);
		
	}
	
	@Override
	public String toString() {
		return "Student [num=" + num 
				+ ", name="	+ name 
				+ ", kor=" + kor 
				+ ", eng=" + eng 
				+ ", mat=" + mat + "]";
	}

}

/*
1,사나,70,80,90
2,모모,0,70,100
3,쯔위,70,90,90
4,정연,80,90,70
5,원영,90,90,89
 */
public class TestStudent {
	// 데이터를 담을 배열
	private static Student[] stud = new Student[6];

	public static void main(String[] args) {
		input();
		process();
		output();
	}

//input
	private static void input() {
		Scanner in = new Scanner(System.in);
		System.out.println("번호 이름 국어 영어 수학");
		for (int i = 0; i < stud.length; i++) {
			String line = in.nextLine();
			String[] li = line.split(",");
			int num = Integer.parseInt(li[0]);
			String name = li[1];
			int kor = Integer.parseInt(li[2]);
			int eng = Integer.parseInt(li[3]);
			int mat = Integer.parseInt(li[4]);
			// stud[i] = new Student(num, name, kor, eng, mat);
			stud[i] = new Student();
			stud[i].setNum(num);
			stud[i].setName(name);
			stud[i].setKor(kor);
			stud[i].setEng(eng);
			stud[i].setMat(mat);
		}

	}

//process
	private static void process() {
		for (int i = 0; i < 6; i++) {
			stud[i].setTot(i);
			stud[i].setAvg(i);
		}
	}

//output
	private static void output() {
		String  title = "번호 이름 국어 영어 수학 총점 평균 학점 석차";
		System.out.println( title );
		
		for (int i = 0; i < stud.length; i++) {
			stud[i].display();
		}
	}

}
