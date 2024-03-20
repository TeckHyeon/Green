package Graphics;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class MyPanel extends JPanel implements ActionListener {
	JButton button;
	Color color = new Color(0, 0, 0);

	public MyPanel() {
		setLayout(new BorderLayout());
		button = new JButton("색상 변경");
		button.addActionListener(this);
		this.add(button, BorderLayout.SOUTH);

	}

	// 새로그림이 그려질때마다
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.fillRect(10, 10, 210, 220);

	}

	// 기본 액션이 수행될때 - 버튼이 클릭되면
	public void actionPerformed(ActionEvent e) {
		color = new Color((int) (Math.random() * 255.0), (int) (Math.random() * 255.0), (int) (Math.random() * 255.0));

		repaint();
	}
}

public class ColorTest extends JFrame {
	public ColorTest() {
		setSize(240, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Color Test");

		JPanel panel = new MyPanel();
		add(panel);

		setVisible(true);
	}

	public static void main(String[] args) {
		ColorTest s = new ColorTest();
	}

}
