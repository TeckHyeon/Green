package ex03;

class Car {
	// 속성 : field
	String name;
	String color;
	int year;

	// 생성자 : Constructor - 객체를 new 할 때 실행할 명력을 적는다.
	// 주로 객체 초기화 등에 사용한다.
	// 샹성자가 없으면 자동으로 기본 생성자가 생성되어 작동한다..
	// 기본 생성자 : 아무 기능이 없는
	// public Car() {}
	public Car() {

		System.out.println("메롱");
	}

	// 동작 : method
	public void display() {
		System.out.println("차이름 : " + name);
		System.out.println("차색상 : " + color);
		System.out.println("연도 : " + year);
	}

}

public class TestMain {

	public static void main(String[] args) {
		Car fatherCar = new Car();
		fatherCar.name = "아빠차";
		fatherCar.color = "Black";
		fatherCar.year = 2020;
		fatherCar.display();

		Car motherCar = new Car();
		motherCar.name = "엄마차";
		motherCar.color = "Pink";
		motherCar.year = 2023;
		motherCar.display();

		Car myCar = new Car();
		myCar.name = "내차";
		myCar.color = "Red";
		myCar.year = 2022;
		myCar.display();

	}

}
