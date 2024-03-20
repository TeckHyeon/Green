package ex02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


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

	// Getter Setter

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

	// toString
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", name=" + name + ", hiredate=" + hiredate + ", sal=" + sal + ", deptId="
				+ deptId + ", bonus=" + bonus + ", pay=" + pay + ", depName=" + depName + ", rank=" + rank + "]";
	}

}

public class TestFileEmpList {

	private static ArrayList<Emp> empList;

	public static void main(String[] args) throws IOException {

		empList = new ArrayList<>();

		input();
		process();
		output();

	}

	private static void input() throws IOException {
		String path = "D:\\dev\\java\\PrjIo\\src\\ex02\\";
		String fileName = path + "data3.csv";
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] li = line.split(",");
			int empId = Integer.parseInt(li[0]);
			String name = li[1];
			String hiredate = li[2];
			double sal = Double.parseDouble(li[3]);
			int deptId = Integer.parseInt(li[4]);
			Emp emp = new Emp();
			emp.setEmpId(empId);
			emp.setName(name);
			emp.setHiredate(hiredate);
			emp.setSal(sal);
			emp.setDeptId(deptId);
			empList.add(emp);
		}
		br.close();
		fr.close();
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
		String title = "사번   이름 입사일   월급   보너스   수령액   부서명  순위\n";
		String msg = title;
		String fmt = "%4d %4s %8s %6.2f %5.2f %8.2f %8s %4d\n";
		for (Emp e : empList) {
			msg += String.format(fmt, e.getEmpId(), e.getName(), e.getHiredate(), e.getSal(), e.getBonus(),
					e.getPay(), e.getDepName(), e.getRank());
			// System.out.println(empList.get(i));
		}
		System.out.println(msg);

	}

}
