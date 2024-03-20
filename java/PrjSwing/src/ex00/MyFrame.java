package ex00;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	public MyFrame() {
		setSize(300, 200);
		setTitle("첫번째 스윙프로그램");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		initComponent();

		setVisible(true);
	}

	private void initComponent() {
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("단추1");
		p.add(btn1);
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(btn1.getText() + "이 눌러졌습니다.");

			}
		});

		JButton btn2 = new JButton("단추2");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(btn2.getText() + "이 눌러졌습니다.");

			}
		});
		p.add(btn2);
		
		JButton btn3 = new JButton("단추3");
		JButton btn4 = new JButton("단추4");
		JButton btn5 = new JButton("단추5");
		p.add(btn3);
		p.add(btn4);
		p.add(btn5);
		
		
		this.add(p);
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}

}
