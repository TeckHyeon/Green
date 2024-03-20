package collection02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

class GirlMember {
	private  String name;
	private  int    age;
	
	public GirlMember(String name, int age) {	
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
		GirlMember other = (GirlMember) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
	
}

public class TestSetObject {

	public static void main(String[] args) {
		Set<GirlMember>  set  =  new HashSet<GirlMember>();
		
		set.add( new GirlMember("카리나", 22) );
		set.add( new GirlMember("윈터", 21) );
		set.add( new GirlMember("카리나", 22) );
		set.add( new GirlMember("카리나", 25) );
		
		System.out.println(set.size());
		
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			GirlMember girlMember = (GirlMember) iterator.next();
			System.out.println(girlMember);
		}
	}

}










