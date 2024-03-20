package ex01;

class Dog {
	String name;

	void eat() {
		System.out.println(name + "가 사료를 먹는다.");
	}

	void bark() {
		System.out.println("멍멍");
	}
}

class Cat {
	String name;

	void eat() {
		System.out.println(name + "가 사료를 먹는다.");
	}

	void meow() {
		System.out.println("야옹");
	}
}

public class TestMain {

	public static void main(String[] args) {

		Dog chu = new Dog();
		chu.name = "츄";
		chu.eat();
		chu.bark();
		Dog ppopy = new Dog();
		ppopy.name = "뽀삐";
		ppopy.eat();
		ppopy.bark();
		Cat cat = new Cat();
		cat.name ="고양이";
		
	}

}
