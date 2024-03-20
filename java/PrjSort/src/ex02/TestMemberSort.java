package ex02;

import java.util.Arrays;
import java.util.Comparator;

class Member {
	private int mno;

	public int getMno() {
		return mno;
	}

	public Member(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "Member [mno=" + mno + "]";
	}

}

public class TestMemberSort {

	public static void main(String[] args) {
		Member[] mArr = new Member[] { new Member(128), new Member(27), new Member(18), new Member(9), new Member(55),
				new Member(7) };
		
		// 인터페이스를 사용한 클래스(익명 클래스)로 정렬
		Comparator<Member> compAsc = new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				
				return o1.getMno() - o2.getMno();
			}
		};

		Comparator<Member> compDesc = new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				
				return o2.getMno() - o1.getMno();
			}
		};
		
		
		
		System.out.println(Arrays.toString(mArr));
		Arrays.sort(mArr, compAsc);
		System.out.println(Arrays.toString(mArr));
		Arrays.sort(mArr, compDesc);
		System.out.println(Arrays.toString(mArr));
		
		//람다식
		Arrays.sort(mArr, (o1, o2) -> {
			return o1.getMno() - o2.getMno();
		});
		
		System.out.println(Arrays.toString(mArr));
	}

}
