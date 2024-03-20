package ex01;

class Member {

	private int id;

	// Member 객체의 instance 인 m2, m5를 비교한다 : equals 재정의 해서
	public boolean equals(Object obj) {
		Member m = (Member) obj;
		boolean result = this.id == m.id;
		// return super.equals(obj);
		return result;
	}

	private String name;

	public Member(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}

}

public class TestMember {

	public static void main(String[] args) {
		// Member m1 = new Member();
		Member m1 = new Member(1, "민지");
		Member m2 = new Member(2, "카리나");
		Member m3 = new Member(3, "윈터");
		Member m4 = new Member(4, "아영");
		Member m5 = new Member(2, "카리나");
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);
		System.out.println(m5);

		if (m2 == m5) // 주소비교가 된다 : 같지 않다
			System.out.println("같다");
		else
			System.out.println("다르다");
		// 객체 equals 를 비교하면 기본동작 hashcode를 비교한다(==).
		// 단 문자열의 경우는 내부에서 재정의 하여 data를 비교
		// 그러므로 객체의 데이터를 비교하려면 equals를 override하여 비교
		if (m1.equals(m2))
			System.out.println("같다");
		else
			System.out.println("다르다");
		if (m2.equals(m5))
			System.out.println("같다");
		else
			System.out.println("다르다");
	}
}
