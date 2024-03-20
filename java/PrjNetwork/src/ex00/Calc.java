package ex00;

public class Calc {
	TestMain testMain;

	public Calc(TestMain testMain) {
		this.testMain = testMain;
		
	}
	public void calc() {
		String byearStr = testMain.txtBirthYear.getText();
		int byear = Integer.parseInt(byearStr);
		int age = 2024-byear;
		testMain.lblResult.setText(String.valueOf(age));
	}
	
	


}
