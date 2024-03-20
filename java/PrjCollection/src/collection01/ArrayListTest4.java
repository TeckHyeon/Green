package collection01;

import java.util.ArrayList;

public class ArrayListTest4 {

	public static void main(String[] args) {
		// 이름입력 : 6명
		String   [] names = new String[6]; 
		
		names[0]  =  "카리나"; 
		names[1]  =  "윈터"; 
		names[2]  =  "유진"; 
		names[3]  =  "가을"; 
		names[4]  =  "미나"; 
		names[5]  =  "제니";
		// names[6]  =  "리사";   // ArrayIndexOutOfBoundsException: 
		
		for(int i=0;i<names.length;i++) {
			System.out.print( names[i] + " ");
		}
		System.out.println();
		
		//-------------------------------
		ArrayList<String>  nameList  =  new ArrayList<> (); 
		
		nameList.add("사나");    // 0
		nameList.add("미나");    // 1
		nameList.add("카리나");  // 2
		nameList.add("윈터");    // 3
		nameList.add("미미");    // 4
		
		System.out.println( nameList.get(3) );
		
		for (int i = 0; i < nameList.size(); i++) {
			System.out.print( nameList.get(i) + " ");
		}
		System.out.println();
		System.out.println("-----------------");
		
		nameList.add("태연");
		for (int i = 0; i < nameList.size(); i++) {
			System.out.println( nameList.get(i) );
		}

	}

}















