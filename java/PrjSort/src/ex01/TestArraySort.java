package ex01;

import java.util.Arrays;
import java.util.Collections;

public class TestArraySort {

	public static void main(String[] args) {
		int      []  arr1 = /*new int []*/ { 1,5,3,2,4 }; //int는 람다식 불가 Integer로 바꿔라
		Integer  []  arr2 = { 10, 50, 32, 64, 72 };
		Double   []  arr3 = { 12.5, 3.8, 2.145, 16.8 };

		System.out.println("1.");
		System.out.println( Arrays.toString( arr1 ) );
		// 순서대로 출력 : 작은값 앞으로 큰값 뒤로 - 정렬(sort) : ascending	(오름차순)	
		Arrays.sort( arr1 );
		// Arrays.sort( arr2, (a,b) -> { return a - b; }  );	// error : int
		System.out.println( Arrays.toString( arr1 ) );
		
		//------------------------------------------------------------------------------------------------
		
		System.out.println("2.");
		System.out.println( Arrays.toString(arr2) );
		//Arrays.sort( arr2 );
		Arrays.sort( arr2, (a,b) -> { return b - a; }  );	// 동작 : Integer(객체타입만 가능)
		System.out.println( Arrays.toString(arr2) );
		
		
		
		//--------------------------------------------------------------------------------------------------
		System.out.println("3.");
		// 순서대로 출력 : 큰값이 앞으로 작은값 뒤로 - 정렬(sort) - descending (내림차순)
		System.out.println( Arrays.toString(arr3) );
		Arrays.sort( arr3, Collections.reverseOrder() );	
		System.out.println( Arrays.toString(arr3) );
		
		//-------------------------------------------------
		// java 1.8  람다식 - 
		String [] names = {"아이유", "유진", "카리나", "윈터", "가을", "이서"};
		
		System.out.println( Arrays.toString( names ) );
		Arrays.sort( names );  // 오름차순
		//Arrays.sort( names, (a, b) -> { return a.compareTo(b);  } );  // 오름차순
		System.out.println( Arrays.toString( names ) );
		Arrays.sort( names, (a, b) -> { return b.compareTo(a);  } );  // 내림차순
		System.out.println( Arrays.toString( names ) );
		
	}

}








