package ex04;

import java.util.ArrayList;
import java.util.Collections;

public class TestRank {

	public static void main(String[] args) {

		ArrayList<Student> sList = new ArrayList<Student>();

		sList.add(new Student(2, 95));
		sList.add(new Student(4, 80));
		sList.add(new Student(8, 90));
		sList.add(new Student(9, 75));
		sList.add(new Student(6, 90));
		sList.add(new Student(1, 100));
		sList.add(new Student(3, 85));
		sList.add(new Student(5, 80));

		//입력값이 순서없을때
		for (int i = 0; i < sList.size(); i++) {
			int rank = 1;
			for (int j = 0; j < sList.size(); j++) {
				if (sList.get(i).getScore() < sList.get(j).getScore()) {
					rank++;
				}
			}
			sList.get(i).setRank(rank);
		}

		Collections.sort(sList, (a, b) -> {
			return a.getRank() - b.getRank();
		});
		
//		입력값이 순서대로 일때
//		int prevScore = 0;
//		for (int i = 0; i < sList.size(); i++) {
//			Student s = sList.get(i);
//			if (s.getScore() == prevScore) {  //이전 학생의 점수와 비교 같으면
//				s.setRank(sList.get(i-1).getRank());
//			} else { //같지 않으면
//				s.setRank(i+1);
//				prevScore = s.getScore();
//			}
//			
//		} 

		for (Student student : sList) {
			System.out.println(student);
		}

	}

}
