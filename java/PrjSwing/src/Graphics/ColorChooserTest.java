package Graphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

public class ColorChooserTest extends JFrame implements ChangeListener {

	protected JColorChooser color;

	public ColorChooserTest() {
		setTitle("색상 선택기  테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		color = new JColorChooser(); // 생성자 호출
		color.getSelectionModel().addChangeListener(this); // 리스너 등록
		color.setBorder(BorderFactory.createTitledBorder("색상 선택"));

		JPanel panel = new JPanel();
		panel.add(color);
		add(panel);
		pack();
		this.setVisible(true);

	}

	public void stateChanged(ChangeEvent e) {
		Color newColor = color.getColor();
	}

	public static void main(String[] args) {
		new ColorChooserTest();
	}
}
