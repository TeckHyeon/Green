package ex04;

class Car {
	// fields
	String name;
	String color;
	int year;

	// Constructors
// 인자 있는 생성자 : Constructor
	/*
	 * public Car(String name2, String color2, int year2) { this(); //Car(); name =
	 * name2; color = color2; year = year2; }
	 */
	
	public Car(String name, String color, int year) {
		this();
		this.name = name;
		this.color = color;
		this.year = year;
	}
	
	// 기본생성자 : 인자가 없는 생산자
	public Car() {
		System.out.println("---------------------------");
	}

	// methods
	void display() {
		System.out.println("이름:" + name);
		System.out.println("색상:" + color);
		System.out.println("연도:" + year);
	}

}

public class TestMain {

	public static void main(String[] args) {

		Car fCar = new Car();
		fCar.name = "아빠차";
		fCar.color = "깜장";
		fCar.year = 2024;
		fCar.display();
		Car mCar = new Car("엄마차", "빨강", 2024);
		mCar.display();
		
		Car myCar = new Car("내차", "핑크", 2010);
		myCar.display();
	}

}
