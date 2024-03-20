package ex07;

class Tv {
	void info() {
		System.out.println("삼성 Oled 75인치");
	}

	void play() {
		System.out.println("TV를 켭니다.");
	}
}

class Audio {
	void info() {
		System.out.println("LG 비싼 오디오");
	}

	void play() {
		System.out.println("오디오를 켭니다.");
	}
}

public class TestInterface {

	public static void main(String[] args) {
		Tv tv = new Tv();
		tv.info();
		tv.play();

		Audio audio = new Audio();
		audio.info();
		audio.play();
	}

}
