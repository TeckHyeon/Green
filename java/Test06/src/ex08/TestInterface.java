package ex08;

import ex08.Audio;
import ex08.MediaDevice;
import ex08.TV;

abstract class MediaDevice {
	abstract void info();

	abstract void play();
}

class TV extends MediaDevice {

	@Override
	void info() {
		System.out.println("삼성 Oled 75인치");
	}

	@Override
	void play() {
		System.out.println("TV를 켭니다.");
	}
}

class Audio extends MediaDevice {

	@Override
	void info() {
		System.out.println("LG 비싼 오디오");
	}

	@Override
	void play() {
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
