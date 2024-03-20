package ex11;

interface IRacoon {
	void dig();
}

class Duck {
	public void swim() {
		System.out.println("헤엄친다");
	}
}

class Racoon implements IRacoon {
	
	@Override
	public void dig() {
		System.out.println("땅을 판다");
	}
}

class DuckRacoon extends Duck implements IRacoon{
	@Override
	public void dig() {
		System.out.println("땅을 판다");
	}
}

// error : extends 뒤에는 한개의 클래스만 쓸 수 있다 - 다중상속 안됨
// class DuckRacoon extends Duck, Racoon error 

public class TestDuckRacoon {

	public static void main(String[] args) {
		Duck d = new Duck();
		d.swim();
		Racoon r = new Racoon();
		r.dig();
		DuckRacoon dr = new DuckRacoon();
		dr.swim();
		dr.dig();
	}

}
