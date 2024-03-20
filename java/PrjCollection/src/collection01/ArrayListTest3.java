package collection01;

import java.util.ArrayList;

public class ArrayListTest3 {

	public static void main(String[] args) {
		// java 1.5
		// <T> : generic  T: class Type : reference type 만 가능
		//       입력되는 data type 제한
		// ArrayList<int> : 오류
		// ArrayList<Integer> : class type 만 가능		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(20);
		al.add(30);
		// al.add("40");  // error
		
	    for (int i = 0; i < al.size(); i++) {
			System.out.println( al.get(i) );
		}
	    
	    // for each
	    for (Integer num : al) {
			System.out.println( num );
		}
		
	    
	}

}





