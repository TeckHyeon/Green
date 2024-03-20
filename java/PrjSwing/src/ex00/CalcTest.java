package ex00;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalcTest extends JFrame {

	public CalcTest() {
		setTitle("간단 계산기");

		initComponent();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}

	private void initComponent() {
		this.setLayout(new GridLayout(5, 2));

		JLabel lblVal1 = new JLabel("값1");
		add(lblVal1);
		JTextField txtVal1 = new JTextField(10);
		add(txtVal1);

		JLabel lblVal2 = new JLabel("값2");
		add(lblVal2);
		JTextField txtVal2 = new JTextField(10);
		add(txtVal2);

		JButton btnAdd = new JButton("더하기");
		add(btnAdd);
		JButton btnSub = new JButton("빼기");
		add(btnSub);
		JButton btnMul = new JButton("곱하기");
		add(btnMul);
		JButton btnDiv = new JButton("나누기");
		add(btnDiv);

		JLabel lblResult = new JLabel("결과");
		add(lblResult);

		ActionListener btnClick = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				double val1 = Integer.parseInt(txtVal1.getText());
				double val2 = Integer.parseInt(txtVal2.getText());
				double val = 0;
				switch (e.getActionCommand()) {
				case "더하기":
					val = val1 + val2;
					break;
				case "빼기":
					val = val1 - val2;
					break;
				case "곱하기":
					val = val1 * val2;
					break;
				case "나누기":
					val = val1 / val2;
					break;
				}
				lblResult.setText(String.valueOf(val));
			}
		};
		btnAdd.addActionListener(btnClick);
		btnSub.addActionListener(btnClick);
		btnMul.addActionListener(btnClick);
		btnDiv.addActionListener(btnClick);

	}

	public static void main(String[] args) {
		new CalcTest();

	}

}
