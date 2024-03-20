package collection04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMap2 {

	public static void main(String[] args) {
		//      Key      value
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(10, "인사");  // 추가
		map.put(20, "자재");
		map.put(30, "연구개발");
		map.put(40, "총무");
		map.put(50, "생산");
		
		System.out.println( map.get( 30 ) );
		System.out.println( map.size() );
		
		map.put(70, "기획");  // 추가
		map.put(10, "홍보");  // 수정
		System.out.println( map.get( 10 ) );
		System.out.println("=================");
		
		System.out.println( map );
		
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			System.out.println(key + ":" + val);
		}
		System.out.println("=================");
		
		// 모두출력
		// 1. 키목록 : Set keySet()
		Set<Integer>  keySet = map.keySet(); 
		for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
			Integer key = (Integer) iterator.next();
			System.out.printf( "%d %s, ", key,  map.get(key) );
		}
		System.out.println();
		
		// sort 하여 출력
		List<Integer> keyList = new ArrayList<>( keySet );  
		//Collections.sort(keyList, (a, b)-> a - b);
		keyList.sort( (a, b)-> a - b); // 오름차순 정렬
//		keyList.sort( (a, b)-> b - a); // 내림차순 정렬
		for (Iterator iterator = keyList.iterator(); iterator.hasNext();) {
			Integer key = (Integer) iterator.next();
			System.out.printf( "%d %s, ", key,  map.get(key) );
		}
		
		map.remove( 40 );
		
		//2. MapEntry<Key, Value> 를 이용하여 전체출력
		System.out.println("\n==================");
		Set< Map.Entry<Integer, String> > entrySet = map.entrySet();
		for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) {
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iterator.next();
			Integer  key   =  entry.getKey();
			String   value =  entry.getValue();
			System.out.println(key + ":" + value);
		}
		
		map.clear();
		if(map.isEmpty())
			System.out.println("자료가 없습니다");
		
	}

}











