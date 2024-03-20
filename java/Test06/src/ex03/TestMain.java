package ex03;

class Person {
	private String name;
	private int bYear;
	boolean isAdult;

	// 미성년자 인지 판단
	boolean getAdult() {
		boolean result = false;
		if (2024 - getbYear() >= 19)
			result = true;
		else
			result = false;
		return result;
	}

	public String getName() {
		return name;
	}

	public int getbYear() {
		return bYear;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setbYear(int bYear) {
		this.bYear = bYear;
		if (bYear >= 1900 && 2024 < bYear)
			this.bYear = bYear;
		else
			this.bYear = 9999;
	}

	// 출력
	void display() {
		System.out.println("이름 : " + getName());
		System.out.println("생년 : " + getbYear());
		System.out.println("성인 : " + this.getAdult());
	}

// Setter : 잘못된 데이터 입력 방지
	/*
	 * public void setbYear(int bYear) { if (bYear >= 1900 && 2024 < bYear)
	 * this.bYear = bYear; else this.bYear = 9999; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 */
}

public class TestMain {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("이강인");
		p1.setbYear(0);
		p1.display();
	}
}
