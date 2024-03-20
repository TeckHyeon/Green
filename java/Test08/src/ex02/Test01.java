package ex02;
// 입력 1줄 -> 결과 1줄

import java.time.LocalDate;
import java.util.Scanner;

// 입력data : 사번,이름,입사일,월급,부서번호
// 출력     : 사번,이름,입사일,월급,보너스,수령액,부서명

// 금액은 소수이하 두자리로 반올림
// 보너스   =  연차에 따라 월급의 0.5% 로 계산한다
// 수령액   =  월급 + 보너스
// 부서명   =  10:인사,20:자재,30:총무,40:연구개발,50:생산,60:서비스

// 모든기능은 class애 구현한다.
// 입력data
// 사번,이름,입사일,월급,부서번호
/*
100,사나,20110101,300.0,10
200,모모,20120301,270.0,20
300,정연,20091003,250.0,30
400,나연,20110105,220.0,40
500,미나,20180401,170.0,60
600,쯔위,2020801,200.0,50
*/

interface IEmplo {
	void input();

	void process();

	void output();
}

class Employee {

	// 입력 데이터

	// 사번
	private int num;
	// 이름
	private String name;
	// 입사일
	private String date;
	// 월급
	private double sal;
	// 부서번호
	private int depNum;

	// 출력 데이터

	// 보너스
	private double bonus;
	// 수령액
	private double rec;
	// 부서명
	private String depName;

	public Employee() {

	}

	public Employee(String line) {
		String[] li = line.split(",");
		int num = Integer.parseInt(li[0]);
		String name = li[1];
		String date = li[2];
		double sal = Double.parseDouble(li[3]);
		int depNum = Integer.parseInt(li[4]);

		this.num = num;
		this.name = name;
		this.date = date;
		this.sal = sal;
		this.depNum = depNum;
	}

	public Employee(int num, String name, String date, double sal, int depNum) {
		super();
		this.num = num;
		this.name = name;
		this.date = date;
		this.sal = sal;
		this.depNum = depNum;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public double getSal() {
		return sal;
	}

	public int getDepNum() {
		return depNum;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public void setDepNum(int depNum) {
		this.depNum = depNum;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public void setRec(double rec) {
		this.rec = rec;
	}

	// 출력 : 사번,이름,입사일,월급,보너스,수령액,부서명
	@Override
	public String toString() {
		return "사번 : " + num + ", 이름 : " + name + ", 입사일 : " + date + ", 월급 : " + sal + "만원, 보너스 = " + bonus
				+ "만원, 수령액 : " + rec + "만원, 부서명 : " + depName;
	}

	public void display() {
		String fmt = "%3d %3s %4s %6.1f %5.1f %8.1f %5s";
		String msg = String.format(fmt, num, name, date, sal, bonus, rec, depName);
		System.out.println(msg);

	}

}

class Emplo implements IEmplo {
	private static Employee[] emplo = new Employee[6];

	public Emplo() {

	}

	@Override
	public void input() {
		Scanner in = new Scanner(System.in);
		System.out.println("사번,이름,입사일,월급,부서번호");
		for (int i = 0; i < emplo.length; i++) {
			String line = in.nextLine().trim();
			emplo[i] = new Employee(line);
		}
		in.close();
	}

	@Override
	public void process() {

		for (int j = 0; j < emplo.length; j++) {
			// 보너스 계산
			LocalDate now = LocalDate.now();
			int thisYear = now.getYear();
			int inYear = Integer.parseInt(emplo[j].getDate().substring(0, 4));
			int years = thisYear - inYear;

			if (years <= 1) {
				emplo[j].setBonus(0);
			} else {
				emplo[j].setBonus(0.005 * years * emplo[j].getSal());
			}

			// 수령액 계산
			emplo[j].setRec(emplo[j].getSal() + emplo[j].getBonus());

			// 부서명
			// 10:인사,20:자재,30:총무,40:연구개발,50:생산,60:서비스
			switch (emplo[j].getDepNum()) {
			case 10:
				emplo[j].setDepName("인사");
				break;
			case 20:
				emplo[j].setDepName("자재");
				break;
			case 30:
				emplo[j].setDepName("총무");
				break;
			case 40:
				emplo[j].setDepName("연구개발");
				break;
			case 50:
				emplo[j].setDepName("생산");
				break;
			case 60:
				emplo[j].setDepName("서비스");
				break;

			default:
				emplo[j].setDate(null);
				break;
			}

		}

	}

	@Override
	public void output() {
		String title = "사번, 이름, 입사일, 월급, 보너스, 수령액, 부서명";
		title = title.replace(",", " ");
		System.out.println(title);
		for (int i = 0; i < emplo.length; i++) {
			emplo[i].display();
		}

	}

}

public class Test01 {

	public static void main(String[] args) {

		Emplo e = new Emplo();
		e.input();
		e.process();
		e.output();

	}

}

/*
 * SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); Date today = new
 * Date(); String hireDateStr = emplo[j].getDate(); String fromDateStr =
 * format.format(today); try { Date hireDate = format.parse(hireDateStr); Date
 * fromDate = format.parse(fromDateStr);
 * 
 * long baseDay = 24 * 60 * 60 * 1000; // 일 long baseMonth = baseDay * 30; // 월
 * long baseYear = baseMonth * 12; // 년 long calDate = fromDate.getTime() -
 * hireDate.getTime(); long diffYear = calDate / baseYear;
 * 
 * if (diffYear <= 1) { emplo[j].setBonus(0); } else { emplo[j].setBonus(0.005 *
 * diffYear * emplo[j].getSal()); } } catch (Exception e) { // TODO: handle
 * exception }
 */