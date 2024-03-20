package collection01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// 배열 -> arraylist
		String       [] names    = {"홍길동", "이길동", "박길동", "최길동"};
		List<String>    nameList =  Arrays.asList(names);
				
		// nameList.add("전우치"); // error
		//  Arrays.asList(names) // size 변경불가능한 ArrayList로 변환
		
		// foreach
		for (String name : nameList) {
			System.out.print( name + ",");
		}
		System.out.println();
		
		// sort : asc
		//Collections.sort( nameList );
		// sort desc
		Collections.sort( nameList, (a, b)-> b.compareTo(a) );
		
		// 출력
		for (String name : nameList) {
			System.out.print( name + ",");
		}
		System.out.println();
		
		
		List<Integer>  list2 = Arrays.asList(11, 56, 5, 8, 99);
		for (Integer num : list2) {
			System.out.println(num);
		}
		

	}

}








