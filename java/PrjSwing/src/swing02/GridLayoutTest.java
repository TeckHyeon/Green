package swing02;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GridLayoutTest extends JFrame {
	
	public GridLayoutTest() {
		this.setTitle("GridLayout Test");
		
		initComponent();
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 200);
		this.setVisible( true );
	}
	
	private void initComponent() {
		
		GridLayout  gl = new GridLayout(3, 2 , 20, 20); // 3 줄 2 칸
		this.setLayout( gl );
		
		JButton [] btns = new JButton[6];
		for (int i = 0; i < btns.length; i++) {
			btns[i]  =  new JButton("버튼" + i);
			this.add( btns[i] );
		}
		this.add( new JTextField() );
		
	}

	public static void main(String[] args) {
		new GridLayoutTest();
	}

}








