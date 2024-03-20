package ex02;

class Car {
	String name;
	String color;
	int year;

	public void display() {
		System.out.println("차이름 : " + name);
		System.out.println("차색상 : " + color);
		System.out.println("연도 : " + year);
	}

}

public class TestMain {

	public static void main(String[] args) {
		Car fatherCar = new Car();
		Car motherCar = new Car();
		Car myCar = new Car();
		fatherCar.name = "아빠차";
		fatherCar.color = "Black";
		fatherCar.year = 2020;
		fatherCar.display();
		
		motherCar.name = "엄마차";
		motherCar.color = "Pink";
		motherCar.year = 2023;
		motherCar.display();
		
		myCar.name = "내차";
		myCar.color = "Red";
		myCar.year = 2022;
		myCar.display();
	}

}
