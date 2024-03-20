package ex06;

class Compute {
	int add(int v1, int v2) {
		return v1 + v2;
	}

	int add(int v1, int v2, int v3) {
		return v1 + v2 + v3;
	}
	double add(double v1, double v2) {
		return v1 + v2;
	}
}

public class TestMain {

	// overloading

	public static void main(String[] args) {
		Compute c1 = new Compute();

		System.out.println(c1.add(7, 2));
		System.out.println(c1.add(1, 2, 3));
		System.out.println(c1.add(7.3, 5.9));
	}

}
