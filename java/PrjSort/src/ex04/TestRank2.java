package ex04;

import java.util.ArrayList;
import java.util.Collections;

public class TestRank2 {

	public static void main(String[] args) {

		ArrayList<Student> sList = new ArrayList<Student>();
		// 입력
		sList.add(new Student(2, 95));
		sList.add(new Student(4, 80));
		sList.add(new Student(8, 90));
		sList.add(new Student(9, 75));
		sList.add(new Student(6, 90));
		sList.add(new Student(1, 100));
		sList.add(new Student(3, 85));
		sList.add(new Student(5, 80));
		// 석차구하기
		int max = sList.size();
		for (int i = 0; i < max; i++) {
			Student s = sList.get(i);
			int rank = 1;
			for (int j = 0; j < max; j++) {
				if (sList.get(i).getScore() < sList.get(j).getScore()) {
					rank++;
				}
			}
			s.setRank(rank);
		}
		// 정렬
		Collections.sort(sList, (a, b) -> {
			return a.getRank() - b.getRank();
		});
		// 출력
		for (Student student : sList) {
			System.out.println(student);
		}
	}

}
