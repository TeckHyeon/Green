package collection02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {

		// Set set1 = new Set(); // error : Cannot instantiate the type Set
		// interface는 new 할 수 없다
		// Set set1 = new Set() { // 코드를 넣으면 }; // new 가능 * 대단히 많이 나옴
		
		
		// 중복 자료 저장 불가
		HashSet<String> set = new HashSet<String>();

		System.out.println(set.size()); // 0
		set.add("Java");
		set.add("Python");
		set.add("Oracle");
		set.add("Java");
		set.add("Spring");
		System.out.println(set.size()); // 4

		System.out.println(set.toString());

		for (Iterator iterator = set.iterator(); iterator.hasNext(); ) { //hasNext : 자료가 있나 확인하는 명령어
			String string = (String) iterator.next(); //next() : 있는 자료를 들고 오는 명령어
			System.out.println(string);
		}

		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}

	}

}
