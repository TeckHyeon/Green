package ex04;

public class Student {
	private int num;
	private int score;
	private int rank;

	public Student(int num, int score) {
		super();
		this.num = num;
		this.score = score;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", score=" + score + ", rank=" + rank + "]";
	}

	// GET SET
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
// GET SET 종료	

}