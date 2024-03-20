package swing01;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class MyFrame extends  JFrame {
	/**
	 * @wbp.nonvisual location=196,329
	 */
	private final JRadioButton radioButton = new JRadioButton("New radio button");
	// 기본생성자
	public  MyFrame() {
		
		//super("첫번재 프로그램"); // JFrame class 생성자를 호출한다 - 제목을 지정
		setTitle("첫번재 프로그램");
		
		JPanel    p  =   new JPanel();
		
		JButton   btnOk = new JButton("단추1");
		btnOk.setForeground(new Color(0, 0, 255));
		p.add(btnOk);
		JButton   btn2 = new JButton("버튼2");
		p.add(btn2);
		JButton   btn3 = new JButton("버튼3");
		p.add(btn3);
		JButton   btn4 = new JButton("버튼4");
		p.add(btn4);
		JButton   btn5 = new JButton("버튼5");
		p.add(btn5);
		
		ButtonGroup  grp = new ButtonGroup();  
		JRadioButton  rdoBtn1 = new JRadioButton("남자");
		p.add(rdoBtn1);
		JRadioButton  rdoBtn2 = new JRadioButton("기혼");
		p.add(rdoBtn2);
		grp.add(rdoBtn1);
		grp.add(rdoBtn2);
		
		getContentPane().add(p);		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("음악감상");
		p.add(chckbxNewCheckBox);
		
		setSize(300, 300);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		MyFrame  app = new MyFrame();

	}
		

}










