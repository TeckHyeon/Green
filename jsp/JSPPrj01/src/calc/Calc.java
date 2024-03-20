package calc;

public class Calc {

	public double add(double v1, double v2) {
		double v = v1 + v2;

		return v;
	}

	public double cal(String op, double v1, double v2) {
		double result = 0.0;
		switch (op) {
		case "-선택-":
			break;
		case "+":
			result = v1 + v2;
			break;
		case "-":
			result = v1 - v2;
			break;
		case "*":
			result = v1 * v2;
			break;
		case "/":
			result = v1 / v2;
			break;

		default:
			result = 0.0;
			break;
		}
		return result;
	}

	public double sub(double v1, double v2) {
		double v = v1 - v2;

		return v;
	}

	public double mul(double v1, double v2) {
		double v = v1 * v2;

		return v;
	}

	public double div(double v1, double v2) {
		double v = v1 / v2;

		return v;
	}

}
