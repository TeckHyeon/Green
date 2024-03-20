package ex09;

// 다형성 : polymophism
// 공통된 기능을 구현해서 같은 메소드 이름으로 다른 기능을 대응할 수 있다.
interface MediaDevice {
	abstract void info();

	abstract void play();
}

class TV implements MediaDevice {

	@Override
	public void info() {
		System.out.println("삼성 Oled 75인치");
	}

	@Override
	public void play() {
		System.out.println("TV를 켭니다.");
	}
}

class Audio implements MediaDevice {

	@Override
	public void info() {
		System.out.println("LG 비싼 오디오");
	}

	@Override
	public void play() {
		System.out.println("오디오를 켭니다.");
	}
}

public class TestInterface {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.info();
		tv.play();

		Audio audio = new Audio();
		audio.info();
		audio.play();
	}

}
