package collection01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

class Car {
}

public class ArrayLIstTest {

	public static void main(String[] args) {
		// Array : 배열 - 만들어진후 크기변경 불가능
		// ArrayList : - 만들어진후 실행중에 크기변경가능

		int[] arr = new int[3]; // 0~2
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		// arr[3] = 40; // ArrayIndexOutOfBoundsException
		// arr[3] = "abc"; // type mismatch

		System.out.println("배열:" + Arrays.toString(arr));

		ArrayList<Object> al = new ArrayList<Object>();
		// al.add(Object obj) : Object 는 모든 type 과 class 의 조상
		// Object type : 아무거나 받을수 있는 type
		al.add(10);
		al.add(20);
		al.add(30);
		al.add("haha");
		al.add(37.2346);
		al.add(new Car());
		// System.out.println( "ArrayList:" + al );
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i)); // al[i]
		}
		System.out.println(al.size());

		// Object 타입을 사용하지 않고 처리하기 위해
		// Generic 문법 <T> : T typoe 만 가능하다 T 는 class type( java 1.5 )
		// ArrayList<int> : error -> ArrayList<Integer> 로 표시해야한다
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(10); // 0
		al2.add(20); // 1 -> 0
		al2.add(30); // 2
		al2.add(100); // 3
		al2.add(50); // 4
		// al2.add("haha"); -> 에러
		al2.remove(0);
		al2.remove(0);
		al2.set(1, 1000); // 30 '100 --> 1000' 50
		al2.add(1, 99); // 30 99 <-- 1000 50
		// al2.add(3.141592); // error
		for (int i = 0; i < al2.size(); i++) {
			System.out.print(al2.get(i) + " ");
		}
		System.out.println();
		System.out.println(al2.size());
		// ArrayList == Vector
		// 차이 : Thread 안에서 사용할 때는 Vector 사용하라

		Vector<String> nameList = new Vector<>();
		nameList.add("다나");
		nameList.add("나나");
		nameList.add("사나");
		nameList.add("가나");
		nameList.add("다나");
		nameList.add("미나");
		nameList.add("다나");
		nameList.add("다나");
		// nameList.remove("다나"); // 여러개일경우 1개만 지워짐
		delVector(nameList, "다나");

		for (int i = 0; i < nameList.size(); i++) {
			System.out.print(nameList.get(i) + " ");
		}
		System.out.println();

		// LinkedList : 입출력을 자주할 경우 사용 - 속도가 증가된다

	}

	private static void delVector(Vector<String> nameList, String delText) {
		// 뒤에서 부터 앞으로 지우면서 와야 체크되지 않는 자료가 없음
		for (int i = nameList.size() - 1; i >= 0; i--) {
			if (nameList.contains(delText)) {
				String name = nameList.get(i);
				if (name.equals(delText)) {
					nameList.remove(i);
					System.out.println(i + " " + name + " 지워짐");
				}
			}
		}

	}

}
