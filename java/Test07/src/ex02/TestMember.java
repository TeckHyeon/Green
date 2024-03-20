package ex02;

import java.util.Objects;

class Member {

	private int id;

	private String name;
	private String tel;

	public Member(int id, String name, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
	}

	public Member() {

	}

	@Override
	public String toString() {
		return "Member [id=" + id + "," + " name=" + name + "," + " tel=" + tel + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	// 객체 비교를 위한 equals를 재정의 (자동)
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Member m = (Member) obj;
		if (m.id > 0)
			return result = this.id == m.id;
		if (m.name != null)
			return result = Objects.equals(this.name, m.name);
		return result;

	}

}

public class TestMember {

	public static void main(String[] args) {
//
//		Member m1 = new Member(1, "민지", "010");
//		Member m2 = new Member(2, "카리나", "011");
//		Member m3 = new Member(3, "윈터", "014");
//		Member m4 = new Member(4, "세나", "015");
		// 객체 배열
		/*
		 * Member [] mArr = new Member[5]; //배열을 만든다 : 5개 mArr[0] = new Member(1, "민지",
		 * "010"); mArr[1] = new Member(2, "카리나", "011"); mArr[2] = new Member(3, "윈터",
		 * "014"); mArr[3] = new Member(4, "세나", "015");
		 */
		Member[] mArr = new Member[] { new Member(1, "민지", "010"), new Member(2, "카리나", "011"),
				new Member(3, "윈터", "014"), new Member(4, "세나", "015"), new Member(5, "가나", "016"),
				new Member(6, "나나", "017"), new Member(7, "세나", "018") };
		Member m = new Member(4, "세나", null);
		// 전체회원에서 m에 있는 정보와 같은 멤버를 찾는다.
		findMember(mArr, m);
		m = new Member(0, "세나", null);
		findMember(mArr, m);

	}

	private static void findMember(Member[] mArr, Member m) {

		boolean isFound = false;
		for (int i = 0; i < mArr.length; i++) {
			if (mArr[i].equals(m)) { // 주소비교
				System.out.println("찾았다");
				System.out.println(mArr[i]);
				isFound = true;
			}
		}
		if (isFound != true)
			System.out.println("못 찾았다");
	}
}
