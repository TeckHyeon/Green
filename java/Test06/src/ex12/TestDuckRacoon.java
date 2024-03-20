package ex12;

interface IDuck {
	void swim();
}

interface IRacoon {
	void dig();
}

class DuckRacoon implements IDuck, IRacoon {

	@Override
	public void swim() {
		System.out.println("헤엄친다");
	}

	@Override
	public void dig() {
		System.out.println("땅을 판다");
	}

}

public class TestDuckRacoon {

	public static void main(String[] args) {
		DuckRacoon dr = new DuckRacoon();
		dr.dig();
		dr.swim();
	}

}
