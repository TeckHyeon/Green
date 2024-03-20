package ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class Student {
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	private String grade;
	private int rank;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Student(int num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", avg=" + avg + ", grade=" + grade + ", rank=" + rank + "]";
	}

}

public class TestFileScore {

	private static ArrayList<Student> studList;

	public static void main(String[] args) throws IOException {

		studList = new ArrayList<>();

		input();
		process();
		output();

	}

	private static void input() throws IOException {
		String path = TestFileScore.class.getResource("").getPath();
		String fileName = "data3.txt";
		System.out.println(path);
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] li = line.split(",");
			int num = Integer.parseInt(li[0]);
			String name = li[1];
			int kor = Integer.parseInt(li[2]);
			int eng = Integer.parseInt(li[3]);
			int mat = Integer.parseInt(li[4]);
			Student stud = new Student();
			stud.setNum(num);
			stud.setName(name);
			stud.setKor(kor);
			stud.setEng(eng);
			stud.setMat(mat);
			studList.add(stud);
		}

	}

	private static void process() {
		for (int i = 0; i < studList.size(); i++) {
			Student stud = studList.get(i);
			int sum = stud.getKor() + stud.getEng() + stud.getMat();
			stud.setTot(sum);
			stud.setAvg(sum / 3.0);
			switch ((int) stud.getAvg() / 10) {
			case 10:
			case 9:
				stud.setGrade("A");
				break;
			case 8:
				stud.setGrade("B");
				break;
			case 7:
				stud.setGrade("C");
				break;
			case 6:
				stud.setGrade("D");
				break;
			default:
				stud.setGrade("F");
				break;
			}

		}

		Collections.sort(studList, (a, b) -> {
			return b.getTot() - a.getTot();
		});
		int prevScore = 0;
		for (int i = 0; i < studList.size(); i++) {
			Student s = studList.get(i);
			if (s.getTot() == prevScore) { // 이전 학생의 점수와 비교 같으면
				s.setRank(studList.get(i - 1).getRank());
			} else { // 같지 않으면
				s.setRank(i + 1);
				prevScore = s.getTot();
			}

		}
		Collections.sort(studList, (a, b) -> {
			return a.getRank() - b.getRank();
		});

		/*
		 * for (int i = 0; i < studList.size(); i++) {
		 * 
		 * int rank = 1; for (int j = 0; j < studList.size(); j++) { if
		 * (studList.get(i).getTot() < studList.get(j).getTot()) { rank++; } }
		 * studList.get(i).setRank(rank); }
		 */

	}

	private static void output() throws IOException {

		String title = "번호 이름 국어 영어 수학 총점 평균 학점 석차\n";
		String msg = title;
		String fmt = "%3d %-5s %3d %3d %3d %3d %6.2f %s %2d\n";
		for (Student s : studList) {
			msg += String.format(fmt, s.getNum(), s.getName(), s.getKor(), s.getEng(), s.getMat(), s.getTot(),
					s.getAvg(), s.getGrade(), s.getRank());
		}

		// 출력 : 화면
		System.out.println(msg);
		// 파일 준비
		// String path
		// = TestFileScore.class.getResource("").getPath(); // bin/ex02
		String path = "D:\\dev\\java\\PrjIO\\src\\ex02\\";
		String ofilename = path + "result3.txt";
		FileWriter fw = new FileWriter(ofilename);
		BufferedWriter bw = new BufferedWriter(fw);

		// 출력 : 파일
		bw.write(msg);

		// 파일 닫기
		bw.close();
		fw.close();

	}

}
