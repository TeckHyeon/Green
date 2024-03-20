package ex00;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestMain extends JFrame {
		JButton btnCalc1, btnCalc2;
		JTextField txtBirthYear;
		JLabel lblResult;
		
		
	public TestMain() {
		setTitle("나이 계산");
		initComponent();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
	}

	private void initComponent() {
		setLayout(new FlowLayout());
		this.txtBirthYear = new JTextField(20);
		this.txtBirthYear.setText("1999");
		this.txtBirthYear.setToolTipText("태어난 연도 입력하세요");
		add(txtBirthYear);
		
		this.btnCalc1 = new JButton("나이계산");
		add(btnCalc1);
		TestMain tm = this;
		// 기능 추가
		this.btnCalc1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Calc c1 = new Calc(tm);
				c1.calc();
				
			}
		});
		
		this.lblResult = new JLabel("결과:");
		this.lblResult.setPreferredSize(new Dimension(200, 150));
		add(lblResult);
	}

	public static void main(String[] args) {
		new TestMain();

	}

}
