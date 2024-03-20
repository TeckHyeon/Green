package exam.condition;

public class Test04 {

	public static void main(String[] args) {
		String choice = "A";
		String msg = "";
		switch (choice) {
		case "A":
			msg = "비행기";
			break;
		case "B":
			msg = "자전거";
			break;
		case "C":
			msg = "자동차";
			break;
		default:
			msg="";
			break;
		}
		System.out.println(msg);
	}
}
