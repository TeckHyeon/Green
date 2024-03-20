package ex04;

abstract class Pet {
	String name;

	void eat() {
		System.out.println(name + "가 사료를 먹는다.");
	}

	abstract void sound();
}

class Dog extends Pet {

	@Override
	void sound() {
		System.out.println("멍멍");

	}

}

class Cat extends Pet {

	@Override
	void sound() {
		System.out.println("야옹");

	}

}

class Tiger extends Pet {

	@Override
	void sound() {
		System.out.println("어흥 나 큰 고양이");
	}

}

public class TestMain {

	public static void main(String[] args) {
//		Cat cat1 = new Cat();
//		cat1.name = "네로";
//		cat1.eat();
//		cat1.sound();
//		Tiger tiger1 = new Tiger();
//		tiger1.name = "큰고양이";
//		tiger1.eat();
//		tiger1.sound();
		Dog dog1 = new Dog();
		action(dog1, "츄");
		Dog dog2 = new Dog();
		action(dog2, "바둑이");
		
		Tiger neo = new Tiger();
		action(neo, "네오");

	}

	private static void action(Tiger tiger, String name) {
		tiger.name = name;
		tiger.eat();
		tiger.sound();
	
	}

	private static void action(Dog dog, String name) {
		dog.name = name;
		dog.eat();
		dog.sound();

	}

}