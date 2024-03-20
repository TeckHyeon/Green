package ex05;

abstract class Pet {
	String name;

	void eat() {
		System.out.println(name + "가 사료를 먹는다.");
	}

	abstract void sound();
	
}

class Dog extends Pet {
	
	void houserkeeping() {
		System.out.println(name + "가 집을 지킨다.");
	}
	
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

		Dog dog1 = new Dog();
		action(dog1, "츄");

		Dog dog2 = new Dog();
		action(dog2, "바둑이");

		Tiger neo = new Tiger();
		action(neo, "네오");

	}
	// Pet <- Dog, Tiger (부모 <- 자식) 변환없이 사용가능
	private static void action(Pet pet, String name) {
		pet.name = name;
		pet.eat();
		pet.sound();
		//pet 이 Dog Class로 만들어진 instance 일 때
		if(pet instanceof Dog ) {
			Dog d = (Dog) pet;
			d.houserkeeping();		
		}
	}

}