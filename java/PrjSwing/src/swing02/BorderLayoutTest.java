package swing02;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutTest extends JFrame implements ActionListener {

	JButton[] btns; // class 배열

	// 기본생성자
	public BorderLayoutTest() {
		// super("BorderLayout Test"); // 부모(JFrame)생생성자 호출
		setTitle("BorderLayout Test");

		initComponent();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}

	private void initComponent() {
		String[] titles = { "North", "East", "South", "West", "Center", "단추1", "단추2", "단추3", "단추4", "단추5" };

		this.setLayout(new BorderLayout());

		btns = new JButton[titles.length];

		for (int i = 0; i < titles.length; i++) {
			btns[i] = new JButton(titles[i]);
		}

		// 베치
		this.add(btns[0], BorderLayout.NORTH);
		this.add(btns[1], BorderLayout.EAST);
		this.add(btns[2], BorderLayout.SOUTH);
		this.add(btns[3], BorderLayout.WEST);
		this.add(btns[4], BorderLayout.CENTER);

		JPanel pan1 = new JPanel(new FlowLayout());
		pan1.add(btns[4]);
		pan1.add(btns[5]);
		pan1.add(btns[6]);
		pan1.add(btns[7]);
		this.add(pan1, BorderLayout.CENTER);

		// 이벤트 연결
		for (int i = 0; i < btns.length; i++) {
			btns[i].addActionListener(this);
			// this : event 코드가 있는 BoderLayoutTest class 에 있음
			// ex) actionPerformed(ActionEvent e) <-- 부분
		}

	}

	public static void main(String[] args) {
		new BorderLayoutTest();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + "를 클릭");

	}

}
