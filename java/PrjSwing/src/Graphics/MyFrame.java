package Graphics;

import java.awt.*;
import javax.swing.*;

class MyPanel1 extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("안녕하세요? 자바 프로그래머 여러분!", 10, 10);
		g.drawLine(10, 20, 110, 20);
		g.drawRect(10, 30, 100, 100);
		g.drawOval(40, 65, 30, 30);
		g.drawString("강도현", 70, 50);
	}

}

public class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("MyFrame");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel1 p = new MyPanel1();

		setVisible(true);

		add(p);
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}
}