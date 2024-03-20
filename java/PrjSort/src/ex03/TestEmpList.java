package ex03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

//입력data : 사번,이름,입사일,월급,부서번호
//출력     : 사번,이름,입사일,월급,보너스,수령액,부서명

//금액은 소수이하 두자리로 반올림
//보너스   =  연차에 따라 월급의 0.5% 로 계산한다
//수령액   =  월급 + 보너스
//부서명   =  10:인사,20:자재,30:총무,40:연구개발,50:생산,60:서비스

//모든기능은 class애 구현한다.
//입력data
//사번,이름,입사일,월급,부서번호
/*
100,사나,20110101,300.0,10
600,쯔위,20150801,200.0,50
400,나연,20110105,220.0,40
300,정연,20091003,250.0,30
500,미나,20180401,170.0,60
200,모모,20120301,270.0,20
*/

class Emp {
	// 입력data : 사번,이름,입사일,월급,부서번호
	private int empId;
	private String name;
	private String hiredate;
	private double sal;
	private int deptId;

	// 출력 : 사번,이름,입사일,월급,보너스,수령액,부서명
	private double bonus;
	private double pay;
	private String depName;
	private int rank;

	public Emp() {

	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Emp(int empId, String name, String hiredate, double sal, int deptId) {
		// TODO Auto-generated constructor stub
		this.empId = empId;
		this.name = name;
		this.hiredate = hiredate;
		this.sal = sal;
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", name=" + name + ", hiredate=" + hiredate + ", sal=" + sal + ", bonus=" + bonus
				+ ", pay=" + pay + ", depName=" + depName + "]";
	}

}

public class TestEmpList {

	private static ArrayList<Emp> empList;

	public static void main(String[] args) {

		empList = new ArrayList<>();

		input();
		process();
		output();
	}

	private static void input() {
		Scanner in = new Scanner(System.in);
		System.out.println("사번,이름,입사일,월급,부서번호(종료:exit)");

		while (true) {
			String line = in.nextLine().trim(); // 한줄
			if (line.toLowerCase().equals("exit"))
				break; // 반복중지

			String[] li = line.split(",");
			int empId = Integer.parseInt(li[0]);
			String name = li[1];
			String hiredate = li[2];
			double sal = Double.parseDouble(li[3]);
			int deptId = Integer.parseInt(li[4]);
			// Emp emp = new Emp(empId, name, hiredate, sal, deptId);
			Emp emp = new Emp();
			emp.setEmpId(empId);
			emp.setName(name);
			emp.setHiredate(hiredate);
			emp.setSal(sal);
			emp.setDeptId(deptId);
			empList.add(emp);
		}

	}

	private static void process() {
		for (int i = 0; i < empList.size(); i++) {
			Emp emp = empList.get(i);
			LocalDate now = LocalDate.now();
			int thisYear = now.getYear();
			int inYear = Integer.parseInt(emp.getHiredate().substring(0, 4));
			int years = thisYear - inYear;

			if (years <= 1) {
				emp.setBonus(0);
			} else {
				emp.setBonus(0.005 * years * emp.getSal());
			}

			// 수령액 계산
			emp.setPay(emp.getSal() + emp.getBonus());

			String dname = "";
			HashMap<Integer, String> map = new HashMap<Integer, String>();
			map.put(10, "인사");
			map.put(20, "자재");
			map.put(30, "총무");
			map.put(40, "연구개발");
			map.put(50, "생산");
			map.put(60, "서비스");
			emp.setDepName(map.get(emp.getDeptId()));
		}

		// 정렬 : ArrayList 실수령액
		/*
		 * Collections.sort(empList, new Comparator<Emp>() {
		 * 
		 * @Override public int compare(Emp o1, Emp o2) {
		 * 
		 * return (int) (o2.getPay() - o1.getPay()); } });
		 */

		/* pay순으로 석차 */
		for (int i = 0; i < empList.size(); i++) {
			int rank = 1;
			for (int j = 0; j < empList.size(); j++) {
				if (empList.get(i).getPay() < empList.get(j).getPay()) {
					rank++;
				}
			}
			empList.get(i).setRank(rank);
		}

		Collections.sort(empList, (a, b) -> {
			return (int) (a.getRank() - b.getRank());
		});

		// 석차

	}

	private static void output() {
		String msg = "";
		String title = "사번   이름 입사일   월급   보너스   수령액   부서명  순위\n";
		for (int i = 0; i < empList.size(); i++) {
			Emp emp = empList.get(i);
			String fmt = "%4d %4s %8s %6.2f %6.2f %8.2f %5s %2d";
			msg = String.format(fmt, emp.getEmpId(), emp.getName(), emp.getHiredate(), emp.getSal(), emp.getBonus(),
					emp.getPay(), emp.getDepName(), emp.getRank());
			System.out.println(msg);
			// System.out.println(empList.get(i));
		}
	}
}
