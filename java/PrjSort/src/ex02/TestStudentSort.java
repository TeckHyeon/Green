package ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Student implements Comparable {
	private int sno;
	private String name;

	public Student(int sno, String name) {
		this.setSno(sno);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [sno=" + getSno() + ", name=" + name + "]";

	}

	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;
		return this.getSno() - s.getSno();
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}
	
	
}

public class TestStudentSort {

	public static void main(String[] args) {

		Student[] stud = new Student[5];
		stud[0] = new Student(1, "카리나");
		stud[1] = new Student(5, "윈터");
		stud[2] = new Student(4, "안유진");
		stud[3] = new Student(2, "장원영");
		stud[4] = new Student(6, "미나");

		display(stud);
		// 번호 오름차순 정렬
		Arrays.sort(stud);
		display(stud);
		System.out.println("====================================");
		//--------------------
		ArrayList<Student> sList = new ArrayList<>();
		sList.add(new Student(10, "나나"));
		sList.add(new Student(20, "가나"));
		sList.add(new Student(16, "사나"));
		sList.add(new Student(13, "다나"));
		sList.add(new Student(11, "하나"));
		sList.add(new Student(15, "자나"));
		dispList(sList);
		
		Comparator<Student> comp1 = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o2.getSno()-o1.getSno();
			}
		};
		
/*		Collections.sort(sList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o2.getSno()-o1.getSno();
			}
		});*/
		dispList(sList);
		
		
	}

	private static void dispList(ArrayList<Student> sList) {
		for (Student stud : sList) {
			System.out.println(stud + " ");
		}
		System.out.println();
	}

	private static void display(Student[] stud) {

		for (int i = 0; i < stud.length; i++) {
			System.out.printf(stud[i] + " ");
		}
		System.out.println();
	}

}
