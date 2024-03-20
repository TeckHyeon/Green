package ex02;
// class 상속 : inherit
// 부모 : Pet - 공통된 소스를 가지고
// 자식 : Dog, Cat, Duck - extends Pet을 통해 소스를 재사용
// 자바, C#은 한개의 부모만 상속가능하다.
class Pet {
	String name;

	void eat() {
		System.out.println(name + "가 사료를 먹는다.");
	}
}

class Dog extends Pet{
	void bark() {
		System.out.println("멍멍");
	}
}

class Cat extends Pet{
	void meow() {
		System.out.println("야옹");
	}
}
class Duck extends Pet{
	void quack() {
		System.out.println("꽉꽉");
	}
}

public class TestMain {

	public static void main(String[] args) {
		Dog dog1 = new Dog();
		dog1.name = "츄";
		dog1.eat();
		dog1.bark();
		Cat cat1 = new Cat();
		cat1.name = "네로";
		cat1.eat();
		cat1.meow();
		Duck duck1 = new Duck();
		duck1.name = "도날드";
		duck1.eat();
		duck1.quack();
	}

}
