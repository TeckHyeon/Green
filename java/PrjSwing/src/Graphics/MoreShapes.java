package Graphics;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class MoreShapes extends JFrame {

	public MoreShapes() {
		setSize(600, 130);
		setTitle("Java 2D Shapes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new MyPanel3();
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MoreShapes();
	}
}

class MyPanel3 extends JPanel {
	ArrayList<Shape> shapeArray = new ArrayList<Shape>();

	public MyPanel3() {
		Shape s;

		// 사각형
		s = new Rectangle2D.Float(10, 10, 70, 80);
		shapeArray.add(s);

		// 둥근 사각형
		s = new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20);
		shapeArray.add(s);

		// 타원
		s = new Ellipse2D.Float(210, 10, 80, 80);
		shapeArray.add(s);

		// 원호: Arc2D.OPEN
		s = new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN);
		shapeArray.add(s);

		// 원호 Arc2D.CHORD
		s = new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD);
		shapeArray.add(s);

		// 원호 Arc2D.PIE
		s = new Arc2D.Float(510, 10, 80, 80, 45, 90, Arc2D.PIE);
		shapeArray.add(s);
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// 앤티 에일리어싱을 설정한다.
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		for (Shape s : shapeArray)
			g2.draw(s);
	}
}
