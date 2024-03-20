package exam.variable;

public class TestVar03 {
	public static void main(String[] args) {
		//실수
		//float : 4byte
		//double : 8byte
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);	
		
		System.out.println(3.7123456789123456789);
		System.out.println(3.7123456789123456789f);
		
		System.out.println('A');	//문자 char
		//System.out.println('AB'); //에러 
		System.out.println('한');
		System.out.println("AB");	//문자열 string
		
		boolean male = false;
		System.out.println(male);
		boolean pass = true;
		System.out.println(pass);
		
		String name1 = "카리나";
		String name2 = new String("카리나");
		System.out.println(name1);
		System.out.println(name2);
	}
}
