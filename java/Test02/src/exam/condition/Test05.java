package exam.condition;

public class Test05 {

	public static void main(String[] args) {
		int bye = 1991;
		String ddi = "";
		switch (bye % 12) {
		case 0:
			ddi = "원숭이";
			break;
		case 1:
			ddi = "닭";
			break;
		case 2:
			ddi = "개";
			break;
		case 3:
			ddi = "돼지";
			break;
		case 4:
			ddi = "쥐";
			break;
		case 5:
			ddi = "소";
			break;
		case 6:
			ddi = "호랑이";
			break;
		case 7:
			ddi = "토끼";
			break;
		case 8:
			ddi = "용";
			break;
		case 9:
			ddi = "뱀";
			break;
		case 10:
			ddi = "말";
			break;
		case 11:
			ddi = "양";
			break;
		default:
			break;
		}
		System.out.println(ddi);
	}
}
