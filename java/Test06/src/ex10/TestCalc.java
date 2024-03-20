package ex10;

interface ICalc {
	int calc(int v1, int v2);
}

class Add implements ICalc {

	@Override
	public int calc(int v1, int v2) {
		return v1 + v2;
	}
}

class Subtract implements ICalc {

	@Override
	public int calc(int v1, int v2) {
		return v1 - v2;
	}
}

public class TestCalc {

	public static void main(String[] args) {
		Add add = new Add();
		opperation(add, 7, 2);
		//System.out.println(add.calc(7, 2));
		Subtract sub = new Subtract();
		//System.out.println(add.calc(7, 2));
		opperation(sub, 7, 2);
	}
	private static void opperation(ICalc op, int v1, int v2) {
		System.out.println(op.calc(v1, v2));
	}
}
