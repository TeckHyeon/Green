package ex01;

import java.util.Scanner;

/* csv format- comma seperator
1,P01,10,1250.0
2,P02,15,2000.0
3,P03,30,1500.0
5,P04,25,2000.0
4,P05,28,1900.0
*/
// 입력:번호,제품코드,수량,단가
//      num, pcode, amount, price
// P01:새우깡, P02:빅파이, P03:짱구, P04:초코파이, P05:수박맛초코파이
// 출력:번호,제품명,수량,단가,금액(수량*단가)
//      num, pname, amount, price, kum 

// interface IProd
interface IProd {
	void input();

	void process();

	void output();
}

// class Product
class Product {
	// Fields
	// 입력:번호,제품코드,수량,단가
	private int num;
	private String pcode;
	private int amount;
	private double price;

	// 출력:번호,제품명,수량,단가,금액(수량*단가)
	private String pname;
	private double kum;

	// Constructor : 생성자

	public Product() {

	}

	public Product(int num, String pcode, int amount, double price) {
		super();
		this.num = num;
		this.pcode = pcode;
		this.setAmount(amount);
		this.setPrice(price);
	}

	// toString
	@Override
	public String toString() {
		return "Product [num=" + num + ", pcode=" + pcode + ", amount=" + amount + ", price=" + price
				+ ", pname=" + pname + ", kum=" + kum + "]";
	}

	// Getter / Setter
	
	// 금액
	public double getKum() {
		return kum;
	}

	public void setKum(double kum) {
		this.kum = kum;
	}

	// 수량
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	// 단가
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	//제품코드
	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	
	//제품명
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}

//class Prod
class Prod implements IProd {

	// Fields
	Product prod = null;

	// 기본 생성자
	public Prod() {

	}

	// method
	@Override
	public void input() {

		Scanner in = new Scanner(System.in);
		System.out.println("번호,제품코드,수량,단가");
		String line = in.nextLine();
		String[] li = line.split(",");
		int num = Integer.parseInt(li[0]);
		String pcode = li[1];
		int amount = Integer.parseInt(li[2]);
		double price = Double.parseDouble(li[3]);
		prod = new Product(num, pcode, amount, price);
		in.close();
	}

	@Override
	public void process() {
		// 금액 = 수량 * 단가
		prod.setKum(prod.getAmount() * prod.getPrice());
		
		// 제품명 - P01:새우깡, P02:빅파이, P03:짱구, P04:초코파이, P05:수박맛초코파이
		switch (prod.getPcode()) {
		case "P01":
			prod.setPname("새우깡");
			break;
		case "P02":
			prod.setPname("빅파이");
			break;
		case "P03":
			prod.setPname("짱구");
			break;
		case "P04":
			prod.setPname("초코파이");
			break;
		case "P05":
			prod.setPname("수박맛초코파이");
			break;
		default:
			prod.setPname(null);
			break;
		}

	}

	@Override
	public void output() {

		System.out.println(prod.toString());
	}

}

public class TestProd {

	public static void main(String[] args) {

		Prod p = new Prod();
		p.input();
		p.process();
		p.output();
	}

}
