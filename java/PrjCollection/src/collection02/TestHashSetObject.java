package collection02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Member {
	private  String name;
	private  int    age;
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
}

public class TestHashSetObject {

	public static void main(String[] args) {
		// set : 중복되지 않는 data 모음(배열)
		Set<Member> set = new HashSet<>();
		// HashSet<Member> set = new HashSet<>();
		
		set.add( new Member("카리나", 21) );
		set.add( new Member("윈터",   20) );
		set.add( new Member("아이유", 26) );
		set.add( new Member("카리나", 21) );
		set.add( new Member("카리나", 26) );
		
		System.out.println( set.size() );
		System.out.println( set  );
		
		//----------------------
		// 자동정렬되는 set
		TreeSet<String>  ts  = new TreeSet<>();
		ts.add("박순신");
		ts.add("이순신");
		ts.add("한순신");
		ts.add("강순신");
		ts.add("오순신");
		
		System.out.println( ts );
		TreeSet<String> res = (TreeSet<String>) ts.descendingSet();
		System.out.println( res );
		

	}

}









